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

@WebServlet(value = "/editEmployeeById")
public class EditEmployeeByIdController extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String empId = req.getParameter("id");
        employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee();
        try {
            employee = employeeDAO.getEmployeeById(Integer.parseInt(empId));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        //Hidden form field , to edit the info of the employee
        writer.println("<form name=\"Employee edit form\" method=\"post\" action=\"afterEditEmployeeById\">");
        writer.println("<input type='hidden' name='id' value="+employee.getEmpId()+"><br><br>");
        writer.println("FirstName:<input type=\"text\" name=\"firstName\" value="+employee.getFirstName()+"><br>");
        writer.println("LastName:<input type=\"text\" name=\"lastName\" value="+employee.getLastName()+"><br>");
        writer.println(" UserName:<input type=\"text\" name=\"userName\" value="+employee.getUserName()+"><br>");
        writer.println("Password:<input type=\"text\" name=\"password\" value="+employee.getPassword()+"><br>");
        writer.println("Country: <select name=\"country\" style=\"width:180px\">");
        writer.println("<option value=\"india\">INDIA</option>");
        writer.println("<option value=\"usa\">USA</option>");
        writer.println("<option value=\"london\">LONDON</option>");
        writer.println("<option value=\"africa\">AFRICA</option>");
        writer.println("<option value=\"other\">OTHER</option>");
        writer.println("</select><br><br>");
        writer.println("<input type=\"submit\" value=\"edit & save employee\">");
        writer.println("</form>");

        writer.close();
    }
}
