package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.models.Like;
import com.olexiy.lunchplacepicker.service.like.LikeService;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
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
    private LikeService likeService;

    @Autowired
    private MenuService menuService;

    public AbstractLikeController() {
    }

    public List<Like> getAllByMenuID(int id) {
        log.info("get all likes for menu {} ", id);
        return likeService.getAllByMenuID(id);
    }

    public void save (Like like, int menuID) {
        like.setMenu(menuService.getByID(menuID));
        like.setUserID(SecurityUtils.getLoggedInUser().getId());
        like.setCreationDateTime(LocalDateTime.now());

        Like likeExist = likeService.getByUserIDAndAndMenuId(like.getUserID(), like.getMenu().getId());
        if (likeExist != null) {
            likeService.deleteById(likeExist.getId());
            log.info("deleted LIKE for menu {} ", menuID);
        } else {
            log.info("created LIKE for menu {} ", menuID);
            likeService.save(like);
        }
    }
}