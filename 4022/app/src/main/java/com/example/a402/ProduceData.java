package com.example.a402;

public class ProduceData {
    private String name;
    private int stock;
    private float price;

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    private int ItemID;
    private int GroupID;
    private int StoreID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int groupID) {
        GroupID = groupID;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int storeID) {
        StoreID = storeID;
    }

    @Override
    public String toString() {
        return "ProduceData{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", ItemID=" + ItemID +
                ", GroupID=" + GroupID +
                ", StoreID=" + StoreID +
                '}';
    }
}
