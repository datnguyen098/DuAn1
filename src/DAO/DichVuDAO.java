/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.DichVu;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import utils.KetNoiDB;

/**
 *
 * @author ADMIN
 */
public class DichVuDAO {

    public static List<DichVu> readDichVu(String TenLoaiDichVu) {
        List<DichVu> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.DichVu AS DV JOIN dbo.LoaiDichVu AS LDV ON LDV.ID = DV.IDLoaiDichVu WHERE LDV.TenLoaiDichVu = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, TenLoaiDichVu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu(
                        rs.getInt("ID"),
                        rs.getString("TenDichVu"),
                        rs.getDouble("Gia"),
                        rs.getInt("SoLuong"),
                        rs.getBoolean("TrangThai"),
                        rs.getInt("IDLoaiDichVu")
                );
                list.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int themDichVuTheoTenLoai(String tenDV, double gia, int soLuong, int trangThai, String tenLoaiDV) {
    String sql = "INSERT INTO DichVu (TenDichVu, Gia, SoLuong, TrangThai, IDLoaiDichVu) " +
                 "SELECT ?, ?, ?, ?, ID FROM LoaiDichVu WHERE TenLoaiDichVu = ?";

    try (Connection con = KetNoiDB.getConnectDB();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, tenDV);
        ps.setDouble(2, gia);
        ps.setInt(3, soLuong);
        ps.setInt(4, trangThai);
        ps.setString(5, tenLoaiDV);

        return ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}


    public static int UpDateGiamSoLuongDV(int SoLuong, int ID) {
        String sql = "UPDATE dbo.DichVu SET  SoLuong = SoLuong - ? WHERE ID = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, SoLuong);
            ps.setInt(2, ID);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            System.out.println(" có lỗi ở UpDateGiamSoLuongDV: " + e.getMessage());
            return 0;
        }

    }
public static int suaDichVuTheoIDVaLoai(int idDichVu, String tenLoaiDichVu, double giaMoi, int soLuongMoi, boolean trangThaiMoi) {
    String sql = "UPDATE DichVu " +
                 "SET Gia = ?, SoLuong = ?, TrangThai = ? " +
                 "WHERE ID = ? AND IDLoaiDichVu = (SELECT ID FROM LoaiDichVu WHERE TenLoaiDichVu = ?)";
    try (Connection con = KetNoiDB.getConnectDB();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setDouble(1, giaMoi);
        ps.setInt(2, soLuongMoi);
        ps.setBoolean(3, trangThaiMoi);
        ps.setInt(4, idDichVu);
        ps.setString(5, tenLoaiDichVu);

        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}


    public static int DeleteDichVu(String TenDichVu) {
        String sql = "DELETE FROM DichVu WHERE TenDichVu = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, TenDichVu);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<DichVu> SearchDichVu(String keyword) {
        List<DichVu> list = new ArrayList<>();
        String sql = "SELECT * FROM DichVu WHERE TenDichVu LIKE ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dv = new DichVu(
                        rs.getInt("ID"),
                        rs.getString("TenDichVu"),
                        rs.getDouble("Gia"),
                        rs.getInt("SoLuong"),
                        rs.getBoolean("TrangThai"),
                        rs.getInt("IDLoaiDichVu")
                );
                list.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int capNhatTrangThaiDichVu(String tenDichVu) {
        String sql = "UPDATE DichVu SET TrangThai = 0 WHERE SoLuong = 0 AND TenDichVu = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tenDichVu);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
public static int getIDByTenDichVu(String tenDichVu) {
    String sql = "SELECT ID FROM DichVu WHERE TenDichVu = ?";
    try (Connection con = KetNoiDB.getConnectDB();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, tenDichVu);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("ID");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
     return 0;
}


}
