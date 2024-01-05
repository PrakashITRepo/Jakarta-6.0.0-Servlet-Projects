package com.prakashit;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletLifecycle implements Servlet {
    public ServletLifecycle() {
        System.out.println("Constructor is called..");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Inside inside init() method..");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Inside inside service() method..");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Inside inside destroy() method..");
    }
}
