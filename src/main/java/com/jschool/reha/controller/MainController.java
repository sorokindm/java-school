package com.jschool.reha.controller;

import com.jschool.reha.crud.entity.Person;
import com.jschool.reha.crud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Main controller
 * @author Dmitry Sorokin
 */
@Controller
public class MainController {


    private static final String LOGIN_PAGE = "login";
    private static final String LOGGED_IN_PAGE = "loggedIn";
    private static final String REDIRECT_LOGGED_IN = "redirect:/" + LOGGED_IN_PAGE;

    @Autowired
    private AdminService adminService;

    /**
     * Welcome page mapping
     * @param request
     * @return welcome or login page ULR
     */
    @RequestMapping("/")
    public String loginPage(HttpServletRequest request) {
        //TODO Main menu page
         return REDIRECT_LOGGED_IN;
    }

    @GetMapping(value="/admin")
    public String adminPageGet() {

        return "admin";
    }

    @PostMapping(value="/admin")
    public String adminPagePost() {

        return "admin";
    }

    /**
     * Logged in page. Fetches user data from db, adds data to attribute
     * @param model
     * @return logged in page on success, error page on fail
     */
    @GetMapping("/loggedIn")
    public String loggedInPage(Model model) {
        List<Person> personList=adminService.getAllPersons();


        //Add user data to model and present it in logged in page
        if (personList != null) {
            model.addAttribute("users", personList);
            return LOGGED_IN_PAGE;
        } else {
            return "error";
        }


    }
}
