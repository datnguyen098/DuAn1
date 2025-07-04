package entity;

public class ChiTietHoaDon {

    private int id;
    private String tenDV;
    private double gia;
    private int soLuong, IDDichVu, IDHoaDon;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int id, String tenDV, double gia, int soLuong, int IDDichVu, int IDHoaDon) {
        this.id = id;
        this.tenDV = tenDV;
        this.gia = gia;
        this.soLuong = soLuong;
        this.IDDichVu = IDDichVu;
        this.IDHoaDon = IDHoaDon;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public double thanhTien() {
        return gia * soLuong;
    }
}
