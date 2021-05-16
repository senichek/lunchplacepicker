package com.olexiy.lunchplacepicker.controllers;

import com.olexiy.lunchplacepicker.UserTestData;
import org.junit.Test;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RootControllerTest extends AbstractControllerTest {

    @Test
    public void users() throws Exception {
        super.getMockMvc().perform(get("/admin/users")
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("adminUI/users"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/adminUI/users.jsp"));

    }

    @Test
    public void restaurantsOfAdmin() throws Exception {
        super.getMockMvc().perform(get("/admin/{id}/all", UserTestData.ADMIN_ID)
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("adminUI/restaurants"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/adminUI/restaurants.jsp"));
    }

    @Test
    public void menusOfRestaurant() throws Exception {
        super.getMockMvc().perform(get("/admin/menus/" + 100006 + "/all")
                .with(httpBasic("admin@gmail.com", "admin")))
                .andExpect(status().isOk())
                .andExpect(view().name("adminUI/menus"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/adminUI/menus.jsp"));
    }

    @Test
    public void restaurantsOfUser() throws Exception {
        super.getMockMvc().perform(get("/profile/restaurants/all")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andExpect(view().name("userUI/userRestaurants"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userUI/userRestaurants.jsp"));
    }

    @Test
    public void menusOfUserRestaurantsWithLikes() throws Exception {
        super.getMockMvc().perform(get("/profile/menus/" + 100006 + "/all/likes")
                .with(httpBasic("user@gmail.com", "user")))
                .andExpect(status().isOk())
                .andExpect(view().name("userUI/userMenus"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userUI/userMenus.jsp"));
    }

    @Test
    public void restaurantsAll() throws Exception {
        super.getMockMvc().perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(view().name("restaurantsMainPage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/restaurantsMainPage.jsp"));
    }

    @Test
    public void menusAll() throws Exception {
        super.getMockMvc().perform(get("/menus"))
                .andExpect(status().isOk())
                .andExpect(view().name("menusMainPage"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/menusMainPage.jsp"));
    }

    @Test
    public void registration() throws Exception {
        super.getMockMvc().perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("userUI/registration"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userUI/registration.jsp"));
    }

    @Test
    public void login() throws Exception {
        super.getMockMvc().perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("userUI/login"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userUI/login.jsp"));
    }

    @Test
    public void accessDenied() throws Exception {
        super.getMockMvc().perform(get("/accessDenied"))
                .andExpect(status().isOk())
                .andExpect(view().name("userUI/accessDenied"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userUI/accessDenied.jsp"));
    }

    @Test
    public void index() throws Exception {
        super.getMockMvc().perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"));
    }

    @Test
    public void showApiDocs() throws Exception {
        super.getMockMvc().perform(get("/api-doc"))
                .andExpect(status().isOk())
                .andExpect(view().name("api-doc"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/api-doc.jsp"));
    }
}