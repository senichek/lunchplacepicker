package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUIController extends AbstractUserController {

    @GetMapping(value = "/users")
    public List<User> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void save(@RequestBody User user) {
        super.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}/all")
    public List<Restaurant> getRestaurantsOfUser(@PathVariable("id") Integer id) {
        return super.getRestaurantsOfUser(id);
    }
}
