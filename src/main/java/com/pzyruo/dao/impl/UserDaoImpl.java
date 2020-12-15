package com.pzyruo.dao.impl;

import com.pzyruo.dao.UserDao;
import com.pzyruo.domain.User;
import com.pzyruo.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate  template = new JdbcTemplate(JdbcUtils.getDataSource());

    //登陆
    @Override
    public User login(String userName, String passWord) {
        String sql = "select * from tab_user where username=? and password=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userName, passWord);
        return user;
    }
}
