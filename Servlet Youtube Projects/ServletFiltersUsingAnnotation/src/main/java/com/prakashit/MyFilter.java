package com.prakashit;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"},servletNames = {"Display"})
public class MyFilter implements Filter {
    static int count = 0;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        String incomingURI = ((HttpServletRequest)request).getRequestURI();

        if (incomingURI.contains("/filter")){
            System.out.println("Total visitors = "+(++count));
            System.out.println("incomingURI : "+incomingURI);
        }
    }
}
