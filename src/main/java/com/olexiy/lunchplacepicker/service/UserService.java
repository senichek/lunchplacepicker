package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByID(Integer id);

    User getByEmail(String email);

    User save(User user);

    void deleteByID(Integer id);

    boolean existsById(Integer id);

    User getWithRestaurants(Integer id);
}
