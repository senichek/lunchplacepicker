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
        return "adminUI/users";
    }

    @GetMapping("/admin/{id}/all")
    public String RestaurantsOfAdmin(@PathVariable int id) {
        return "adminUI/restaurants";
    }

    @GetMapping("/admin/menus/{id}/all")
    public String MenusOfRestaurant(@PathVariable int id) {
        return "adminUI/menus";
    }

    @GetMapping("/profile/restaurants/all")
    public String RestaurantsOfUser() {
        return "userUI/userRestaurants";
    }

    @GetMapping("/profile/menus/{id}/all/likes")
    public String MenusOfUserRestaurantsWithLikes(@PathVariable int id) {
        return "userUI/userMenus";
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
    public String registration(){ return "userUI/registration"; }

    @GetMapping(value = "/login")
    public String login(){
        // login page exceptions are handled by CustomErrorController;
        // https://www.baeldung.com/spring-boot-custom-error-page
        return "userUI/login";
    }

    @GetMapping(value = "/accessDenied")
    public String accessDenied(){
        return "userUI/accessDenied";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("var", "test variable string");
        String index = "index";
        return index;
    }

    @GetMapping(value = "/api-doc")
    public String showApiDocs(){
        return "api-doc";
    }
}
