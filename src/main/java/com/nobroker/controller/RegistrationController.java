package com.nobroker.controller;

import com.nobroker.entity.User;
import com.nobroker.service.EmailService;
import com.nobroker.service.EmailVerificationService;
import com.nobroker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private EmailVerificationService emailVerificationService;
    private UserService userService;
    private EmailService emailService;

    public RegistrationController(EmailVerificationService emailVerificationService, UserService userService, EmailService emailService) {
        this.emailVerificationService = emailVerificationService;
        this.userService = userService;
        this.emailService = emailService;
    }


    //http://localhost:8080/api/register
    @PostMapping("/register")
    public Map<String,String>registerUser(@RequestBody User user){
        //register the user without email verification
        User registeredUser=userService.registerUser(user);
        return emailService.sendOtpEmail(user.getEmail());
    }

    //http://localhost:8080/api/verify-otp?email=&otp=
    @PostMapping("/verify-otp")
    public  Map<String,String> verifyOtp(@RequestParam String email,@RequestParam String otp){
        return emailVerificationService.verifyOtp(email,otp);
    }














}

