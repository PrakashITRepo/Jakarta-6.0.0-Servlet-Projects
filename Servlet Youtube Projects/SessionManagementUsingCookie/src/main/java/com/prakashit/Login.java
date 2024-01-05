package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        Cookie userNameCookie = new Cookie("userName",userName);
        Cookie passwordCookie = new Cookie("password",password);
        userNameCookie.setMaxAge(20);
        passwordCookie.setMaxAge(20);
        resp.addCookie(userNameCookie);
        resp.addCookie(passwordCookie);
        writer.println("Welcome to login page <br>");
        writer.println("<a href='welcome'>click me</a>");
        writer.close();
    }
}
