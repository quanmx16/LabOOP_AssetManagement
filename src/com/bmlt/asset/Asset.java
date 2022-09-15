package com.bmlt.asset;

public class Asset {
//assetID name color price weight quantity

    private String assetID;
    private String name;
    private String color;
    private double price;
    private double weight;
    private int quantity;

    public Asset() {
    }

    public Asset(String assetID, String name, String color, double price, double weight, int quantity) {
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getAssetID() {
        return assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getAssetID() + "|" + getName() + "|" + getColor() + "|" + getPrice() + "|" + getWeight() + "|" + getQuantity();
    }

    public void showInfor() {
        System.out.printf("%-10s\t%-20s\t%-10s\t%-6.2f\t%-6.2f\t%-6d\n", getAssetID(), getName(), getColor(), getPrice(), getWeight(), getQuantity());
    }
}
