package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.controllers.menu.AbstractMenuController;
import com.olexiy.lunchplacepicker.models.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/menus", produces = MediaType.APPLICATION_JSON_VALUE)
public class LikeUIController extends AbstractLikeController {

    /*@GetMapping(value = "/{restId}/{menuId}/all")
    public List<Menu> getAllForMenu() {
        return super.getAll();
    }*/

    /*@GetMapping(value = "/likes/{id}")
    public Menu getByID(@PathVariable("id") Integer id) {
        return super.getByID(id);
    }

    @GetMapping(value = "/likes/{id}")
    public List<Menu> getAllByRestIDWithLikes(@PathVariable("id") Integer id) {
        return super.getMenusByRestaurantIdWithLikes(id);
    }

    @PostMapping(value = "/{restId}/{menuId}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void save(@RequestBody Menu menu) {
        super.save(menu);
    }

    @DeleteMapping("/likes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }*/
}