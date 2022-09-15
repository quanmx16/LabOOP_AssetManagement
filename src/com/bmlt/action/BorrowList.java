package com.bmlt.action;

import com.bmlt.file.BorrowReader;
import com.bmlt.file.BorrowWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BorrowList extends ArrayList<ActionInfor> implements I_BorrowList {

    {
        loadDataFromFile();
    }

    public BorrowList() {
    }

    @Override
    public void loadDataFromFile() {
        BorrowReader borR = new BorrowReader();
        borR.readDataToList(this);
    }

    @Override
    public void writeDataToFile() {
        BorrowWriter bw = new BorrowWriter();
        bw.writeListToFile(this);
    }

    @Override
    public void showAll() {
        System.out.printf("%-5s\t%-8s\t%-10s\t%-8s\t%-15s\n", "bID", "assetID", "employeeID", "quantity", "borrowDateTime");
        for (ActionInfor act : this) {
            showInfor(act);
        }
    }

    @Override
    public void showInfor(ActionInfor act) {
        LocalDateTime dateTime = act.getDateTime();
        String date = dateTime.getDayOfMonth() + "-" + dateTime.getMonth().getValue() + "-" + dateTime.getYear() + " " + dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond();
        System.out.printf("%-5s\t%-8s\t%-10s\t%-8d\t%-15s\n", act.getId(), act.getAssetID(), act.getEmployeeID(), act.getQuantity(), date);
    }

}
