package com.prakashit.dao;

import com.prakashit.beans.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    public boolean validate(Admin admin) throws SQLException, ClassNotFoundException;
}
