package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.LikeTestData;
import com.olexiy.lunchplacepicker.MenuTestData;
import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.service.like.LikeOfMenuService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class LikeOfMenuServiceTest extends AbstractServiceTest {

    @Autowired
    LikeOfMenuService likeOfMenuService;

    @Test
    void getById() {
        LikeOfMenu likeFromService = likeOfMenuService.getById(LikeTestData.likeOfMenu.getId());
        LikeOfMenu expected = LikeTestData.likeOfMenu;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("menu").isEqualTo(expected);
    }

    @Test
    void deleteById() {
        likeOfMenuService.deleteById(LikeTestData.likeOfMenu.getId());

        Assertions.assertThatThrownBy(() -> {
            likeOfMenuService.getById(LikeTestData.likeOfMenu.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", LikeTestData.likeOfMenu.getId());
    }

    @Test
    void save() {
        LikeOfMenu newLike = LikeTestData.getNewLikeOfMenu;
        newLike.setMenu(MenuTestData.menu3);
        newLike.setUserID(UserTestData.USER_ID);

        likeOfMenuService.save(newLike);

        LikeOfMenu likeFromService = likeOfMenuService.getById(100021);

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("menu").isEqualTo(newLike);
    }

    @Test
    void getAllByMenuID() {
        List<LikeOfMenu> likesFromService = likeOfMenuService.getAllByMenuID(MenuTestData.menu.getId());
        List<LikeOfMenu> expected = List.of(LikeTestData.likeOfMenu);

        Assertions.assertThat(likesFromService).usingRecursiveComparison()
                .ignoringFields("menu").isEqualTo(expected);
    }

    @Test
    void getByUserIDAndAndMenuId() {
        LikeOfMenu likeFromService = likeOfMenuService.getByUserIDAndAndMenuId(UserTestData.USER_ID, MenuTestData.menu.getId());
        LikeOfMenu expected = LikeTestData.likeOfMenu;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("menu").isEqualTo(expected);
    }

    @Test
    void getByUserId() {
        LikeOfMenu likeFromService = likeOfMenuService.getByUserId(UserTestData.USER_ID);
        LikeOfMenu expected = LikeTestData.likeOfMenu;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("menu").isEqualTo(expected);
    }
}