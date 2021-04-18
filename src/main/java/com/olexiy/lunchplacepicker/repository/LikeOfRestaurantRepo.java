package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LikeOfRestaurantRepo extends JpaRepository<LikeOfRestaurant, Integer> {

    LikeOfRestaurant getById(Integer id);

    void deleteById(Integer id);

    List<LikeOfRestaurant> getAllByRestaurantId(int id);

    LikeOfRestaurant getByUserIDAndRestaurantId(int userID, int restaurantID);

    LikeOfRestaurant getByUserID(Integer id);
}