package ui;
import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.DichVuDAO;
import DAO.HoaDonDAO;
import DAO.ThanhToanDAO;
import Entity.Ban;
import Entity.ChiTietHoaDon;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.KhachHang;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Timer;
import java.sql.Timestamp;
import java.util.Random;


public class ThanhToanJDialog extends javax.swing.JDialog {

    private int IDBan;
    private static List<Ban> Banlst;
    //private int gio = 0, phut = 0, giay = 0;
    private Timer timer;
    //private static int IdHD;
    public ThanhToanJDialog(java.awt.Frame parent, boolean modal, int IDBan) {
        super(parent, modal);
        this.IDBan = IDBan;

        initComponents();
        HoaDon hoaDon = HoaDonDAO.readIDHD(IDBan);
        int idhd = hoaDon.getId();
        readCTHD(idhd);
        //createThueban(IDBan);
        Color Blue = Color.decode("#3ABEF9");
        getContentPane().setBackground(Blue);
        loadLoaiDichVu();
        readKhachHang();
        readHoaDon(IDBan);
        txtTongGioChoi.setEditable(false);
    }



    public void loadLoaiDichVu() {
        List<String> loadLoaiDVlst = ThanhToanDAO.loadLoaiDichVu();
        cboLoaiDichVu.removeAllItems();
        for (String string : loadLoaiDVlst) {
            cboLoaiDichVu.addItem(string);
        }
    }

    public void readLoaiDichVu() {
        String tenLoai = (String) cboLoaiDichVu.getSelectedItem();
        if (tenLoai != null) {
            List<DichVu> dichVulst = ThanhToanDAO.readDichVu(tenLoai);
            DefaultTableModel tblBangDV = (DefaultTableModel) this.tblBangDV.getModel();
            tblBangDV.setRowCount(0);
            for (DichVu dichVu : dichVulst) {
                tblBangDV.addRow(new Object[]{
                    dichVu.getID(),
                    dichVu.getTenDichVu(),
                    dichVu.getGia(),
                    dichVu.getSoLuong(),
                    dichVu.isTrangThai() ? "còn" : "Hết"
                });
            }
        }
    }

    public void readKhachHang() {
        List<KhachHang> khachHanglst = ThanhToanDAO.readKhachHang();

        DefaultTableModel tblBangKH = (DefaultTableModel) this.tblbangKH.getModel();
        for (KhachHang khachHang : khachHanglst) {
            tblBangKH.addRow(new Object[]{
                khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai()
            });
        }
    }

    public void readHoaDon(int ID) {
        HoaDon hoaDon = new HoaDon();
        hoaDon = ThanhToanDAO.readHoaDon(ID);
        txtNguoitao.setText(Auth.user.getTenNhanVien());
        txtTenKhachHang.setText(hoaDon.getTenKhachHang());
        txtNgayTao.setText(hoaDon.getNgayTao() + "");
        txtBan.setText(hoaDon.getIdBan() + "");
        txtTongTien.setText(hoaDon.getTongTien() + "");
        System.out.println(" tongtien: " + hoaDon.getTongTien());
        LocalDateTime gioBatDau = hoaDon.getGioBatDau();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedGioBatDau = gioBatDau.format(formatter);
        txtGiobatDau.setText(formattedGioBatDau);  // Gán chuỗi đã định dạng vào JTextField
// Lấy thời gian hiện tại làm GioKetThuc
       // LocalDateTime gioKetThuc = LocalDateTime.now();

        // Tính tổng giờ chơi
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime gioHienTai = LocalDateTime.now(); // giờ kết thúc tạm thời
                Duration duration = Duration.between(gioBatDau, gioHienTai);

                long totalSeconds = duration.getSeconds();
                int hours = (int) (totalSeconds / 3600);
                int minutes = (int) (totalSeconds % 3600) / 60;
                int seconds = ((int) totalSeconds % 60) + 1;

                String thoiGianChoi = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                txtTongGioChoi.setText(thoiGianChoi);
            }
        });
        timer.start(); // Bắt đầu đếm giờ

