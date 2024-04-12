package com.example.demo.controller;


import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v2/mail")
@CrossOrigin
public class mailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/sendConfirmationEmail")
    public String sendConfirmationEmail(@RequestParam String email) {
        // Generate confirmation token
        //String token = generateToken();

        // Send email
        String subject = "Confirm your email";
        String text = "Please click the following link to confirm your email: http://yourdomain.com/confirm?token=" ;//+ token;
        emailService.sendEmail(email, subject, text);

        return "Confirmation email sent successfully!";
    }
    /*private String generateToken() {
        // Generate token logic, for example:
        return UUID.randomUUID().toString();
    }*/
}
