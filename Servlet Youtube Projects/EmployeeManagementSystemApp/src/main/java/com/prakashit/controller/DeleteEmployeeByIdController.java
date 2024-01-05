package com.prakashit.controller;

import com.prakashit.dao.EmployeeDAO;
import com.prakashit.daoImpl.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/deleteEmployeeById")
public class DeleteEmployeeByIdController extends HttpServlet {
    private EmployeeDAO employeeDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String empId = req.getParameter("id");
        employeeDAO = new EmployeeDAOImpl();
        try {
         result = employeeDAO.deleteEmployee(Integer.parseInt(empId));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        if (result>0){
            writer.println("Record deleted successfully for the employee.."+empId);
            System.out.println("Record deleted successfully for the employee.."+empId);
            req.getRequestDispatcher("/emp-form.html").include(req, resp);
        }else {
            writer.println("Record deletion failed for the employee.."+empId);
            System.out.println("Record deletion failed for the employee.."+empId);
        }
    }
}
