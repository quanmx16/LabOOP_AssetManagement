/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.action;

/**
 *
 * @author Dell
 */
public interface I_BorrowList {

    void loadDataFromFile();

    void writeDataToFile();

    void showAll();

    void showInfor(ActionInfor act);
}
