package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.orm.SugarRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mapScreen;
    private Button produceListScreen;
    private Button recentlyViewedScreen;
    private Button preferenceScreen;
    private Button searchByZipScreen;
    private List<ProduceData> produceDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteAllRecords();

        SortData(R.raw.albertsons_data);
        SortData(R.raw.frys_data);
        SortData(R.raw.safeway_data);

        addNewRecord();


        ProduceList pl = new ProduceList("kiwi", 5, 5, 111, 03, 02);
        pl.save();


        mapScreen = (Button) findViewById(R.id.MapScreen);
        mapScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        produceListScreen = (Button) findViewById(R.id.ProduceListScreen);
        produceListScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProduceList();
            }
        });
        recentlyViewedScreen = (Button) findViewById(R.id.RecentlyViewedScreen);
        recentlyViewedScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecent();
            }
        });
        preferenceScreen = (Button) findViewById(R.id.PreferencesScreen);
        preferenceScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPreferences();
            }
        });
        searchByZipScreen = (Button) findViewById(R.id.SearchByZipView);
        searchByZipScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchByZip();
            }
        });
    }

    private void addNewRecord() {
        for (int i = 0; i < produceDataList.size(); i++) {
            ProduceList pl = new ProduceList(produceDataList.get(i).getName(), produceDataList.get(i).getStock(),
                    produceDataList.get(i).getPrice(), produceDataList.get(i).getItemID(), produceDataList.get(i).getGroupID(),
                    produceDataList.get(i).getStoreID());
            pl.save();
        }
    }


    public void openMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void openProduceList() {
        Intent intent2 = new Intent(this, ProduceListActivity.class);
        startActivity(intent2);
    }

    public void openRecent() {
        Intent intent3 = new Intent(this, RecentListActivity.class);
        startActivity(intent3);
    }

    public void openPreferences() {
        Intent intent4 = new Intent(this, PreferencesActivity.class);
        startActivity(intent4);
    }

    public void openSearchByZip() {
        Intent intent5 = new Intent(this, SearchByZipActivity.class);
        startActivity(intent5);
    }

    public static void deleteAllRecords() {
        SugarRecord.deleteAll(ProduceList.class);
    }

    public void SortData(int data) {
        InputStream is = getResources().openRawResource(data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                ProduceData pd = new ProduceData();
                pd.setName(tokens[0]);
                pd.setStock(Integer.parseInt(tokens[1]));
                pd.setPrice(Float.parseFloat(tokens[2]));
                pd.setItemID(Integer.parseInt(tokens[3]));
                pd.setGroupID(Integer.parseInt(tokens[4]));
                pd.setStoreID(Integer.parseInt(tokens[5]));

                produceDataList.add(pd);

                Log.d("MyActivity", "JustCreated: " + pd);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }
    }

    public void onMapSearch(View view) {
        MapActivity ma = new MapActivity();
        ma.onMapSearch(view);
    }


}


