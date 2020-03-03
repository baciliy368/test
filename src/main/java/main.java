import com.jayway.restassured.RestAssured;
import models.CsgotmPricesResponse;
import models.Item;

import java.net.MalformedURLException;
import java.net.URL;

public class main {
    static int i = 0;
    public static void main(String[] args) throws MalformedURLException {
        final CsgotmPricesResponse as = RestAssured.get(new URL("https://market.csgo.com/api/v2/prices/USD.json")).as(CsgotmPricesResponse.class);
        System.out.println("ready");
        final Timer timer = new Timer();
        timer.start();
        for (Item item : as.items) {
            if(item.price <= 5.0) {
            try {

                    String steam = item.getSteamInfoAboutItem().lowest_price;
                    if(Double.parseDouble(steam.replace("$", "")) >= item.price) {
                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.println(item.market_hash_name);
                        System.out.println("PRICE ON TM: " + item.price);
                        System.out.println("PRICE ON STEAM: " + steam);
                    }
                } catch (Exception ignore){}
                System.out.println("---------------------------------------------------------------------------------------");
            }
        }
        timer.stop();
        System.out.println(timer.i);
    }

}


