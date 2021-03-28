package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.service.like.LikeOfMenuService;
import com.olexiy.lunchplacepicker.service.like.LikeOfRestaurantService;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public abstract class AbstractLikeController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LikeOfMenuService likeOfMenuService;

    @Autowired
    private LikeOfRestaurantService likeOfRestaurantService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    public AbstractLikeController() {
    }

    public List<LikeOfMenu> getAllByMenuID(int id) {
        log.info("get all likes for menu {} ", id);
        return likeOfMenuService.getAllByMenuID(id);
    }

    public List<LikeOfRestaurant> getAllByRestaurantID(int id) {
        log.info("get all likes for restaurant {} ", id);
        return likeOfRestaurantService.getAllByRestaurantID(id);
    }

    public void saveLikeOfMenu(LikeOfMenu likeOfMenu, int menuID) {
        likeOfMenu.setMenu(menuService.getByID(menuID));
        likeOfMenu.setUserID(SecurityUtils.getLoggedInUser().getId());
        likeOfMenu.setCreationDateTime(LocalDateTime.now());

        LikeOfMenu likeOfMenuExist = likeOfMenuService.getByUserIDAndAndMenuId(likeOfMenu.getUserID(), likeOfMenu.getMenu().getId());
        if (likeOfMenuExist != null) {
            likeOfMenuService.deleteById(likeOfMenuExist.getId());
            log.info("deleted LIKE for menu {} ", menuID);
        } else {
            log.info("created LIKE for menu {} ", menuID);
            likeOfMenuService.save(likeOfMenu);
        }
    }

    public void saveLikeOfRestaurant(LikeOfRestaurant likeOfRestaurant, int restaurantID) {
        likeOfRestaurant.setRestaurant(restaurantService.getByID(restaurantID));
        likeOfRestaurant.setUserID(SecurityUtils.getLoggedInUser().getId());
        likeOfRestaurant.setCreationDateTime(LocalDateTime.now());

        LikeOfRestaurant likeOfRestaurantExist = likeOfRestaurantService.getByUserIDAndRestaurantId(likeOfRestaurant.getUserID(), likeOfRestaurant.getRestaurant().getId());
        if (likeOfRestaurantExist != null) {
            likeOfRestaurantService.deleteById(likeOfRestaurantExist.getId());
            log.info("deleted LIKE for restaurant {} ", restaurantID);
        } else {
            log.info("created LIKE for restaurant {} ", restaurantID);
            likeOfRestaurantService.save(likeOfRestaurant);
        }
    }
}