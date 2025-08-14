package DAO;

import Entity.KhachHang;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import utils.KetNoiDB;

public class KhachHangDAO {

    public static List<KhachHang> getAllKhachHang() {
//List: danh sách khách hàng 
        List<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";//Lấy dữ liệu bảng khách hàng từ bên SQL 
//Array: mảng 
//ArrayList: Tạo mảng danh sách khách hàng 
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
//Try để tự động đóng kết nối 
//Tạo kết nối với cơ sở dữ liệu 
//PreparedStatement: Truy vấn SQL có tham số 
            ResultSet rs = ps.executeQuery();
//Thực hiện truy vấn dữ liệu select
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String TenKhachHang = rs.getString("TenKhachHang");
                boolean GioiTinh = rs.getBoolean("GioiTinh");
                Date NgaySinh = rs.getDate("NgaySinh");
                String SoDienThoai = rs.getString("SoDienThoai");
//Lấy dữ liệu bên SQL tạo đối tượng 
                KhachHang kh = new KhachHang(ID, TenKhachHang, GioiTinh, NgaySinh, SoDienThoai);
                list.add(kh);
//Thêm vào List 
            }
            return list;
        } catch (Exception e) {
//Bắt lỗi            
        }
        return list;

    }

    public static int CreateKhachHang(KhachHang khachHang) {
//Thêm 1 khách hàng vào bảng
        String sql = "insert into KhachHang (TenKhachHang, GioiTinh, NgaySinh, SoDienThoai) values (?, ?, ?, ?)";
        //Thêm dòng mới vào bảng KhachHang 
        //?: Truyền dữ liệu nhập vào
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, khachHang.getTenKhachHang());
            ps.setBoolean(2, khachHang.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(khachHang.getNgaySinh());
            ps.setString(3, date);
            ps.setString(4, khachHang.getSoDienThoai());
//Gán vào ?
            return ps.executeUpdate();//Trả về 1 nếu thành công 
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public static int UpdateKhachHang(KhachHang khachHang) {
        String sql = "UPDATE KhachHang \n"
                + "SET TenKhachHang = ?, \n"
                + "GioiTinh = ?, \n"
                + "NgaySinh = ?, \n"
                + "SoDienThoai = ? \n"
                + "WHERE ID = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, khachHang.getTenKhachHang());
            ps.setBoolean(2, khachHang.isGioiTinh());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(khachHang.getNgaySinh());
            ps.setString(3, date);
            ps.setString(4, khachHang.getSoDienThoai());
            ps.setInt(5, khachHang.getID()); // điều kiện WHERE ID = ?
            int ketqua = ps.executeUpdate();
            return ketqua;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int DeleteKhachHang(KhachHang khachHang) {
        String sql = "DELETE FROM KhachHang WHERE ID = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, khachHang.getID());
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static List<KhachHang> SearchKhachHang(String keyword) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("ID"));
                kh.setTenKhachHang(rs.getString("TenKhachHang"));
                kh.setGioiTinh(rs.getBoolean("GioiTinh"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
