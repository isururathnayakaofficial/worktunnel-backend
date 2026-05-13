package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.Doctor_SlipDTO;
import com.example.worktunnelweb.service.DynamicMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class DynamicMailServiceImpl implements DynamicMailService {

    @Override
    public void sendMail(Doctor_SlipDTO dto) {

        try {

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

            // Gmail SMTP
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);

            // Dynamic sender credentials
            mailSender.setUsername(dto.getFromEmail());
            mailSender.setPassword(dto.getAppPassword());

            Properties props = mailSender.getJavaMailProperties();

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            // Create Mail
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(dto.getFromEmail());
            message.setTo(dto.getPatientEmail());

            message.setSubject("Doctor Prescription");

            message.setText(
                    "Doctor Name: " + dto.getDoctorName() + "\n" +
                            "Patient Name: " + dto.getPatientName() + "\n" +
                            "Age: " + dto.getAge() + "\n" +
                            "Date: " + dto.getDate() + "\n\n" +

                            "Description:\n" +
                            dto.getDescription() + "\n\n" +

                            "Medicine List:\n" +
                            dto.getMedicine_list()
            );

            // Send Mail
            mailSender.send(message);

        } catch (Exception e) {

            throw new RuntimeException("Email sending failed : " + e.getMessage());

        }
    }
}