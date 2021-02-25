package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantsUIController extends AbstractRestaurantController {

    @PostMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void save(@RequestBody Restaurant restaurant) {
        super.save(restaurant, SecurityUtils.getLoggedInUser().getId());
    }

    @DeleteMapping("/all/{entityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("entityId") Integer entityId) {
        super.delete(SecurityUtils.getLoggedInUser().getId(), entityId);
    }

    @GetMapping(value = "/all")
    public List<Restaurant> getRestaurantsOfLoggedInUser() {
        return super.getRestaurantsOfLoggedInUser();
    }
}