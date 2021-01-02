package com.olexiy.lunchplacepicker.repository;

import com.olexiy.lunchplacepicker.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    Restaurant getById(Integer id);
    Restaurant getByName(String name);
    List<Restaurant> getAllByUserId(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
