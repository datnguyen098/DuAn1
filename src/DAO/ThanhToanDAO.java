/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.DichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Entity.LoaiDichVu;
import java.time.LocalDateTime;
import utils.KetNoiDB;

public class ThanhToanDAO {

    public static List<String> loadLoaiDichVu() {
        List<String> loadloaiDichVulst = new ArrayList<>();
        String sql = "SELECT TenLoaiDichVu FROM dbo.LoaiDichVu  ";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String LoaiDichVu = rs.getString("TenLoaiDichVu");
                loadloaiDichVulst.add(LoaiDichVu);
            }
            return loadloaiDichVulst;

        } catch (Exception e) {
            System.out.println("có lỗi ở " + e.getMessage());
            return loadloaiDichVulst;
        }
    }

    public static List<KhachHang> readKhachHang() {
        List<KhachHang> readKhachHanglst = new ArrayList<>();
        String sql = " SELECT TenKhachHang, SoDienThoai FROM dbo.KhachHang ";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String TenKhachHang = rs.getString("TenKhachHang");
                String SoDienThoai = rs.getString("SoDienThoai");
                KhachHang khachHang = new KhachHang(TenKhachHang, SoDienThoai);
                readKhachHanglst.add(khachHang);
            }
            return readKhachHanglst;

        } catch (Exception e) {
            System.out.println("có lỗi ở " + e.getMessage());
            return readKhachHanglst;
        }
    }

    public static List<DichVu> readDichVu(String TenLoaiDichVu) {
        List<DichVu> dichVulst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.DichVu AS DV "
                + "JOIN dbo.LoaiDichVu AS LDV "
                + "ON LDV.ID = DV.IDLoaiDichVu "
                + "WHERE LDV.TenLoaiDichVu = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, TenLoaiDichVu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String TenDichVu = rs.getString("TenDichVu");
                Float Gia = rs.getFloat("Gia");
                int SoLuong = rs.getInt("SoLuong");
                boolean TrangThai = rs.getBoolean("TrangThai");
                DichVu dichVu = new DichVu(id,TenDichVu, Gia, SoLuong, TrangThai);
                dichVulst.add(dichVu);
            }
            return dichVulst;
        } catch (Exception e) {
            System.out.println("có lỗi ở readDichVu " + e.getMessage());
            return dichVulst;
        }
    }

    public static List<KhachHang> SearchKhachHang(String tenKhachHang) {
        String sql = "SELECT * FROM dbo.KhachHang WHERE TenKhachHang LIKE ?";
        List<KhachHang> khachHanglst = new ArrayList<>();
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + tenKhachHang + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String TenKhachHang = rs.getString("TenKhachHang");
                String SoDienThoai = rs.getString("SoDienThoai");
                KhachHang khachHang = new KhachHang(TenKhachHang, SoDienThoai);
                khachHanglst.add(khachHang);
            }
            return khachHanglst;

        } catch (Exception e) {
            System.out.println("có lỗi ở " + e.getMessage());
            return khachHanglst;
        }
    }

    public static HoaDon readHoaDon(int ID) {
        String sql = "SELECT * FROM dbo.HoaDon AS HD JOIN dbo.Ban AS B ON B.ID = HD.IDBan WHERE HD.IDBan = ? AND HD.TrangThai = 0";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int iD = rs.getInt("ID");
                String NguoiTao = rs.getString("NguoiTao");
                Date NgayTao = rs.getDate("NgayTao");
                String TenKhachHang = rs.getString("TenKhachHang");
                Timestamp gioBatDauTimestamp = rs.getTimestamp("GioBatDau");
                LocalDateTime GioBatDau = gioBatDauTimestamp.toLocalDateTime();
                Timestamp gioKetThucTimestamp = rs.getTimestamp("GioKetThuc");
                LocalDateTime GioKetThuc = gioKetThucTimestamp.toLocalDateTime();
                Time TongGioChoi = rs.getTime("TongGioChoi");
                double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");
                int IDBan = rs.getInt("IDBan");
                int IDKhachHang = rs.getInt("IDKhachHang");
                int IDNhanVien = rs.getInt("IDNhanVien");
                HoaDon hoaDon = new HoaDon(iD, NguoiTao, TenKhachHang, NgayTao, GioBatDau, GioKetThuc, TongGioChoi, TongTien, TrangThai, IDBan, IDKhachHang, IDNhanVien);
                return hoaDon;
            }
            return null;
        } catch (Exception e) {
            System.out.println("có lỗi ở " + e.getMessage());
            return null;
        }
    }

    public static void readTenKhachHang() {
        String sql = "select TenKhachHang from KhachHang";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String TenKhachHang = rs.getString("TenKhachHang");
                KhachHang khachHang = new KhachHang();
            }
        } catch (Exception e) {
        }
    }

    public double TinhTienBan(Timestamp GioBatDau, Timestamp GioKetThuc, double giaBan) {
    double tien = 0;
    String sql = "SELECT dbo.fn_TinhTienBida(?, ?, ?)";
    try (Connection con = KetNoiDB.getConnectDB(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setTimestamp(1, GioBatDau);
        ps.setTimestamp(2, GioKetThuc);
        ps.setDouble(3, giaBan);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            tien = rs.getDouble(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return tien;
}

}
