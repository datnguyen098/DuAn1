package entity;

import java.util.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class HoaDon {

    private int id;
    private String nguoiTao, tenKhachHang;
    private Date ngayTao;
    private Time GioBatDau;
    private Time GioKetThuc;
    private int tongGioChoi;
    private double tongTien;
    private boolean trangThai;
    private int idBan, idKhachHang, idNhanVien;

    public HoaDon() {
    }

    public HoaDon(int id, String nguoiTao, String tenKhachHang, Date ngayTao, Time GioBatDau, Time GioKetThuc, int tongGioChoi, double tongTien, boolean trangThai, int idBan, int idKhachHang, int idNhanVien) {
        this.id = id;
        this.nguoiTao = nguoiTao;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.GioBatDau = GioBatDau;
        this.GioKetThuc = GioKetThuc;
        this.tongGioChoi = tongGioChoi;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.idBan = idBan;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Time getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(Time GioBatDau) {
        this.GioBatDau = GioBatDau;
    }

    public Time getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(Time GioKetThuc) {
        this.GioKetThuc = GioKetThuc;
    }

    public int getTongGioChoi() {
        return tongGioChoi;
    }
    
    Set<String> hashSet = new HashSet<String>();
    
    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

}
