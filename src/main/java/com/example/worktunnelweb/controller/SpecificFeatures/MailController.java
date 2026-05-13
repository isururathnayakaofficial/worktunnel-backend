package com.example.worktunnelweb.controller.SpecificFeatures;

import com.example.worktunnelweb.dto.Doctor_SlipDTO;
import com.example.worktunnelweb.service.DynamicMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
@CrossOrigin
public class MailController {

    private final DynamicMailService dynamicMailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(
            @RequestBody Doctor_SlipDTO dto
    ) {

        dynamicMailService.sendMail(dto);

        return ResponseEntity.ok("Email Sent Successfully");
    }
}