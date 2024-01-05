package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        //read cookies
        Cookie[] cookies = req.getCookies();
        writer.println("userName from cookie : "+cookies[0].getValue()+"<br>");
        writer.println("password from cookie : "+cookies[1].getValue()+"<br>");
        writer.println("<a href='welcome'>click me</a>");
        writer.close();
    }
}
