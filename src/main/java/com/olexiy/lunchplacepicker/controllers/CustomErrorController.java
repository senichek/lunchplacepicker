package com.olexiy.lunchplacepicker.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    // login page exceptions are handled by CustomErrorController;
    // https://www.baeldung.com/spring-boot-custom-error-page

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("errorMessages", "Bad Credentials. HTTP Status Code: " + status.toString());
        return "exception";
    }
}