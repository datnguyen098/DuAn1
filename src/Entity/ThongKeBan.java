/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class ThongKeBan {
    private int IDBan;
    private int SoLanDatBan;

    public ThongKeBan() {
    }

    public ThongKeBan(int IDBan, int SoLanDatBan) {
        this.IDBan = IDBan;
        this.SoLanDatBan = SoLanDatBan;
    }

    public int getIDBan() {
        return IDBan;
    }

    public void setIDBan(int IDBan) {
        this.IDBan = IDBan;
    }

    public int getSoLanDatBan() {
        return SoLanDatBan;
    }

    public void setSoLanDatBan(int SoLanDatBan) {
        this.SoLanDatBan = SoLanDatBan;
    }
    
}
