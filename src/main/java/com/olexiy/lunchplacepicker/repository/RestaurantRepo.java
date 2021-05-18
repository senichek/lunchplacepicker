package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

    Restaurant getRestaurantById(Integer id);

    Restaurant getByIdAndUserId(Integer id, Integer userId);

    List<Restaurant> getAllByUserId(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    void deleteById(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:restId AND r.user.id=:userId")
    int deleteByIdAndUserId(Integer restId, Integer userId);

    @Query(value = "SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.likesOfRestaurant")
    List<Restaurant> getAllWithLikes();

    @Query(value = "SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.likesOfRestaurant WHERE r.user.id=:id")
    List<Restaurant> getAllByUserIdWithLikes(Integer id);
}
