package entity;

public class LoaiDichVu {

    int id;
    String tenLoaiDV;

    public LoaiDichVu() {
    }

    public LoaiDichVu(int id, String tenLoaiDV) {
        this.id = id;
        this.tenLoaiDV = tenLoaiDV;
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
