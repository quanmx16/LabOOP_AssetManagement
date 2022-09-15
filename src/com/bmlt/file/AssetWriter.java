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
public class AssetWriter implements Writer {

    @Override
    public void writeListToFile(ArrayList src) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src\\data\\asset.txt"), "UTF-8");
            BufferedWriter buffWiter = new BufferedWriter(writer);
            for (Object asset : src) {
                buffWiter.write(asset.toString());
                buffWiter.newLine();
            }
            buffWiter.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Successfully store the information!");
    }

}
