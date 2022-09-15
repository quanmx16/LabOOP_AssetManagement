/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.manager;

import com.bmlt.emplyee.Employee;
import com.bmlt.emplyee.EmployeeList;
import com.bmlt.emplyee.I_EmployeeList;
import com.bmlt.lib.Utils;

/**
 *
 * @author Dell
 */
public class Login implements I_Login {

    I_EmployeeList emloyeeList = new EmployeeList();
    static boolean checkLogin = false;

    {
        emloyeeList.readDataFromFile();
    }

    @Override
    public boolean loginToSystem() {
        String employeeID;
        String password;
        employeeID = Utils.getString("Enter employee id: ");
        password = Utils.getString("Enter your password: ");
        Employee employee = emloyeeList.searchEmployeeByID(employeeID);
        if (employee != null && employee.getRole().equals("EM")) {
            System.out.println("***You are not manager, try again!***");
            return checkLogin;
        }
        if (employee != null) {
            if (employee.getPassword().equals(password)) {
                checkLogin = true;
            } else {
                checkLogin = false;
            }
        } else {
            checkLogin = false;
        }
        if (checkLogin == true) {
            System.out.println("Login successfully!");
        } else {
            System.out.println("Incorrect id or password!");
        }
        return checkLogin;
    }

    @Override
    public boolean checkLogin() {
        return checkLogin;
    }
}
