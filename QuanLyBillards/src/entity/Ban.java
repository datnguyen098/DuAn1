package entity;

public class Ban {

    private int ID;
    private double gia;
    private boolean trangThai;

    public Ban() {
    }

    public Ban(int ID, double gia, boolean trangThai) {
        this.ID = ID;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
