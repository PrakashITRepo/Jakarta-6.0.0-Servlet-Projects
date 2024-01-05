package com.prakashit.dao;

import com.prakashit.beans.Employee;

import java.sql.SQLException;
import java.util.List;

/*This EmployeeDAO class will provide all the CRUD(create,read,update and delete operation)

* **/
public interface EmployeeDAO {
    public int saveEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public int deleteEmployee(int empId) throws SQLException, ClassNotFoundException;
    public Employee getEmployeeById(int empId) throws SQLException, ClassNotFoundException;
    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;
}
