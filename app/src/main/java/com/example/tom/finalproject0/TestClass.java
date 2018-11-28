package com.example.tom.finalproject0;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;

public class TestClass {
    public static void main(String[] unused) throws IOException {
        String output = "ERROR";
        JsonObject info = DataRequest.readJsonFromUrl("https://api.iextrading.com/1.0/stock/market/batch?symbols=aapl,fb&types=quote,news,chart&range=1m&last=5");
        JsonObject AAPL = (JsonObject) info.get("AAPL");
        JsonArray allNews = (JsonArray) AAPL.get("news");
        JsonObject oneNews = (JsonObject) allNews.get(0);
        String title = oneNews.get("headline").getAsString();
        output = title;
        System.out.println(output);
    }
}
