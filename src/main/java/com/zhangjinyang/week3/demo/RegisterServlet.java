package com.zhangjinyang.week3.demo;

import com.zhangjinyang.model.User;
import com.zhangjinyang.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthdate");

        user.setId(1);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        Connection conn = (Connection) getServletContext().getAttribute("con");;
        UserDao userDao = new UserDao();
        try {
            userDao.saveUser(conn,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter writer = response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>Email:"+Email);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>birthDate:"+birthDate);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
}
