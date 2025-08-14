/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class LoaiDichVu {
    private int id;
   private String tenLoaiDV;

    public LoaiDichVu(int id, String tenLoaiDV) {
        this.id = id;
        this.tenLoaiDV = tenLoaiDV;
    }

    public LoaiDichVu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiDV() {
        return tenLoaiDV;
    }

    public void setTenLoaiDV(String tenLoaiDV) {
        this.tenLoaiDV = tenLoaiDV;
    }
   
}
