package dao;

import entity.KhachHang;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class KhachHangDAO {

    Connection conn;

    public KhachHangDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> listKH = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM KhachHang");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenKH = rs.getString("TenKhachHang");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String soDienThoai = rs.getString("SoDienThoai");

                KhachHang kh = new KhachHang(id, tenKH, gioiTinh, ngaySinh, soDienThoai);
                listKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public List<KhachHang> getKhachHang(String tenKhachHang, String SDT) {
        List<KhachHang> listKH = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM KhachHang WHERE TenKhachHang LIKE ? OR SoDienThoai LIKE ?");
            ps.setString(1, tenKhachHang);
            ps.setString(2, SDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenKH = rs.getString("TenKhachHang");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String soDienThoai = rs.getString("SoDienThoai");

                KhachHang kh = new KhachHang(id, tenKH, gioiTinh, ngaySinh, soDienThoai);
                listKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public KhachHang selectByID(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM KhachHang WHERE ID = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenKH = rs.getString("TenKhachHang");
                boolean gioiTinh = rs.getBoolean("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String soDienThoai = rs.getString("SoDienThoai");

                KhachHang kh = new KhachHang(id, tenKH, gioiTinh, ngaySinh, soDienThoai);
                return kh;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(KhachHang kh) {
        try {
            String SQL = "INSERT INTO KhachHang VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, kh.getTenKH());
            ps.setBoolean(2, kh.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sdf.format(kh.getNgaySinh());
            ps.setString(3, ngaySinh);
            ps.setString(4, kh.getSoDienThoai());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void update(KhachHang kh, int ID) {
        try {
            String SQL = "UPDATE KhachHang SET TenKhachHang = ?, GioiTinh = ?, NgaySinh = ?, SoDienThoai = ? WHERE ID = ? ";
            PreparedStatement ps = conn.prepareStatement(SQL);

            ps.setString(1, kh.getTenKH());
            ps.setBoolean(2, kh.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sdf.format(kh.getNgaySinh());
            ps.setString(3, ngaySinh);
            ps.setString(4, kh.getSoDienThoai());
            ps.setInt(5, ID);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public void delete(int ID) {
        try {
            String url = "DELETE FROM KhachHang WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
