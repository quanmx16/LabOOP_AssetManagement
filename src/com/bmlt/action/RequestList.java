package com.bmlt.action;

import com.bmlt.file.RequestReader;
import com.bmlt.file.RequestWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RequestList extends ArrayList<ActionInfor> implements I_RequestList {

    {
        loadDataFromFile();
    }

    public RequestList() {
    }

    @Override
    public void loadDataFromFile() {
        RequestReader resR = new RequestReader();
        resR.readDataToList(this);
    }

    @Override
    public void writeDataToFile() {
        RequestWriter rw = new RequestWriter();
        rw.writeListToFile(this);
    }

    @Override
    public void showAll() {
        System.out.printf("%-5s\t%-8s\t%-10s\t%-8s\t%-15s\n", "rID", "assetID", "employeeID", "quantity", "requestDateTime");
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

    @Override
    public ActionInfor searchRequestByID(String id) {
        ActionInfor act;
        for (int i = 0; i < this.size(); i++) {
            act = this.get(i);
            if (act.getId().equals(id)) {
                return act;
            }
        }
        return null;
    }

}
