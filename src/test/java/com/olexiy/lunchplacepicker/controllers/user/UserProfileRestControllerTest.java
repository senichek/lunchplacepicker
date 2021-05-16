package com.olexiy.lunchplacepicker.controllers.user;

import com.olexiy.lunchplacepicker.UserTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractRestControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;


import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserProfileRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/UserProfileRestController/";

    @Test
    public void ifLoggedIn() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/ifloggedin")
                .contextPath(APP_CONTEXT)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andDo(document( FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void save() throws Exception {
        String newUser = JacksonObjectMapper.getMapper().writeValueAsString(UserTestData.getNew());
        super.getMockMvc().perform(post(APP_CONTEXT + "/rest/register")
                .contextPath(APP_CONTEXT)
                .contentType(MediaType.APPLICATION_JSON).content(newUser))
                .andExpect(status().isCreated())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}