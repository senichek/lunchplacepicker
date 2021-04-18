package com.olexiy.lunchplacepicker.service.like;

import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;

import java.util.List;

public interface LikeOfRestaurantService {

    LikeOfRestaurant getById(Integer id);

    void deleteById(Integer id);

    LikeOfRestaurant save(LikeOfRestaurant likeOfRestaurant);

    List<LikeOfRestaurant> getAllByRestaurantID(int id);

    LikeOfRestaurant getByUserIDAndRestaurantId(int userID, int restaurantID);

    LikeOfRestaurant getByUserId(Integer id);
}