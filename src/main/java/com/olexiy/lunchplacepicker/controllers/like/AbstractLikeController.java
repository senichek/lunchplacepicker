package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.service.like.LikeOfMenuService;
import com.olexiy.lunchplacepicker.service.like.LikeOfRestaurantService;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.utils.SecurityUtils;
import com.olexiy.lunchplacepicker.utils.TimeUtils;
import com.olexiy.lunchplacepicker.utils.exceptions.TooLateToVoteException;
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

    public void saveLikeOfMenu(LikeOfMenu currentLike, int menuID) {
        currentLike.setMenu(menuService.getByID(menuID));
        currentLike.setUserID(SecurityUtils.getLoggedInUser().getId());
        currentLike.setCreationDateTime(LocalDateTime.now());

        LikeOfMenu likeOfUserExist = likeOfMenuService.getByUserId(currentLike.getUserID());

        if (likeOfUserExist == null) {
            likeOfMenuService.save(currentLike);
            log.info("created LIKE for menu {} ", menuID);
        }

        if (likeOfUserExist != null) {
            if (TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())
                    && likeOfUserExist.getMenu().getId() != menuID) {
                /* If Like of a user exists but it belongs to a different restaurant we delete this like to give it to another restaurant
                if it's not too late; */
                likeOfMenuService.deleteById(likeOfUserExist.getId());
                log.info("deleted LIKE for menu {} ", likeOfUserExist.getMenu().getId());
                likeOfMenuService.save(currentLike);
                log.info("created LIKE for menu {} ", menuID);
            }
            if (TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())
                    && likeOfUserExist.getMenu().getId() == menuID) {
                likeOfMenuService.deleteById(likeOfUserExist.getId());
                log.info("deleted LIKE for menu {} ", likeOfUserExist.getMenu().getId());
            }
            if (!TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())) {
                throw new TooLateToVoteException("Too late. You can change your vote only before 11:00 AM");
            }
        }
    }

    public void saveLikeOfRestaurant(LikeOfRestaurant currentLike, int restaurantID) throws Exception {
        currentLike.setRestaurant(restaurantService.getByID(restaurantID));
        currentLike.setUserID(SecurityUtils.getLoggedInUser().getId());
        currentLike.setCreationDateTime(LocalDateTime.now());

        LikeOfRestaurant likeOfUserExist = likeOfRestaurantService.getByUserId(currentLike.getUserID());

        if (likeOfUserExist == null) {
            likeOfRestaurantService.save(currentLike);
            log.info("created LIKE for restaurant {} ", restaurantID);
        }

        if (likeOfUserExist != null) {
            if (TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())
                    && likeOfUserExist.getRestaurant().getId() != restaurantID) {
                /* If Like of a user exists but it belongs to a different restaurant we delete this like to give it to another restaurant
                if it's not too late; */
                likeOfRestaurantService.deleteById(likeOfUserExist.getId());
                log.info("deleted LIKE for restaurant {} ", likeOfUserExist.getRestaurant().getId());
                likeOfRestaurantService.save(currentLike);
                log.info("created LIKE for restaurant {} ", restaurantID);
            }
            if (TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())
                    && likeOfUserExist.getRestaurant().getId() == restaurantID) {
                likeOfRestaurantService.deleteById(likeOfUserExist.getId());
                log.info("deleted LIKE for restaurant {} ", likeOfUserExist.getRestaurant().getId());
            }
            if (!TimeUtils.isLikeTimeBetweenExclusive(currentLike.getCreationDateTime())) {
                throw new TooLateToVoteException("Too late. You can change your vote only before 11:00 AM");
            }
        }
    }
}