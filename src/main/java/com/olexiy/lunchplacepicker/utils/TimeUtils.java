package com.olexiy.lunchplacepicker.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeUtils {
    public static boolean isLikeTimeBetweenExclusive(LocalDateTime current) {
        LocalDateTime start = LocalDate.now().atTime(0, 0);
        LocalDateTime end = LocalDate.now().atTime(11, 00);

        if ((current.isAfter(start) || current.isEqual(start)) && current.isBefore(end)) {
            return true;
        } else {
            return false;
        }
    }
}