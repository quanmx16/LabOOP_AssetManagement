/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.file;

import com.bmlt.action.ActionInfor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Dell
 */
public class RequestReader implements Reader {

    @Override
    public void readDataToList(ArrayList list) {

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src\\data\\request.txt"), "UTF-8");
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
        String rID = token.get(0);
        String assetID = token.get(1);
        String employeeID = token.get(2);
        int quantity = Integer.parseInt(token.get(3));
        String date = token.get(4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        ActionInfor act = new ActionInfor(rID, assetID, employeeID, quantity, dateTime);
        list.add(act);
    }

}
