import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Read_JSON_Simple {
    public static void main(String[] args) throws IOException, JsonException {
        //tao dong Reader
        Reader reader = Files.newBufferedReader(Paths.get("employee.json"));
        // doc object tu dong(stream)
        JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
        //read employee detail
        BigDecimal id = (BigDecimal) parser.get("id");
        String name = (String) parser.get("name");
        String email = (String) parser.get("email");
        BigDecimal age = (BigDecimal) parser.get("age");
        System.out.println(id + " "+ name+" " +email+" "+age);

        //read address
        Map<Object, Object> address =(Map<Object, Object>) parser.get("address");
        address.forEach((key,value)-> System.out.println(key + " :" + value));

        //read projects
        JsonArray projects = (JsonArray) parser.get("projects");
        projects.forEach(entry->{
            JsonObject project = (JsonObject) entry;
            System.out.println(project.get("title"));
            System.out.println(project.get("budget"));
        });

        // dong lai stream sau khi dung xonng
        reader.close();

    }
}
