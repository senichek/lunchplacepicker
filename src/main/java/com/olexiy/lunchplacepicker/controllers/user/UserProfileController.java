package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void save(@RequestBody User user) {
        super.save(user);
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