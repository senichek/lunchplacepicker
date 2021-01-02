package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.Role;
import com.olexiy.lunchplacepicker.models.User;

import java.time.LocalDateTime;
import java.util.Collections;

import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;

    public static final User user = new User(USER_ID, "User", "user@gmail.com", "user",
            LocalDateTime.parse("2020-03-30 17:00:00"), Collections.singleton(Role.USER));

    public static final User admin = new User(USER_ID, "Admin", "admin@gmail.com", "admin",
            LocalDateTime.parse("2018-11-25 19:00:00"), Collections.singleton(Role.ADMIN));

    /*У админа должны быть рестораны
    Админов может быть больше одного
    static {
        user.setMeals(meals);
        admin.setMeals(List.of(adminMeal2, adminMeal1));
    }*/

    public static User getNew() {
        return new User(null, "NewUser", "newuser@gmail.com", "newpass",
                LocalDateTime.now(), Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = user;
        updated.setName("UpdatedName");
        updated.setEmail("updated@gmail.com");
        updated.setPassword("newPass");
        updated.setRegistered(LocalDateTime.parse("2018-10-23 11:00:00"));
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }
}
