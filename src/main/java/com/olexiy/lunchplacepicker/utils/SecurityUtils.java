package com.olexiy.lunchplacepicker.utils;

import com.olexiy.lunchplacepicker.models.User;
import com.olexiy.lunchplacepicker.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {

    public static User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return userPrincipal.getUser();
    }

    public static boolean isLoggedIn() {
        String authName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (authName.equals("anonymousUser")) {
            return false;
        } else {
            return true;
        }
    }

    public static void login(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println(e);
        }
    }
}