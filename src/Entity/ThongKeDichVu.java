/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class ThongKeDichVu {
    private String TenDichVu;
    private int SoLuongDV;

    public ThongKeDichVu() {
    }

    public ThongKeDichVu(String TenDichVu, int SoLuongDV) {
        this.TenDichVu = TenDichVu;
        this.SoLuongDV = SoLuongDV;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public int getSoLuongDV() {
        return SoLuongDV;
    }

    public void setSoLuongDV(int SoLuongDV) {
        this.SoLuongDV = SoLuongDV;
    }
    
    
}
