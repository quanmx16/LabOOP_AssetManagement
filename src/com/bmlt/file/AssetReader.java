/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.file;

import com.bmlt.asset.Asset;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Dell
 */
public class AssetReader implements Reader {

    @Override
    public void readDataToList(ArrayList list) {

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src\\data\\asset.txt"), "UTF-8");
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
        String assetID = token.get(0);
        String name = token.get(1);
        String color = token.get(2);
        double price = Double.parseDouble(token.get(3));
        double weight = Double.parseDouble(token.get(4));
        int quantity = Integer.parseInt(token.get(5));

        Asset asset = new Asset(assetID, name, color, price, weight, quantity);
        list.add(asset);
    }

}
