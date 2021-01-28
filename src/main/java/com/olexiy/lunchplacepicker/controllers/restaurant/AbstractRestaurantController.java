package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.service.RestaurantService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public abstract class AbstractRestaurantController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    public AbstractRestaurantController() {
    }

    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return restaurantService.getAll();
    }

    public Restaurant getByID(Integer id) {
        log.info("get restaurant with id {}", id);
        return restaurantService.getByID(id);
    }

    public void save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            // the date doesn't come from the form, it is set up by default
            restaurant.setRegisterDateTime(LocalDateTime.now());
            log.info("created {}", restaurant);
            restaurantService.save(restaurant);
        } else if (!restaurantService.existsById(restaurant.getId())) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", restaurant.getId()));
        } else {
            Restaurant toUpdate = restaurantService.getByID(restaurant.getId());

            if (!toUpdate.getName().equals(restaurant.getName())) {
                toUpdate.setName(restaurant.getName());
            }
            if (!toUpdate.getAddress().equals(restaurant.getAddress())) {
                toUpdate.setAddress(restaurant.getAddress());
            }
            if (!toUpdate.getDescription().equals(restaurant.getDescription())) {
                toUpdate.setDescription(restaurant.getDescription());
            }
            log.info("updated {}", toUpdate);
            restaurantService.save(toUpdate);
        }
    }

    public void delete(Integer id) {
        log.info("deleted restaurant with id {}", id);
        restaurantService.delete(id);
    }

    public List<Restaurant> getRestaurantsOfUser(Integer id) {
        log.info("get all restaurants of user {}", id);
        return restaurantService.getAllByUserId(id);
    }
}