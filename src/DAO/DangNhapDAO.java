package DAO;

import Entity.NhanVien;

import java.util.*;
import java.util.Date;
import utils.KetNoiDB;
import java.sql.*;

public class DangNhapDAO {

    public static NhanVien Login(String TenDangNhap, String MatKhau) {
        String sql = "select * from NhanVien where TenDangNhap = ? and" + " MatKhau = ?";
        try (java.sql.Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, TenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               int ID = rs.getInt("ID");
               String TenNhanVien = rs.getString("TenNhanVien");
                String TenDangNhapDB = rs.getString("TenDangNhap");
               String MatKhauDB = rs.getString("MatKhau");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                boolean VaiTro = rs.getBoolean("VaiTro");
                String SoDienThoai = rs.getString("SoDienThoai");
                return new NhanVien(ID, TenNhanVien, TenDangNhap, MatKhau, GioiTinh, NgaySinh, VaiTro, SoDienThoai);
                
            }
            return null;
        } catch (Exception e) {
            System.out.println("có lỗi ở đăng nhập" + e.getMessage());
            return null;
        }
    }

    public static int DoiMatKhau(String TenDangNhap, String MatKhau) {
        String sql = "UPDATE dbo.NhanVien SET\n"
                + "MatKhau = ?\n"
                + "WHERE TenDangNhap = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MatKhau);
            ps.setString(2, TenDangNhap);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            System.out.println("có lỗi ở phần đổi mật Khẩu" + e.getMessage());
            return 0;
            
        }
    }
}
