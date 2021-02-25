package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantsRestController extends AbstractRestaurantController {

    @GetMapping(value = "/rs/all")
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{userId}/{entityId}")
    public Restaurant getByID(@PathVariable("userId") Integer userId,
                              @PathVariable("entityId") Integer entityId) {
        return super.getByID(userId, entityId);
    }

    @PostMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void save(@RequestBody Restaurant restaurant, @PathVariable(value = "userId") Integer userId) {
        super.save(restaurant, userId);
    }

    @DeleteMapping("/{userId}/{entityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("userId") Integer userId,
                       @PathVariable("entityId") Integer entityId) {
        super.delete(userId, entityId);
    }

    @GetMapping(value = "/{id}/all")
    public List<Restaurant> getRestaurantsOfUser(@PathVariable("id") Integer id) {
        return super.getRestaurantsOfUser(id);
    }
}