package com.example.a402;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSVManager extends AppCompatActivity {

    private void CheckForNewFile(){

    }

    private List<ProduceData> produceDataList = new ArrayList<>();
    public void SortData()
    {
        InputStream is = getResources().openRawResource(R.raw.albertsons_data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {
        while ((line = reader.readLine()) != null)
        {
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
}
