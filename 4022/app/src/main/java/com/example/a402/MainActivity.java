package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
    private Button screen2;
    private Button screen3;
    private Button screen4;
    private Button screen5;
    private Button screen6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen2 = (Button) findViewById(R.id.screen2);
        screen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });
        screen3 = (Button) findViewById(R.id.screen3);
        screen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity3();
            }
        });
        screen4 = (Button) findViewById(R.id.screen4);
        screen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity4();
            }
        });
        screen5 = (Button) findViewById(R.id.screen5);
        screen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity5();
            }
        });
        screen6 = (Button) findViewById(R.id.screen6);
        screen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity6();
            }
        });
    }


    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }
    public void openActivity4() {
        Intent intent3 = new Intent(this, Activity4.class);
        startActivity(intent3);
    }
    public void openActivity5() {
        Intent intent4 = new Intent(this, Activity5.class);
        startActivity(intent4);
    }
    public void openActivity6() {
        Intent intent5 = new Intent(this, Activity6.class);
        startActivity(intent5);
    }

}
