package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.LikeOfMenuTestData;
import com.olexiy.lunchplacepicker.MenuTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

class MenuServiceTest extends AbstractServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    void getAll() {
        List<Menu> menusFromService = menuService.getAll();
        List<Menu> expected = MenuTestData.menus;

        Assertions.assertThat(menusFromService).usingRecursiveComparison()
                .ignoringFields("likesOfMenu", "restaurant").isEqualTo(expected);
    }

    @Test
    void getByID() {
        Menu menuFromService = menuService.getByID(100010);
        Menu expected = MenuTestData.menu1;

        Assertions.assertThat(menuFromService).usingRecursiveComparison()
                .ignoringFields("likesOfMenu", "restaurant").isEqualTo(expected);
    }

    @Test
    void getAllByRestaurantIdWithLikes() {
        List<Menu> menusFromService = menuService.getAllByRestaurantIdWithLikes(100002);
        List<Menu> expected = List.of(MenuTestData.menu1);

        LikeOfMenu likeOfExpectedMenu = LikeOfMenuTestData.likeOfMenu1;

        likeOfExpectedMenu.setMenu(MenuTestData.menu1);
        likeOfExpectedMenu.setUserID(UserTestData.USER_ID);

        expected.get(0).setLikes(Collections.singletonList(likeOfExpectedMenu));

        Assertions.assertThat(menusFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(expected);
    }

    @Test
    void getAllByRestaurantId() {
        List<Menu> menusFromService = menuService.getAllByRestaurantId(100002);
        List<Menu> expected = List.of(MenuTestData.menu1);

        Assertions.assertThat(menusFromService).usingRecursiveComparison()
                .ignoringFields("likesOfMenu", "restaurant").isEqualTo(expected);
    }

    @Test
    void save() {
        Menu newMenu = MenuTestData.getNew();
        newMenu.setRestaurant(RestaurantTestData.rest1);
        newMenu.setCreationDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        menuService.save(newMenu);

        Menu menuFromService = menuService.getByID(100021);
        menuFromService.setCreationDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        Assertions.assertThat(newMenu).usingRecursiveComparison()
                .ignoringFields("likesOfMenu", "restaurant").isEqualTo(menuFromService);
    }

    @Test
    void delete() {
        menuService.delete(MenuTestData.menu1.getId());

        Assertions.assertThatThrownBy(() -> {
            menuService.getByID(MenuTestData.menu1.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", MenuTestData.menu1.getId());
    }

    @Test
    void getAllWithLikes() {
        List<Menu> menusFromService = menuService.getAllWithLikes();
        List<Menu> expected = List.of(MenuTestData.menu2, MenuTestData.menu5, MenuTestData.menu4, MenuTestData.menu1,
                MenuTestData.menu3, MenuTestData.menu6, MenuTestData.menu8, MenuTestData.menu7);

        Assertions.assertThat(menusFromService).usingRecursiveComparison()
                .ignoringFields("likesOfMenu", "restaurant").isEqualTo(expected);
    }

    @Test
    void getByIDNotFound() {
        Assertions.assertThatThrownBy(() -> {
            menuService.getByID(100100);
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", 100100);
    }
}