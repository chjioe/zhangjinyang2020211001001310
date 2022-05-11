package com.zhangjinyang.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("I am constructor --> LifeCycleServlet() ");
    }

    @Override
    public void init() {
        System.out.println("I am in init() ");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("I am service --> deGet() ");
    }

    @Override
    public void destroy() {
        System.out.println("I am in destroy() ");
    }
}
