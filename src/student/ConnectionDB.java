package student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/EmployeeFPT1";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="";

    static  List<Student> students() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM Student";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String DOB = resultSet.getDate("DOB").toString();

                    Student student = new Student(ID, name, address, email, phone, DOB);
                    students.add(student);
                }
            }
            }
            return students;

    }

    public static boolean studentExists(int studentID) throws SQLException {
        boolean exists = false;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT 1 FROM Student WHERE ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, studentID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    exists = resultSet.next();
                }
            }
        }
        return exists;
    }

    public static void insertStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO Student (ID, name, address, email, phone, DOB) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, student.getID());
                statement.setString(2, student.getName());
                statement.setString(3, student.getAddress());
                statement.setString(4, student.getEmail());
                statement.setString(5, student.getPhone());
                statement.setString(6,student.getDOB());
                statement.executeUpdate();
            }
        }
    }
}
