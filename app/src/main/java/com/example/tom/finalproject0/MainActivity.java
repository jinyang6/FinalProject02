package com.example.tom.finalproject0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button Update;
    private Button showData;
    private TextView TEXTWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Update = findViewById(R.id.Update);
        showData = findViewById(R.id.showData);
        TEXTWindow = findViewById(R.id.TEXTWindow);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                update();
            }
        });

        showData.setOnClickListener(new View.OnClickListener()   {
            @Override
            public void onClick(View v) {
                showData();
            }
        })  ;

    }

    public void showData () {
        showData.setText("clicked");
        String output = "ERROR";
        try {
            output = DataRequest.getTitle("https://api.iextrading.com/1.0/stock/market/batch?symbols=aapl,fb&types=quote,news,chart&range=1m&last=5");
            System.out.println(output);
            TEXTWindow.setText(output);
        } catch (Exception e) {
            showData.setText("BUTTON");
            TEXTWindow.setText("ERROR");
        }
    }

    public void update() {
        Intent intent = new Intent(this, Update.class);
        startActivity(intent);
    }
}
