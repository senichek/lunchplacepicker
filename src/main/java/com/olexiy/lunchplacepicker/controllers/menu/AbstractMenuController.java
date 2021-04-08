package com.olexiy.lunchplacepicker.controllers.menu;

import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public abstract class AbstractMenuController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    public AbstractMenuController() {
    }

    public List<Menu> getAll() {
        log.info("get all menus");
        return menuService.getAll();
    }

    public Menu getByID(Integer id) {
        log.info("get menu with id {}", id);
        return menuService.getByID(id);
    }

    public void save(Menu menu, Integer userID) {
        if (menu.isNew()) {
            Restaurant restaurant = restaurantService.getByID(userID);
            if (restaurant == null) {
                throw new NotFoundException(String.format("Entity with id %s does not exist;", userID));
            } else {
                menu.setRestaurant(restaurant);
            }
            // the date doesn't come from the form, it is set up by default
            menu.setCreationDateTime(LocalDateTime.now());
            menu = menuService.save(menu);
            log.info("created {}", menu);
        } else {
            Menu toUpdate = menuService.getByID(menu.getId());

            if (toUpdate == null) {
                throw new NotFoundException(String.format("Entity with id %s does not exist;", menu.getId()));
            } else {
                if (!toUpdate.getDescription().equals(menu.getDescription())) {
                    toUpdate.setDescription(menu.getDescription());
                }
                log.info("updated {}", toUpdate);
                menuService.save(toUpdate);
            }
        }
    }

    public void delete(Integer id) {
        log.info("deleted menu with id {}", id);
        menuService.delete(id);
    }

    public List<Menu> getAllMenusByRestaurantId(Integer id) {
        log.info("get all menus of restaurant {}", id);
        return menuService.getAllByRestaurantId(id);
    }

    public List<Menu> getAllMenusByRestaurantIdWithLikes(Integer id) {
        log.info("get all menus of restaurant {} with likes", id);
        return menuService.getAllByRestaurantIdWithLikes(id);
    }

    public List<Menu> getAllWithLikes() {
        log.info("get all menus with likes");
        return menuService.getAllWithLikes();
    }

    public List<Menu> getAllWithLikesDesc() {
        log.info("get all menus with likes Desc");
        return menuService.getAllWithLikesDesc();
    }

    public List<Menu> getAllWithLikesAsc() {
        log.info("get all menus with likes Asc");
        return menuService.getAllWithLikesAsc();
    }
}