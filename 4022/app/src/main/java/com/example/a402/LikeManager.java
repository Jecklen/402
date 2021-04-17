package com.example.a402;

import com.orm.SugarRecord;

public class LikeManager extends SugarRecord<ProduceList> {
    String Item;
    int ItemID;
    int LikeNum;

    public LikeManager(){}

    public LikeManager(String Item, int ItemID, int LikeNum){
        this.Item = Item;
        this.ItemID = ItemID;
        this.LikeNum = LikeNum;
    }

}
