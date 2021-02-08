package com.olexiy.lunchplacepicker.service.user;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.repository.RestaurantRepo;
import com.olexiy.lunchplacepicker.repository.UserRepo;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    private RestaurantRepo restaurantRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RestaurantRepo restaurantRepo) {
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
    }

    public UserServiceImpl() {
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public User getWithRestaurants(Integer id) {
        User user = userRepo.getById(id);
        user.setRestaurants(restaurantRepo.getAllByUserId(id));
        return user;
    }

    @Override
    public User getByID(Integer id) {
        User user = userRepo.getById(id);
        if (user == null) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            return user;
        }
    }

    @Override
    public User getByEmail(String email) {
        User user = userRepo.getByEmail(email);
        if (user == null) {
            throw new NotFoundException(String.format("Entity with email %s does not exist;", email));
        } else {
            return user;
        }
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteByID(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException(String.format("Entity with id %s does not exist;", id));
        } else {
            userRepo.deleteById(id);
        }
    }
}
