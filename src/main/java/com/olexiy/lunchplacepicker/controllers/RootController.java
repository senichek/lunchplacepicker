package com.olexiy.lunchplacepicker.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/users")
    public String Users() {
        return "users";
    }

    @GetMapping("/admin/restaurants/{id}/all")
    public String RestaurantsOfUser(@PathVariable int id) {
        return "restaurants";
    }
}
