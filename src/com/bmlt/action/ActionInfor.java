package com.bmlt.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActionInfor {

    //rID assetID employeeID quantity requestDateTime
    private String id;
    private String assetID;
    private String employeeID;
    private int quantity;
    private LocalDateTime dateTime;

    public ActionInfor() {
    }

    public ActionInfor(String id, String assetID, String employeeID, int quantity, LocalDateTime dateTime) {
        this.id = id;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public String getAssetID() {
        return assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getNumberInID() {
        String temp = id.substring(1);
        return Integer.parseInt(temp);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return getId() + "|" + getAssetID() + "|" + getEmployeeID() + "|" + getQuantity() + "|" + getDateTime().format(formatter);
    }

}
