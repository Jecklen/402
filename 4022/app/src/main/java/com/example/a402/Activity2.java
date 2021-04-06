package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.MapView;

public class Activity2 extends AppCompatActivity {
    private Button home;
    private ImageView gmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

        gmap = (ImageView) findViewById(R.id.gmap);
        gmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    openActivity3();
            }
        });
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }

}