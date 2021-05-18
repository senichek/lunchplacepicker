package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.LikeTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.models.Restaurant;
import com.olexiy.lunchplacepicker.service.restaurant.RestaurantService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    void getAll() {
        List<Restaurant> restaurantsFromService = restaurantService.getAll();
        List<Restaurant> expected = List.of(RestaurantTestData.rest1, RestaurantTestData.rest2, RestaurantTestData.rest3, RestaurantTestData.rest4,
                RestaurantTestData.rest5, RestaurantTestData.rest6, RestaurantTestData.rest7, RestaurantTestData.rest8);

        Assertions.assertThat(restaurantsFromService).usingRecursiveComparison()
                .ignoringFields("likesOfRestaurant", "menu", "user").isEqualTo(expected);
    }

    @Test
    void getAllWithLikes() {
        List<Restaurant> restaurantsFromService = restaurantService.getAllWithLikes();

        Restaurant restWithLike = RestaurantTestData.rest4;

        LikeOfRestaurant likeOfRestaurant = LikeTestData.likeOfRestaurant;
        likeOfRestaurant.setRestaurant(restWithLike);

        restWithLike.setLikesOfRestaurant(List.of(likeOfRestaurant));

        List<Restaurant> expected = List.of(RestaurantTestData.rest7, RestaurantTestData.rest8, RestaurantTestData.rest5, RestaurantTestData.rest6,
                restWithLike, RestaurantTestData.rest2, RestaurantTestData.rest3, RestaurantTestData.rest1);

        // Setting empty lists of Likes
        for (Restaurant x : expected) {
            if (x.getId() != RestaurantTestData.rest4.getId()) {
                x.setLikesOfRestaurant(new ArrayList<>());
            }
        }

        Assertions.assertThat(restaurantsFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user").isEqualTo(expected);
    }

    @Test
    void getAllByUserIdWithLikes() {
        List<Restaurant> restaurantsFromService = restaurantService.getAllByUserIdWithLikes(UserTestData.USER_ID);

        Restaurant restWithLike = RestaurantTestData.rest4;

        LikeOfRestaurant likeOfRestaurant = LikeTestData.likeOfRestaurant;
        likeOfRestaurant.setRestaurant(restWithLike);

        restWithLike.setLikesOfRestaurant(List.of(likeOfRestaurant));

        List<Restaurant> expected = List.of(RestaurantTestData.rest3, restWithLike, RestaurantTestData.rest5);

        // Setting empty lists of Likes
        for (Restaurant x : expected) {
            if (x.getId() != RestaurantTestData.rest4.getId()) {
                x.setLikesOfRestaurant(new ArrayList<>());
            }
        }

        Assertions.assertThat(restaurantsFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user").isEqualTo(expected);
    }

    @Test
    void getByID() {
        Restaurant restFromService = restaurantService.getByID(RestaurantTestData.rest5.getId());
        Restaurant expected = RestaurantTestData.rest5;

        Assertions.assertThat(restFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user", "likesOfRestaurant").isEqualTo(expected);
    }

    @Test
    void getByUserIdAndEntityId() {
        Restaurant restFromService = restaurantService.getByUserIdAndEntityId(UserTestData.USER_ID, RestaurantTestData.rest5.getId());
        Restaurant expected = RestaurantTestData.rest5;

        Assertions.assertThat(restFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user", "likesOfRestaurant").isEqualTo(expected);
    }

    @Test
    void getByUserIdAndEntityIdNotFound() {
        Assertions.assertThatThrownBy(() -> {
            restaurantService.getByUserIdAndEntityId(UserTestData.ADMIN_ID, RestaurantTestData.rest5.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity %s doesn't exist or doesn't belong to user %s;", RestaurantTestData.rest5.getId(), UserTestData.ADMIN_ID);
    }

    @Test
    void save() {
        Restaurant newRest = RestaurantTestData.getNew();
        newRest.setUser(UserTestData.user);

        restaurantService.save(newRest);
        Restaurant restFromService = restaurantService.getByID(100021);

        Assertions.assertThat(restFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user", "likesOfRestaurant").isEqualTo(newRest);
    }

    @Test
    void delete() {
        restaurantService.delete(RestaurantTestData.rest4.getId());

        Assertions.assertThatThrownBy(() -> {
            restaurantService.getByID(RestaurantTestData.rest4.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", RestaurantTestData.rest4.getId());
    }

    @Test
    void deleteByIdAndUserId() {
        restaurantService.deleteByIdAndUserId(RestaurantTestData.rest4.getId(), UserTestData.USER_ID);

        Assertions.assertThatThrownBy(() -> {
            restaurantService.getByUserIdAndEntityId(UserTestData.USER_ID, RestaurantTestData.rest4.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity %s doesn't exist or doesn't belong to user %s;", RestaurantTestData.rest4.getId(), UserTestData.USER_ID);
    }

    @Test
    void getAllByUserId() {
        List<Restaurant> restaurantsOfUserFromService = restaurantService.getAllByUserId(UserTestData.USER_ID);
        List<Restaurant> expectedUserRest = List.of(RestaurantTestData.rest3, RestaurantTestData.rest4, RestaurantTestData.rest5);

        Assertions.assertThat(restaurantsOfUserFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user", "likesOfRestaurant").isEqualTo(expectedUserRest);


        List<Restaurant> restaurantsOfAdminFromService = restaurantService.getAllByUserId(UserTestData.ADMIN_ID);
        List<Restaurant> expectedAdminRest = List.of(RestaurantTestData.rest1, RestaurantTestData.rest2,
                RestaurantTestData.rest6, RestaurantTestData.rest7, RestaurantTestData.rest8);

        Assertions.assertThat(restaurantsOfAdminFromService).usingRecursiveComparison()
                .ignoringFields("menu", "user", "likesOfRestaurant").isEqualTo(expectedAdminRest);
    }
}