package com.olexiy.lunchplacepicker.controllers.menu;

import com.olexiy.lunchplacepicker.MenuTestData;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserMenuRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/UserMenuRestController/";

    @Test
    public void getAll() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/menus/")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getAllWithLikes() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/menus/likes")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getByID() throws Exception {
        String menuMatch = JacksonObjectMapper.getMapper().writeValueAsString(MenuTestData.menu);

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/menus/{id}", 100010)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andExpect(content().json(menuMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void save() throws Exception {
        String newMenu = JacksonObjectMapper.getMapper().writeValueAsString(MenuTestData.getNew());

        super.getMockMvc().perform(post(APP_CONTEXT + "/rest/profile/menus/{restaurantId}", RestaurantTestData.rest5.getId())
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user"))
                .contentType(MediaType.APPLICATION_JSON).content(newMenu))
                .andExpect(status().isCreated())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void delete() throws Exception {
        super.getMockMvc().perform(MockMvcRequestBuilders
                .delete(APP_CONTEXT + "/rest/profile/menus/{id}", 100010)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getAllMenusByRestaurantId() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/menus/100002/all")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getAllMenusByRestaurantIdWithLikes() throws Exception {
        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/profile/menus/100002/all/likes")
                .contextPath(APP_CONTEXT)
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }
}