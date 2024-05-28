package student;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewStudent {
    private static final String FILE_PATH ="students.json";
    private static Gson gson = new Gson();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        try(FileReader reader = new FileReader(FILE_PATH)) {
            students = gson.fromJson(reader,new TypeToken<List<Student>>() {}.getType());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add new Student");
            System.out.println("2. Display all data");
            System.out.println("3. Search by name");
            System.out.println("4. Search by email");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    displayAllData();
                    break;
                case 3:
                    searchByName(scanner);
                    break;
                case 4:
                    searchByEmail(scanner);
                    break;
                case 5:
                    saveDataToJson();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private static void addNewStudent(Scanner scanner){
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter address:");
        String address = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter DOB (YYYY-MM-DD):");
        String DOB = scanner.nextLine();

        Student student = new Student(ID, name, address, email, phone, DOB);
        students.add(student);
        saveDataToJson();

    }
    private static void displayAllData(){
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchByName(Scanner scanner){
        System.out.println("Enter name to search:");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
            }
        }
    }

    private static void searchByEmail(Scanner scanner){
        System.out.println("Enter email to search:");
        String email = scanner.nextLine();
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                System.out.println(student);
            }
        }
    }

    private static void saveDataToJson(){
        try(FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(students,writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

