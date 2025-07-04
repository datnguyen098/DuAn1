package dao;

import java.sql.*;
import java.util.*;
import java.util.*;
import utils.JdbcHelper;

public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<Object[]> getDoanhThuVaHoaDon(String ngayBD, String ngayKT) {
        String sql = "{CALL ThongKeDoanhThuVaHoaDon(?,?)}";
        String[] cols = {"SoLuongHoaDon", "DoanhThu"};
        return this.getListOfArray(sql, cols, ngayBD, ngayKT);
    }

    public List<Object[]> getBan(String ngayBD, String ngayKT) {
        String sql = "{CALL ThongKeDoanhThuTheoBan(?,?)}";
        String[] cols = {"IDBan", "Ngay", "TongDoanhThu"};
        return this.getListOfArray(sql, cols, ngayBD, ngayKT);
    }

    public List<Object[]> getDichVu(String ngayBD, String ngayKT) {
        String sql = "{CALL ThongKeDichVu(?,?)}";
        String[] cols = {"TenDichVu", "TongSoLuong", "TongTien"};
        return this.getListOfArray(sql, cols, ngayBD, ngayKT);
    }
    
    public List<Object[]> getGioiTinh() {
        String sql = "{CALL ThongKeKhachHang}";
        String[] cols = {"GioiTinh", "SoLuong"};
        return this.getListOfArray(sql, cols);
    }
}
