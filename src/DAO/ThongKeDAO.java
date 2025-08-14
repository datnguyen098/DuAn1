/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.DichVu;
import Entity.ThongKeBan;
import Entity.ThongKeDichVu;
import Entity.ThongKeKhachHang;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.KetNoiDB;

/**
 *
 * @author ADMIN
 */
public class ThongKeDAO {

    public static int GetSoLuongHoaDon(Date TuNgay, Date DenNgay) {
        int SoLuong = 0;
        String sql = "SELECT COUNT(*) FROM HoaDon WHERE NgayTao BETWEEN ? AND ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(TuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(DenNgay.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SoLuong = rs.getInt(1);

            }
            return SoLuong;
        } catch (Exception e) {
            e.printStackTrace();
            return SoLuong;
        }
    }

    public static double getDoanhThu(Date TuNgay, Date DenNgay) {
        double tong = 0;
        String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE NgayTao BETWEEN ? AND ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(TuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(DenNgay.getTime()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tong = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tong;
    }

    public static List<ThongKeDichVu> ThongKeDichVu(Date TuNgay, Date DenNgay) {
        List<ThongKeDichVu> Dichvulst = new ArrayList<>();
        String sql = "SELECT hct.Ten, COUNT(*) AS SoLanSuDung\n"
                + "FROM HoaDonChiTiet hct\n"
                + "JOIN HoaDon hd ON hct.IDHoaDon = hd.ID\n"
                + "WHERE CAST(hd.NgayTao AS DATE)BETWEEN ? AND ?\n"
                + "GROUP BY hct.Ten\n"
                + "ORDER BY SoLanSuDung DESC;";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(TuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(DenNgay.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("Ten");
                int soLanSuDung = rs.getInt("SoLanSuDung");
                ThongKeDichVu TKDV = new ThongKeDichVu(ten, soLanSuDung);
                Dichvulst.add(TKDV);
            }
            return Dichvulst;
        } catch (Exception e) {
            e.printStackTrace();
            return Dichvulst;
        }
    }

    public static List<ThongKeKhachHang> ThongKeKhachHang(Date TuNgay, Date DenNgay) {
        List<ThongKeKhachHang> Khachhanglst = new ArrayList<>();
        String sql = "SELECT kh.TenKhachHang, COUNT(*) AS SoLuongHoaDon\n"
                + "FROM HoaDon hd\n"
                + "JOIN KhachHang kh ON hd.IDKhachHang = kh.ID\n"
                + "WHERE hd.NgayTao BETWEEN ? AND ?\n"
                + "GROUP BY hd.IDKhachHang, kh.TenKhachHang\n"
                + "ORDER BY SoLuongHoaDon DESC;";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(TuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(DenNgay.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("TenKhachHang");
                int SoLuongHoaDon = rs.getInt("SoLuongHoaDon");
                ThongKeKhachHang TKKH = new ThongKeKhachHang(ten, SoLuongHoaDon);
                Khachhanglst.add(TKKH);
            }
            return Khachhanglst;
        } catch (Exception e) {
            e.printStackTrace();
            return Khachhanglst;
        }
    }

    public static List<ThongKeBan> ThongKeBan(Date TuNgay, Date DenNgay) {
        List<ThongKeBan> Banlst = new ArrayList<>();
        String sql = " SELECT b.ID, COUNT(hd.ID) AS SoLanDuocDat\n"
                + "FROM HoaDon hd\n"
                + "JOIN Ban b ON hd.IDBan = b.ID\n"
                + "WHERE hd.NgayTao BETWEEN ? AND ?\n"
                + "GROUP BY b.ID\n"
                + "ORDER BY SoLanDuocDat DESC;";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(TuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(DenNgay.getTime()));
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                int ID = rs.getInt("ID");
                int SoLanDuocDat = rs.getInt("SoLanDuocDat");
                ThongKeBan TKB = new ThongKeBan(ID, SoLanDuocDat);
                Banlst.add(TKB);
            }
             return Banlst;
        } catch (Exception e) {
            e.printStackTrace();
            return Banlst;
        }
    }
}
