package com.loparok.controller;


import com.loparok.configuration.JwtProvider;
import com.loparok.model.User;
import com.loparok.repository.UserRepository;
import com.loparok.response.AuthResponse;
import com.loparok.service.CustomUserDetailsService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetails;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse createUser(@RequestBody User user) throws ExecutionControl.UserException {



        return null;
    }

}
