package com.pzyruo.service.impl;

import com.pzyruo.dao.RegisterDao;
import com.pzyruo.dao.impl.RegisterDaoImpl;
import com.pzyruo.domain.User;
import com.pzyruo.service.RegisterService;
import com.pzyruo.util.MailUtils;
import com.pzyruo.util.UuidUtil;

import java.text.ParseException;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao dao = new RegisterDaoImpl();
    @Override
    public int register(User user) throws ParseException {

        //1.设置激活码，要求唯一
        user.setCode(UuidUtil.getUuid());
        System.out.println(user.getCode());
        //2.设置激活状态
        user.setStatus("N");
        int i =  dao.register(user);
//        http://localhost/travel/index.html
        System.out.println(user.getCode());
        //3.发送激活邮件
        String content = "<a href='http://localhost/travel/activityUserServlet?activityCode="+user.getCode()+"'>点击激活【旅游网】</a>";//需要一个servlet来接收
        try{
            MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int activity(String activityCode) {
        //1.根据id查询用户对象
        User user = dao.findByCode(activityCode);
        System.out.println(user.toString());
        //2.调用dao的修改激活状态的方法
        final int i = dao.updateStatus(user);
        System.out.println(i);
        return i;


        }
    }

