package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserProfileControllerTest extends AbstractControllerTest {

    @Test
    public void save() throws Exception {
        String newUser = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.getNew());
        super.getMockMvc().perform(post("/register")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(newUser));
    }

    @Test
    public void ifLoggedIn() throws Exception {
        super.getMockMvc().perform(get("/ifloggedin"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));


        super.getMockMvc().perform(get("/ifloggedin")
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}