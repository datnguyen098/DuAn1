package dao;

import entity.LoaiDichVu;
import java.util.*;
import java.sql.*;

public class LoaiDichVuDAO {

    private Connection conn;

    public LoaiDichVuDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<LoaiDichVu> getAllLoaiDichVu() {
        List<LoaiDichVu> listLDV = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM LoaiDichVu");
            while (rs.next()) {
                int idLDV = rs.getInt("ID");
                String tenLDV = rs.getString("TenLoaiDichVu");

                LoaiDichVu ldv = new LoaiDichVu(idLDV, tenLDV);
                listLDV.add(ldv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listLDV;
    }
    
    public void add(String tenLDV) {
        try {
            String SQL = "INSERT INTO LoaiDichVu VALUES (?)";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, tenLDV);

            ps.execute();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void update(String tenLDV, int ID) {
        try {
            String SQL = "UPDATE LoaiDichVu SET TenLoaiDichVu = ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, tenLDV);
            ps.setInt(2, ID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ID) {
        try {
            String url = "DELETE FROM LoaiDichVu WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
