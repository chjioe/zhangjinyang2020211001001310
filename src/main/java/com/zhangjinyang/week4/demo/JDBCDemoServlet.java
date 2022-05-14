package com.zhangjinyang.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebServlet(name = "JDBCDemoServlet",urlPatterns = {"/jdbc"},
//    initParams = {
//            @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//            @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
//            @WebInitParam(name = "username",value = "zjysa"),
//            @WebInitParam(name = "password",value = "123456")
//    },
//        loadOnStartup = 1
//)
@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)
public class JDBCDemoServlet extends HttpServlet {

    Connection conn=null;
    @Override
    public void init() throws ServletException {



        super.init();

//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
//        String username="zjysa";
//        String password="123456";

//        ServletConfig config = getServletConfig();
//        String driver= config.getInitParameter("driver");
//        String url= config.getInitParameter("url");
//        String username= config.getInitParameter("username");
//        String password= config.getInitParameter("password");

        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");


        try {
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoservlet" +conn);//test
            context.setAttribute("con",conn);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
