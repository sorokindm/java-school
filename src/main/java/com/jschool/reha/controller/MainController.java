package com.jschool.reha.controller;

import com.jschool.reha.crud.dao.PersonDAO;
import com.jschool.reha.crud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private PersonDAO personDAO;

    /**
     * Welcome page mapping
     * @param request
     * @return welcome or login page ULR
     */
    @RequestMapping("/")
    public String loginPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        if (person == null) return LOGIN_PAGE;
        else return REDIRECT_LOGGED_IN;
    }

    /**
     * Login action controller
     * @param request
     * @param username
     * @param password
     * @return Logged in page on success, login page on fail
     */
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");

        final String login = "admin";
        final String pass = "admin";
        if (person != null) {
            return REDIRECT_LOGGED_IN;
        } else {
            if (username.equals(login) && password.equals(pass)) {
                person = new Person();
                person.setUsername(username);
                person.setPassword(password);

                session.setAttribute("person", person);
                return REDIRECT_LOGGED_IN;
            }
        }
        return LOGIN_PAGE;
    }

    /**
     * Logged in page. Fetches user data from db, adds data to attribute
     * @param model
     * @return logged in page on success, error page on fail
     */
    @RequestMapping("/loggedIn")
    public String loggedInPage(Model model) {
        List<Person> personList=personDAO.getAllPersons();


        //Add user data to model and present it in logged in page
        if (personList != null) {
            model.addAttribute("users", personList);
            return LOGGED_IN_PAGE;
        } else {
            return "error";
        }


    }
}
