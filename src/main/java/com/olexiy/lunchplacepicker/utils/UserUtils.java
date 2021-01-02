package com.olexiy.lunchplacepicker.utils;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.to.UserTO;

public class UserUtils {

    public static UserTO createTO(User user) {
        return new UserTO(user.getId(), user.getName(), user.getEmail(),
                user.getRegistered(), user.getRoles());
    }
}
