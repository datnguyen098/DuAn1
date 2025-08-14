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
public class KhuyenMai {
    private int ID;
    private String MaKhuyenMai;
    private String TenKhuyenMai;
    private int PhanTramGiam;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private boolean TrangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(int ID, String MaKhuyenMai, String TenKhuyenMai, int PhanTramGiam, Date NgayBatDau, Date NgayKetThuc, boolean TrangThai) {
        this.ID = ID;
        this.MaKhuyenMai = MaKhuyenMai;
        this.TenKhuyenMai = TenKhuyenMai;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaKhuyenMai() {
        return MaKhuyenMai;
    }

    public void setMaKhuyenMai(String MaKhuyenMai) {
        this.MaKhuyenMai = MaKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return TenKhuyenMai;
    }

    public void setTenKhuyenMai(String TenKhuyenMai) {
        this.TenKhuyenMai = TenKhuyenMai;
    }

    public int getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(int PhanTramGiam) {
        this.PhanTramGiam = PhanTramGiam;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
