//package com.pzyruo.web.servlet;
//
//import com.pzyruo.service.RegisterService;
//import com.pzyruo.service.impl.RegisterServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/activityUserServlet")
//public class ActivityUserServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        final String activityCode = request.getParameter("activityCode");
//        System.out.println(activityCode);
//        RegisterService service = new RegisterServiceImpl();
//        final int activity = service.activity(activityCode);
//        if (activity>0){
//            request.getRequestDispatcher("/index.html").forward(request,response);
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request,response);
//    }
//}
