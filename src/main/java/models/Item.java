package models;

import com.jayway.restassured.RestAssured;

import java.net.MalformedURLException;
import java.net.URL;

public class Item {
    public String market_hash_name;
    public String volume;
    public Double price;

    public SteamInfoAboutItem getSteamInfoAboutItem() {
        String url = "https://steamcommunity.com/market/priceoverview/?appid=730&market_hash_name=" + market_hash_name;
        try {
            return RestAssured.get(new URL(url)).as(SteamInfoAboutItem.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new SteamInfoAboutItem();
        }
    }
}
