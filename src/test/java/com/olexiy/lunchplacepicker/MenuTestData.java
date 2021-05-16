package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.models.Restaurant;

import java.time.LocalDateTime;
import java.time.Month;


import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static final int MENU_ID = START_SEQ + 10;

    public static final String IMG_URL = "resources/images/placeholder_menu_pic.jpg";

    public static final Menu menu = new Menu(MENU_ID, LocalDateTime.of(2020, Month.MARCH, 30, 12, 0), "French Lunch Menu", IMG_URL);

    public static final Menu menu_for_user = new Menu(100013, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Breakfast Menu", IMG_URL);

    public static Menu getNew() {
        return new Menu(null, null, "New Lunch Menu", IMG_URL);
    }
}