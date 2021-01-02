package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.repository.RestaurantRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<Restaurant> getAll() {
        Iterable<Restaurant> restaurants = restaurantRepo.findAll();
        List<Restaurant> all = new ArrayList<>();
        restaurants.forEach(r -> {
            all.add(r);
        });
        return all;
    }

    @Override
    public Restaurant getByID(Integer id) {
        if (!restaurantRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            return restaurantRepo.getById(id);
        }
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
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
    public boolean existsById(Integer id) {
        return restaurantRepo.existsById(id);
    }

    @Override
    public List<Restaurant> getAllByUserId(Integer id) {
        return restaurantRepo.getAllByUserId(id);
    }
}
