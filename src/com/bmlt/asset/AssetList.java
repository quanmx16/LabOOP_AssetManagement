package com.bmlt.asset;

import com.bmlt.file.AssetReader;
import com.bmlt.file.AssetWriter;
import java.util.ArrayList;

public class AssetList extends ArrayList<Asset> implements I_AssetList {

    @Override
    public void readDataFromFile() {
        AssetReader ar = new AssetReader();
        ar.readDataToList(this);
    }

    @Override
    public void writeDataToFile() {
        AssetWriter aw = new AssetWriter();
        aw.writeListToFile(this);
    }

    @Override
    public Asset searchAssetByID(String id) {
        Asset result = null;
        for (Asset asset : this) {
            if (asset.getAssetID().equals(id)) {
                result = asset;
            }
        }
        return result;
    }

    @Override
    public ArrayList<Asset> searchAssetByName(String text) {
        ArrayList<Asset> res = new ArrayList<>();
        for (Asset asset : this) {
            if (asset.getName().toUpperCase().contains(text.toUpperCase())) {
                res.add(asset);
            }
        }
        return res;
    }

    @Override
    public boolean addNewAsset(String id, String name, String color, double price, double weight, int quantity) {
        Asset asset = new Asset(id, name, color, price, weight, quantity);
        this.add(asset);
        return true;
    }

}
