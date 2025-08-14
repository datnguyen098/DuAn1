/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class Ban {
    private int ID;
    private double Gia;
    private boolean TrangThai;

    public Ban() {
    }

    public Ban(int ID, double Gia, boolean TrangThai) {
        this.ID = ID;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Ban(double Gia, boolean TrangThai) {
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public Ban(int ID) {
        this.ID = ID;
    }
    
}
