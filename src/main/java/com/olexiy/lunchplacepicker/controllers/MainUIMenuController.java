package com.olexiy.lunchplacepicker.controllers;

import com.olexiy.lunchplacepicker.controllers.menu.AbstractMenuController;
import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MainUIMenuController extends AbstractMenuController {
    @GetMapping(value = "/menus")
    public List<Menu> getAllWithLikes(@RequestParam(value = "sort", required = false) String sortOrder) {
        if (sortOrder != null && sortOrder.equals("desc")) {
            return super.getAllWithLikesDesc();
        }
        if (sortOrder != null && sortOrder.equals("asc")) {
            return super.getAllWithLikesAsc();
        } else {
            return super.getAllWithLikes();
        }
    }

    @GetMapping(value = "/menus/restaurant/{restaurantID}")
    public List<Menu> getAllByRestaurantId(@PathVariable("restaurantID") Integer id) {
        return super.getAllMenusByRestaurantId(id);
    }
}