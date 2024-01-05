package com.prakashit.utility;

import java.sql.*;

public class JDBCConnectionUtility {
    private static final String URL = "jdbc:mysql://localhost:3306/servletdb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        return con;
    }

    //cleanup
    public static void cleanUp(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs!=null){
            rs.close();
        }
        if (ps!=null){
            ps.close();
        }
        if (con!=null){
            con.close();
        }
    }

    public static void cleanUp( PreparedStatement ps, Connection con) throws SQLException {
        if (ps!=null){
            ps.close();
        }
        if (con!=null){
            con.close();
        }
    }

}
