package com.example.a402;

import com.orm.SugarRecord;

public class ProduceList extends SugarRecord<ProduceList> {
    String Item;
    int Stock;
    float Price;
    int ItemID;
    int GroupID;
    int StoreID;

    public ProduceList(){}

    public ProduceList(String Item, int Stock, float Price, int ItemID, int GroupID, int StoreID){
        this.Item = Item;
        this.Stock = Stock;
        this.Price = Price;
        this.ItemID = ItemID;
        this.GroupID = GroupID;
        this.StoreID = StoreID;
    }

}
