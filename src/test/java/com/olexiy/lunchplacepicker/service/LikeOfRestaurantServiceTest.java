package com.olexiy.lunchplacepicker.service;

import com.olexiy.lunchplacepicker.LikeTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;
import com.olexiy.lunchplacepicker.service.like.LikeOfRestaurantService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class LikeOfRestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    LikeOfRestaurantService likeOfRestaurantService;

    @Test
    void getById() {
        LikeOfRestaurant likeFromService = likeOfRestaurantService.getById(LikeTestData.likeOfRestaurant.getId());
        LikeOfRestaurant expected = LikeTestData.likeOfRestaurant;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(expected);
    }

    @Test
    void deleteById() {
        likeOfRestaurantService.deleteById(LikeTestData.likeOfRestaurant.getId());

        Assertions.assertThatThrownBy(() -> {
            likeOfRestaurantService.getById(LikeTestData.likeOfRestaurant.getId());
        }).isInstanceOf(NotFoundException.class)
                .hasMessageContaining("Entity with id %s does not exist;", LikeTestData.likeOfRestaurant.getId());
    }

    @Test
    void save() {
        LikeOfRestaurant newLike = LikeTestData.getNewLikeOfRestaurant;
        newLike.setRestaurant(RestaurantTestData.rest7);
        newLike.setUserID(UserTestData.USER_ID);

        likeOfRestaurantService.save(newLike);

        LikeOfRestaurant likeFromService = likeOfRestaurantService.getById(100021);

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(newLike);
    }

    @Test
    void getAllByRestaurantID() {
        List<LikeOfRestaurant> likesFromService = likeOfRestaurantService.getAllByRestaurantID(RestaurantTestData.rest4.getId());
        List<LikeOfRestaurant> expected = List.of(LikeTestData.likeOfRestaurant);

        Assertions.assertThat(likesFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(expected);
    }

    @Test
    void getByUserIDAndRestaurantId() {
        LikeOfRestaurant likeFromService = likeOfRestaurantService.getByUserIDAndRestaurantId(UserTestData.ADMIN_ID, RestaurantTestData.rest4.getId());
        LikeOfRestaurant expected = LikeTestData.likeOfRestaurant;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(expected);
    }

    @Test
    void getByUserId() {
        LikeOfRestaurant likeFromService = likeOfRestaurantService.getByUserId(UserTestData.ADMIN_ID);
        LikeOfRestaurant expected = LikeTestData.likeOfRestaurant;

        Assertions.assertThat(likeFromService).usingRecursiveComparison()
                .ignoringFields("restaurant").isEqualTo(expected);
    }
}