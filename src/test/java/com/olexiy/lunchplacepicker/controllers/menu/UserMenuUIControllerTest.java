package com.olexiy.lunchplacepicker.controllers.menu;

import com.olexiy.lunchplacepicker.MenuTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserMenuUIControllerTest extends AbstractControllerTest {

    @Test
    public void getAll() throws Exception {
        super.getMockMvc().perform(get("/profile/menus/")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllWithLikes() throws Exception {
        super.getMockMvc().perform(get("/profile/menus/likes")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk());
    }

    @Test
    public void getByID() throws Exception {
        String menuMatch = JacksonObjectMapper.getMapper().writeValueAsString(MenuTestData.menu_for_user);

        super.getMockMvc().perform(get("/profile/menus/{id}", 100013)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andExpect(content().json(menuMatch));
    }

    @Test
    public void save() throws Exception {
        String newMenu = JacksonObjectMapper.getMapper().writeValueAsString(MenuTestData.getNew());

        super.getMockMvc().perform(post("/profile/menus/{restaurantId}", RestaurantTestData.rest5.getId())
                .with(httpBasic("user@gmail.com", "user"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(newMenu))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete("/profile/menus/{id}", 100013)
                .with(httpBasic("user@gmail.com", "user"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getMenusByRestaurantId() throws Exception {
        super.getMockMvc().perform(get("/profile/menus/100002/all")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk());
    }

    @Test
    public void getMenusByRestaurantIdWithLikes() throws Exception {
        super.getMockMvc().perform(get("/profile/menus/100002/all/likes")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk());
    }
}