package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.service.like.LikeOfMenuService;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    MenuService menuService;

    @Autowired
    LikeOfMenuService likeOfMenuService;

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