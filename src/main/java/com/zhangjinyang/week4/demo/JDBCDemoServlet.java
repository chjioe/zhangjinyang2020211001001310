package com.zhangjinyang.week4.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "JDBCDemoServlet")
public class JDBCDemoServlet extends HttpServlet {

    Connection conn=null;
    @Override
    public void init() throws ServletException {



        super.init();

        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username="zjysa";
        String password="123456";

        try {
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> " +conn);//test
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
