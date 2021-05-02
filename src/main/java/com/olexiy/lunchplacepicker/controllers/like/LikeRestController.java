package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/likes", produces = MediaType.APPLICATION_JSON_VALUE)
public class LikeRestController extends AbstractLikeController {

    @GetMapping(value = "/menu/{id}")
    public List<LikeOfMenu> getByMenuID(@PathVariable("id") Integer id) {
        return super.getAllByMenuID(id);
    }

    @GetMapping(value = "/restaurant/{id}")
    public List<LikeOfRestaurant> getByRestaurantID(@PathVariable("id") Integer id) {
        return super.getAllByRestaurantID(id);
    }

    @PostMapping(value = "/menu/{menuID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void saveLikeOfMenu(@RequestBody LikeOfMenu likeOfMenu, @PathVariable("menuID") Integer id) {
        super.saveLikeOfMenu(likeOfMenu, id);
    }

    @PostMapping(value = "/restaurant/{restaurantID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public void saveLikeOfRestaurant(@RequestBody LikeOfRestaurant likeOfRestaurant, @PathVariable("restaurantID") Integer id) throws Exception {
        super.saveLikeOfRestaurant(likeOfRestaurant, id);
    }
}