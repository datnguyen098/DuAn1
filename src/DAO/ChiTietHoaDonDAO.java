/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import utils.KetNoiDB;
import Entity.ChiTietHoaDon;

public class ChiTietHoaDonDAO {
    public static List<ChiTietHoaDon> readChiTietHoaDon( int ID){
        List<ChiTietHoaDon> chiTietHoaDonlst = new ArrayList<>();
    String sql = "select * from HoaDonChiTiet where IDHoaDon = ?";
        try (Connection con = KetNoiDB.getConnectDB(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
             int iD = rs.getInt("ID");
                String Ten = rs.getString("Ten");
                double Gia = rs.getDouble("Gia");
                int SoLuong = rs.getInt("SoLuong");
                int ThanhTien = rs.getInt("ThanhTien");
                int IDDichVu = rs.getInt("IDDichVu");
                int IDHoaDon = rs.getInt("IDHoaDon");
            ChiTietHoaDon chitiethoadon = new ChiTietHoaDon(iD, Ten, Gia, SoLuong,ThanhTien ,IDDichVu, IDHoaDon);
            chiTietHoaDonlst.add(chitiethoadon);
            
            }
            return chiTietHoaDonlst;
        } catch (Exception e) {
            e.printStackTrace();
            return chiTietHoaDonlst;
        }
    }
   public static int createHDCT(ChiTietHoaDon CTHD){
   String sql = "INSERT INTO HoaDonChiTiet VALUES (?,?,?,?,?,?)";
       try (Connection con = KetNoiDB.getConnectDB();PreparedStatement ps = con.prepareStatement(sql)) {
           ps.setString(1, CTHD.getTen());
           ps.setDouble(2, CTHD.getGia());
           ps.setInt(3, CTHD.getSoLuong());
           ps.setDouble(4, CTHD.getThanhTien());
           ps.setInt(5, CTHD.getIDDichVu());
           ps.setInt(6, CTHD.getIDHoaDon());
           int ketqua = ps.executeUpdate();
           return ketqua;
       } catch (Exception e) {
           e.printStackTrace();
           return 0;
       }
   }
   public static int UpdateThanhTien(double ThanhTien, int ID ){
   String sql = "UPDATE dbo.HoaDonChiTiet SET ThanhTien = ? WHERE IDHoaDon = ? ";
       try (Connection con = KetNoiDB.getConnectDB();PreparedStatement ps = con.prepareStatement(sql)) {
           ps.setDouble(1, ThanhTien);
           ps.setInt(2, ID);
           int ketqua = ps.executeUpdate();
           return ketqua;
       } catch (Exception e) {
           e.printStackTrace();
           return 0;
       }
   }
   public  static int upDateThueBan(double ThanhTien, int IDHoaDon){
  String sql = "UPDATE dbo.HoaDonChiTiet SET ThanhTien = ? WHERE Ten = N'Thuê Bàn' AND IDHoaDon = ?";
       try(Connection con = KetNoiDB.getConnectDB();PreparedStatement ps = con.prepareStatement(sql)) {
          ps.setDouble(1, ThanhTien);
          ps.setInt(2, IDHoaDon);
           int ketqua = ps.executeUpdate();
           return ketqua;
      } catch (Exception e) {
          return 0;
       }
   }
}
