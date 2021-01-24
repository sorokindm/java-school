package com.jschool.reha.controller;

import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.Assignment;
import com.jschool.reha.service.interfaces.AdminService;
import com.jschool.reha.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

/**
 * Doctor controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class DoctorController {

    private static final String DOCTOR_PAGE = "doctor";
    private static final String REDIRECT_DOCTOR_PAGE = "/java_school/doctor";
    private static final String REDIRECT_TREATMENTS_PAGE = "/java_school/doctor/treatments";

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
        model.addAttribute("user", new UserDto());
        return "newPatient";
    }

    /**
     * Process new patient form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newPatient/processForm")
    public RedirectView processNewPatientForm(@ModelAttribute("user") UserDto userDto) {
        adminService.addNewPatient(userDto);
        return new RedirectView(REDIRECT_DOCTOR_PAGE);
    }

    /**
     * Page with all treatments
     *
     * @return treatments page
     */
    @GetMapping("/doctor/treatments")
    public String treatmentsPage(Model model) {
        List<TreatmentDto> treatments = doctorService.getAllTreatments();
        model.addAttribute("treatments", treatments);
        return "treatments";
    }

    /**
     * Select patient page mapping
     *
     * @return selectPatient page url
     */
    @GetMapping("/doctor/newTreatment/selectPatient")
    public String selectPatientForTreatment(Model model) {
        model.addAttribute("patients", doctorService.getAllPatients());
        return "selectPatient";
    }

    /**
     * New Treatment form page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor/newTreatment/create")
    public String doctorNewTreatmentPage(Principal principal, @RequestParam("patientId") int patientId, Model model) {
        TreatmentDto dto = new TreatmentDto();
        dto.setDoctor(adminService.findMedStaffByUsername(principal.getName()));
        dto.setPatient(adminService.findPatientById(patientId));
        model.addAttribute("treatment", dto);
        return "newTreatment";
    }

    /**
     * Process new treatment form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newTreatment/processForm")
    public RedirectView processNewTreatmentForm(@ModelAttribute("treatment") TreatmentDto treatmentDto) {
        doctorService.addNewTreatment(treatmentDto);
        return new RedirectView(REDIRECT_TREATMENTS_PAGE);
    }

    /**
     * Page with all assignments for selected treatment
     *
     * @return treatments page
     */
    @GetMapping("/doctor/assignment")
    public String assignments(@RequestParam("idTreatment") int idTreatment, Model model) {
        List<AssignmentDto> assignments = doctorService.getAssignmentsForTreatment(idTreatment);
        model.addAttribute("assignments", assignments);
        return "assignments";
    }

    /**
     * New Assignment page mapping
     *
     * @return doctor page url
     */
    @GetMapping("/doctor/newAssignment/create")
    public String doctorNewAssignmentPage(Model model) {
        model.addAttribute("assignment", new AssignmentDto());
        return "newAssignment";
    }

    /**
     * Process new Assignment form
     *
     * @return doctor page url
     */
    @PostMapping("/doctor/newAssignment/processForm")
    public RedirectView processNewAssignmentForm(@ModelAttribute("assignment") AssignmentDto assignmentDto) {
        doctorService.addNewAssignment(assignmentDto);
        return new RedirectView(REDIRECT_DOCTOR_PAGE);
    }
}
