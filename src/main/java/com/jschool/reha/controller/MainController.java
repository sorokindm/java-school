package com.jschool.reha.controller;

import com.jschool.reha.dto.UserDto;
import com.jschool.reha.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Main controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class MainController {
    private static final String HOME_PAGE = "home";
    private static final String ADMIN_PAGE = "admin";
    private static final String DOCTOR_PAGE = "doctor";
    private static final String NURSE_PAGE = "nurse";
    private static final String PATIENT_PAGE = "patient";

    @Autowired
    private AdminService adminService;

    /**
     * Welcome page mapping
     *
     * @return home page ULR
     */
    @GetMapping("/")
    public String homePage() {
        return HOME_PAGE;
    }

    /**
     * Admin page. Fetches user data from db
     *
     * @return model with UserDto List
     */
    @GetMapping("/admin")
    public ModelAndView adminPage() {
        List<UserDto> users = adminService.getAllUserData();

        ModelAndView model = new ModelAndView();
        model.addObject("users", users);
        model.setViewName(ADMIN_PAGE);
        return model;
    }

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
     * Nurse page mapping
     *
     * @return nurse page url
     */
    @GetMapping("/nurse")
    public String nursePage() {
        return NURSE_PAGE;
    }

    /**
     * Patient page mapping
     *
     * @return patient page url
     */
    @GetMapping("/patient")
    public String patientPage() {
        return PATIENT_PAGE;
    }

}
