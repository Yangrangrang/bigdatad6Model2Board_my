package com.bd6.board.controller.user;

import com.bd6.board.service.UserService;
import com.bd6.board.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/idCheck.do")
public class UserIdCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        if (userId == null || userId.trim().equals("") || userId.length() < 4) {
            resp.sendError(400);    //요청이 잘못되었다
            return;     //코드를 멈추려면 꼭 return
        }
        UserService userService = null;
        int idCheck =0;
        try{
            userService = new UserServiceImp();
            idCheck =userService.idcheck(userId);

        } catch (Exception e){
            e.printStackTrace();
            resp.sendError(500);
            return;
        }
        resp.setHeader("Content-Type", "application/json;charset=utf-8");
        resp.getWriter().append("{\"idCheck\":"+idCheck+"}");

    }
}
