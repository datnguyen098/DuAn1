/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;
public class NhanVien {
    private int ID;
    private String TenNhanVien, TenDangNhap, MatKhau;
    private boolean GioiTinh;
    private Date NgaySinh;
    private boolean VaiTro;
    private String SoDienThoai;

    public NhanVien() {
    }

    public NhanVien(int ID, String TenNhanVien, String TenDangNhap, String MatKhau, boolean GioiTinh, Date NgaySinh, boolean VaiTro, String SoDienThoai) {
        this.ID = ID;
        this.TenNhanVien = TenNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.VaiTro = VaiTro;
        this.SoDienThoai = SoDienThoai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public NhanVien(String TenNhanVien, String TenDangNhap, String MatKhau, Date NgaySinh, boolean VaiTro, String SoDienThoai) {
        this.TenNhanVien = TenNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.NgaySinh = NgaySinh;
        this.VaiTro = VaiTro;
        this.SoDienThoai = SoDienThoai;
    }

    public NhanVien(String TenDangNhap, String MatKhau) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public NhanVien(String TenNhanVien, String TenDangNhap, String MatKhau, boolean GioiTinh, Date NgaySinh, boolean VaiTro, String SoDienThoai) {
        this.TenNhanVien = TenNhanVien;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.VaiTro = VaiTro;
        this.SoDienThoai = SoDienThoai;
    }
    
}
