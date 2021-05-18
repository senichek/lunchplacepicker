package com.olexiy.lunchplacepicker.service.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.repository.RestaurantRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return restaurantRepo.findAll();
    }

    @Override
    public List<Restaurant> getAllWithLikes() {
        log.info("get all restaurants with likes");
        return restaurantRepo.getAllWithLikes();
    }

    @Override
    public List<Restaurant> getAllWithLikesDesc() {
        List<Restaurant> restaurants = restaurantRepo.getAllWithLikes();

        List<Restaurant> sortedRest = restaurants.stream()
                .sorted(Comparator.comparingInt(Restaurant::getTotalLikes).reversed())
                .collect(Collectors.toList());

        log.info("get all restaurants with likes Desc");

        return sortedRest;
    }

    @Override
    public List<Restaurant> getAllWithLikesAsc() {
        List<Restaurant> restaurants = restaurantRepo.getAllWithLikes();

        List<Restaurant> sortedRest = restaurants.stream()
                .sorted(Comparator.comparingInt(Restaurant::getTotalLikes))
                .collect(Collectors.toList());

        return sortedRest;
    }

    @Override
    public List<Restaurant> getAllByUserIdWithLikes(Integer id) {
        return restaurantRepo.getAllByUserIdWithLikes(id);
    }

    @Override
    public Restaurant getByID(Integer id) {
        Restaurant restaurant = restaurantRepo.getRestaurantById(id);
        if (restaurant == null) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            return restaurant;
        }
    }

    @Override
    public Restaurant getByUserIdAndEntityId(Integer userId, Integer entityId) {
        Restaurant restaurant = restaurantRepo.getByIdAndUserId(entityId, userId);
        if (restaurant == null) {
            throw new NotFoundException(String.format("Entity %s doesn't exist or doesn't belong to user %s;" , entityId, userId));
        } else {
            return restaurant;
        }
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @Override
    public void delete(Integer id) {
        if (!restaurantRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            restaurantRepo.deleteById(id);
        }
    }

    @Override
    public int deleteByIdAndUserId(Integer restId, Integer userId) {
        return restaurantRepo.deleteByIdAndUserId(restId, userId);
    }

    @Override
    public List<Restaurant> getAllByUserId(Integer id) {
        return restaurantRepo.getAllByUserId(id);
    }
}