package com.bmlt.emplyee;

public interface I_EmployeeList {

//Read data from file
    void readDataFromFile();
//Write data to file needs to be called 

    void writeDataToFile();

    Employee searchEmployeeByID(String id);
}
