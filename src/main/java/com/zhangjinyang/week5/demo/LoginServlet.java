package com.zhangjinyang.week5.demo;

import com.zhangjinyang.model.User;
import com.zhangjinyang.userdao.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    public void init() throws ServletException {
        super.init();
//        ServletContext context = getServletContext();
//        String driver = context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username = context.getInitParameter("username");
//        String password = context.getInitParameter("password");
//
//
//        try {
//            Class.forName(driver);
//            Connection conn= DriverManager.getConnection(url,username,password);
//            System.out.println("Connection --> in JDBCDemoservlet" +conn);//test
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        conn = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");


        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(conn,username,password);
            if (user != null){

                String rememberMe = request.getParameter("rememberMe");
                if(rememberMe!= null && rememberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(60*60*24*10);
                    passwordCookie.setMaxAge(60*60*24*10);
                    rememberMeCookie.setMaxAge(60*60*24*10);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60*60);
                session.setAttribute("user", user);


                request.getRequestDispatcher("userInfo.jsp").forward(request, response);

            }else {
                request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
