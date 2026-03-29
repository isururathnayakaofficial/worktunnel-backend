package com.example.worktunnelweb.service.impl;

import com.example.worktunnelweb.dto.Doctor_SlipDTO;
import com.example.worktunnelweb.entity.Doctor_Slip;
import com.example.worktunnelweb.repository.Doctor_SlipRepo;
import com.example.worktunnelweb.service.Doctor_Slip_Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Doctor_Slip_ServiceImpl implements Doctor_Slip_Service {

    private final Doctor_SlipRepo doctorSlipRepo;
    @Override
    public void send(Doctor_SlipDTO doctorSlipDTO) {
        Doctor_Slip doctorSlip = new Doctor_Slip();
        doctorSlip.setPatientName(doctorSlipDTO.getPatientName());
        doctorSlip.setAge(doctorSlipDTO.getAge());
        doctorSlip.setDescription(doctorSlipDTO.getDescription());
        doctorSlip.setMedicine_list(doctorSlipDTO.getMedicine_list());
        doctorSlip.setEmail(doctorSlipDTO.getEmail());

        doctorSlipRepo.save(doctorSlip);

    }
}
