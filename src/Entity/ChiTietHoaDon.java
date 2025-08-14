/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class ChiTietHoaDon {

    private int ID;
    private String Ten;
    private double Gia;

    private int SoLuong;
    private double ThanhTien;
    private int IDDichVu, IDHoaDon;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int ID, String Ten, double Gia, int SoLuong, double ThanhTien, int IDDichVu, int IDHoaDon) {
        this.ID = ID;
        this.Ten = Ten;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.IDDichVu = IDDichVu;
        this.IDHoaDon = IDHoaDon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
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

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public int getIDDichVu() {
        return IDDichVu;
    }

    public void setIDDichVu(int IDDichVu) {
        this.IDDichVu = IDDichVu;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

   
}
