package com.olexiy.lunchplacepicker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String showMainPage(Model model){
        model.addAttribute("var", "test variable string");
        String index = "index";
        return index;
    }
}
