package com.prakashit.daoImpl;

import com.prakashit.beans.Employee;
import com.prakashit.dao.EmployeeDAO;
import com.prakashit.utility.JDBCConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String SAVE_EMPLOYEE
            = "insert into employee_details (firstName,lastName,userName,password,country) values(?,?,?,?,?)";
    private static final String UPDATE_EMPLOYEE_BY_ID
            = "update employee_details set firstName=?,lastName=?,userName=?,password=?,country=? where empId=?";
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from employee_details  where empId=?";
    private static final String GET_EMPLOYEE_BY_ID = "select * from employee_details where empId=?";
    private static final String GET_ALL_EMPLOYEES = "select * from employee_details";

    @Override
    public int saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(SAVE_EMPLOYEE);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getUserName());
        ps.setString(4, employee.getPassword());
        ps.setString(5, employee.getCountry());

        System.out.println(ps);
        status = ps.executeUpdate();

        JDBCConnectionUtility.cleanUp(ps,con);
        return status;
    }

    @Override
    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getUserName());
        ps.setString(4, employee.getPassword());
        ps.setString(5, employee.getCountry());
        ps.setInt(6, employee.getEmpId());
        System.out.println(ps);
        status = ps.executeUpdate();
        JDBCConnectionUtility.cleanUp(ps,con);
        return status;
    }

    @Override
    public int deleteEmployee(int empId) throws SQLException, ClassNotFoundException {
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE_BY_ID);

        ps.setInt(1, empId);
        System.out.println(ps);
        status = ps.executeUpdate();
        JDBCConnectionUtility.cleanUp(ps,con);
        return status;
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException, ClassNotFoundException {
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_BY_ID);
        ps.setInt(1, empId);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        Employee emp = new Employee();
        while (rs.next()) {
            emp.setEmpId(rs.getInt(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUserName(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setCountry(rs.getString(6));

        }
        JDBCConnectionUtility.cleanUp(rs,ps,con);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_ALL_EMPLOYEES);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUserName(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setCountry(rs.getString(6));
            employeeList.add(emp);
        }
        JDBCConnectionUtility.cleanUp(rs,ps,con);
        return employeeList;
    }
}
