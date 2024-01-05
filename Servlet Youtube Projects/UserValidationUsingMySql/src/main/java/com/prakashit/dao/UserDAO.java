package com.prakashit.dao;

import com.prakashit.bean.User;

import java.sql.*;

public class UserDAO {
    boolean  status = false;
    String sql = "select * from user_login where userName = ? and password = ?";

    public boolean validate(User user) throws ClassNotFoundException, SQLException {
        //jdbc code to validate
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con
                     = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "root");
             PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            System.out.println("stmt : "+pstmt);

            ResultSet rs = pstmt.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return status;
    }
}
