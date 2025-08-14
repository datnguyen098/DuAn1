/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private int ID;
    private String TenKhachHang;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String SoDienThoai;

    public KhachHang() {
    }

    public KhachHang(int ID, String TenKhachHang, boolean GioiTinh, Date NgaySinh, String SoDienThoai) {
        this.ID = ID;
        this.TenKhachHang = TenKhachHang;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SoDienThoai = SoDienThoai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public KhachHang(String TenKhachHang, String SoDienThoai) {
        this.TenKhachHang = TenKhachHang;
        this.SoDienThoai = SoDienThoai;
    }

    public KhachHang(String TenKhachHang, boolean GioiTinh, Date NgaySinh, String SoDienThoai) {
        this.TenKhachHang = TenKhachHang;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SoDienThoai = SoDienThoai;
    }
    
}
