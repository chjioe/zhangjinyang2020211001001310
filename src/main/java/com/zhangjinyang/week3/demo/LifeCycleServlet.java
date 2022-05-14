package com.zhangjinyang.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "LifeCycleServlet",urlPatterns = {"/life"})
public class LifeCycleServlet extends HttpServlet {
    Connection conn = null;
    public LifeCycleServlet(){
        System.out.println("I am constructor --> LifeCycleServlet() ");
    }

    @Override
    public void init() {
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");


        try {
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoservlet" +conn);//test
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("I am in init() -->in LifeCycleServlet " +conn);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("I am service --> deGet() ");
    }

    @Override
    public void destroy() {
        System.out.println("I am in destroy() ");
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
