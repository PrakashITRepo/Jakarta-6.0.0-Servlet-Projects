package com.prakashit.servlet;

import com.prakashit.bean.Employee;
import com.prakashit.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class EmployeeRegistration extends HttpServlet {
    private EmployeeDAO employeeDAO;
    int result = 0;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String eMail = req.getParameter("eMail");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.seteMail(eMail);
        employeeDAO = new EmployeeDAO();
        try {
            result = employeeDAO.register(employee);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (result != 0) {
            writer.println("Employee successfully registered..");
            System.out.println("\"Employee successfully registered..\"");
            resp.sendRedirect("employeeRegister.html");

        } else {
            writer.println("Employee not registered..");
            System.out.println("\"Employee not registered..\"");
        }
    }
}
