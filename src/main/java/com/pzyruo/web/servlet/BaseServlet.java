package com.pzyruo.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("你好");
        super.init();
    }


    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取请求
        final String uri = req.getRequestURI();
        //截取uri,得到方法名
        final String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        try{
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,res);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void writeValue(Object obj,HttpServletResponse response)throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),obj);
    }

}
