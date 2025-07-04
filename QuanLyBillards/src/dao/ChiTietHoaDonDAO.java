package dao;

import entity.ChiTietHoaDon;
import java.sql.*;
import java.util.*;
import utils.MsgBox;

public class ChiTietHoaDonDAO {

    Connection conn;

    public ChiTietHoaDonDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<ChiTietHoaDon> getAllCTHDByID(int ID) {
        List<ChiTietHoaDon> listCTHD = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM HoaDonChiTiet WHERE IDHoaDon = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenDV = rs.getString("Ten");
                double gia = rs.getDouble("Gia");
                int soLuong = rs.getInt("SoLuong");
                int IDDichVu = rs.getInt("IDDichVu");
                int IDHoaDon = rs.getInt("IDHoaDon");

                ChiTietHoaDon cthd = new ChiTietHoaDon(id, tenDV, gia, soLuong, IDDichVu, IDHoaDon);
                listCTHD.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCTHD;
    }

    public List<ChiTietHoaDon> getCTHDByDichVu(int ID, int DichVu) {
        List<ChiTietHoaDon> listCTHD = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM HoaDonChiTiet WHERE IDHoaDon = ? AND IDDichVu = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID);
            ps.setInt(2, DichVu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenDV = rs.getString("Ten");
                double gia = rs.getDouble("Gia");
                int soLuong = rs.getInt("SoLuong");
                int IDDichVu = rs.getInt("IDDichVu");
                int IDHoaDon = rs.getInt("IDHoaDon");

                ChiTietHoaDon cthd = new ChiTietHoaDon(id, tenDV, gia, soLuong, IDDichVu, IDHoaDon);
                listCTHD.add(cthd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCTHD;
    }

    public void add(ChiTietHoaDon cthd) {
        try {
            String SQL = "INSERT INTO HoaDonChiTiet VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, cthd.getTenDV());
            ps.setDouble(2, cthd.getGia());
            ps.setInt(3, cthd.getSoLuong());
            ps.setDouble(4, cthd.thanhTien());
            ps.setInt(5, cthd.getIDDichVu());
            ps.setInt(6, cthd.getIDHoaDon());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTang(int SL, int IDDV, int IDHD) {
        try {
            String SQL = "UPDATE HoaDonChiTiet SET SoLuong = SoLuong + ? WHERE IDDichVu = ? AND IDHoaDon = ?"
                    + "UPDATE HoaDonChiTiet SET ThanhTien = Gia*SoLuong WHERE IDDichVu = ? AND IDHoaDon = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, SL);
            ps.setInt(2, IDDV);
            ps.setInt(3, IDHD);
            ps.setInt(4, IDDV);
            ps.setInt(5, IDHD);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGiam(int SL, int IDDV, int IDHD) {
        try {
            String SQL = "UPDATE HoaDonChiTiet SET SoLuong = SoLuong - ? WHERE IDDichVu = ? AND IDHoaDon = ?"
                    + "UPDATE HoaDonChiTiet SET ThanhTien = Gia*SoLuong WHERE IDDichVu = ? AND IDHoaDon = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, SL);
            ps.setInt(2, IDDV);
            ps.setInt(3, IDHD);
            ps.setInt(4, IDDV);
            ps.setInt(5, IDHD);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int IDHoaDon, String tenDV) {
        try {
            String SQL = "DELETE FROM HoaDonChiTiet WHERE ID = (SELECT A.ID FROM HoaDonChiTiet A "
                    + "INNER JOIN HoaDon B ON A.IDHoaDon = B.ID "
                    + "WHERE A.IDHoaDon = ? AND Ten = ?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, IDHoaDon);
            ps.setString(2, tenDV);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
