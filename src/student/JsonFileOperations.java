package student;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JsonFileOperations {
    private static final String FILE_PATH = "students.json";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        List<Student> students = readDataFromJson();

        saveDataToDatabase(students);
    }

    private static List<Student> readDataFromJson() {
        List<Student> students = null;
        try (FileReader reader = new FileReader(FILE_PATH)) {
            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private static void saveDataToDatabase(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("No student data to save.");
            return;
        }

        for (Student student : students) {
            try {
                if (!ConnectionDB.studentExists(student.getID())) {
                    ConnectionDB.insertStudent(student);
                    System.out.println("Student with ID " + student.getID() + " inserted into the database.");
                } else {
                    System.out.println("Student with ID " + student.getID() + " already exists in the database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
