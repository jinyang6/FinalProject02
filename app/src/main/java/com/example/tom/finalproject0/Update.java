package com.example.tom.finalproject0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        TextView UpdateText = findViewById(R.id.UpdateText);
        String output = "ERROR";
        try {
            JsonObject info = DataRequest.readJsonFromUrl("https://api.iextrading.com/1.0/stock/market/batch?symbols=aapl,fb&types=quote,news,chart&range=1m&last=5");
            JsonObject AAPL = info.get("AAPL").getAsJsonObject();
            JsonArray allNews = AAPL.get("news").getAsJsonArray();
            JsonObject oneNews = (JsonObject) allNews.get(0);
            String title = oneNews.get("summary").getAsString();
            output = title;
        } catch (Exception e) {
        }
        UpdateText.setText(output);
    }
}
