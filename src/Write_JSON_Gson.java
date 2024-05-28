import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Write_JSON_Gson {
    public static void main(String[] args) throws IOException {
        //tao dong ghi(Stream Write)
        BufferedWriter writer= Files.newBufferedWriter(Paths.get("employee.json"));

        //tao doi tuong employee thong map
        Map<String, Object> employee = new HashMap<>();
        employee.put("id",1);
        employee.put("name", "hongngoc");
        employee.put("email","hn@gmail.com");
        employee.put("age", 18);
        //Tao doi tuong address
        Map<String, Object> address= new HashMap<>();
        address.put("street", "ton that thuyet");
        address.put("city", "ha noi");
        address.put("zipcode", 1000);

        //gan address cho employee
        employee.put("address",address);
        //tao cac project
        Map<String,Object> pro1=new HashMap<>();
        pro1.put("title","java and json");
        pro1.put("budget",2000);

        Map<String,Object> pro2=new HashMap<>();
        pro2.put("title","employee management");
        pro2.put("budget",5000);

        Map<String,Object> pro3=new HashMap<>();
        pro3.put("title","fpt");
        pro3.put("budget",6000);

        //gan projcect cho employee
        employee.put("projects", Arrays.asList(pro1,pro2,pro3));

        //tao doi tuong gson
     //   Gson gson=new Gson();
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        //Ghi json vao file(ghi noi dung vao stream write)
        writer.write(gson.toJson(employee));

        //giai phong tai nguyen
        writer.close();

    }
}
