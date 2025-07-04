package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String jdbcUrl = "jdbc:sqlserver://localhost:1436;databaseName=QuanLyBilliards;encrypt=true;trustServerCertificate=true";
    private static final String username = "sa";
    private static final String password = "123";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql); // Proc: thủ tục
        } else {
            stmt = conn.prepareStatement(sql); // SQL
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }
//    public JdbcHelper() {
//        conn = DatabaseConnection.getConnection();
//    }
//    private static Connection conn = DatabaseConnection.getConnection();
//    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
//        PreparedStatement stmt;
//        if (sql.trim().startsWith("{")) {
//            stmt = conn.prepareCall(sql); // Proc: thủ tục
//        } else {
//            stmt = conn.prepareStatement(sql); // SQL
//        }
//        for (int i = 0; i < args.length; i++) {
//            stmt.setObject(i + 1, args[i]);
//        }
//        return stmt;
//    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
