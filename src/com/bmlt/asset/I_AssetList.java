package com.bmlt.asset;

import com.bmlt.asset.Asset;
import java.util.ArrayList;

public interface I_AssetList {

//load data
    void readDataFromFile();
//store data must be called

    void writeDataToFile();
//The system will search in the company, and return asset that has name contain the search id.

    Asset searchAssetByID(String id);
//The system will search in the company, and return all asset that has name contain the search text.

    ArrayList<Asset> searchAssetByName(String text);

    // add new asset to list
    boolean addNewAsset(String id, String name, String color, double price, double weight, int quantity);
}
