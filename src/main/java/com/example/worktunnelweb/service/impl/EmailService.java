package com.example.worktunnelweb.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendAdminCredentials(String toEmail, String username, String password) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Admin Account Created");

        message.setText(
                "Hello,\n\n" +
                        "Your admin account has been created.\n\n" +
                        "Username: " + username + "\n" +
                        "Password: " + password + "\n\n" +
                        "Please login and change your password.\n\n" +
                        "Thank you!"
        );

        mailSender.send(message);
    }
    public void sendUpdatedAdminCredentials(String toEmail, String username, String password) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Admin Account Updated");

        message.setText(
                "Hello,\n\n" +
                        "Your admin account details have been updated.\n\n" +
                        "Updated Username: " + username + "\n" +
                        "Updated Password: " + password + "\n\n" +
                        "If you did not request this change, please contact support immediately.\n\n" +
                        "Thank you!"
        );

        mailSender.send(message);
    }


}