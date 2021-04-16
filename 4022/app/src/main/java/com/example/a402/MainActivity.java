package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mapScreen;
    private Button produceListScreen;
    private Button recentlyViewedScreen;
    private Button preferenceScreen;
    private Button searchByZipScreen;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProduceList pl = new ProduceList("kiwi", 5, 5, 111,03, 02);
        pl.save();


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
