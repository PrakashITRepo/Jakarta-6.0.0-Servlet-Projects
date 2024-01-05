package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            String password = req.getParameter("password");

            //url rewrite
            if (password.equals("Smith")){
                resp.sendRedirect("welcome?username="+userName);
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
