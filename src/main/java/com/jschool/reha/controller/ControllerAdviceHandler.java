package com.jschool.reha.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class ControllerAdviceHandler {
    private Logger logger = LogManager.getLogger();

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException ex, Model model) {
        model.addAttribute("msg", "404:The page that you requested does not exist");
        logger.info("No page handler found, redirecting to error page with code 404");
        return "error";
    }
}
