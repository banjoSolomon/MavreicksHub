package com.solo.mavreickshub.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.solo.mavreickshub.security.utils.SecurityUtils.PUBLIC_ENDPOINTS;

@Component
public class CustomAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String requestPath = request.getServletPath();
        boolean isRequestPathPublic = PUBLIC_ENDPOINTS.contains(requestPath);
        if(isRequestPathPublic) filterChain.doFilter(request, response);
       String authorizationHeader = request.getHeader("Authorization");



    }
}
