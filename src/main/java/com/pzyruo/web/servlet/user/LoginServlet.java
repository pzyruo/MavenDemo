//package com.pzyruo.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pzyruo.domain.ResultInfo;
//import com.pzyruo.domain.User;
//import com.pzyruo.service.UserService;
//import com.pzyruo.service.impl.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/loginServlet")
//public class LoginServlet extends HttpServlet {
//    UserService service = new UserServiceImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进入到登录验证");
//        ResultInfo result = new ResultInfo();
//        final String username = request.getParameter("username");
//        final String password = request.getParameter("password");
//        final String checkCode = request.getParameter("checkCode");
//        //验证码判断
//        final String checkCode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
//        //保证验证码一次有效
//        request.getSession().removeAttribute("CHECKCODE_SERVER");
//        //判断验证码
//        if (!checkCode_server.equalsIgnoreCase(checkCode)){
//            result.setErrorMsg("验证码错误");
//            request.getRequestDispatcher("/login.html").forward(request,response);
//            return;
//        }
//        //查出结果
//        User user = service.login(username,password);
//
//        if (user!=null){
//            request.getSession().setAttribute("user",user);
//            result.setFlag(true);
//            result.setData(user);
//        }else {
//            result.setFlag(false);
//            result.setErrorMsg("用户名或者密码错误");
//        }
//
//
//        ObjectMapper mapper = new ObjectMapper();
////      String jsonResult = mapper.writeValueAsString(result);
//
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getWriter(),result);
//        System.out.println(result);
//
//    }
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request,response);
//    }
//}
