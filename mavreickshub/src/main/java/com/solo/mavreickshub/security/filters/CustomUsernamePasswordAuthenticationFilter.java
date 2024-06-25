package com.solo.mavreickshub.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solo.mavreickshub.dtos.request.LoginRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Collection;



@Component
@AllArgsConstructor
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
      String token = JWT.create()
               .withIssuer("mavericks_hub")
               .withArrayClaim("roles", getClaimsForm(authResult.getAuthorities()))
               .withExpiresAt(Instant.now().plusSeconds(24 * 60 * 60))
               .sign(Algorithm.HMAC512("secret"));

    }
    private static String[] getClaimsForm(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map((grantedAuthority )-> grantedAuthority.getAuthority())
                .toArray(String[]::new);

    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //1 Retrieve authentication credentials from the request body
            InputStream requestBodyStream = request.getInputStream();
            //2 Convert the request body to a LoginRequest object
            LoginRequest loginRequest = objectMapper.readValue(requestBodyStream, LoginRequest.class);
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
            //3 Create an authentication token from the credentials
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            //4 pass the unauthenticated object to the AuthenticationManager
            //get back the authentication result form the AuthenticationManager
           Authentication authenticationResult = authenticationManager.authenticate(authentication);
           //5 put the authentication result in the security  context
            SecurityContextHolder.getContext().setAuthentication(authenticationResult);
           return authenticationResult;
        } catch (IOException e) {
            throw new BadCredentialsException(e.getMessage());
        }

    }
}
