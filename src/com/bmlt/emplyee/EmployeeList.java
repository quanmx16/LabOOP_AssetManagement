package com.bmlt.emplyee;

import com.bmlt.file.EmployeeReader;
import com.bmlt.file.EmployeeWriter;
import java.util.ArrayList;

public class EmployeeList extends ArrayList<Employee> implements I_EmployeeList {
    
    @Override
    public void writeDataToFile() {
        EmployeeWriter ew = new EmployeeWriter();
        ew.writeListToFile(this);
    }
    
    @Override
    public Employee searchEmployeeByID(String id) {
        Employee result = null;
        for (Employee employee : this) {
            if (employee.getEmployID().equals(id)) {
                result = employee;
            }
        }
        return result;
    }
    
    @Override
    public void readDataFromFile() {
        EmployeeReader er = new EmployeeReader();
        er.readDataToList(this);
    }
    
}
