package com.olexiy.lunchplacepicker.controllers.restaurant;

import com.olexiy.lunchplacepicker.RestaurantTestData;
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
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminRestaurantsRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/AdminRestaurantsRestController/";

    @Test
    public void getAll() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/admin/rs/all")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getByID() throws Exception {
        String restaurantMatch = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.rest6);
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/admin/{userId}/{entityId}", 100001, 100007)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(restaurantMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void save() throws Exception {
        String newRest = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.getNew());

        super.getMockMvc().perform(post(APP_CONTEXT + "/rest/admin/{userId}", UserTestData.ADMIN_ID)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin"))
                .contentType(MediaType.APPLICATION_JSON).content(newRest))
                .andExpect(status().isCreated())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete(APP_CONTEXT + "/rest/admin/{userId}/{entityId}", UserTestData.ADMIN_ID, 100007)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getRestaurantsOfUser() throws Exception {
        String restaurantMatch = JacksonObjectMapper.getMapper().writeValueAsString(RestaurantTestData.restaurantsAdmin);

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/admin/{id}/all", UserTestData.ADMIN_ID)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(restaurantMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}