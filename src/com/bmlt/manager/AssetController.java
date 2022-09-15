package com.bmlt.manager;

import com.bmlt.lib.IdGenerator;
import com.bmlt.lib.CurrentTime;
import com.bmlt.action.ActionInfor;
import com.bmlt.action.BorrowList;
import com.bmlt.action.RequestList;
import com.bmlt.asset.AssetList;
import com.bmlt.asset.Asset;
import com.bmlt.lib.Utils;
import java.util.ArrayList;
import java.util.Collections;

public class AssetController implements I_AssetController {

    AssetList assetList;

    {
        loadAssetData();
    }

    public AssetController() {

    }

    @Override
    public void loadAssetData() {
        assetList = new AssetList();
        assetList.readDataFromFile();
    }

    @Override
    public void login() {
        Login login = new Login();
        if (login.checkLogin() == true) {
            System.out.println("You has already logged in!");
        } else {
            login.loginToSystem();
        }
    }

    @Override
    public void searchAssetByName() {
        String nameText = Utils.getString("Enter a name string: ");
        ArrayList<Asset> resultAsset = assetList.searchAssetByName(nameText);
        //sort asset by name (descending)
        Collections.sort(resultAsset, (as1, as2) -> {
            return -1 * (as1.getName().compareTo(as2.getName()));
        });
        showAllAssetInList(resultAsset);
    }

    @Override
    public void createNewAsset() {
        if (Login.checkLogin == false) {
            System.out.println("Manager must login to use this function!");
            return;
        }
        boolean check;
        boolean exit;
        boolean status;
        //assetID name color price weight quantity
        do {
            status = false;
            check = true;

            String id = Utils.getString("Enter asset id: ");
            if (assetList.searchAssetByID(id) != null) {
                System.out.println("Asset's existed! Cannot add");
                check = false;
            }

            if (check) {
                String name = Utils.getString("Enter asset name: ");
                String color = Utils.getString("Enter asset color: ");
                double price = Utils.getDouble("Enter asset price: ", 0, 9999);
                double weight = Utils.getDouble("Enter asset weight: ", 0, 9999);
                int quantity = Utils.getInt("Enter asset quantity: ", 0, 9999);
                status = assetList.addNewAsset(id, name, color, price, weight, quantity);
            }
            if (status) {
                System.out.println("Add successful!");
                // after creating the program will write data to file and reload it 
                assetList.writeDataToFile();
                loadAssetData();
            }
            exit = Utils.confirmYesNo("Do you want to continue adding? (Y/N): ");

        } while (exit);

    }

    @Override
    public void updateAsset() {
        if (Login.checkLogin == false) {
            System.out.println("Manager must login to use this function!");
            return;
        }
        boolean check = true;
        //assetID name color price weight quantity
        String id = Utils.getString("Enter asset id: ");
        Asset asset = assetList.searchAssetByID(id);
        if (asset == null) {
            System.out.println("Asset does not exist!");
            check = false;
        }
        if (check) {
            String name = Utils.updateString("Enter new name: ", asset.getName());
            String color = Utils.updateString("Enter new color: ", asset.getColor());
            double price = Utils.updateDouble("Enter asset new price: ", 0, 9999, asset.getPrice());
            double weight = Utils.updateDouble("Enter asset new weight: ", 0, 9999, asset.getWeight());
            int quantity = Utils.updateInt("Enter asset new quantity: ", 0, 9999, asset.getQuantity());

            asset.setName(name);
            asset.setColor(color);
            asset.setPrice(price);
            asset.setWeight(weight);
            asset.setQuantity(quantity);
            //show infor after updating
            System.out.printf("%-10s\t%-20s\t%-10s\t%-6s\t%-6s\t%-6s\n", "id", "name", "color", "price", "weight", "quantity");
            asset.showInfor();
            //after updating the program will write data to file and reload it
            assetList.writeDataToFile();
            loadAssetData();
        }
    }

    @Override
    public void approveRequest() {
        //Manager must login to use this function
        if (Login.checkLogin == false) {
            System.out.println("Manager must login to use this function!");
            return;
        }
        RequestList requestList = new RequestList();
        //System will show list of borrow request from employee
        requestList.showAll();
        String selectedID = Utils.getString("Enter the request id to approve: ");
        ActionInfor request = requestList.searchRequestByID(selectedID);
        if (request == null) {
            System.out.println("Request id does not exit!");
        } else {
            //get the quantity of asset in stock
            Asset assetInStock = assetList.searchAssetByID(request.getAssetID());
            if (assetInStock == null) {
                System.out.println("Asset does not exit in stock!");
            } else {
                //check quantity
                int existAsset = assetInStock.getQuantity();
                if (existAsset < request.getQuantity()) {
                    System.out.println("The number of assets in request bigger than in stock!");
                } else {

                    BorrowList borrowList = new BorrowList();
                    //Insert data into the file borrow
                    ActionInfor act = new ActionInfor(IdGenerator.getBorrowId(borrowList.get(borrowList.size() - 1).getNumberInID()), request.getAssetID(), request.getEmployeeID(), request.getQuantity(), CurrentTime.getCurrentTime());
                    borrowList.add(act);
                    //Remove the data line in the file request
                    requestList.remove(request);
                    requestList.writeDataToFile();
                    borrowList.writeDataToFile();
                    //Update infor in stock
                    if (existAsset - request.getQuantity() > 0) {
                        assetInStock.setQuantity(existAsset - request.getQuantity());
                    } else {
                        assetList.remove(assetInStock);
                    }
                    assetList.writeDataToFile();
                    loadAssetData();
                    System.out.println("Approve successfully!");
                }
            }
        }
    }

    @Override
    public void showBorrowAssetList() {
        //Manager must login to use this function
        if (Login.checkLogin == false) {
            System.out.println("Manager must login to use this function!");
            return;
        }
        BorrowList borrowList = new BorrowList();
        borrowList.showAll();
    }

    @Override
    public Asset searchAssetByID(String id) {
        return assetList.searchAssetByID(id);
    }

    @Override
    public void showAllAssetInList(ArrayList<Asset> list) {
        //assetID name color price weight quantity
        System.out.printf("%-10s\t%-20s\t%-10s\t%-6s\t%-6s\t%-6s\n", "id", "name", "color", "price", "weight", "quantity");
        for (Asset asset : list) {
            asset.showInfor();
        }
    }

}
