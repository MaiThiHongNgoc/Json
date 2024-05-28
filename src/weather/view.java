package weather;


import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileReader;
import java.io.IOException;


public class view {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("weather.json")) {
            JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);

            WeatherData weatherData = new WeatherData();

            // Coord
            JsonObject coordJson = (JsonObject) jsonObject.get("coord");
            Coord coord = new Coord();
            coord.setLon(((Number) coordJson.get("lon")).doubleValue());
            coord.setLat(((Number) coordJson.get("lat")).doubleValue());
            weatherData.setCoord(coord);

            // Weather
            JsonArray weatherArray = (JsonArray) jsonObject.get("weather");
            for (Object obj : weatherArray) {
                JsonObject weatherJson = (JsonObject) obj;
                Weather weather = new Weather();
                weather.setId(((Number) weatherJson.get("id")).intValue());
                weather.setMain((String) weatherJson.get("main"));
                weather.setDescription((String) weatherJson.get("description"));
                weather.setIcon((String) weatherJson.get("icon"));
                weatherData.getWeather().add(weather);
            }

            // Base
            weatherData.setBase((String) jsonObject.get("base"));

            // Main
            JsonObject mainJson = (JsonObject) jsonObject.get("main");
            Main main = new Main();
            main.setTemp(((Number) mainJson.get("temp")).doubleValue());
            main.setFeels_like(((Number) mainJson.get("feels_like")).doubleValue());
            main.setTemp_min(((Number) mainJson.get("temp_min")).doubleValue());
            main.setTemp_max(((Number) mainJson.get("temp_max")).doubleValue());
            main.setPressure(((Number) mainJson.get("pressure")).intValue());
            main.setHumidity(((Number) mainJson.get("humidity")).intValue());
            main.setSea_level(((Number) mainJson.get("sea_level")).intValue());
            main.setGrnd_level(((Number) mainJson.get("grnd_level")).intValue());
            weatherData.setMain(main);

            // Visibility
            weatherData.setVisibility(((Number) jsonObject.get("visibility")).intValue());

            // Wind
            JsonObject windJson = (JsonObject) jsonObject.get("wind");
            Wind wind = new Wind();
            wind.setSpeed(((Number) windJson.get("speed")).doubleValue());
            wind.setDeg(((Number) windJson.get("deg")).intValue());
            wind.setGust(((Number) windJson.get("gust")).doubleValue());
            weatherData.setWind(wind);

            // Clouds
            JsonObject cloudsJson = (JsonObject) jsonObject.get("clouds");
            Clouds clouds = new Clouds();
            clouds.setAll(((Number) cloudsJson.get("all")).intValue());
            weatherData.setClouds(clouds);

            // Dt
            weatherData.setDt(((Number) jsonObject.get("dt")).longValue());

            // Sys
            JsonObject sysJson = (JsonObject) jsonObject.get("sys");
            Sys sys = new Sys();
            sys.setType(((Number) sysJson.get("type")).intValue());
            sys.setId(((Number) sysJson.get("id")).intValue());
            sys.setCountry((String) sysJson.get("country"));
            sys.setSunrise(((Number) sysJson.get("sunrise")).longValue());
            sys.setSunset(((Number) sysJson.get("sunset")).longValue());
            weatherData.setSys(sys);

            // Timezone, Id, Name, Cod
            weatherData.setTimezone(((Number) jsonObject.get("timezone")).intValue());
            weatherData.setId(((Number) jsonObject.get("id")).intValue());
            weatherData.setName((String) jsonObject.get("name"));
            weatherData.setCod(((Number) jsonObject.get("cod")).intValue());

            // Hiển thị dữ liệu từ đối tượng WeatherData
            System.out.println("Coord:");
            System.out.println("  Lon: " + weatherData.getCoord().getLon());
            System.out.println("  Lat: " + weatherData.getCoord().getLat());

            System.out.println("Weather:");
            for (Weather weather : weatherData.getWeather()) {
                System.out.println("  Id: " + weather.getId());
                System.out.println("  Main: " + weather.getMain());
                System.out.println("  Description: " + weather.getDescription());
                System.out.println("  Icon: " + weather.getIcon());
            }

            System.out.println("Base: " + weatherData.getBase());

            System.out.println("Main:");
            System.out.println("  Temp: " + weatherData.getMain().getTemp());
            System.out.println("  Feels like: " + weatherData.getMain().getFeels_like());
            System.out.println("  Temp min: " + weatherData.getMain().getTemp_min());
            System.out.println("  Temp max: " + weatherData.getMain().getTemp_max());
            System.out.println("  Pressure: " + weatherData.getMain().getPressure());
            System.out.println("  Humidity: " + weatherData.getMain().getHumidity());
            System.out.println("  Sea level: " + weatherData.getMain().getSea_level());
            System.out.println("  Grnd level: " + weatherData.getMain().getGrnd_level());

            System.out.println("Visibility: " + weatherData.getVisibility());

            System.out.println("Wind:");
            System.out.println("  Speed: " + weatherData.getWind().getSpeed());
            System.out.println("  Deg: " + weatherData.getWind().getDeg());
            System.out.println("  Gust: " + weatherData.getWind().getGust());

            System.out.println("Clouds:");
            System.out.println("  All: " + weatherData.getClouds().getAll());

            System.out.println("Dt: " + weatherData.getDt());

            System.out.println("Sys:");
            System.out.println("  Type: " + weatherData.getSys().getType());
            System.out.println("  Id: " + weatherData.getSys().getId());
            System.out.println("  Country: " + weatherData.getSys().getCountry());
            System.out.println("  Sunrise: " + weatherData.getSys().getSunrise());
            System.out.println("  Sunset: " + weatherData.getSys().getSunset());

            System.out.println("Timezone: " + weatherData.getTimezone());
            System.out.println("Id: " + weatherData.getId());
            System.out.println("Name: " + weatherData.getName());
            System.out.println("Cod: " + weatherData.getCod());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JsonException e) {
            throw new RuntimeException(e);
        }
    }
}
