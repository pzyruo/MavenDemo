//package com.pzyruo.web.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pzyruo.domain.ResultInfo;
//import com.pzyruo.domain.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/welcomeServlet")
//public class WelcomeServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        final User user = (User) request.getSession().getAttribute("user");
//
//        ResultInfo result = new ResultInfo();
//        result.setFlag(true);
//        result.setData(user);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getWriter(),result);
//        System.out.println(request);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request,response);
//    }
//}
