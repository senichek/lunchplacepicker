package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.models.User;
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


public class AdminUIControllerTest extends AbstractControllerTest {

    @Test
    public void getAll() throws Exception {
        String usersMatch = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.allUsers);

        super.getMockMvc().perform(get("/admin/users/all")
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(usersMatch));
    }

    @Test
    public void getByID() throws Exception {
        User adminWithoutRestaurants = UserTestData.admin;
        adminWithoutRestaurants.setRestaurants(null);
        String userMatch = JacksonObjectMapper.getMapper().writeValueAsString(adminWithoutRestaurants);

        super.getMockMvc().perform(get("/admin/users/" + UserTestData.ADMIN_ID)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(userMatch));
    }

    @Test
    public void save() throws Exception {
        String newUser = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.getNew());

        super.getMockMvc().perform(post("/admin/users/")
                .with(httpBasic("admin@gmail.com", "admin"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(newUser))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete("/admin/users/all/" + UserTestData.USER_ID)
                .with(httpBasic("admin@gmail.com", "admin"))
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}