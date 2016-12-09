package com.smartfarmh2.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by DELL on 11/19/2016.
 */
public class SecurityUtil {
    public static UserDetails getCurrentUser () {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
