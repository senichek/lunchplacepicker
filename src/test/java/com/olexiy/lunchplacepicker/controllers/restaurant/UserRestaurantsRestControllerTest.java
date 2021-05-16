package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractRestControllerTest;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserRestaurantsRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/UserRestaurantsRestController/";

    @Test
    public void save() throws Exception {
        String newRest = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.getNew());

        super.getMockMvc().perform(post(APP_CONTEXT + "/rest/profile/restaurants/all")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user"))
                .contentType(MediaType.APPLICATION_JSON).content(newRest))
                .andExpect(status().isCreated())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete(APP_CONTEXT + "/rest/profile/restaurants/all/" + 100006)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getRestaurantsOfLoggedInUserWithLikes() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/restaurants/all/likes")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}