/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.file;

import com.bmlt.emplyee.Employee;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class EmployeeWriter implements Writer {

    @Override
    public void writeListToFile(ArrayList src) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src\\data\\employee.txt"), "UTF-8");
            BufferedWriter buffWiter = new BufferedWriter(writer);
            for (Object employee : src) {
                buffWiter.write(((Employee) employee).toString());
                buffWiter.newLine();
            }
            buffWiter.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Store successfully!");
    }

}
