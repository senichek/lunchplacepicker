package com.olexiy.lunchplacepicker.service.restaurant;

import com.olexiy.lunchplacepicker.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    List<Restaurant> getAllWithLikes();

    List<Restaurant> getAllByUserIdWithLikes(Integer id);

    Restaurant getByID(Integer id);

    Restaurant getByUserIdAndEntityId(Integer userId, Integer entityId);

    List<Restaurant> getAllByUserId(Integer id);

    Restaurant save(Restaurant restaurant);

    void delete(Integer id);
}