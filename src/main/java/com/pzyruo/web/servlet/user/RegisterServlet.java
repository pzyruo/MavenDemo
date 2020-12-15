//package com.pzyruo.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pzyruo.domain.ResultInfo;
//import com.pzyruo.domain.User;
//import com.pzyruo.service.RegisterService;
//import com.pzyruo.service.impl.RegisterServiceImpl;
//import com.pzyruo.util.UuidUtil;
//import org.apache.commons.beanutils.BeanUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.text.ParseException;
//import java.util.Map;
//
//@WebServlet("/register")
//public class RegisterServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进入到注册验证");
//        User user = new User();
//        ResultInfo result = new ResultInfo();
//        //前端传来的验证码
//        final String code = request.getParameter("checkedCode");
//        //服务器端的验证码
//        final String server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
//        request.getSession().removeAttribute("CHECKCODE_SERVER");
//        //验证码判断
//        if (!server.equalsIgnoreCase(code) || server==null) {
//            result.setFlag(false);
//            result.setErrorMsg("验证码错误");
////            request.getRequestDispatcher("/register.html").forward(request,response);
//            return;
//        }
//
//        final Map<String, String[]> parameterMap = request.getParameterMap();
//
//        try {
//            BeanUtils.populate(user, parameterMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        RegisterService service = new RegisterServiceImpl();
//        int i = 0;
//        try {
//            i = service.register(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (i > 0) {
//            result.setFlag(true);
//        } else {
//            result.setFlag(false);
//        }
//
//        ObjectMapper mapper = new ObjectMapper();
////      String jsonResult = mapper.writeValueAsString(result);
//        mapper.writeValue(response.getWriter(), result);
//
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
