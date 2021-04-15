package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mapScreen;
    private Button produceListScreen;
    private Button recentlyViewedScreen;
    private Button preferenceScreen;
    private Button searchByZipScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapScreen = (Button) findViewById(R.id.MapScreen);
        mapScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMap();
            }
        });
        produceListScreen = (Button) findViewById(R.id.ProduceListScreen);
        produceListScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openProduceList();
            }
        });
        recentlyViewedScreen = (Button) findViewById(R.id.RecentlyViewedScreen);
        recentlyViewedScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openRecent();
            }
        });
        preferenceScreen = (Button) findViewById(R.id.PreferencesScreen);
        preferenceScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPreferences();
            }
        });
        searchByZipScreen = (Button) findViewById(R.id.SearchByZipView);
        searchByZipScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openSearchByZip();
            }
        });
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

}
