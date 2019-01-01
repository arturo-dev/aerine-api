package com.arturo.aerineapi.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomCorsFilter extends OncePerRequestFilter {

    @Value("${security.cors.origin}")
    private String origin;

    @Value("${security.cors.header}")
    private String header;

    @Value("${security.cors.method}")
    private String method;

    @Value("${security.cors.credential}")
    private boolean credential;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, 
            HttpServletResponse response, 
            FilterChain filterChain
        ) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", method);
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
        response.addHeader("Access-Control-Expose-Headers", "WWW-Authenticate");
        if ("OPTIONS".equals(request.getMethod()))
            response.setStatus(HttpServletResponse.SC_OK);
        else
            filterChain.doFilter(request, response);
    }
}