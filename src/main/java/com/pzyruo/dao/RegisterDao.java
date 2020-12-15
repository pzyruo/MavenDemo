package com.pzyruo.dao;

import com.pzyruo.domain.User;

import java.text.ParseException;

public interface RegisterDao {
    int register(User user) throws ParseException;

    User findByCode(String code);

    int updateStatus(User user);
}
