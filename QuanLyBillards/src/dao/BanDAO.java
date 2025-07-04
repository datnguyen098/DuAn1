package dao;

import entity.Ban;
import java.sql.*;
import java.util.*;

public class BanDAO {

    Connection conn;

    public BanDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<Ban> getAllBan() {
        List<Ban> listB = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Ban");
            while (rs.next()) {
                int id = rs.getInt("ID");
                double gia = rs.getDouble("Gia");
                boolean trangThai = rs.getBoolean("TrangThai");

                Ban b = new Ban(id, gia, trangThai);
                listB.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listB;
    }

    public void add(double gia) {
        try {
            String SQL = "INSERT INTO Ban VALUES (?,?)";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setDouble(1, gia);
            ps.setBoolean(2, true);

            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGia(double gia, int ID) {
        try {
            String SQL = "UPDATE Ban SET Gia = ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setDouble(1, gia);
            ps.setInt(2, ID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ID) {
        try {
            String url = "DELETE FROM BAN WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Ban b, int ID) {
        try {
            String SQL = "UPDATE Ban SET TrangThai = ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setBoolean(1, b.isTrangThai());
            ps.setInt(2, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTT(int ID) {
        try {
            String SQL = "UPDATE Ban SET TrangThai = 1 WHERE ID = (SELECT IDBan FROM HoaDon A "
                    + "INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.ID = ?)";
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setInt(1, ID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
