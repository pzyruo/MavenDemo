package com.pzyruo.service;

import com.pzyruo.domain.User;

import java.text.ParseException;

public interface RegisterService {
    int register(User user) throws ParseException;

    int activity(String activityCode);
}
