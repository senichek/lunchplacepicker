package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class UserServiceTest extends AbstractServiceTest {

    @Autowired
    UserService userService;

    @Test
    void getAll() {
        List<User> usersFromService = userService.getAll();
        List<User> expected = List.of(UserTestData.user, UserTestData.admin);
        Assertions.assertThat(usersFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(expected);
    }

    @Test
    void getByID() {
        User userFromService = userService.getByID(UserTestData.USER_ID);
        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(UserTestData.user);
    }

    @Test
    void getByEmail() {
        User userFromService = userService.getByEmail(UserTestData.admin.getEmail());
        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(UserTestData.admin);
    }

    @Test
    void getByEmailNotFound() {
        String email = "notfound@gmail.com";
        Assertions.assertThatThrownBy(() -> {
            userService.getByEmail(email);
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with email %s does not exist;", email);
    }

    @Test
    void getNotFound() {
        Assertions.assertThatThrownBy(() -> {
            userService.getByID(UserTestData.NOT_FOUND);
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", UserTestData.NOT_FOUND);
    }

    @Test
    void saveWithOneRole() {
        User userFromService = userService.save(UserTestData.getNew());
        int newID = userFromService.getId();
        User expected = UserTestData.getNew();
        expected.setId(newID);

        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(expected);
    }

    @Test
    void saveWithTwoRoles() {
        User userFromService = userService.save(UserTestData.getNewWithTwoRoles());
        int newID = userFromService.getId();
        User expected = UserTestData.getNewWithTwoRoles();
        expected.setId(newID);

        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(expected);
    }

    @Test
    void delete() {
        userService.deleteByID(UserTestData.USER_ID);
        Assertions.assertThatThrownBy(() -> {
            userService.getByID(UserTestData.USER_ID);
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", UserTestData.USER_ID);
    }

    @Test
    void existsById() {
        boolean exists = userService.existsById(UserTestData.ADMIN_ID);
        Assertions.assertThat(exists).isTrue();
    }

    @Test
    void getWithRestaurants() {
        User userFromService = userService.getWithRestaurants(UserTestData.USER_ID);
        List<Restaurant> restsOfUserFromService = userFromService.getRestaurants();

        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(UserTestData.user);

        Assertions.assertThat(restsOfUserFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user").isEqualTo(UserTestData.user.getRestaurants());
    }

    @Test
    void update() {
        User expected = UserTestData.getUpdated();
        User userFromService = userService.save(expected);
        Assertions.assertThat(userFromService).usingRecursiveComparison()
                .ignoringFields("restaurants", "password").isEqualTo(expected);
    }
}