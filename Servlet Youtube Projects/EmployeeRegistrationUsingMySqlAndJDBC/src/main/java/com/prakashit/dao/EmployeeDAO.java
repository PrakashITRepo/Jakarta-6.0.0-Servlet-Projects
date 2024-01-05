package com.prakashit.dao;

import com.prakashit.bean.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
    int result = 0;
    public int register(Employee employee) throws ClassNotFoundException {
        //JDBC code
        String insert_query = "insert into employees (firstName,lastName,eMail) values (?,?,?)";
        String url = "jdbc:mysql://localhost:3306/servletdb";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(url,"root","root");
             PreparedStatement ps = con.prepareStatement(insert_query)){

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.geteMail());

            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }

        return result;
    }
}
