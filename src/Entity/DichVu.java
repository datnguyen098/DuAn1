/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class DichVu {
    private int ID;
    private String TenDichVu;
    private double Gia;
    private int SoLuong;
    private boolean TrangThai;
    private int IDLoaiDichVu;

    public DichVu(int ID, String TenDichVu, double Gia, int SoLuong, boolean TrangThai, int IDLoaiDichVu) {
        this.ID = ID;
        this.TenDichVu = TenDichVu;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.IDLoaiDichVu = IDLoaiDichVu;
    }

    public DichVu() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getIDLoaiDichVu() {
        return IDLoaiDichVu;
    }

    public void setIDLoaiDichVu(int IDLoaiDichVu) {
        this.IDLoaiDichVu = IDLoaiDichVu;
    }

    public DichVu(String TenDichVu, double Gia, int SoLuong, boolean TrangThai) {
        this.TenDichVu = TenDichVu;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public DichVu(int ID, String TenDichVu, double Gia, int SoLuong, boolean TrangThai) {
        this.ID = ID;
        this.TenDichVu = TenDichVu;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public DichVu(String TenDichVu, double Gia, int SoLuong, boolean TrangThai, int IDLoaiDichVu) {
        this.TenDichVu = TenDichVu;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.IDLoaiDichVu = IDLoaiDichVu;
    }
    
}
