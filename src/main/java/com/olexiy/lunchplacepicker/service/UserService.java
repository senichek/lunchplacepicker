package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByID(Integer id);

    void save(User user);

    void delete(Integer id);

    boolean existsById(Integer id);
}
