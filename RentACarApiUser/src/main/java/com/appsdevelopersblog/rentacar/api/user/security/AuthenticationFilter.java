package com.appsdevelopersblog.rentacar.api.user.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appsdevelopersblog.rentacar.api.user.business.abstracts.UserService;
import com.appsdevelopersblog.rentacar.api.user.business.requests.UserRequests.LoginUserRequest;
import com.appsdevelopersblog.rentacar.api.user.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private UserService userService;
    private Environment environment;

    @Autowired
    public AuthenticationFilter(UserService userService, Environment environment, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.environment = environment;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginUserRequest credidentals  = new ObjectMapper().readValue(request.getInputStream(), LoginUserRequest.class);
            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken
                    (credidentals.getEmail(), credidentals.getPassword(), new ArrayList<>()));
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String userName = ((User)authResult.getPrincipal()).getUsername();
        UserEntity userDetails = this.userService.getByEmail(userName);
    }
}
