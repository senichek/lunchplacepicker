package com.olexiy.lunchplacepicker.controllers;

import org.junit.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainUIRestaurantControllerTest extends AbstractControllerTest {

    @Test
    public void getAllWithLikes() throws Exception {
        super.getMockMvc().perform(get("/restaurants"))
                .andExpect(status().isOk());
    }
}