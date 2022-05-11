package com.zhangjinyang.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthdate");

        PrintWriter writer = response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>Email:"+Email);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>birthDate:"+birthDate);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
