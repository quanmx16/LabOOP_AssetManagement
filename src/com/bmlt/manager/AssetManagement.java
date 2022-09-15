package com.bmlt.manager;

import com.bmlt.menu.I_Menu;
import com.bmlt.menu.Menu;

public class AssetManagement {

    public static void main(String[] args) {
        I_Menu menu = new Menu();
        menu.addItem("Login");
        menu.addItem("Search asset by name");
        menu.addItem("Create new asset");
        menu.addItem("Updating asset's information");
        menu.addItem("Approve the request of employee");
        menu.addItem("Show list of borrow asset");
        menu.addItem("Quit");
        AssetController assetController = new AssetController();
        int choice;
        boolean exit = false;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    assetController.login();
                    break;
                case 2:
                    assetController.searchAssetByName();
                    break;
                case 3:
                    assetController.createNewAsset();
                    break;
                case 4:
                    assetController.updateAsset();
                    break;
                case 5:
                    assetController.approveRequest();
                    break;
                case 6:
                    assetController.showBorrowAssetList();
                    break;
                case 7:
                    exit = menu.confirmYesNo("Are you sure?(Y/N)");
                    break;
            }
        } while (!exit);
        System.out.println("Goodbye!");
    }
}
