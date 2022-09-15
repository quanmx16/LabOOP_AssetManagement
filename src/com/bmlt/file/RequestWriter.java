/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class RequestWriter implements Writer {

    @Override
    public void writeListToFile(ArrayList src) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src\\data\\request.txt"), "UTF-8");
            BufferedWriter buffWiter = new BufferedWriter(writer);
            for (Object request : src) {
                buffWiter.write(request.toString());
                buffWiter.newLine();
            }
            buffWiter.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
