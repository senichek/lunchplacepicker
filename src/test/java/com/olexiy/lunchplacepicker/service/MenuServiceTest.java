package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.models.Like;
import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.service.like.LikeService;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    MenuService menuService;

    @Autowired
    LikeService likeService;

    @Test
    void getAll() {
    }

    @Test
    void getByID() {
    }

    @Test
    void getAllByRestaurantIdWithLikes() {
    }

    @Test
    void getAllByRestaurantId() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAllWithLikes() {

    }
}