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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/getAllEmployees")
public class AllEmployeesViewController extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        List<Employee> employeeList = new ArrayList<>();
        employeeDAO = new EmployeeDAOImpl();
        try {
            employeeList =  employeeDAO.getAllEmployees();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        writer.print("<table border='1' width='100%'");
        writer.print("<tr><th>EmpId</th><th>FirstName</th><th>LastName</th><th>UserName</th>" +
                "<th>Password</th><th>Country</th><th>Edit</th><th>Delete</th> </tr>");
        for (Employee emp : employeeList) {
            writer.print("<tr><td>"+ emp.getEmpId() +"</td><td>" + emp.getFirstName()+"</td><td>"
                    + emp.getLastName() + "</td><td>"+ emp.getUserName()
                    + "</td><td>"+ emp.getPassword() +"</td><td>" + emp.getCountry() + "</td><td>"
                    + "<a href='editEmployeeById?id=" + emp.getEmpId() + "'>edit</a>   </td><td>"
                    + "<a href='deleteEmployeeById?id=" + emp.getEmpId() + "'>delete</a> </td></tr>");
        }
        writer.println("</table>");
        writer.println("<br> <a href='emp-form.html'>add employee </a>");
        writer.close();
    }
}
