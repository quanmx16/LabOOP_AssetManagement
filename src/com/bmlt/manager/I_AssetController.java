/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.manager;

import com.bmlt.asset.Asset;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface I_AssetController {

//    1. Login
    void login();
//    2. Search asset by name

    void searchAssetByName();
//    3. Create new asset

    void createNewAsset();
//    4. Updating asset 's information

    void updateAsset();
//    5. Approve the request of employee

    void approveRequest();
//    6. Show list of borrow asset

    void showBorrowAssetList();
//    Search asset by inputted id

    Asset searchAssetByID(String id);
//show all asset in a given list

    void showAllAssetInList(ArrayList<Asset> list);

//load data of asset
    void loadAssetData();

}
