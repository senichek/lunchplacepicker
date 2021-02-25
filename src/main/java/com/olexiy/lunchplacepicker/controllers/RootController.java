package com.olexiy.lunchplacepicker.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/users")
    public String Users() {
        return "users";
    }

    @GetMapping("/admin/{id}/all")
    public String RestaurantsOfAdmin(@PathVariable int id) {
        return "restaurants";
    }

    @GetMapping("/profile/restaurants/all")
    public String RestaurantsOfUser() {
        return "userUI/userRestaurants";
    }

    @GetMapping("/admin/menus/{id}/all")
    public String MenusOfRestaurant(@PathVariable int id) {
        return "menus";
    }

    @GetMapping(value = "/restaurants")
    public String RestaurantsAll(){
        return "restaurantsMainPage";
    }

    @GetMapping(value = "/menus")
    public String MenusAll(){
        return "menusMainPage";
    }

    @GetMapping(value = "/register")
    public String registration(){
        return "userUI/registration";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("var", "test variable string");
        String index = "index";
        return index;
    }
}
