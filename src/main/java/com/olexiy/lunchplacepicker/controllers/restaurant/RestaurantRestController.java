package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends AbstractRestaurantController {

    @GetMapping(value = "/")
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{id}")
    public Restaurant getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void save(@RequestBody Restaurant restaurant) {
        super.save(restaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}/all")
    public List<Restaurant> getRestaurantsOfUser(@PathVariable("id") Integer id) {
        return super.getRestaurantsOfUser(id);
    }
}