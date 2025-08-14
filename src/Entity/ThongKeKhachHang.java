/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class ThongKeKhachHang {

    public String TenKhachHang;

    public int SoLanThueBan;

    public ThongKeKhachHang() {
    }

    public ThongKeKhachHang(String TenKhachHang, int SoLanThueBan) {
        this.TenKhachHang = TenKhachHang;

        this.SoLanThueBan = SoLanThueBan;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getSoLanThueBan() {
        return SoLanThueBan;
    }

    public void setSoLanThueBan(int SoLanThueBan) {
        this.SoLanThueBan = SoLanThueBan;
    }

}
