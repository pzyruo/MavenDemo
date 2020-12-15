package com.pzyruo.service;

import com.pzyruo.domain.User;

public interface UserService {
    User login(String username,String password);
}
