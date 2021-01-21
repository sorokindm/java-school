package com.jschool.reha.controller;

import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.service.AdminService;
import com.jschool.reha.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Doctor controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class DoctorController {

    private static final String DOCTOR_PAGE = "doctor";
    private static final String REDIRECT_DOCTOR_PAGE = "/java_school/doctor";

    @Autowired
    private AdminService adminService;

    @Autowired
    private DoctorService doctorService;

    /**
     * Doctor page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor")
    public String doctorPage() {
        return DOCTOR_PAGE;
    }


    /**
     * New Patient page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor/newPatient")
    public String doctorNewPatientPage(Model model) {
        model.addAttribute("patient",new Patient());
        return "newPatient";
    }

    /**
     * Process new patient form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newPatient/processForm")
    public RedirectView processNewPatientForm(@ModelAttribute("patient") Patient patient) {
        doctorService.addNewPatient(patient);
        return new RedirectView(REDIRECT_DOCTOR_PAGE);
    }

    /**
     * New Treatment page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor/newTreatment")
    public String doctorNewTreatmentPage(Model model) {
        model.addAttribute("treatment",new Treatment());
        return "newTreatment";
    }

    /**
     * Process new treatment form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newTreatment/processForm")
    public RedirectView processNewTreatmentForm(@ModelAttribute("treatment") Treatment treatment) {
        doctorService.addNewTreatment(treatment);
        return new RedirectView(REDIRECT_DOCTOR_PAGE);
    }

    /**
     * New Assignment page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor/newAssignment")
    public String doctorNewAssignmentPage(Model model) {
        model.addAttribute("assignment",new Assignment());
        return "newAssignment";
    }

    /**
     * Process new Assignment form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newAssignment/processForm")
    public RedirectView processNewAssignmentForm(@ModelAttribute("assignment") Assignment assignment) {
        doctorService.addNewAssignment(assignment);
        return new RedirectView(REDIRECT_DOCTOR_PAGE);
    }
}
