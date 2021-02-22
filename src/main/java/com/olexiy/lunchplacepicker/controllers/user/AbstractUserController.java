package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.service.user.UserService;
import com.olexiy.lunchplacepicker.utils.UserUtils;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public abstract class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    public AbstractUserController() {
    }

    public List<User> getAll() {
        log.info("get all users");
        return userService.getAll();
    }

    public User getByID(Integer id) {
        log.info("get user with id {}", id);
        return userService.getByID(id);
    }

    public void save(User user) {
        if (user.isNew()) {
            // the date doesn't come from the form, it is set up by default
            user.setRegistered(LocalDateTime.now());
            user.setPassword(UserUtils.generateCommonLangPassword());
            log.info("created {}", user);
            userService.save(user);
        } else {
            User toUpdate = userService.getByID(user.getId());
            if (toUpdate == null) {
                throw new NotFoundException(String.format("Entity with id %s does not exist;", user.getId()));
            } else {
                 /*User comes with no password and date from UI
                because the password is not serialized;*/
                if (user.getPassword() == null) {
                    user.setPassword(toUpdate.getPassword());
                }
                if (!toUpdate.getName().equals(user.getName())) {
                    toUpdate.setName(user.getName());
                }
                if (!toUpdate.getEmail().equals(user.getEmail())) {
                    toUpdate.setEmail(user.getEmail());
                }
                if (!toUpdate.getPassword().equals(user.getPassword())) {
                    toUpdate.setPassword(user.getPassword());
                }
                if (!toUpdate.getRoles().equals(user.getRoles())) {
                    toUpdate.setRoles(user.getRoles());
                }
                log.info("updated {}", toUpdate);
                userService.save(toUpdate);
            }
        }
    }

    public void delete(Integer id) {
        log.info("deleted user with id {}", id);
        userService.deleteByID(id);
    }
}