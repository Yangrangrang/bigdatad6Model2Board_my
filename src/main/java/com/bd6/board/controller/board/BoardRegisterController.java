package com.bd6.board.controller.board;

import com.bd6.board.dao.BoardImgDao;
import com.bd6.board.dto.BoardDto;
import com.bd6.board.dto.BoardImgDto;
import com.bd6.board.service.BoardService;
import com.bd6.board.service.BoardServiceImp;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/board/register.do")
public class BoardRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        String title = req.getParameter("title");
//        String imgFileName = req.getParameter("imgFile"); 이렇게 못받아옴
        // form data가 blob일 떄만 사용 가능(multipart/form-data)
        // MultiPartRequest : cos의 클래스로 blob 데이터를 처리해준다.(파일이면 저장, 문자열인 인코딩처리)
        // 1. 파일크기 제한 (MultiPartRequest 처리)
        // 2. 파일이름설정 (두가지방법) 1) fileRenamePolicy 객체를 재정의, 2) 저장된 파일의 이름을 바꾼다.
        // 3. 파일 형식을 확인해서 이미지가 아닌 것은 삭제!
        String imgPath = req.getServletContext().getRealPath("/public/img");   //배포된 프로젝트의 물리적인 위치 (target)
        // target : war를 배포하는 경로로 매번 초기화된다. (img업로드를 하면 안된다.)
        imgPath = "/Users/yanghanna/intellij_workspace/BigData6Model2Board/src/main/webapp/public/img"; //(배포전 경로)
        // 콤캣 > 구성편집 > 톰캣인스텅스에 구성된 어플리케이션 배포(체크) : 정적파일은 war로 배포하기 전 어플의 소스를 사용 // 이클립스에서는 (server moduls )
        int fileSize = 1024*1024*1; // 1mb;
        // DefaultFileRenamePolicy() : 동일한 이름의 파일이 존재하면 (1~2~10) 수를 더해서 중복을 막는다.
        int register = 0;   // 게시글 저장 성공 = 1 (+이미지 저장)
        BoardDto board = null;
        try {
            MultipartRequest multiReq = new MultipartRequest(req,imgPath,fileSize,"UTF-8",new DefaultFileRenamePolicy());
            String title = multiReq.getParameter("title");
            String contents = multiReq.getParameter("contents");
            String userId = multiReq.getParameter("userId");

            board = new BoardDto();
            board.setTitle(title);
            board.setContents(contents);
            board.setUserId(userId);
            List<BoardImgDto> boardImgList = new ArrayList<BoardImgDto>();
            Enumeration<String> fileNames = multiReq.getFileNames();
            BoardService boardService = null;
            while (fileNames.hasMoreElements()){
                String fileName = fileNames.nextElement();
                File imgFile = multiReq.getFile(fileName);
                if(imgFile!=null){
                    String[] contentsTypes = multiReq.getContentType(fileName).split("/");  // "image/jpeg"
                    if(!contentsTypes[0].equals("image")){
                        System.out.println("이미지가 아닌 파일 삭제 : " + imgFile.delete());
                    }else {
                        int random = (int) Math.random() * 10000;
                        // 0.12345634452523 => 1234.5634452523 => 1234
                        String fileRename = "board_" + System.currentTimeMillis()+ "_" + random + "." +contentsTypes[1];
                        // 이렇게 하면 파일이 중복 될수 있음 그래서 뒤에 랜덤하게 숫자를 만들어서 넣어줌
                        imgFile.renameTo(new File(imgPath+"/"+fileRename));
                        BoardImgDto boardImg = new BoardImgDto();
                        boardImg.setImgPath((fileRename));
                        boardImgList.add(boardImg);
                    }
                }
            } // img저장 끝
            board.setBoardImgList(boardImgList);
            boardService = new BoardServiceImp();
            register = boardService.register(board);
        } catch (Exception e ){
            e.printStackTrace();
        }
        System.out.println("저장 :" + register);
        if(register>0){ // 성공시 리스트
            resp.sendRedirect("detail.do?boardNo=" + board.getBoardNo());
        } else {    // 실패 시 다시 폼으로
            resp.sendRedirect("register.do");
        }
    }
}
