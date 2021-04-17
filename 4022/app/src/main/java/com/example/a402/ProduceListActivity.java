package com.example.a402;

import android.app.ListActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ProduceListActivity extends ListActivity {
    private Button home;
    ListView listView;
    private IndexCounter ic = new IndexCounter();

    List<ProduceList> produceList = ProduceList.listAll(ProduceList.class);
    List<LikeManager> likeManager = LikeManager.listAll(LikeManager.class);

    // Create variables to hold information from database
    private String prodNames[] = new String[produceList.size()];
    private String prodQuant[] = new String[produceList.size()];
    private int imageInt[] = new int[produceList.size()];
    private int tag[] = new int[produceList.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        int i = 0;
        while(i < produceList.size()){
            prodNames[i] = produceList.get(i).Item;
            prodQuant[i] = String.valueOf(produceList.get(i).Stock);

            switch(produceList.get(i).StoreID){
                case 1:
                    imageInt[i] = R.drawable.frys_logo;
                    break;
                case 2:
                    imageInt[i] = R.drawable.safeway_logo;
                    break;
                case 3:
                    imageInt[i] = R.drawable.albertsons_logo;
                    break;
                default:
                    break;
            }
            tag[i] = i;
            i++;
        }

        Log.d("produce", produceList.toString());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.produce_list_view);

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });



        listView = (ListView)findViewById(android.R.id.list);

        CustomAdapter customAdapter = new CustomAdapter(this, prodNames, prodQuant, imageInt, tag);
        listView.setAdapter(customAdapter);

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "You Selected " + prodNames[position - 1] + " as Product", Toast.LENGTH_SHORT).show();

            }
        });*/
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void likeClicked(View v){
        int ID = (int) v.getTag();

        Toast.makeText(this, "Liked " + produceList.get(ID).Item, Toast.LENGTH_SHORT).show();

        int prodExists = ProductInDatabase(ID);
        if(prodExists > 0) {
            AddLike(prodExists);
        }
        else
        {
            AddLikedItem(produceList.get(ID).ItemID, produceList.get(ID).Item);
        }
    }

    public int ProductInDatabase(int ID){
        int itemID = produceList.get(ID).ItemID;
        int i = 0;
        if(likeManager.size() != 0){
            while(i < likeManager.size()){
                if(likeManager.get(i).ItemID == itemID){
                    return i;
                }
            }

        }
        return 0;
    }

    public void AddLike(int itemExists){
        // If greater than 0 than the item does exist
            LikeManager lm = LikeManager.findById(LikeManager.class, Long.parseLong(String.valueOf(itemExists)));
            lm.LikeNum = lm.LikeNum + 1;
            lm.save();
    }

    public void AddLikedItem(int ItemID, String ItemName){
        LikeManager lm = new LikeManager(ItemName, ItemID, 1);
        lm.save();
    }



}