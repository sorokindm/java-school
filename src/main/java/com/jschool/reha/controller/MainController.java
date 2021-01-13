package com.jschool.reha.controller;

import com.jschool.reha.crud.dto.UserDto;
import com.jschool.reha.crud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Main controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class MainController {

    //TODO 12.01.2021 matmalik: remove this empty line
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
     * @param request
     * @return home page ULR
     */
    @GetMapping("/")
    public String homePage(HttpServletRequest request) {
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
     * @param request
     * @return doctor page url
     */
    @GetMapping("/doctor")
    public String doctorPage(HttpServletRequest request) {
        return DOCTOR_PAGE;
    }

    /**
     * Nurse page mapping
     *
     * @param request
     * @return nurse page url
     */
    @GetMapping("/nurse")
    public String nursePage(HttpServletRequest request) {
        return NURSE_PAGE;
    }

    /**
     * Patient page mapping
     *
     * @param request
     * @return patienet page url
     */
    @GetMapping("/patienet") //TODO 12.01.2021 matmalik: typo in word patient
    public String patienetPage(HttpServletRequest request) {
        return PATIENT_PAGE;
    }


}
