package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.Menu;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;


import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static final int MENU_ID = START_SEQ + 10;

    public static final String IMG_URL = "resources/images/placeholder_menu_pic.jpg";

    public static final Menu menu = new Menu(MENU_ID, LocalDateTime.of(2020, Month.MARCH, 30, 12, 0), "French Lunch Menu", IMG_URL);

    public static final Menu menu_for_user = new Menu(100013, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Breakfast Menu", IMG_URL);

    public static Menu getNew() {
        return new Menu(null, null, "New Lunch Menu", IMG_URL);
    }

    public static final Menu menu1 = new Menu(MENU_ID, LocalDateTime.of(2020, Month.MARCH, 30, 12, 0), "French Lunch Menu", IMG_URL);
    public static final Menu menu2 = new Menu(MENU_ID + 1, LocalDateTime.of(2020, Month.MARCH, 30, 17, 0), "Crepes", IMG_URL);
    public static final Menu menu3 = new Menu(MENU_ID + 2, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Lunch Menu", IMG_URL);
    public static final Menu menu4 = new Menu(MENU_ID + 3, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Breakfast Menu", IMG_URL);
    public static final Menu menu5 = new Menu(MENU_ID + 4, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "French Lunch Menu", IMG_URL);
    public static final Menu menu6 = new Menu(MENU_ID + 5, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Dinner Menu", IMG_URL);
    public static final Menu menu7 = new Menu(MENU_ID + 6, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "English Breakfast Menu", IMG_URL);
    public static final Menu menu8 = new Menu(MENU_ID + 7, LocalDateTime.of(2020, Month.MARCH, 30, 10, 0), "Crepes", IMG_URL);

    public static final List<Menu> menus = List.of(menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8);
}