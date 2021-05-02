package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserProfileRestController extends AbstractUserController {

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user, HttpServletRequest request) {
        String rawPassword = user.getPassword();
        super.save(user);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            public void afterCommit() {
                //This part is executed after the transaction is committed (after the user has been saved to db)
                SecurityUtils.login(request, user.getEmail(), rawPassword);
            }
        });
    }

    @GetMapping(value = "/ifloggedin")
    public boolean ifLoggedIn() {
        return SecurityUtils.isLoggedIn();
    }
}