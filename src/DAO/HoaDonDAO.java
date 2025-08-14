/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import java.util.List;
import java.util.Date;
import java.sql.Time;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import utils.KetNoiDB;

/**
 *
 * @author ADMIN
 */
public class HoaDonDAO {

    public static List<HoaDon> readHoaDon() {
        List<HoaDon> hoaDonlst = new ArrayList<>();
        String sql = "select * from HoaDon";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NguoiTao = rs.getString("NguoiTao");
                Date NgayTao = rs.getDate("NgayTao");
                String TenKhachHang = rs.getString("TenKhachHang");
                Timestamp gioBatDauTimestamp = rs.getTimestamp("GioBatDau");
                LocalDateTime GioBatDau = gioBatDauTimestamp.toLocalDateTime();
                Timestamp gioKetThucTimestamp = rs.getTimestamp("GioKetThuc");
                LocalDateTime GioKetThuc = gioKetThucTimestamp.toLocalDateTime();

                // Định dạng LocalDateTime thành chuỗi theo định dạng "yyyy-MM-dd HH:mm:ss"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedGioBatDau = GioBatDau.format(formatter);

                // Chuyển GioBatDau sang chuỗi đã định dạng
                String formattedGioKetThuc = GioKetThuc.format(formatter);

                Time TongGioChoi = rs.getTime("TongGioChoi");
                Double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");
                int IDBan = rs.getInt("IDBan");
                int IDKhachHang = rs.getInt("IDKhachHang");
                int IDNhanVien = rs.getInt("IDNhanVien");
                HoaDon hoaDon = new HoaDon(ID, NguoiTao, TenKhachHang, NgayTao, GioBatDau, GioKetThuc, TongGioChoi, TongTien, TrangThai, IDBan, IDKhachHang, IDNhanVien);
                hoaDonlst.add(hoaDon);
            }
            return hoaDonlst;
        } catch (Exception e) {
            return hoaDonlst;
        }
    }

    public static int CreateHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO dbo.HoaDon\n"
                + "(\n"
                + "    NguoiTao,\n"
                + "   NgayTao,\n"
                + "    TenKhachHang,\n"
                + "    GioBatDau,\n"
                + "    GioKetThuc,\n"
                + "    TongGioChoi,\n"
                + "    TongTien,\n"
                + "    TrangThai,\n"
                + "    IDBan,\n"
                + "    IDKhachHang,\n"
                + "    IDNhanVien\n"
                + ")\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hoaDon.getNguoiTao());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String NgayTao = sdf.format(hoaDon.getNgayTao());
            ps.setString(2, NgayTao);
            ps.setString(3, hoaDon.getTenKhachHang());
            Date d = new Date();
//            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
//            String GioBatDau = sdf2.format(d);
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime truncatedDateTime = localDateTime.truncatedTo(ChronoUnit.MILLIS);
            hoaDon.setGioBatDau(truncatedDateTime);
            // Chuyển đổi LocalDateTime sang Timestamp
            Timestamp timestamp = Timestamp.valueOf(truncatedDateTime);
            ps.setString(4, timestamp.toString());
            // để rỗng vì giờ kết thúc chưa được set
            ps.setString(5, "");
            // để 00:00:00 vì chưa có giwof kết thúc chưa biết được tổng giờ chơi
            ps.setTime(6, java.sql.Time.valueOf("00:00:00"));
            ps.setDouble(7, hoaDon.getTongTien());
            ps.setBoolean(8, hoaDon.isTrangThai());
            ps.setInt(9, hoaDon.getIdBan());
            ps.setInt(10, hoaDon.getIdKhachHang());
            System.out.println("ID nhân viên tạo hóa đơn: " + hoaDon.getIdNhanVien());

            ps.setInt(11, hoaDon.getIdNhanVien());

            int ketqua = ps.executeUpdate();
            return ketqua;

        } catch (Exception e) {
            System.out.println("có lỗi ở create hóa đơn" + e.getMessage());
            return 0;
        }
    }

    public static HoaDon readIDHD(int ID) {
        String sql = "	SELECT ID FROM dbo.HoaDon WHERE IDBan = ? AND TrangThai = 0";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int iD = rs.getInt("ID");
                HoaDon hoadon = new HoaDon(iD);
                return hoadon;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static int updateTongTien(double TongTien, int ID) {
        String sql = "update HoaDon set TongTien = ? where ID = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, TongTien);
            ps.setInt(2, ID);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static int UpdateHD(HoaDon hoaDon) {
        String sql = "UPDATE dbo.HoaDon SET GioKetThuc = ?, TongTien = ?, TongGioChoi = ?, TrangThai = 1 WHERE ID = ? AND IDBan = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(hoaDon.getGioKetThuc()));
            ps.setDouble(2, hoaDon.getTongTien());
            ps.setTime(3, hoaDon.getTongGioChoi());
            ps.setInt(4, hoaDon.getId());
            ps.setInt(5, hoaDon.getIdBan());
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<HoaDon> timKiemHoaDon(Date NgayTao) {
        List<HoaDon> hoaDonlst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.HoaDon WHERE NgayTao = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(NgayTao.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NguoiTao = rs.getString("NguoiTao");
                Date NgayTao1 = rs.getDate("NgayTao");
                String TenKhachHang = rs.getString("TenKhachHang");
                Timestamp gioBatDauTimestamp = rs.getTimestamp("GioBatDau");
                LocalDateTime GioBatDau = gioBatDauTimestamp.toLocalDateTime();
                Timestamp gioKetThucTimestamp = rs.getTimestamp("GioKetThuc");
                LocalDateTime GioKetThuc = gioKetThucTimestamp.toLocalDateTime();

                // Định dạng LocalDateTime thành chuỗi theo định dạng "yyyy-MM-dd HH:mm:ss"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedGioBatDau = GioBatDau.format(formatter);

                // Chuyển GioBatDau sang chuỗi đã định dạng
                String formattedGioKetThuc = GioKetThuc.format(formatter);

                Time TongGioChoi = rs.getTime("TongGioChoi");
                Double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");
                int IDBan = rs.getInt("IDBan");
                int IDKhachHang = rs.getInt("IDKhachHang");
                int IDNhanVien = rs.getInt("IDNhanVien");
                HoaDon hoaDon = new HoaDon(ID, NguoiTao, TenKhachHang, NgayTao1, GioBatDau, GioKetThuc, TongGioChoi, TongTien, TrangThai, IDBan, IDKhachHang, IDNhanVien);
                hoaDonlst.add(hoaDon);
            }
            return hoaDonlst;
        } catch (Exception e) {
            e.printStackTrace();
            return hoaDonlst;
        }
    }

    public static int updateChuyenBan(int ID1, int ID2) {
        String sql = "UPDATE HoaDon SET IDBan = ? WHERE IDBan = (SELECT IDBan FROM HoaDon WHERE IDBan = ? AND TrangThai = 0) AND TrangThai = 0"
                + "UPDATE Ban SET TrangThai = 1 WHERE ID = ?"
                + "UPDATE Ban SET TrangThai = 0 WHERE ID = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ID2);
            ps.setInt(2, ID1);
            ps.setInt(3, ID1);
            ps.setInt(4, ID2);
           int ketqua =  ps.executeUpdate();
return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
