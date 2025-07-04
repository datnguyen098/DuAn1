package entity;

public class DichVu {

    private int id;
    private String tenDV;
    private double giaDV;
    private int soLuong;
    private boolean trangThai;
    private int idLoaiDV;

    public DichVu() {
    }

    public DichVu(int id, String tenDV, double giaDV, int soLuong, boolean trangThai, int idLoaiDV) {
        this.id = id;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.idLoaiDV = idLoaiDV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(double giaDV) {
        this.giaDV = giaDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdLoaiDV() {
        return idLoaiDV;
    }

    public void setIdLoaiDV(int idLoaiDV) {
        this.idLoaiDV = idLoaiDV;
    }

}
