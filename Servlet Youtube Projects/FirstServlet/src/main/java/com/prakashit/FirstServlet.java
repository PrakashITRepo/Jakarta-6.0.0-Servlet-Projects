package com.prakashit;

import jakarta.servlet.*;

import java.io.IOException;

public class FirstServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("I am inside service() method..");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
