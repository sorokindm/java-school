package com.jschool.reha.controller;

import com.jschool.reha.dto.UserDto;
import com.jschool.reha.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;


/**
 * Main controller
 *
 * @author Dmitry Sorokin
 */
@Controller
public class MainController {
    private static final String HOME_PAGE = "home";
    private static final String REDIRECT_ADMIN_PAGE = "redirect:/admin";
    private static final String REDIRECT_PATIENT_PAGE = "redirect:/patient";
    private static final String REDIRECT_DOCTOR_PAGE = "redirect:/doctor";
    private static final String REDIRECT_NURSE_PAGE = "redirect:/nurse";

    @Autowired
    private AdminService adminService;

    /**
     * Welcome page mapping
     *
     * @return home page ULR
     */
    @GetMapping("/")
    public String homePage(Principal principal) {
        UserDto user=adminService.findUserByUsername(principal.getName());
        switch (user.getRole()) {
            case ROLE_ADMIN:{
                return REDIRECT_ADMIN_PAGE;
            }
            case ROLE_PATIENT:{
                return REDIRECT_PATIENT_PAGE;
            }
            case ROLE_NURSE:{
                return REDIRECT_NURSE_PAGE;
            }
            case ROLE_DOCTOR:{
                return REDIRECT_DOCTOR_PAGE;
            }
        }
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
        model.setViewName("admin");
        return model;
    }

    /**
     * Page for adding new mediacal staff
     *
     * @return model with UserDto List
     */
    @GetMapping("/admin/newMedStaff")
    public String newMedStaffPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "newMedStaff";
    }

    /**
     * Page for processing form to add new medStaff
     *
     * @return model with UserDto List
     */
    @PostMapping("/admin/newMedStaff/processForm")
    public RedirectView processNewMedStaffForm(@ModelAttribute("user") UserDto userDto) {
        adminService.addNewMedStaff(userDto);
        return new RedirectView("/java_school/admin");
    }

}
