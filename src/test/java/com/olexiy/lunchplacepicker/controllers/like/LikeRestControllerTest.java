package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.LikeTestData;
import com.olexiy.lunchplacepicker.MenuTestData;
import com.olexiy.lunchplacepicker.RestaurantTestData;
import com.olexiy.lunchplacepicker.controllers.AbstractRestControllerTest;
import com.olexiy.lunchplacepicker.utils.TimeUtils;
import com.olexiy.lunchplacepicker.web.json.JacksonObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class LikeRestControllerTest extends AbstractRestControllerTest {

    private final String FOLDER_NAME = "restControllers/LikeRestController/";

    @Test
    public void getAllByMenuID() throws Exception {
        String likeMatch = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.likeOfMenu);
        likeMatch = "[ " + likeMatch + " ]";

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/likes/menu/{id}", MenuTestData.MENU_ID)
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(likeMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void getAllByRestaurantID() throws Exception {
        String likeMatch = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.likeOfRestaurant);
        likeMatch = "[ " + likeMatch + " ]";

        super.getMockMvc().perform(get(APP_CONTEXT + "/rest/likes/restaurant/{id}", RestaurantTestData.rest4.getId())
                .contextPath(APP_CONTEXT)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(content().json(likeMatch))
                .andDo(document(FOLDER_NAME + "{methodName}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())));
    }

    @Test
    public void saveLikeOfMenu() throws Exception {
        String newLike = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.getNewLikeOfMenu);

        if (TimeUtils.isLikeTimeBetweenExclusive(LocalDateTime.now())) {
            super.getMockMvc().perform(post(APP_CONTEXT + "/rest/likes/menu/{menuID}", 100015)
                    .contextPath(APP_CONTEXT)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isCreated())
                    .andDo(document(FOLDER_NAME + "{methodName}",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint())));
        } else {
            super.getMockMvc().perform(post(APP_CONTEXT + "/rest/likes/menu/{menuID}", 100015)
                    .contextPath(APP_CONTEXT)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isOk())
                    .andDo(document(FOLDER_NAME + "{methodName}",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint())));
        }
    }

    @Test
    public void saveLikeOfRestaurant() throws Exception {
        String newLike = JacksonObjectMapper.getMapper().writeValueAsString(LikeTestData.getNewLikeOfMenu);

        if (TimeUtils.isLikeTimeBetweenExclusive(LocalDateTime.now())) {
            super.getMockMvc().perform(post(APP_CONTEXT + "/rest/likes/restaurant/{restaurantID}", 100006)
                    .contextPath(APP_CONTEXT)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isCreated())
                    .andDo(document(FOLDER_NAME + "{methodName}",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint())));
        } else {
            super.getMockMvc().perform(post(APP_CONTEXT + "/rest/likes/restaurant/{restaurantID}", 100006)
                    .contextPath(APP_CONTEXT)
                    .with(httpBasic("admin@gmail.com", "admin"))
                    .contentType(MediaType.APPLICATION_JSON).content(newLike))
                    .andExpect(status().isOk())
                    .andDo(document(FOLDER_NAME + "{methodName}",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint())));
        }
    }
}