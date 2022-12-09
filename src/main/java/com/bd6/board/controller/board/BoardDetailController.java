package com.bd6.board.controller.board;

import com.bd6.board.dto.BoardDto;
import com.bd6.board.dto.PagingDto;
import com.bd6.board.dto.ReplyDto;
import com.bd6.board.service.BoardService;
import com.bd6.board.service.BoardServiceImp;
import com.bd6.board.service.ReplySevice;
import com.bd6.board.service.ReplySeviceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/detail.do")
public class BoardDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page_str=req.getParameter("page");
        String rows_str=req.getParameter("rows");
        String order=req.getParameter("order");
        String direct=req.getParameter("direct");
        String boardNo_str = req.getParameter("boardNo");
        BoardDto board = null;
        PagingDto paging =null;
        BoardService boardService = null;
        ReplySevice replySevice = null;
        try {
            int page=(page_str!=null)?Integer.parseInt(page_str):1;
            int rows=(rows_str!=null)?Integer.parseInt(rows_str):5;
            order=(order!=null)?order:"reply_no";
            direct=(direct!=null)?direct:"DESC";

            int boardNo = Integer.parseInt(boardNo_str);
            boardService = new BoardServiceImp();
            board = boardService.detail(boardNo);
            if(board!=null){
                replySevice = new ReplySeviceImp();
                paging = new PagingDto(page,rows,order ,direct);
                paging.setQueryString(req.getParameterMap());
                List<ReplyDto> replyList = replySevice.boardDetailList(paging,boardNo);
                board.setReplyList(replyList);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
            resp.sendError(400);
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
        if (board != null){
            req.setAttribute("paging",paging);
            req.setAttribute("board",board);
            req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("list.do");
        }
    }
}
