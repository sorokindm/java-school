package com.jschool.reha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
/**
 * User login controller
 * @author Dmitry Sorokin
 */
@Controller
public class LoginController {

    private static final String LOGIN_PAGE = "login";
    private static final String LOGGED_IN ="loggedIn";
    /**
     * Welcome page mapping
     * @param request http request
     * @return welcome or login page ULR
     */
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        return LOGIN_PAGE;
    }

    /**
     * Login action
     * @param request http request
     * @param username Username
     * @param password User password
     * @return Logged in page on success, login page on fail
     */
    @PostMapping("/doLogin")
    public String doLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        return LOGGED_IN;
    }
}
