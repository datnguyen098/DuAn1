package dao;

import entity.HoaDon;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class HoaDonDAO {

    Connection conn;

    public HoaDonDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM HoaDon";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nguoiTao = rs.getString("NguoiTao");
                String tenKhachHang = rs.getString("TenKhachHang");
                Date ngayTao = rs.getDate("NgayTao");
                Time gioBatDau = rs.getTime("GioBatDau");
                Time gioKetThuc = rs.getTime("GioKetThuc");
                double tongTien = rs.getDouble("TongTien");
                int tongGioChoi = rs.getInt("TongGioChoi");
                boolean trangThai = rs.getBoolean("TrangThai");
                int idBan = rs.getInt("IDBan");
                int idKhachHang = rs.getInt("IDKhachHang");
                int idNhanVien = rs.getInt("IDNhanVien");

                HoaDon hd = new HoaDon(id, nguoiTao, tenKhachHang, ngayTao, gioBatDau, gioKetThuc, tongGioChoi, tongTien, trangThai, idBan, idKhachHang, idNhanVien);
                listHD.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public List<HoaDon> getAllHoaDonTheoNgay(String ngayBD, String ngayKT) {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM HoaDon WHERE ngayTao BETWEEN ? AND ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, ngayBD);
            ps.setString(2, ngayKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nguoiTao = rs.getString("NguoiTao");
                String tenKhachHang = rs.getString("TenKhachHang");
                Date ngayTao = rs.getDate("NgayTao");
                Time gioBatDau = rs.getTime("GioBatDau");
                Time gioKetThuc = rs.getTime("GioKetThuc");
                double tongTien = rs.getDouble("TongTien");
                int tongGioChoi = rs.getInt("TongGioChoi");
                boolean trangThai = rs.getBoolean("TrangThai");
                int idBan = rs.getInt("IDBan");
                int idKhachHang = rs.getInt("IDKhachHang");
                int idNhanVien = rs.getInt("IDNhanVien");

                HoaDon hd = new HoaDon(id, nguoiTao, tenKhachHang, ngayTao, gioBatDau, gioKetThuc, tongGioChoi, tongTien, trangThai, idBan, idKhachHang, idNhanVien);
                listHD.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public HoaDon selectByID(int ID) {
        try {
            String SQL = "SELECT * FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.IDBan = ? and A.TrangThai = 0";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nguoiTao = rs.getString("NguoiTao");
                String tenKhachHang = rs.getString("TenKhachHang");
                Date ngayTao = rs.getDate("NgayTao");
                Time gioBatDau = rs.getTime("GioBatDau");
                Time gioKetThuc = rs.getTime("GioKetThuc");
                double tongTien = rs.getDouble("TongTien");
                int tongGioChoi = rs.getInt("TongGioChoi");
                boolean trangThai = rs.getBoolean("TrangThai");
                int idBan = rs.getInt("IDBan");
                int idKhachHang = rs.getInt("IDKhachHang");
                int idNhanVien = rs.getInt("IDNhanVien");

                HoaDon hd = new HoaDon(id, nguoiTao, tenKhachHang, ngayTao, gioBatDau, gioKetThuc, tongGioChoi, tongTien, trangThai, idBan, idKhachHang, idNhanVien);
                return hd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(HoaDon hd) {
        try {
            String SQl = ("INSERT INTO HoaDon VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement ps = conn.prepareStatement(SQl);
            ps.setString(1, hd.getNguoiTao());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(hd.getNgayTao());
            ps.setString(2, date);
            ps.setString(3, hd.getTenKhachHang());
            Date d = new Date();
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            String gioBatDau = sdf2.format(d);
            ps.setString(4, gioBatDau);
            ps.setString(5, "");
            ps.setInt(6, 0);
            ps.setDouble(7, hd.getTongTien());
            ps.setBoolean(8, hd.isTrangThai());
            ps.setInt(9, hd.getIdBan());
            ps.setInt(10, hd.getIdKhachHang());
            ps.setInt(11, hd.getIdNhanVien());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGioKT(String gioKT, int ID) {
        try {
            String SQL = "UPDATE HoaDon SET GioKetThuc = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, gioKT);
            ps.setInt(2, ID);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTongGioChoi(int ID) {
        try {
            String SQL = "UPDATE HoaDon SET TongGioChoi = DATEDIFF(MINUTE, GioBatDau, GioKetThuc) WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTongTien(int ID) {
        try {
            String SQl = "UPDATE HoaDon SET TongTien = (SELECT ((B.TongGioChoi/60) * C.Gia) + SUM(A.ThanhTien)"
                    + "FROM HoaDonChiTiet A INNER JOIN HoaDon B ON A.IDHoaDon = B.ID INNER JOIN Ban C ON B.IDBan = C.ID "
                    + "WHERE B.ID = ? GROUP BY B.TongGioChoi, C.Gia) WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQl);
            ps.setInt(1, ID);
            ps.setInt(2, ID);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateThanhToan(String ten, int IDKH, int ID) {
        try {
            String SQl = "UPDATE HoaDon SET TenKhachHang = ?, TrangThai = 1, IDKhachHang = ? WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(SQl);
            ps.setString(1, ten);
            ps.setInt(2, IDKH);
            ps.setInt(3, ID);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBan(int ID1, int ID2) {
        try {
            String SQL = "UPDATE HoaDon SET IDBan = ? WHERE IDBan = (SELECT IDBan FROM HoaDon WHERE IDBan = ? AND TrangThai = 0) AND TrangThai = 0"
                    + "UPDATE Ban SET TrangThai = 1 WHERE ID = ?"
                    + "UPDATE BAN SET TrangThai = 0 WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, ID2);
            ps.setInt(2, ID1);
            ps.setInt(3, ID1);
            ps.setInt(4, ID2);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
