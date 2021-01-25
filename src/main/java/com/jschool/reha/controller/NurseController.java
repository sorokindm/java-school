package com.jschool.reha.controller;

import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.MedStaffDto;
import com.jschool.reha.enums.MedEventStatus;
import com.jschool.reha.service.interfaces.AdminService;
import com.jschool.reha.service.interfaces.DoctorService;
import com.jschool.reha.service.interfaces.NurseService;
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
 * Nurse controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class NurseController {

    @Autowired
    NurseService nurseService;

    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;
    private static final String NURSE_PAGE = "nurse";

    /**
     * Nurse page mapping
     *
     * @return nurse page url
     */
    @GetMapping("/nurse")
    public String nursePage(Principal principal, Model model) {
        MedStaffDto medStaffDto=adminService.findMedStaffByUsername(principal.getName());
        List<MedEventDto> list=nurseService.findMedEventsForNurse(medStaffDto.getIdMedStaff());
        model.addAttribute("medEvents",list);
        return NURSE_PAGE;
    }

    @GetMapping("/nurse/cancel")
    public String nurseCancelEventPage(@RequestParam ("idMedEvent") int idMedEvent,Model model) {
        model.addAttribute("medEvent",nurseService.getMedEventById(idMedEvent));
        return "nurseCancelEvent";
    }

    @PostMapping("/nurse/cancel")
    public RedirectView nurseCancelEventProcess(@ModelAttribute("medEvent") MedEventDto medEventDto) {
        medEventDto.setStatus(MedEventStatus.CANCELED);
        doctorService.closeMedEvent(medEventDto);
        return new RedirectView("/java_school/nurse");
    }

    @PostMapping("/nurse/done")
    public RedirectView processDoneEvent (@RequestParam ("idMedEvent") int idMedEvent) {
        MedEventDto medEventDto=nurseService.getMedEventById(idMedEvent);
        medEventDto.setClosedComments("Done");
        medEventDto.setStatus(MedEventStatus.DONE);
        doctorService.closeMedEvent(medEventDto);
        return new RedirectView("/java_school/nurse");
    }

}
