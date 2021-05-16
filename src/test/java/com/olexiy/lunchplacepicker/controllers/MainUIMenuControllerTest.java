package com.olexiy.lunchplacepicker.controllers;

import org.junit.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainUIMenuControllerTest extends AbstractControllerTest {

    @Test
    public void getAllWithLikes() throws Exception {
        super.getMockMvc().perform(get("/menus"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllByRestaurantId() throws Exception {
        super.getMockMvc().perform(get("/menus/restaurant/" + 100005))
                .andExpect(status().isOk());
    }
}