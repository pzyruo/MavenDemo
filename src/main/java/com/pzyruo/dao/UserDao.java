package com.pzyruo.dao;

import com.pzyruo.domain.User;

public interface UserDao {
    public User login(String userName, String passWord);
}
