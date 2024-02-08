package com.example.emaisenderapi.controller;

import com.example.emaisenderapi.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/email")
//@RequiredArgsConstructor
public class EmailController {
    EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("send")
    public String sendMmail(@RequestParam (value = "file", required = false) MultipartFile[] file, String to,
                            String[] cc, String subject, String body){
        return emailService.sendMail(file, to, cc, subject, body);
    }
}


