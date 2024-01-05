package com.prakashit.controller;

import com.prakashit.beans.Admin;
import com.prakashit.dao.AdminDAO;
import com.prakashit.daoImpl.AdminDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/admin",loadOnStartup = 1)
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        adminDAO = new AdminDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        //extract data from req
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        Admin admin = new Admin();
        admin.setEmpId(Integer.parseInt(empId));
        admin.setPassword(password);

        boolean status = false;
        try {
            status = adminDAO.validate(admin);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        if (status){
            writer.println("login successful..");
            System.out.println("\"login successful..\"");
            req.getRequestDispatcher("/emp-form.html").include(req, resp);
        }else {
            writer.println("Invalid login, please try with valid credential");
            System.out.println("Invalid login, please try with valid credential");
            req.getRequestDispatcher("/login.html").include(req,resp);
        }
        writer.close();
    }
}
