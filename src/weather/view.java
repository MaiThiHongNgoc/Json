package weather;


import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class view {
    public static void main(String[] args) {
        String jsonString = "{ \"coord\": { \"lon\": 105.8412, \"lat\": 21.0245 }, \"weather\": [ { \"id\": 804, \"main\": \"Clouds\", \"description\": \"overcast clouds\", \"icon\": \"04n\" } ], \"base\": \"stations\", \"main\": { \"temp\": 301.15, \"feels_like\": 305.72, \"temp_min\": 301.15, \"temp_max\": 301.15, \"pressure\": 1009, \"humidity\": 83, \"sea_level\": 1009, \"grnd_level\": 1007 }, \"visibility\": 10000, \"wind\": { \"speed\": 2.65, \"deg\": 150, \"gust\": 4.66 }, \"clouds\": { \"all\": 98 }, \"dt\": 1716390042, \"sys\": { \"type\": 1, \"id\": 9308, \"country\": \"VN\", \"sunrise\": 1716329803, \"sunset\": 1716377412 }, \"timezone\": 25200, \"id\": 1581130, \"name\": \"Hanoi\", \"cod\": 200 }";

        try {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString, new JsonObject());

            System.out.println("Coord:");
            JsonObject coord = (JsonObject) jsonObject.get("coord");
            System.out.println("  Lon: " + coord.get("lon"));
            System.out.println("  Lat: " + coord.get("lat"));

            System.out.println("Weather:");
            JsonArray weatherArray = (JsonArray) jsonObject.get("weather");
            for (Object obj : weatherArray) {
                JsonObject weather = (JsonObject) obj;
                System.out.println("  Id: " + weather.get("id"));
                System.out.println("  Main: " + weather.get("main"));
                System.out.println("  Description: " + weather.get("description"));
                System.out.println("  Icon: " + weather.get("icon"));
            }

            System.out.println("Base: " + jsonObject.get("base"));

            System.out.println("Main:");
            JsonObject main = (JsonObject) jsonObject.get("main");
            System.out.println("  Temp: " + main.get("temp"));
            System.out.println("  Feels like: " + main.get("feels_like"));
            System.out.println("  Temp min: " + main.get("temp_min"));
            System.out.println("  Temp max: " + main.get("temp_max"));
            System.out.println("  Pressure: " + main.get("pressure"));
            System.out.println("  Humidity: " + main.get("humidity"));
            System.out.println("  Sea level: " + main.get("sea_level"));
            System.out.println("  Grnd level: " + main.get("grnd_level"));

            System.out.println("Visibility: " + jsonObject.get("visibility"));

            System.out.println("Wind:");
            JsonObject wind = (JsonObject) jsonObject.get("wind");
            System.out.println("  Speed: " + wind.get("speed"));
            System.out.println("  Deg: " + wind.get("deg"));
            System.out.println("  Gust: " + wind.get("gust"));

            System.out.println("Clouds:");
            JsonObject clouds = (JsonObject) jsonObject.get("clouds");
            System.out.println("  All: " + clouds.get("all"));

            System.out.println("Dt: " + jsonObject.get("dt"));

            System.out.println("Sys:");
            JsonObject sys = (JsonObject) jsonObject.get("sys");
            System.out.println("  Type: " + sys.get("type"));
            System.out.println("  Id: " + sys.get("id"));
            System.out.println("  Country: " + sys.get("country"));
            System.out.println("  Sunrise: " + sys.get("sunrise"));
            System.out.println("  Sunset: " + sys.get("sunset"));

            System.out.println("Timezone: " + jsonObject.get("timezone"));
            System.out.println("Id: " + jsonObject.get("id"));
            System.out.println("Name: " + jsonObject.get("name"));
            System.out.println("Cod: " + jsonObject.get("cod"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
