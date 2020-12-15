package com.pzyruo.service.impl;

import com.pzyruo.dao.UserDao;
import com.pzyruo.dao.impl.UserDaoImpl;
import com.pzyruo.domain.User;
import com.pzyruo.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public User login(String username,String password) {

        System.out.println(username+password);
        return dao.login(username,password);


    }
}
