package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.repository.UserRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserServiceImpl() {
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getByID(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            return userRepo.getById(id);
        }
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            userRepo.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return userRepo.existsById(id);
    }
}
