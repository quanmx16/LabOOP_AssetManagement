/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.file;

import com.bmlt.emplyee.Employee;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Dell
 */
public class EmployeeReader implements Reader {

    @Override
    public void readDataToList(ArrayList list) {

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src\\data\\employee.txt"), "UTF-8");
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            while ((line = buffReader.readLine()) != null) {
                createObject(line, list);
            }
            buffReader.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createObject(String line, ArrayList list) {
        StringTokenizer st = new StringTokenizer(line, "|");
        List<String> token = new ArrayList<>();
        while (st.hasMoreElements()) {
            token.add(st.nextToken());
        }
        String employID = token.get(0);
        String name = token.get(1);
        String bDate = token.get(2); // convert to string before specifying 
        String role = token.get(3);
        String sex = token.get(4);
        String password = token.get(5);

        //deal with date-time
        StringTokenizer stBDate = new StringTokenizer(bDate, "/");
        int[] time = new int[3];
        int index = 0;
        while (stBDate.hasMoreElements()) {
            time[index] = Integer.parseInt(stBDate.nextToken());
            index++;
        }
        LocalDate birthDay = LocalDate.of(time[2], time[1], time[0]);

        Employee employee = new Employee(employID, name, birthDay, role, sex, password);
        list.add(employee);
    }

}
