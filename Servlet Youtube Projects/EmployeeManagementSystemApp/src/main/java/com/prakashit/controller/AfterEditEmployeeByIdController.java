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

@WebServlet(value = "/afterEditEmployeeById")
public class AfterEditEmployeeByIdController extends HttpServlet {
    private EmployeeDAO employeeDAO;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status = 0;
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        // get user data
        String empId = req.getParameter("id");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String country = req.getParameter("country");

        Employee employee = new Employee();
        employee.setEmpId(Integer.parseInt(empId));
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setCountry(country);
        employeeDAO = new EmployeeDAOImpl();
        try {
          status = employeeDAO.updateEmployee(employee);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        if (status>0){
            writer.println("Record updated successfully for the employee.."+employee.getEmpId());
            System.out.println("Record updated successfully for the employee.."+employee.getEmpId());
            req.getRequestDispatcher("/emp-form.html").include(req, resp);
        }else {
            writer.println("Record updation failed for the employee.."+employee.getEmpId());
            System.out.println("Record updation failed for the employee.."+employee.getEmpId());
        }
    }
}
