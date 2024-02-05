package com.nobroker.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.nobroker.service.EmailVerificationService.emailOtpMapping;

@Service
@AllArgsConstructor

public class EmailService {

    private JavaMailSender javaMailSender;

 private final UserService userService;

//    @Autowired
//    public EmailService(JavaMailSender javaMailSender,UserService userService) {
//        this.javaMailSender = javaMailSender;
//        this.userService=userService;
//    }
    public  String generateOtp(){
        return String.format("%06d",new java.util.Random().nextInt(1000000));
    }
    public Map<String,String> sendOtpEmail(String email) {
        String otp = generateOtp();
        emailOtpMapping.put(email,otp);
        sendEmail(email,"OTP for Email Verification","your otp is:"+otp);

        Map<String,String> response=new HashMap<>();
        response.put("statuse","success");
        response.put("message","OTP send successfully");
        return response;
    }

    private void sendEmail(String to,String subject,String text){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("your.gmail@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
