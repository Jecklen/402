package com.example.a402;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ProduceListActivity extends ListActivity {
    private Button home;
    ListView listView;

    List<ProduceList> produceList = ProduceList.listAll(ProduceList.class);
    int i = 0;

    private String prodNames[] = {
            "Apple",
            "Carrot",
            "Coconut",
            "Tomato",
            "Apple",
            "Carrot",
            "Coconut",
            "Tomato",
            "Apple",
            "Carrot",
            "Coconut",
            "Tomato"
    };


    private String prodQuant[] = {
            "High",
            "Low",
            "Low",
            "Medium",
            "High",
            "Low",
            "Low",
            "Medium",
            "High",
            "Low",
            "Low",
            "Medium"
    };

    private Integer imageid[] = {
            R.drawable.apple,
            R.drawable.carrot,
            R.drawable.coconut,
            R.drawable.tomato,
            R.drawable.apple,
            R.drawable.carrot,
            R.drawable.coconut,
            R.drawable.tomato,
            R.drawable.apple,
            R.drawable.carrot,
            R.drawable.coconut,
            R.drawable.tomato
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] prodNames = new String[produceList.size()];

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

        CustomAdapter customAdapter = new CustomAdapter(this, prodNames, prodQuant, imageid);
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


}