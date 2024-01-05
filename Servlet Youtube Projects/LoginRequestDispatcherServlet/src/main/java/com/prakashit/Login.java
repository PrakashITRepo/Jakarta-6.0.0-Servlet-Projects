package com.prakashit;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        //validation
        if (userName.equals("Smith") && password.equals("smith")){
            RequestDispatcher rd = req.getRequestDispatcher("/welcome");
            rd.forward(req,resp);
        }else {
            writer.println("Invalid userName/password, Please enter the correct userName/password.");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req,resp);
            writer.close();
        }
    }
}
