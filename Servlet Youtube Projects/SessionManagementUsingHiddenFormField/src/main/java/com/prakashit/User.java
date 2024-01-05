package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user")
public class User extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           resp.setContentType("text/html");
           PrintWriter writer = resp.getWriter();
           String userName = req.getParameter("userName");
           writer.println("submitted userName : "+userName);

           //using hidden form field to maintain session
           writer.println("<form action='hiddenForm' method='get' >");
           writer.println("<input type='hidden' name='userName' value='"+userName+"'><br><br>");
           writer.println("<input type='submit' value='submit' > ");
           writer.println("</form>");

           writer.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
