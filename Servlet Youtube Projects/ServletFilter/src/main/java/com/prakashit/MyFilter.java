package com.prakashit;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String incomingURI = ((HttpServletRequest) request).getRequestURI();
        System.out.println("incomingURI : " + incomingURI);
        if (incomingURI.contains("/user/login")) {
            Long startTime = System.currentTimeMillis();
            chain.doFilter(request, response);
            Long endTime = System.currentTimeMillis();
            System.out.println("Total time taken = " + (endTime - startTime) + " ms");
        }else {
            try {
                throw new Exception("Invalid URL, please enter valid URL.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
