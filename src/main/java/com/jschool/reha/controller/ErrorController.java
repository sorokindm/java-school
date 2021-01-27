package com.jschool.reha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/403")
    public String accessForbiddenPage(Model model) {
        model.addAttribute("msg","You do not have permission to access this page");
        return "error";
    }
}
