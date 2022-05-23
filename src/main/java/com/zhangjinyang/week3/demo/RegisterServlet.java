package com.zhangjinyang.week3.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    @Override
    public void init() throws ServletException {
        conn= (Connection) getServletContext().getAttribute("conn");//name of attibute
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ID=request.getParameter("ID");
        String username=request.getParameter("username");
        String passwords=request.getParameter("passwords");
        String emails=request.getParameter("emails");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthdate");

        try {
            String sql = "insert into Registers(ID, username, passwords, emails, gender, birthdate) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"23");
            ps.setString(2, username);
            ps.setString(3, passwords);
            ps.setString(4, emails);
            ps.setString(5, gender);
            ps.setString(6, birthdate);
            ps.executeUpdate();

            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/registerwww.jsp").forward(request, response);
    }
}
