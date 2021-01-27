package com.jschool.reha.controller;

import com.jschool.reha.service.interfaces.AdminService;
import com.jschool.reha.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AdminService adminService;

    /**
     * Patient page mapping
     *
     * @return patient page url
     */
    @GetMapping("/patient")
    public String patientPage(Model model, Principal principal) {
        int patientId=adminService.findUserByUsername(principal.getName()).getPatient().getIdPatient();
        model.addAttribute("medEvents",patientService.getAllActiveMedEventsForGivenPatient(patientId));
        return "patient";
    }
}
