package com.prakashit.controller;

import com.prakashit.beans.Employee;
import com.prakashit.dao.EmployeeDAO;
import com.prakashit.daoImpl.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/addEmployee")
public class AddEmployeeController extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        // get user data
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String country = req.getParameter("country");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setCountry(country);
        employeeDAO = new EmployeeDAOImpl();
        try {
            result = employeeDAO.saveEmployee(employee);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        if (result > 0) {
            System.out.println("Employee added successfully..");
            writer.println("Employee added successfully..");
            req.getRequestDispatcher("/emp-form.html").include(req, resp);
        } else {
            System.out.println("\"Employee addition failed..\"");
            writer.println("Employee addition failed..");
        }
    }
}
