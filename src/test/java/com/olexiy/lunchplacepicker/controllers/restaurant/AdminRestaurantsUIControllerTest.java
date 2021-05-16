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

public class AdminRestaurantsUIControllerTest extends AbstractControllerTest {

    @Test
    public void getAll() throws Exception {
        super.getMockMvc().perform(get("/admin/rs/all")
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        String newRest = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.getNew());

        super.getMockMvc().perform(post("/admin/{userId}", UserTestData.ADMIN_ID)
                .with(httpBasic("admin@gmail.com", "admin"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(newRest))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete("/admin/{userId}/{entityId}", UserTestData.ADMIN_ID, 100007)
                .with(httpBasic("admin@gmail.com", "admin"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getRestaurantsOfUserWithLikes() throws Exception {
        super.getMockMvc().perform(get("/admin/{id}/all/likes", UserTestData.ADMIN_ID)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk());
    }
}