package com.olexiy.lunchplacepicker;

import com.olexiy.lunchplacepicker.models.Restaurant;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.olexiy.lunchplacepicker.models.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int REST1_ID = START_SEQ + 2;
    public static final int REST_NOT_FOUND = 10;

    public static final Restaurant rest1 = new Restaurant(REST1_ID, "Chez Marlene", "58 avenue de Paris", "French Cuisine", LocalDateTime.of(2020, Month.MARCH, 30, 10, 0));
    public static final Restaurant rest2 = new Restaurant(REST1_ID + 1, "Chez Antoine", "93 rue de Versailles", "Creperie", LocalDateTime.of(2018, Month.MAY, 28, 11, 0));
    public static final Restaurant rest3 = new Restaurant(REST1_ID + 2, "La Belle Epoque", "10 Place de la Mairie", "French Cuisine", LocalDateTime.of(2017, Month.MARCH, 28, 12, 0));
    public static final Restaurant rest4 = new Restaurant(REST1_ID + 3, "La Veranda", "1 Boulevard de la Reine", "European Cuisine", LocalDateTime.of(2016, Month.MAY, 28, 13, 0));
    public static final Restaurant rest5 = new Restaurant(REST1_ID + 4, "Le Sept", "7 Rue de Montreuil", "European Cuisine", LocalDateTime.of(2015, Month.MAY, 27, 14, 0));
    public static final Restaurant rest6 = new Restaurant(REST1_ID + 5, "La Table du 11", "8 Rue de la Chancellerie", "French Cuisine", LocalDateTime.of(2017, Month.MAY, 13, 15, 0));
    public static final Restaurant rest7 = new Restaurant(REST1_ID + 6, "Chez Tiouiche", "4 Rue Saint-Julien", "Creperie", LocalDateTime.of(2018, Month.MAY, 28, 16, 0));
    public static final Restaurant rest8 = new Restaurant(REST1_ID + 7, "Cheval Rouge", "Place de la Loi", "English Cuisine", LocalDateTime.of(2020, Month.NOVEMBER, 15, 17, 0));

    public static List<Restaurant> restaurantsUser = List.of(rest3, rest4, rest5);
    public static List<Restaurant> restaurantsAdmin = List.of(rest1, rest2, rest6, rest7, rest8);

    public static Restaurant getNew() {
        return new Restaurant(null, "New Restaur", "new Place", "Food", LocalDateTime.of(2021, Month.JANUARY, 5, 15, 0));
    }

    public static Restaurant getUpdated() {
        return new Restaurant(REST1_ID, "Updated Name", "Updated address", "Creperie", rest1.getRegisterDateTime().plus(2, ChronoUnit.MINUTES));
    }
}