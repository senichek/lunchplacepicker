package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.service.user.UserService;
import com.olexiy.lunchplacepicker.utils.CustomValidator;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
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

    @Autowired
    private UserService userService;

    public AbstractRestaurantController() {
    }

    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    public List<Restaurant> getAllWithLikes() {
        return restaurantService.getAllWithLikes();
    }

    public List<Restaurant> getAllWithLikesDesc() {
        return restaurantService.getAllWithLikesDesc();
    }

    public List<Restaurant> getAllWithLikesAsc() {
        log.info("get all restaurants with likes Asc");
        return restaurantService.getAllWithLikesAsc();
    }

    // Used only by rest controller
    public Restaurant getByID(Integer userId, Integer entityId) {
        log.info("get restaurant {} of user {}", entityId, userId);
        return restaurantService.getByUserIdAndEntityId(userId, entityId);
    }

    public void save(Restaurant restaurant, Integer userID) {
        if (restaurant.isNew()) {
            User user = userService.getByID(userID);
            if (user == null) {
                throw new NotFoundException(String.format("Entity with id %s does not exist;", userID));
            } else {
                restaurant.setUser(user);
            }
            // the date doesn't come from the form, it is set up by default
            restaurant.setRegisterDateTime(LocalDateTime.now());

            /*The failed validation triggers an exception. The methods marked by @ExceptionHandler will
            handle the exception, see GlobalExceptionHandler class.*/
            CustomValidator.validate(restaurant);
            restaurantService.save(restaurant);
            log.info("created {}", restaurant);
        } else {
            Restaurant toUpdate = restaurantService.getByID(restaurant.getId());

            if (toUpdate == null) {
                throw new NotFoundException(String.format("Entity with id %s does not exist;", restaurant.getId()));
            } else {
                if (!toUpdate.getName().equals(restaurant.getName())) {
                    toUpdate.setName(restaurant.getName());
                }
                if (!toUpdate.getAddress().equals(restaurant.getAddress())) {
                    toUpdate.setAddress(restaurant.getAddress());
                }
                if (!toUpdate.getDescription().equals(restaurant.getDescription())) {
                    toUpdate.setDescription(restaurant.getDescription());
                }
                if (!toUpdate.getImageUrl().equals(restaurant.getImageUrl())) {
                    toUpdate.setImageUrl(restaurant.getImageUrl());
                }
                log.info("updated {}", toUpdate);
                restaurantService.save(toUpdate);
            }
        }
    }

    public void delete(Integer userId, Integer entityId) {
        if (restaurantService.deleteByIdAndUserId(entityId, userId) == 1) {
            log.info("deleted restaurant with id {} of user {}", entityId, userId);
        }
        else {
            throw new NotFoundException(String.format("Combination user_id %s and entity_id %s does not exist;", userId, entityId));
        }
    }

    public List<Restaurant> getRestaurantsOfUser(Integer id) {
        log.info("get all restaurants of user {}", id);
        return restaurantService.getAllByUserId(id);
    }

    public List<Restaurant> getRestaurantsOfUserWithLikes(Integer id) {
        log.info("get all restaurants of user {}", id);
        return restaurantService.getAllByUserIdWithLikes(id);
    }

    public List<Restaurant> getRestaurantsOfLoggedInUser() {
        log.info("get all restaurants of the logged in user {}", SecurityUtils.getLoggedInUser().getId());
        return restaurantService.getAllByUserId(SecurityUtils.getLoggedInUser().getId());
    }

    public List<Restaurant> getRestaurantsOfLoggedInUserWithLikes() {
        log.info("get all restaurants of the logged in user {}", SecurityUtils.getLoggedInUser().getId());
        return restaurantService.getAllByUserIdWithLikes(SecurityUtils.getLoggedInUser().getId());
    }
}