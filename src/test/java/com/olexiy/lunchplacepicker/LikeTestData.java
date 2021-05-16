package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;
import com.olexiy.lunchplacepicker.models.LikeOfRestaurant;

import java.time.LocalDateTime;
import java.time.Month;

import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class LikeTestData {
    //public static final int LIKE_ID = START_SEQ + 18;

    public static final LikeOfMenu likeOfMenu = new LikeOfMenu(100018, LocalDateTime.of(2021, Month.MAY, 01, 07, 00));

    public static final LikeOfRestaurant likeOfRestaurant = new LikeOfRestaurant(100020, LocalDateTime.of(2021, Month.MAY, 01, 07, 00));

    public static LikeOfMenu getNewLikeOfMenu = new LikeOfMenu(null, LocalDateTime.of(2021, Month.APRIL, 05, 07, 00));

    static {
        likeOfMenu.setUserID(100000);
        likeOfRestaurant.setUserID(100001);
    }
}