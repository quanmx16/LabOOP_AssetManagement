package com.bmlt.action;

/**
 *
 * @author Dell
 */
public interface I_RequestList {

    void loadDataFromFile();

    void writeDataToFile();

    void showAll();

    void showInfor(ActionInfor act);

    ActionInfor searchRequestByID(String id);
}
