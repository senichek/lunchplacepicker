package com.olexiy.lunchplacepicker.controllers.menu;

import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/profile/menus", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserMenuRestController extends AbstractMenuController {

    // unused in UI, used only in REST
    @GetMapping(value = "/")
    public List<Menu> getAll() {
        return super.getAll();
    }

    // unused in UI, used only in REST
    @GetMapping(value = "/likes")
    public List<Menu> getAllWithLikes() {
        return super.getAllWithLikes();
    }

    @GetMapping(value = "/{id}")
    public Menu getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Menu menu, @PathVariable("restaurantId") Integer restaurantId) {
        super.save(menu, restaurantId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }

    @GetMapping(value = "/{id}/all")
    public List<Menu> getAllMenusByRestaurantId(@PathVariable("id") Integer id) {
        return super.getAllMenusByRestaurantId(id);
    }

    @GetMapping(value = "/{id}/all/likes")
    public List<Menu> getAllMenusByRestaurantIdWithLikes(@PathVariable("id") Integer id) {
        return super.getAllMenusByRestaurantIdWithLikes(id);
    }
}