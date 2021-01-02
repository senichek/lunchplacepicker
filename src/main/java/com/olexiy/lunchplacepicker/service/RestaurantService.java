package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    Restaurant getByID(Integer id);

    List<Restaurant> getAllByUserId(Integer id);

    void save(Restaurant restaurant);

    void delete(Integer id);

    boolean existsById(Integer id);
}
