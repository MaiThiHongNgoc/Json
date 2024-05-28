package weather.weather;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

public class WriteWeatherJSON {
    public static void main(String[] args) {
        // Tạo đối tượng JsonObject chứa thông tin thời tiết
        JsonObject weatherJson = new JsonObject();

        // Thêm thông tin về tọa độ (coord)
        JsonObject coord = new JsonObject();
        coord.put("lon", 105.8412);
        coord.put("lat", 21.0245);
        weatherJson.put("coord", coord);

        // Thêm thông tin về thời tiết (weather)
        JsonArray weatherArray = new JsonArray();
        JsonObject weather = new JsonObject();
        weather.put("id", 804);
        weather.put("main", "Clouds");
        weather.put("description", "overcast clouds");
        weather.put("icon", "04n");
        weatherArray.add(weather);
        weatherJson.put("weather", weatherArray);

        // Thêm thông tin về cơ sở (base)
        weatherJson.put("base", "stations");

        // Thêm thông tin về nhiệt độ và độ ẩm (main)
        JsonObject main = new JsonObject();
        main.put("temp", 301.15);
        main.put("feels_like", 305.72);
        main.put("temp_min", 301.15);
        main.put("temp_max", 301.15);
        main.put("pressure", 1009);
        main.put("humidity", 83);
        main.put("sea_level", 1009);
        main.put("grnd_level", 1007);
        weatherJson.put("main", main);

        // Thêm thông tin về tầm nhìn (visibility)
        weatherJson.put("visibility", 10000);

        // Thêm thông tin về gió (wind)
        JsonObject wind = new JsonObject();
        wind.put("speed", 2.65);
        wind.put("deg", 150);
        wind.put("gust", 4.66);
        weatherJson.put("wind", wind);

        // Thêm thông tin về mây (clouds)
        JsonObject clouds = new JsonObject();
        clouds.put("all", 98);
        weatherJson.put("clouds", clouds);

        // Thêm thông tin về thời gian (dt)
        weatherJson.put("dt", 1716390042);

        // Thêm thông tin về hệ thống (sys)
        JsonObject sys = new JsonObject();
        sys.put("type", 1);
        sys.put("id", 9308);
        sys.put("country", "VN");
        sys.put("sunrise", 1716329803);
        sys.put("sunset", 1716377412);
        weatherJson.put("sys", sys);

        // Thêm thông tin về múi giờ (timezone)
        weatherJson.put("timezone", 25200);

        // Thêm thông tin về ID và tên địa điểm (id, name)
        weatherJson.put("id", 1581130);
        weatherJson.put("name", "Hanoi");

        // Thêm mã trạng thái (cod)
        weatherJson.put("cod", 200);

        // Ghi dữ liệu JSON vào tệp
        try (FileWriter file = new FileWriter("weather.json")) {
            Jsoner.serialize(weatherJson, file);
            System.out.println("Successfully wrote JSON object to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
