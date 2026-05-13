package com.example.worktunnelweb.service;

import com.example.worktunnelweb.dto.Doctor_SlipDTO;

import java.time.LocalDate;

public interface DynamicMailService {

    void sendMail(Doctor_SlipDTO dto);
}
