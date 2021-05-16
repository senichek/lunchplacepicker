package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestaurantsUIControllerTest extends AbstractControllerTest {

    @Test
    public void save() throws Exception {
        String newRest = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.getNew());

        super.getMockMvc().perform(post("/profile/restaurants/all", UserTestData.USER_ID)
                .with(httpBasic("user@gmail.com", "user"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(newRest))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete("/profile/restaurants/all/{entityId}", 100004)
                .with(httpBasic("user@gmail.com", "user"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getRestaurantsOfLoggedInUserWithLikes() throws Exception {
        super.getMockMvc().perform(get("/profile/restaurants/all/likes")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk());
    }
}