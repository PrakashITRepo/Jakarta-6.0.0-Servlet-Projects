package com.prakashit;

import com.prakashit.bean.User;
import com.prakashit.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class UserLogin extends HttpServlet {
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            userDAO = new UserDAO();
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            boolean status = userDAO.validate(user);
            if (status){
                System.out.println("login successful : "+userName);
                writer.println("login successful.."+userName);
            }else {
                System.out.println("login invalid for : "+userName);
                writer.println("login invalid..for "+userName);
                writer.println("<br><a href='login.html'>login with valid credential</a>");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
