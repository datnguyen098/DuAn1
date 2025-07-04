package dao;

import entity.DichVu;
import java.sql.*;
import java.util.*;

public class DichVuDAO {

    Connection conn;

    public DichVuDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<DichVu> getAllDichVu(int idLDV) {
        List<DichVu> listDV = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM DichVu WHERE IDLoaiDichVu = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, idLDV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDV = rs.getInt("ID");
                String tenDV = rs.getString("TenDichVu");
                double giaDV = rs.getDouble("Gia");
                int soLuong = rs.getInt("SoLuong");
                boolean trangThai = rs.getBoolean("TrangThai");
                int idLoaiDV = rs.getInt("IDLoaiDichVu");
                DichVu dv = new DichVu(idDV, tenDV, giaDV, soLuong, trangThai, idLoaiDV);
                listDV.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDV;
    }

    public DichVu selectByID(int id) {
        try {
            String SQL = "SELECT * FROM DichVu WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDV = rs.getInt("ID");
                String tenDV = rs.getString("TenDichVu");
                double giaDV = rs.getDouble("Gia");
                int soLuong = rs.getInt("SoLuong");
                boolean trangThai = rs.getBoolean("TrangThai");
                int idLoaiDV = rs.getInt("IDLoaiDichVu");
                DichVu dv = new DichVu(idDV, tenDV, giaDV, soLuong, trangThai, idLoaiDV);
                return dv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(DichVu dv) {
        try {
            String SQL = "INSERT INTO DichVu VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, dv.getTenDV());
            ps.setDouble(2, dv.getGiaDV());
            ps.setInt(3, dv.getSoLuong());
            ps.setBoolean(4, dv.isTrangThai());
            ps.setInt(5, dv.getIdLoaiDV());

            ps.execute();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void update(DichVu dv, int ID) {
        try {
            String SQL = "UPDATE DichVu SET TenDichVu = ?, Gia = ?, SoLuong = ?, TrangThai = ? WHERE ID = ? ";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, dv.getTenDV());
            ps.setDouble(2, dv.getGiaDV());
            ps.setInt(3, dv.getSoLuong());
            ps.setBoolean(4, dv.isTrangThai());
            ps.setInt(5, ID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGiam(int soLuong, int ID) {
        try {
            String SQL = "UPDATE DichVu SET SoLuong = SoLuong - ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, soLuong);
            ps.setInt(2, ID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTang(int soLuong, int ID) {
        try {
            String SQL = "UPDATE DichVu SET SoLuong = SoLuong + ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, soLuong);
            ps.setInt(2, ID);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ID) {
        try {
            String url = "DELETE FROM DICHVU WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
