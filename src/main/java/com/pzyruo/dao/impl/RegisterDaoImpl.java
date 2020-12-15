package com.pzyruo.dao.impl;

import com.pzyruo.dao.RegisterDao;
import com.pzyruo.domain.User;
import com.pzyruo.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterDaoImpl implements RegisterDao {
    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public int register(User user) throws ParseException {
        final String username = user.getUsername();
        final String password = user.getPassword();
        final String email = user.getEmail();
        final String birthday = user.getBirthday();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        final String name = user.getName();
        final String sex = user.getSex();
        final String telephone = user.getTelephone();
        final String status = user.getStatus();
        final String code = user.getCode();
        String sql = "insert into tab_user(username,password,email,status,name,telephone,sex,birthday,code) values (?,?,?,?,?,?,?,?,?)";
        return template.update(sql,username,password,email,status,name,telephone,sex,date,code);
    }

    @Override
    public User findByCode(String code) {
        String sql = "select * from tab_user where code=?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
/**
 *
  * @param user
 * @return {@link [com.pzyruo.domain.User]}
 * @throws
 * @author 我的电脑 
 * @date 2020/12/15 15:23
 */
    @Override
    public int updateStatus(User user) {
        String sql = "update tab_user set status ='Y' where code=?";
        return template.update(sql,user.getCode());

    }
}
