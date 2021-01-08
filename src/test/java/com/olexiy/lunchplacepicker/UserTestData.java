package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.Role;
import com.olexiy.lunchplacepicker.models.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;

import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;

    public static final User user = new User(USER_ID, "User", "user@gmail.com", "user",
            LocalDateTime.of(2020, Month.MARCH, 30, 17, 0), Collections.singleton(Role.USER));

    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin",
            LocalDateTime.of(2018, Month.NOVEMBER, 25, 19, 0), Role.ADMIN, Role.USER);

    static {
        user.setRestaurants(RestaurantTestData.restaurantsUser);
        admin.setRestaurants(RestaurantTestData.restaurantsAdmin);
    }

    public static User getNew() {
        return new User(null, "NewUser", "newuser@gmail.com", "newpass",
                LocalDateTime.of(2021, Month.JANUARY, 5, 23, 0), Collections.singleton(Role.USER));
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
