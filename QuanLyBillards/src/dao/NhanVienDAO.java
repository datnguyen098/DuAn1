package dao;

import entity.NhanVien;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class NhanVienDAO {

    Connection conn;

    public NhanVienDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM NhanVien");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenNV = rs.getString("TenNhanVien");
                String tenDN = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                boolean vaiTro = rs.getBoolean("VaiTro");
                String soDienThoai = rs.getString("SoDienThoai");

                NhanVien nv = new NhanVien(id, tenNV, tenDN, matKhau, gioiTinh, ngaySinh, vaiTro, soDienThoai);
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public NhanVien selectByID(int ID) {
        try {
            String SQL = "SELECT * FROM NhanVien WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenNV = rs.getString("TenNhanVien");
                String tenDN = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                boolean vaiTro = rs.getBoolean("VaiTro");
                String soDienThoai = rs.getString("SoDienThoai");

                NhanVien nv = new NhanVien(id, tenNV, tenDN, matKhau, gioiTinh, ngaySinh, vaiTro, soDienThoai);
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVien selectByTenDN(String dangNhap) {
        try {
            String SQL = "SELECT * FROM NhanVien WHERE TenDangNhap = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, dangNhap);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenNV = rs.getString("TenNhanVien");
                String tenDN = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                boolean vaiTro = rs.getBoolean("VaiTro");
                String soDienThoai = rs.getString("SoDienThoai");

                NhanVien nv = new NhanVien(id, tenNV, tenDN, matKhau, gioiTinh, ngaySinh, vaiTro, soDienThoai);
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(NhanVien nv) {
        try {
            String SQL = "INSERT INTO NhanVien VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getTenDN());
            ps.setString(3, nv.getMatKhau());
            ps.setBoolean(4, nv.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sdf.format(nv.getNgaySinh());
            ps.setString(5, ngaySinh);
            ps.setBoolean(6, nv.isVaiTro());
            ps.setString(7, nv.getSoDienThoai());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NhanVien nv, int ID) {
        try {
            String SQL = "UPDATE NhanVien SET TenNhanVien = ?, TenDangNhap = ?, GioiTinh = ?, NgaySinh = ?, VaiTro = ?, SoDienThoai = ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getTenDN());
            ps.setBoolean(3, nv.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sdf.format(nv.getNgaySinh());
            ps.setString(4, ngaySinh);
            ps.setBoolean(5, nv.isVaiTro());
            ps.setString(6, nv.getSoDienThoai());
            ps.setInt(7, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMatKhau(String matKhau, int ID) {
        try {
            String SQL = "UPDATE NhanVien SET MatKhau = ? WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, matKhau);
            ps.setInt(2, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int ID) {
        try {
            String url = "DELETE FROM NhanVien WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
