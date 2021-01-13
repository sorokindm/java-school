package com.jschool.reha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
//TODO 12.01.2021 matmalik: remove unused imports
/**
 * User login controller
 * @author Dmitry Sorokin
 */
@Controller
public class LoginController {

    private static final String LOGIN_PAGE = "login";
    private static final String LOGGED_IN_PAGE = "loggedIn";
    private static final String REDIRECT_LOGGED_IN = "redirect:/" + LOGGED_IN_PAGE;
    //TODO 12.01.2021 matmalik: dio we need this REDIRECT_LOGGED_IN?

    /**
     * Welcome page mapping
     * @param request
     * @return welcome or login page ULR
     */
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        return LOGIN_PAGE;
    }

    /**
     * Login action
     * @param request
     * @param username
     * @param password
     * @return Logged in page on success, login page on fail
     */
    @PostMapping("/doLogin")
    public String doLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        return "/";
    }
}
