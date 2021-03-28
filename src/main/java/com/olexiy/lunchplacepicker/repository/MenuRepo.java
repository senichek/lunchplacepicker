package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface MenuRepo extends JpaRepository<Menu, Integer> {
    Menu getById(Integer id);

    List<Menu> getAllByRestaurantId(Integer id);

    @Query(value = "SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.likesOfMenu WHERE m.restaurant.id=:id")
    List<Menu> getAllByRestaurantIdWithLikes(Integer id);

    @Query(value = "SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.likesOfMenu")
    List<Menu> getAllWithLikes();

    void deleteById(Integer id);
}