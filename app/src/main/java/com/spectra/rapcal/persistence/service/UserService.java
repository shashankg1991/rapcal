package com.spectra.rapcal.persistence.service;

import android.app.Application;
import android.content.Context;

import com.spectra.rapcal.persistence.entity.User;
import com.spectra.rapcal.util.HashUtil;

import java.util.List;

public class UserService extends Application {
    private static UserService userService = null;

    private UserService() {
    }

    public static UserService getInstance() {
        if (null == userService) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(HashUtil.md5(password));
        PersistanceService.getInstance().getDb().userDao().addUser(user);
    }

    public User getUser(String username) {
        List<User> users = PersistanceService.getInstance().getDb().userDao().findUserWithUserName(username);
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public boolean login(String username, String password) {
        User user = getUser(username);
        if (null != user) {
            return user.getPasswordHash().equals(HashUtil.md5(password));
        } else {
            return false;
        }
    }
}
