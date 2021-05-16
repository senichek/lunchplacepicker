package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.Role;
import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.service.user.UserService;
import com.olexiy.lunchplacepicker.utils.CustomValidator;
import com.olexiy.lunchplacepicker.utils.UserUtils;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public abstract class AbstractUserController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AbstractUserController() {
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getByID(Integer id) {
        return userService.getByID(id);
    }

    public void save(User user) {
        if (user.isNew()) {
            // the date doesn't come from the form, it is set up by default
            user.setRegistered(LocalDateTime.now());
            if (user.getPassword() == null) {
                user.setPassword(UserUtils.generateCommonLangPassword());
            }
            if (user.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            if (user.getRoles() == null) {
                user.setRoles(Collections.singleton(Role.USER));
            }

            /*The failed validation triggers an exception. The methods marked by @ExceptionHandler will
            handle the exception, see GlobalExceptionHandler class.*/
            CustomValidator.validate(user);
            userService.save(user);
            log.info("created {}", user);
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
        userService.deleteByID(id);
    }
}