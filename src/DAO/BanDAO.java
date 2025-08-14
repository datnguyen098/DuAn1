package DAO;

import Entity.Ban;
import java.sql.*;
import java.util.*;
import utils.KetNoiDB;

public class BanDAO {

    public static List<Ban> getAllBan() {
        List<Ban> banlst = new ArrayList<>();
        String sql = "select * from Ban";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                double gia = rs.getDouble("Gia");
                boolean trangThai = rs.getBoolean("TrangThai");
                Ban ban = new Ban(id, gia, trangThai);
                banlst.add(ban);
            }
        } catch (Exception e) {
            System.out.println("có lỗi ở getAllBan" + e.getMessage());
        }
        return banlst;
    }

    public static int UpdateTrangThaiban(Ban ban) {
        String sql = "UPDATE dbo.Ban SET TrangThai = ? WHERE ID = ? ";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, ban.isTrangThai());
            ps.setInt(2, ban.getID());
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            System.out.println("có lỗi ở update Trạng thái bàn" + e.getMessage());
            return 0;
        }
    }

    public static int UpdateTrangThai(int ID) {
        String sql = "UPDATE Ban SET TrangThai = 1 WHERE ID =  ?";

        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ID);
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            System.out.println("có lỗi ở update Trạng thái bàn" + e.getMessage());
            return 0;
        }
    }

    public static int createBan(Ban ban) {
        String sql = "insert into Ban values(?, ?)";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, ban.isTrangThai());
            ps.setDouble(2, ban.getGia());
            int ketqua = ps.executeUpdate();
            return ketqua;
        } catch (Exception e) {
            System.out.println("có lỗi ở " + e.getMessage());
            return 0;
        }
    }
    public static int deleteBan(int ID){
    String sql = "DELETE FROM dbo.Ban WHERE ID = ? AND TrangThai = 1";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("có lỗi ở"+  e.getMessage());
            return 0;
            
        }
    }
   public static Ban getBanByID(int id) {
    Ban ban = null;
    String sql = "SELECT Gia FROM Ban WHERE ID = ?";
    
    try (Connection con = KetNoiDB.getConnectDB();
         PreparedStatement ps = con.prepareStatement(sql)) {
         
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                ban = new Ban();
                ban.setGia(rs.getDouble("Gia")); // Lấy giá trị Gia
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ban;
}


}
