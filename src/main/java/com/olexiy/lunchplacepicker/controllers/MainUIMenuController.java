package com.olexiy.lunchplacepicker.controllers;

import com.olexiy.lunchplacepicker.controllers.menu.AbstractMenuController;
import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MainUIMenuController extends AbstractMenuController {
    @GetMapping(value = "/menus")
    public List<Menu> getAllWithLikes() {
        return super.getAllWithLikes();
    }

    @GetMapping(value = "/menus/restaurant/{restaurantID}")
    public List<Menu> getAllByRestaurantId(@PathVariable("restaurantID") Integer id) {
        return super.getAllMenusByRestaurantId(id);
    }
}