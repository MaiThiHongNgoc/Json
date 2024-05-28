package student;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Write_GSON_Student {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("students.json")) {
            List<Student> students = ConnectionDB.students();
            gson.toJson(students, writer);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}

