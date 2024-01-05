package com.prakashit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/getInitParams" , loadOnStartup = 1,
        initParams = {@WebInitParam(name = "driverName",value = "sun.jdbc.odbc.JdbcOdbcDriver")
                ,@WebInitParam(name = "userName",value = "System")})
public class InitAnnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("driverName : "+getInitParameter("driverName")+"<br>");
        writer.println("userName : "+getInitParameter("userName")+"<br>");
        writer.println("</body></html>");
        writer.close();
    }
}
