import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApplicationData {
    public static void main(String[] args) throws IOException, SQLException {
        List<User> users= ConnectionDB.getUsers();
        String filePath = "users.json";
        JsonWriterData.writeUserToJson(users,filePath);
        System.out.println(users);
        System.out.println("Data has been write to "+filePath);
    }
}
