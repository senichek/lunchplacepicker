package com.olexiy.lunchplacepicker.controllers;

import com.olexiy.lunchplacepicker.controllers.restaurant.AbstractRestaurantController;
import com.olexiy.lunchplacepicker.models.Restaurant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MainUIRestaurantController extends AbstractRestaurantController {
    @GetMapping(value = "/restaurants")
    public List<Restaurant> getAllWithLikes(@RequestParam(value = "sort", required = false) String sortOrder) {
        if (sortOrder != null && sortOrder.equals("desc")) {
            return super.getAllWithLikesDesc();
        }
        if (sortOrder != null && sortOrder.equals("asc")) {
            return super.getAllWithLikesAsc();
        } else {
            return super.getAllWithLikes();
        }
    }
}