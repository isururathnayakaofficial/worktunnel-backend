package com.example.worktunnelweb.controller.SpecificFeatures;

import com.example.worktunnelweb.dto.Doctor_SlipDTO;
import com.example.worktunnelweb.service.Doctor_Slip_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor/slip")
@RequiredArgsConstructor
public class Doctor_E_slipController {
    @Autowired
    Doctor_Slip_Service doctor_slip_service;
    @PostMapping("/send")
    private void slipNote(@RequestBody Doctor_SlipDTO doctor_slipDTO) {
      doctor_slip_service.send(doctor_slipDTO);
    }
}
