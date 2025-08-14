/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhanVien;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import utils.KetNoiDB;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {

    public static List<NhanVien> ReadNhanVien() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        String sql = "Select * From NhanVien";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String TenNhanVien = rs.getString("TenNhanVien");
                String TenDangNhap = rs.getString("TenDangNhap");
                String Matkhau = rs.getString("MatKhau");
                Boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                Boolean VaiTro = rs.getBoolean("VaiTro");
                String SoDienThoai = rs.getString("SoDienThoai");
                NhanVien nv = new NhanVien(ID, TenNhanVien, TenDangNhap, Matkhau, GioiTinh, NgaySinh, VaiTro, SoDienThoai);
                nhanVienList.add(nv);
            }
            return nhanVienList;
        } catch (Exception e) {
            return nhanVienList;
        }

    }

    public static int createNhanVien(NhanVien nv) {
        String sql = "INSERT INTO NhanVien(TenNhanVien, TenDangNhap, MatKhau, GioiTinh, NgaySinh, VaiTro, SoDienThoai)VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nv.getTenNhanVien());
            ps.setString(2, nv.getTenDangNhap());
            ps.setString(3, nv.getMatKhau());
            ps.setBoolean(4, nv.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(nv.getNgaySinh());
            ps.setString(5, date);
            ps.setBoolean(6, nv.isVaiTro());
            ps.setString(7, nv.getSoDienThoai());
            int KetQua = ps.executeUpdate();
            return KetQua;
        } catch (Exception e) {
            System.out.println("co loi o " + e.getMessage());
            return 0;
        }

    }
     public static int deleteNhanVien(String tenNhanVien) {
        String sql = "DELETE FROM NhanVien WHERE TenNhanVien = ?";
        try (Connection con = KetNoiDB.getConnectDB();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tenNhanVien);
            int KetQua = ps.executeUpdate();
            return KetQua;
        } catch (Exception e) {
                 e.printStackTrace();
                 return 0;
             }
         }

    // Sửa thông tin nhân viên
public static int updateNhanVien(NhanVien nv) {
        String sql = "UPDATE NhanVien SET TenNhanVien = ?, MatKhau = ?, GioiTinh = ?, NgaySinh = ?, VaiTro = ?, SoDienThoai = ? WHERE TenDangNhap = ?";
        try (Connection con = KetNoiDB.getConnectDB();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nv.getTenNhanVien());
            ps.setString(2, nv.getMatKhau());
            ps.setBoolean(3, nv.isGioiTinh());
            ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setBoolean(5, nv.isVaiTro());
            ps.setString(6, nv.getSoDienThoai());
            ps.setString(7, nv.getTenDangNhap());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi khi sửa nhân viên: " + e.getMessage());
            return 0;
        }
    }
    // Tìm kiếm nhân viên theo tên hoặc tên đăng nhập
    public static List<NhanVien> SearchNhanVien(String keyword) {
    List<NhanVien> list = new ArrayList<>();
    String sql = "SELECT * FROM NhanVien WHERE TenNhanVien LIKE ?";
    try (Connection con = KetNoiDB.getConnectDB();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NhanVien nv = new NhanVien(); 
            nv.setID(rs.getInt("ID"));
            nv.setTenNhanVien(rs.getString("TenNhanVien"));
            nv.setGioiTinh(rs.getBoolean("GioiTinh"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setSoDienThoai(rs.getString("SoDienThoai"));
            list.add(nv);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}
