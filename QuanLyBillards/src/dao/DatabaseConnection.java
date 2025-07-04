package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;
    private static final String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBilliards;encrypt=true;trustServerCertificate=true";
    private static final String username = "sa";
    private static final String password = "1234"; // phụ thuộc vào tài khoản đăng nhập azuze
//    private static final String password = "123";
    // Phương thức tạo kết nối

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
