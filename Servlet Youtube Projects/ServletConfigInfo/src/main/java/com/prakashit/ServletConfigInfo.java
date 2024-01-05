package com.prakashit;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class ServletConfigInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        ServletConfig servletConfig = getServletConfig();
        writer.println("<html><body>");
        writer.println("driverName : "+servletConfig.getInitParameter("driverName")+"<br>");
        writer.println("userName : "+servletConfig.getInitParameter("userName")+"<br>");
        writer.println("password : "+servletConfig.getInitParameter("password")+"<br>");
        writer.println("</body></html>");
        writer.println("==========2nd way=========+<br>");
        Enumeration<String> initObjects = servletConfig.getInitParameterNames();
        String str = "";
        writer.println("<html><body>");
        while (initObjects.hasMoreElements()){
            str = initObjects.nextElement();
            writer.println("name = "+str+"<br>");
            writer.println("value = "+servletConfig.getInitParameter(str)+"<br>");
        }
        writer.println("</body></html>");
        writer.close();
    }
}
