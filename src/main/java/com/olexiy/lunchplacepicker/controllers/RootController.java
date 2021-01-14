package com.olexiy.lunchplacepicker.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/users")
    public String getUsers() {
        return "users";
    }
}
