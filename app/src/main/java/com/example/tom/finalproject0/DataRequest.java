package com.example.tom.finalproject0;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;

public class DataRequest {


    public static String getTitle(String url) {
        String output = "ERROR";
        JsonObject info = DataRequest.readJsonFromUrl(url);
        JsonObject AAPL = (JsonObject) info.get("AAPL");
        JsonArray allNews = (JsonArray) AAPL.get("news");
        JsonObject oneNews = (JsonObject) allNews.get(0);
        String title = oneNews.get("headline").getAsString();
        output = title;
        return output;
    }


    private static String readAll(Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        int element;
        try {
            while ((element = reader.read()) != -1) {
            stringBuilder.append((char) element);
            }
        } finally {
            return stringBuilder.toString();
        }
    }

    public static com.google.gson.JsonObject readJsonFromUrl(String url) {
        try {
            InputStream stream = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
            String jsonText = readAll(reader);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonText).getAsJsonObject();
            stream.close();
            return jsonObject;
        } catch (Exception e){
        }
        return null;
    }
}
