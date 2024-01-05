package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            HttpSession httpSession = req.getSession(false);
            String userName = (String) httpSession.getAttribute("userName");
            String sessionId = (String) httpSession.getAttribute("sessionId");
            writer.println("userName : "+userName);
            writer.println("sessionId : "+sessionId);
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
