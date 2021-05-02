package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController extends AbstractUserController {

    @GetMapping
    public List<User> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{id}")
    public User getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Transactional
    @Modifying
    public void save(@RequestBody User user) {
        super.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }
}
