package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            String userName = req.getParameter("userName");
            //HttpSession
            HttpSession httpSession = req.getSession();
            String sessionId = httpSession.getId();
            writer.println("userName : "+userName);
            writer.println("sessionId : "+sessionId);

            //set the attribute
            httpSession.setAttribute("userName",userName);
            httpSession.setAttribute("sessionId",sessionId);
            writer.println("<br><a href='welcome'>click me+'</a>'");
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
