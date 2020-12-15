package com.pzyruo.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pzyruo.domain.ResultInfo;
import com.pzyruo.domain.User;
import com.pzyruo.service.RegisterService;
import com.pzyruo.service.UserService;
import com.pzyruo.service.impl.RegisterServiceImpl;
import com.pzyruo.service.impl.UserServiceImpl;
import com.pzyruo.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        System.out.println("进入到登录验证");
        UserService service = new UserServiceImpl();

        ResultInfo result = new ResultInfo();
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final String checkCode = request.getParameter("checkCode");
        //验证码判断
        final String checkCode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        //保证验证码一次有效
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //判断验证码
        if (!checkCode_server.equalsIgnoreCase(checkCode)){
            result.setErrorMsg("验证码错误");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return;
        }
        //查出结果
        User user = service.login(username,password);

        if (user!=null){
            request.getSession().setAttribute("user",user);
            result.setFlag(true);
            result.setData(user);
        }else {
            result.setFlag(false);
            result.setErrorMsg("用户名或者密码错误");
        }


        ObjectMapper mapper = new ObjectMapper();
//      String jsonResult = mapper.writeValueAsString(result);

        mapper.writeValue(response.getOutputStream(),result);
        System.out.println(result);
    }


    
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("进入到注册验证");
        User user = new User();
        ResultInfo result = new ResultInfo();
        //前端传来的验证码
        final String code = request.getParameter("checkedCode");
        //服务器端的验证码
        final String server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        //验证码判断
        if (!server.equalsIgnoreCase(code) || server==null) {
            result.setFlag(false);
            result.setErrorMsg("验证码错误");
//            request.getRequestDispatcher("/register.html").forward(request,response);
            return;
        }

        final Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }


        RegisterService service = new RegisterServiceImpl();
        int i = 0;
        try {
            i = service.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (i > 0) {
            result.setFlag(true);
        } else {
            result.setFlag(false);
        }

        ObjectMapper mapper = new ObjectMapper();
//      String jsonResult = mapper.writeValueAsString(result);
        mapper.writeValue(response.getWriter(), result);

    }

    public void welcome(HttpServletRequest request,HttpServletResponse response) throws IOException {
        final User user = (User) request.getSession().getAttribute("user");

        ResultInfo result = new ResultInfo();
        result.setFlag(true);
        result.setData(user);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),result);
        System.out.println(request);

    }

    public void activityUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        final String activityCode = request.getParameter("activityCode");
        System.out.println(activityCode);
        RegisterService service = new RegisterServiceImpl();
        final int activity = service.activity(activityCode);
        if (activity>0){
            request.getRequestDispatcher("/index.html").forward(request,response);
        }
    }

    public void exit(HttpServletRequest request,HttpServletResponse response) throws IOException {
         request.getSession().invalidate();
//        ObjectMapper mapper =new ObjectMapper();
//        ResultInfo result = new ResultInfo();
//        result.setFlag(true);
//        mapper.writeValue(response.getOutputStream(),result);
         response.sendRedirect("/travel/index.html");

    }




}
