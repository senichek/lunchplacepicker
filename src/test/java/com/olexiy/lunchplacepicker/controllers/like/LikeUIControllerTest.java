package com.olexiy.lunchplacepicker.controllers.like;


import com.olexiy.lunchplacepicker.LikeTestData;
import com.olexiy.lunchplacepicker.MenuTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.utils.TimeUtils;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LikeUIControllerTest extends AbstractControllerTest {

    @Test
    public void getAllByMenuID() throws Exception {
        String likeMatch = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.likeOfMenu);
        likeMatch = "[ " + likeMatch + " ]";

        super.getMockMvc().perform(get("/likes/menu/{id}", MenuTestData.MENU_ID)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(likeMatch));
    }

    @Test
    public void getAllByRestaurantID() throws Exception {
        String likeMatch = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.likeOfRestaurant);
        likeMatch = "[ " + likeMatch + " ]";

        super.getMockMvc().perform(get("/likes/restaurant/{id}", RestaurantTestData.rest4.getId())
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(likeMatch));
    }

    @Test
    public void saveLikeOfMenu() throws Exception {
        String newLike = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.getNewLikeOfMenu);

        if (TimeUtils.isLikeTimeBetweenExclusive(LocalDateTime.now())) {
            super.getMockMvc().perform(post("/likes/menu/{menuID}", 100015)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isCreated());
        } else {
            super.getMockMvc().perform(post("/likes/menu/{menuID}", 100015)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isOk());
        }
    }

    @Test
    public void saveLikeOfRestaurant() throws Exception {
        String newLike = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.getNewLikeOfMenu);

        if (TimeUtils.isLikeTimeBetweenExclusive(LocalDateTime.now())) {
            super.getMockMvc().perform(post("/likes/restaurant/{restaurantID}", 100006)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isCreated());
        } else {
            super.getMockMvc().perform(post("/likes/restaurant/{menuID}", 100006)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isOk());
        }
    }
}