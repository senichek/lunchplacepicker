package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserProfileController extends AbstractUserController {

    /*@GetMapping(value = "/")
    public List<User> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }*/

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
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

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }*/
}