//        txtTongGioChoi.setText(hoaDon.getTongGioChoi() + "");
        txtTongTien.setText(hoaDon.getTongTien() + "");
        System.out.println(txtBan.getText());

    }

    public void readCTHD(int ID) {

        List<ChiTietHoaDon> CTHDlst = ChiTietHoaDonDAO.readChiTietHoaDon(ID);
        DefaultTableModel tblBangDVSD = (DefaultTableModel) this.tblBangDVSD.getModel();
        tblBangDVSD.setRowCount(0);

        for (ChiTietHoaDon chiTietHoaDon : CTHDlst) {
            tblBangDVSD.addRow(new Object[]{
                chiTietHoaDon.getTen(),
                chiTietHoaDon.getGia(),
                chiTietHoaDon.getSoLuong(),
                chiTietHoaDon.getThanhTien(),
                chiTietHoaDon.getIDDichVu()
            });
        }

    }

    public void InHoaDon() {
        // tạo đường dẫn cho font chữ
        String DuongDanFontChu = "src\\\\font\\\\UTM Swiss 721 Black Condensed.ttf";
        // tạo biến basefont có phạm vi toàn hàm
        BaseFont baseFont = null; //dùng để in tiềng việt và tùy chỉnh font chữ
        try {
            // identity cho phép sử dụng unicode
            // embedded nhúng file vào pdf để mọi máy hiển thị đều là font tiếng việt
            baseFont = BaseFont.createFont(DuongDanFontChu, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
        // tạo font chữ tiếng việt sử dụng basefont vừa tạo
        // Tạo một font chữ dùng trong toàn bộ tài liệu với cỡ chữ 12
        Font FontTiengViet = new Font(baseFont, 12, Font.NORMAL);
        Document document = new Document();
        try {
            // tạo một đối tượng doc mới mục đích tạo file mới
            Random rd = new Random();
            // sử dụng random từ 1 đến 999999 để tránh trùng lặp bill
            int SoBill = rd.nextInt(999999);
            // tạo tên file
            String TenFile = "src/Bill/bill" + SoBill + ".pdf";
            // tạo nơi để lưu file và tạo file nếu chưa có 
            // ghi nội dung pdf vào file
            PdfWriter.getInstance(document, new FileOutputStream(TenFile));
            document.open();

            Paragraph p = new Paragraph("Hoá Đơn Thanh Toán", new Font(baseFont, 20, Font.NORMAL));
            // chỉnh text về giữa
            p.setAlignment(Element.ALIGN_CENTER);
            // thêm text vào file
            document.add(p);
            Paragraph DiaChi = new Paragraph("Địa Chỉ: 118 Cát Bi, Hải An, Hải Phòng", new Font(baseFont, 15, Font.ITALIC));
            DiaChi.setAlignment(Element.ALIGN_CENTER);
            document.add(DiaChi);
            Paragraph SDT = new Paragraph("SĐT: 0857654879", new Font(baseFont, 15, Font.ITALIC));
            SDT.setAlignment(Element.ALIGN_CENTER);
            document.add(SDT);
            document.add(new Paragraph("Người Tạo Hóa Đơn: " + txtNguoitao.getText(), FontTiengViet));
            document.add(new Paragraph("Khách Hàng: " + txtTenKhachHang.getText(), FontTiengViet));
            document.add(new Paragraph("Số Bàn: " + IDBan, FontTiengViet));
            document.add(new Paragraph("Ngày Tạo Hóa Đơn: " + txtNgayTao.getText(), FontTiengViet));
            document.add(new Paragraph("Giờ Bắt Đầu: " + txtGiobatDau.getText(), FontTiengViet));
            document.add(new Paragraph("Giờ Kết Thúc: " + txtGioKetThuc.getText(), FontTiengViet));
            document.add(new Paragraph("Thời Gian Chơi: " + txtTongGioChoi.getText(), FontTiengViet));
            document.add(new Paragraph("Các Dịch Vụ Đã Sử Dụng: ", FontTiengViet));
            document.add(new Paragraph(" "));
            int SoDong = tblBangDVSD.getRowCount();
            // tạo bảng gồm 4 cột
            PdfPTable TenCot = new PdfPTable(4);
            TenCot.addCell(new PdfPCell(new Phrase("Tên Dịch Vụ", FontTiengViet)));
            TenCot.addCell(new PdfPCell(new Phrase("Giá", FontTiengViet)));
            TenCot.addCell(new PdfPCell(new Phrase("Số Lương", FontTiengViet)));
            TenCot.addCell(new PdfPCell(new Phrase("Thành Tiền", FontTiengViet)));
            for (int i = 0; i < SoDong; i++) {
                try {
                    String TenDichVu = tblBangDVSD.getValueAt(i, 0).toString();
                    String Gia = tblBangDVSD.getValueAt(i, 1).toString();
                    String SoLuong = tblBangDVSD.getValueAt(i, 2).toString();
                    String ThanhTien = tblBangDVSD.getValueAt(i, 3).toString();
                    // add từng dòng vào bảng
                    TenCot.addCell(new PdfPCell(new Phrase(TenDichVu, FontTiengViet)));
                    TenCot.addCell(new PdfPCell(new Phrase(Gia, FontTiengViet)));
                    TenCot.addCell(new PdfPCell(new Phrase(SoLuong, FontTiengViet)));
                    TenCot.addCell(new PdfPCell(new Phrase(ThanhTien, FontTiengViet)));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            document.add(TenCot);
            document.add(new Paragraph(" "));
            Paragraph TongTien = new Paragraph("Tổng Tiền: " + txtTongTien.getText(), FontTiengViet);
            TongTien.setAlignment(Element.ALIGN_RIGHT);
            document.add(TongTien);
            Paragraph CamOn = new Paragraph("Cảm Ơn Quý Khách Đã Sử Dụng Dịch Vụ, Hẹn Gặp Lại!", FontTiengViet);
            CamOn.setAlignment(Element.ALIGN_CENTER);
            document.add(CamOn);
            document.close();
            File pdfFile = new File(TenFile);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop không được hỗ trợ trên hệ thống này.");
                }
            } else {
                System.out.println("Tệp không tồn tại: " + TenFile);
            }
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangDVSD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cboLoaiDichVu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblbangKH = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNguoitao = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtBan = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtGiobatDau = new javax.swing.JTextField();
        txtGioKetThuc = new javax.swing.JTextField();
        txtTongGioChoi = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnKetThuc = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các Dịch Vụ đang sử dụng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblBangDVSD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Dịch Vụ", "Giá ", "Số Lượng", "Thành Tiền", "ID Dịch Vụ"
            }
        ));
        jScrollPane1.setViewportView(tblBangDVSD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblBangDV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblBangDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Dịch Vu", "Tên Dịch Vụ", "Giá", "Số Lượng", "Trạng Thái"
            }
        ));
        tblBangDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangDVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangDV);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Loại Dịch Vụ");

        cboLoaiDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblbangKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Khách Hàng", "Số Điện Thoại"
            }
        ));
        tblbangKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangKHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblbangKH);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Người tạo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Bàn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày tạo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giờ bắt đầu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giờ két thúc");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tổng Giờ chơi");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tổng tiền");

        btnKetThuc.setText("Kết Thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(txtTongGioChoi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNguoitao)
                    .addComponent(txtBan)
                    .addComponent(txtGiobatDau)
                    .addComponent(txtGioKetThuc)
                    .addComponent(txtTongTien))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiobatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtGioKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTongGioChoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKetThuc)
                    .addComponent(btnThanhToan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        // Lấy giờ hiện tại
        LocalDateTime now = LocalDateTime.now();

        if (timer != null) {
            timer.stop();
        }

        String ThoiGianKetThuc = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String ThoiGianBatDau = txtGiobatDau.getText();
        txtGioKetThuc.setText(ThoiGianKetThuc);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date TGBatDau = null;

        Date TGKetThuc = null;
        try {
            TGBatDau = sdf.parse(ThoiGianBatDau);
            TGKetThuc = sdf.parse(ThoiGianKetThuc);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Timestamp timeBatDau = new Timestamp(TGBatDau.getTime());
        Timestamp timeKetThuc = new Timestamp(TGKetThuc.getTime());
        ThanhToanDAO thanhToan = new ThanhToanDAO();
        // lấy tong tiền trc khi bấm kết thúc
        double tongTien = Double.parseDouble(txtTongTien.getText());

        double giaBan = BanDAO.getBanByID(IDBan).getGia();
        double TongTien = thanhToan.TinhTienBan(timeBatDau, timeKetThuc, giaBan);

        // biến này lưu tông tiền của các loại dịch vụ
        double TongTienDichVu = TongTien + tongTien;

        HoaDon hoaDon = new HoaDon();
        hoaDon = ThanhToanDAO.readHoaDon(IDBan);
        int IDHD = hoaDon.getId();
        System.out.println("id hoa don: " + IDHD);
        int ketqua1 = HoaDonDAO.updateTongTien(TongTienDichVu, IDHD);
        if (ketqua1 == 1) {
            System.out.println("thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
        int ketqua = ChiTietHoaDonDAO.upDateThueBan(TongTien, IDHD);
        if (ketqua == 1) {
            List<ChiTietHoaDon> CTHDlst = ChiTietHoaDonDAO.readChiTietHoaDon(IDHD);
            DefaultTableModel tblBangDVSD = (DefaultTableModel) this.tblBangDVSD.getModel();
            tblBangDVSD.setRowCount(0);

            for (ChiTietHoaDon chiTietHoaDon : CTHDlst) {
                tblBangDVSD.addRow(new Object[]{
                    chiTietHoaDon.getTen(),
                    chiTietHoaDon.getGia(),
                    chiTietHoaDon.getSoLuong(),
                    chiTietHoaDon.getThanhTien(),
                    chiTietHoaDon.getIDDichVu()
                });
            }
        }
        // int ketqua = chitiethoadon.UpdateThanhTien(TongTienDichVu, IDHD);
        txtTongTien.setText(String.valueOf(TongTienDichVu));
        System.out.println("Tong tien: " + TongTien + "IDHD : " + IDHD);
//      if (ketqua > 0) {
//          
//          this.readCTHD(IDHD);
//       }

    }//GEN-LAST:event_btnKetThucActionPerformed

    private void cboLoaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiDichVuActionPerformed

        readLoaiDichVu();


    }//GEN-LAST:event_cboLoaiDichVuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String timKiem = txtTimKiem.getText();
        if (timKiem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập tên để tìm kiếm");
            return;
        }
        List<KhachHang> khachHanglst = ThanhToanDAO.SearchKhachHang(timKiem);
        DefaultTableModel tblBangKH = (DefaultTableModel) this.tblbangKH.getModel();
        tblBangKH.setRowCount(0);
        for (KhachHang khachHang : khachHanglst) {
            tblBangKH.addRow(new Object[]{
                khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai()
            });
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        double TongTien = Double.parseDouble(txtTongTien.getText());
        String GioBatDau = txtGiobatDau.getText();  // ví dụ: "2025-08-01 14:30:00"
        String GioKetThuc = txtGioKetThuc.getText();
// Format đúng với chuỗi GioBatDau
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime gioBatDau = LocalDateTime.parse(GioBatDau, formatter);
// format dugns với chuỗi tiwof bắt đầu
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime gioKetThuc = LocalDateTime.parse(GioKetThuc, formatter1);
// Tính thời gian chơi
        Duration duration = Duration.between(gioBatDau, gioKetThuc);
        long totalSeconds = duration.getSeconds();  // Tổng số giây
        int totalHours = (int) (totalSeconds / 3600);  // Chuyển đổi sang giờ (1 giờ = 3600 giây)
        int minutes = (int) (totalSeconds % 3600) / 60; // tính số phút chơi
        int seconds = (int) totalSeconds % 60;// tính số giây

        //  lưu dưới dạng chuỗi hh:mm:ss
        String thoiGianChoi = String.format("%02d:%02d:%02d", totalHours, minutes, seconds);
        java.sql.Time time = java.sql.Time.valueOf(thoiGianChoi);
        System.out.println("Giờ bắt đầu: " + gioBatDau);
        System.out.println("Giờ kết thúc: " + GioKetThuc);
        System.out.println("Tổng tiền: " + TongTien);
        System.out.println("Tổng giờ chơi : " + time);
        HoaDon hoaDon = new HoaDon();
        hoaDon = ThanhToanDAO.readHoaDon(IDBan);
        int IDHD = hoaDon.getId();
        HoaDon hoadon = new HoaDon(IDHD, gioKetThuc, time, TongTien, IDBan);
        if (txtGioKetThuc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn nút 'Kết Thúc' trước khi thanh toán!");
            return;
        }

        int ketqua = HoaDonDAO.UpdateHD(hoadon);
        int ketqua1 = BanDAO.UpdateTrangThai(IDBan);
        if (ketqua == 1 && ketqua1 == 1) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");

        }
        this.dispose();
        InHoaDon();
//        Window parent = SwingUtilities.getWindowAncestor(this);
//        BanJDialog dialog = new BanJDialog((Frame) parent, true);
//        dialog.setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblbangKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangKHMouseClicked
        int soHang = tblbangKH.getSelectedRow();
        String TenKhachHang = tblbangKH.getValueAt(soHang, 0).toString();
        String SoDienThoai = tblbangKH.getValueAt(soHang, 1).toString();
        txtTenKhachHang.setText(TenKhachHang);

    }//GEN-LAST:event_tblbangKHMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//      KhachHangJDialog khachHang = new KhachHangJDialog(this, rootPaneCheckingEnabled);
//      khachHang.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblBangDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangDVMouseClicked

        int soHang = tblBangDV.getSelectedRow();
        int IDDichVu = Integer.parseInt(tblBangDV.getValueAt(soHang, 0).toString());
        String TenDichVu = tblBangDV.getValueAt(soHang, 1).toString();
        double Gia = Double.parseDouble(tblBangDV.getValueAt(soHang, 2).toString());
        int SoLuong = Integer.parseInt(tblBangDV.getValueAt(soHang, 3).toString());
        String nhap = JOptionPane.showInputDialog("vui lòng nhập số lượng");
        int SoLuongNhap = Integer.parseInt(nhap);
        if (SoLuongNhap > SoLuong) {
            JOptionPane.showMessageDialog(this, "số lượng bạn nhập vượt quá số lượng trong kho vui lòng liên hệ quản lý");
            return;
        }

        HoaDon hoaDon = new HoaDon();
        // tạo chi tiet hoa don moi de luu dịch vụ
        hoaDon = ThanhToanDAO.readHoaDon(IDBan);
        int IDHD = hoaDon.getId();
        SoLuong = SoLuong - SoLuongNhap;
        double GiaReadBang = Gia * SoLuongNhap;
        double TongTien = Double.parseDouble(txtTongTien.getText());
        double thanhTien = TongTien + GiaReadBang;
        txtTongTien.setText(String.valueOf(thanhTien));

        hoaDon = ThanhToanDAO.readHoaDon(IDBan);

        System.out.println("id hoa don: " + IDHD);
        int ketqua1 = HoaDonDAO.updateTongTien(thanhTien, IDHD);
        //  int ketqua2 = DichVuDAO.capNhatTrangThaiDichVu(TenDichVu);
        this.readLoaiDichVu();

        if (ketqua1 == 1) {
            System.out.println("thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
        //ChiTietHoaDonDAO chitiethoadon = new ChiTietHoaDonDAO();
//        int ketqua1 = chitiethoadon.UpdateThanhTien(thanhTien, IDHD);
//        if (ketqua1 == 1) {
//            System.out.println("Thành Công");
//        }
        ChiTietHoaDon hdct = new ChiTietHoaDon();
        hdct.setTen(TenDichVu);
        hdct.setGia(Gia);
        hdct.setSoLuong(SoLuongNhap);
        hdct.setThanhTien(GiaReadBang);
        hdct.setIDDichVu(IDDichVu);
        hdct.setIDHoaDon(IDHD);
        ChiTietHoaDonDAO CTHDDAO = new ChiTietHoaDonDAO();
        CTHDDAO.createHDCT(hdct);

        System.out.println("idhd: " + IDHD);
        this.readCTHD(IDHD);
        // update lại số lượng dihcj vụ trong kho
        int ketqua = DichVuDAO.UpDateGiamSoLuongDV(SoLuongNhap, IDDichVu);
        int ketqua2 = DichVuDAO.capNhatTrangThaiDichVu(TenDichVu);
        if (ketqua2 == 1) {
            System.out.println("Thành Công");
        }
        String tenLoai = (String) cboLoaiDichVu.getSelectedItem();
        if (tenLoai != null) {
            List<DichVu> dichVulst = ThanhToanDAO.readDichVu(tenLoai);
            DefaultTableModel tblBangDV = (DefaultTableModel) this.tblBangDV.getModel();
            tblBangDV.setRowCount(0);
            for (DichVu dichVu : dichVulst) {
                tblBangDV.addRow(new Object[]{
                    dichVu.getID(),
                    dichVu.getTenDichVu(),
                    dichVu.getGia(),
                    dichVu.getSoLuong(),
                    dichVu.isTrangThai() ? "còn" : "Hết"
                });
            }
        }
    }//GEN-LAST:event_tblBangDVMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cboLoaiDichVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBangDV;
    private javax.swing.JTable tblBangDVSD;
    private javax.swing.JTable tblbangKH;
    private javax.swing.JTextField txtBan;
    private javax.swing.JTextField txtGioKetThuc;
    private javax.swing.JTextField txtGiobatDau;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoitao;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongGioChoi;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
