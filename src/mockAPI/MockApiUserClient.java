package mockAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MockApiUserClient {
    private static final String BASE_URL = "https://656ae3e0dac3630cf72765d3.mockapi.io/product";
    private static final HttpClient client = HttpClient.newHttpClient();

    // Tạo người dùng
    public static String createUser(String firstName, String lastName, String email) throws Exception {
        String jsonInputString = String.format("{\"firstName\": \"%s\", \"lastName\": \"%s\", \"email\": \"%s\"}", firstName, lastName, email);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Lấy danh sách người dùng
    public static String getUsers() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Cập nhật người dùng
    public static String updateUser(int id, String firstName, String lastName, String email) throws Exception {
        String jsonInputString = String.format("{\"firstName\": \"%s\", \"lastName\": \"%s\", \"email\": \"%s\"}", firstName, lastName, email);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Xóa người dùng
    public static String deleteUser(int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn một tùy chọn:");
            System.out.println("1. Tạo người dùng mới");
            System.out.println("2. Lấy danh sách người dùng");
            System.out.println("3. Cập nhật người dùng");
            System.out.println("4. Xóa người dùng");
            System.out.println("5. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng mới còn lại

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Nhập tên:");
                        String firstName = scanner.nextLine();
                        System.out.println("Nhập họ:");
                        String lastName = scanner.nextLine();
                        System.out.println("Nhập email:");
                        String email = scanner.nextLine();
                        String newUser = createUser(firstName, lastName, email);
                        System.out.println("Người dùng mới được tạo: " + newUser);
                        break;
                    case 2:
                        String users = getUsers();
                        System.out.println("Danh sách người dùng: " + users);
                        break;
                    case 3:
                        System.out.println("Nhập ID người dùng cần cập nhật:");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  // Đọc bỏ dòng mới còn lại
                        System.out.println("Nhập tên mới:");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Nhập họ mới:");
                        String newLastName = scanner.nextLine();
                        System.out.println("Nhập email mới:");
                        String newEmail = scanner.nextLine();
                        String updatedUser = updateUser(updateId, newFirstName, newLastName, newEmail);
                        System.out.println("Người dùng được cập nhật: " + updatedUser);
                        break;
                    case 4:
                        System.out.println("Nhập ID người dùng cần xóa:");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();  // Đọc bỏ dòng mới còn lại
                        String deletedUser = deleteUser(deleteId);
                        System.out.println("Người dùng đã được xóa: " + deletedUser);
                        break;
                    case 5:
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
