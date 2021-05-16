package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractRestControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/AdminRestController/";

    @Test
    public void getAll() throws Exception {
        String usersMatch = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.allUsers);

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/admin/users")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(usersMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getByID() throws Exception {
        String userMatch = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.userWithoutRestaurants);

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/admin/users/" + UserTestData.USER_ID)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(userMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void save() throws Exception {
        String newUser = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.getNew());

        super.getMockMvc().perform(post(APP_CONTEXT + "/rest/admin/users/")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin"))
                .contentType(MediaType.APPLICATION_JSON).content(newUser))
                .andExpect(status().isCreated())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void deleteUser() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete(APP_CONTEXT + "/rest/admin/users/" + UserTestData.USER_ID)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}