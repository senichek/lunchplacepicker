package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.LikeOfMenu;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class LikeOfMenuTestData {
    public static final int LIKE_OF_MENU_ID = START_SEQ + 18;

    public static final LikeOfMenu likeOfMenu1 = new LikeOfMenu(LIKE_OF_MENU_ID, LocalDateTime.of(2021, Month.MAY, 01, 07, 0));
    public static final LikeOfMenu likeOfMenu2 = new LikeOfMenu(LIKE_OF_MENU_ID + 1, LocalDateTime.of(2021, Month.MAY, 01, 07, 0));

    public static final List<LikeOfMenu> likes = List.of(likeOfMenu1, likeOfMenu2);
}