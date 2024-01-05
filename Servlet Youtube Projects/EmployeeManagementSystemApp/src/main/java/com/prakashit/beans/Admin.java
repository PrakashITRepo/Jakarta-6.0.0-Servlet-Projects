package com.prakashit.beans;

import java.io.Serializable;

public class Admin implements Serializable {
    private int empId;
    private String password;

    public Admin() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
