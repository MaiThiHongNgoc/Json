import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Write_JSON_Simple {
    public static void main(String[] args) throws IOException {
        //tao ra dong ghi du lieu (Write)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json"));
        //tao doi tuong la employee
        JsonObject employee = new JsonObject();
        employee.put("id",1);
        employee.put("name","Hong Ngoc");
        employee.put("email","ngoc@gmail.com");
        employee.put("age",18);
        //employee.put("address","So 8 ton that thuyet");

        //tao doi tuong Address
        JsonObject address= new JsonObject();
        address.put("street","So 8 Ton That Thuyet");
        address.put("city","ha noi");
        address.put("zipcode",10000);
        //them address vao doi tuong employee
        employee.put("address",address);

        //tao doi tuowng project
        JsonArray projects =new JsonArray();//1-N (employee-projects)
        //tao doi tuong du an 1
        JsonObject pro1 =  new JsonObject();
        pro1.put("title","Employee management");
        pro1.put("budget",5000);

        JsonObject pro2 = new JsonObject();
        pro2.put("title","push sale");
        pro2.put("budget",10000);

        JsonObject pro3 = new JsonObject();
        pro3.put("title","Shop ecommerce");
        pro3.put("budget",15000);

        //add project1,2 to projects
        projects.addAll(Arrays.asList(pro1,pro2,pro3));

        //add projects to employee
        employee.put("projects",projects);

        //ghi file JSON
        Jsoner.serialize(employee,writer);//ghi ra file json thong tin cua employee

        //sau khi ghi xong thi close dong write
        writer.close();


    }
}
