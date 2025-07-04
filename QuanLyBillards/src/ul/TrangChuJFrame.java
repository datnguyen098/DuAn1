package ul;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.Auth;
//import utils.XImage;

public class TrangChuJFrame extends javax.swing.JFrame {

    public TrangChuJFrame() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlText = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnlBan = new javax.swing.JPanel();
        lblBan = new javax.swing.JLabel();
        pnlHoaDon = new javax.swing.JPanel();
        lblThanhToan = new javax.swing.JLabel();
        pnlNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        pnlDichVu = new javax.swing.JPanel();
        lblDichVu = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        lblKhachHang = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        pnlDangXuat = new javax.swing.JPanel();
        lblDangXuat = new javax.swing.JLabel();
        pnlDoiMatKhau = new javax.swing.JPanel();
        lblDoiMatKhau = new javax.swing.JLabel();
        pnlChinh = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần Mềm Quản Lý Billards");
        setPreferredSize(new java.awt.Dimension(1500, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlText.setBackground(new java.awt.Color(255, 153, 153));
        pnlText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlTextMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Phần Mềm Quản Lý Billiards");

        javax.swing.GroupLayout pnlTextLayout = new javax.swing.GroupLayout(pnlText);
        pnlText.setLayout(pnlTextLayout);
        pnlTextLayout.setHorizontalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlTextLayout.setVerticalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(pnlText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        pnlMenu.setBackground(new java.awt.Color(255, 204, 204));

        pnlBan.setBackground(new java.awt.Color(255, 204, 204));
        pnlBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBanMouseEntered(evt);
            }
        });

        lblBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_bida8.png"))); // NOI18N
        lblBan.setText("Quản Lý Bàn");
        lblBan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblBan)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBanLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblBan)
                .addGap(15, 15, 15))
        );

        pnlHoaDon.setBackground(new java.awt.Color(255, 204, 204));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseEntered(evt);
            }
        });

        lblThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/invoice_32px.png"))); // NOI18N
        lblThanhToan.setText("Quản Lý Hoá Đơn");
        lblThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThanhToanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblThanhToan)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblThanhToan)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        pnlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlNhanVienMouseEntered(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_nhanvien.png"))); // NOI18N
        lblNhanVien.setText("Quản Lý Nhân Viên");
        lblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblNhanVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblNhanVien)
                .addGap(15, 15, 15))
        );

        pnlDichVu.setBackground(new java.awt.Color(255, 204, 204));
        pnlDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDichVuMouseEntered(evt);
            }
        });

        lblDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_dichvu.png"))); // NOI18N
        lblDichVu.setText("Quản Lý Dịch Vụ");
        lblDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDichVuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDichVuLayout = new javax.swing.GroupLayout(pnlDichVu);
        pnlDichVu.setLayout(pnlDichVuLayout);
        pnlDichVuLayout.setHorizontalGroup(
            pnlDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDichVuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblDichVu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDichVuLayout.setVerticalGroup(
            pnlDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDichVuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDichVu)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        pnlKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlKhachHangMouseEntered(evt);
            }
        });

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_khachhang.png"))); // NOI18N
        lblKhachHang.setText("Quản Lý Khách Hàng");
        lblKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblKhachHang)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lblKhachHang)
                .addGap(15, 15, 15))
        );

        pnlThongKe.setBackground(new java.awt.Color(255, 204, 204));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseEntered(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/chart_32px.png"))); // NOI18N
        lblThongKe.setText("Thống Kê");
        lblThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblThongKe)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblThongKe)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlDangXuat.setBackground(new java.awt.Color(255, 204, 204));
        pnlDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDangXuatMouseEntered(evt);
            }
        });

        lblDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout Rounded_32px.png"))); // NOI18N
        lblDangXuat.setText("Đăng Xuất");
        lblDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDangXuatLayout = new javax.swing.GroupLayout(pnlDangXuat);
        pnlDangXuat.setLayout(pnlDangXuatLayout);
        pnlDangXuatLayout.setHorizontalGroup(
            pnlDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangXuatLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDangXuatLayout.setVerticalGroup(
            pnlDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangXuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDangXuat)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlDoiMatKhau.setBackground(new java.awt.Color(255, 204, 204));
        pnlDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDoiMatKhauMouseEntered(evt);
            }
        });

        lblDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/password_reset_32px.png"))); // NOI18N
        lblDoiMatKhau.setText("Đổi Mật Khẩu");
        lblDoiMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDoiMatKhauLayout = new javax.swing.GroupLayout(pnlDoiMatKhau);
        pnlDoiMatKhau.setLayout(pnlDoiMatKhauLayout);
        pnlDoiMatKhauLayout.setHorizontalGroup(
            pnlDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiMatKhauLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblDoiMatKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDoiMatKhauLayout.setVerticalGroup(
            pnlDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiMatKhauLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblDoiMatKhau)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 300, 680));

        pnlChinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlChinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlChinhMouseEntered(evt);
            }
        });
        pnlChinh.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlChinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 1250, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBanMouseEntered
        onHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlBanMouseEntered

    private void pnlHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseEntered
        onHover(pnlHoaDon);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlHoaDonMouseEntered

    private void pnlDichVuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDichVuMouseEntered
        onHover(pnlDichVu);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlDichVuMouseEntered

    private void pnlKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhachHangMouseEntered
        onHover(pnlKhachHang);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlKhachHangMouseEntered

    private void pnlThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlThongKeMouseEntered
        onHover(pnlThongKe);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlThongKeMouseEntered

    private void pnlDangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDangXuatMouseEntered
        onHover(pnlDangXuat);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlDangXuatMouseEntered

    private void pnlNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNhanVienMouseEntered
        onHover(pnlNhanVien);
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlNhanVienMouseEntered

    private void pnlTextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTextMouseEntered
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlTextMouseEntered

    private void pnlChinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlChinhMouseEntered
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onLeaveHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlChinhMouseEntered

    private void lblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBanMouseClicked
        pnlChinh.removeAll();
        BanJPanel b = new BanJPanel();
        b.setLocation((pnlChinh.getWidth() - b.getWidth()) / 2, (pnlChinh.getHeight() - b.getHeight()) / 2);
        pnlChinh.add(b).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblBanMouseClicked

    private void lblThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThanhToanMouseClicked
        pnlChinh.removeAll();
        HoaDonJPanel hd = new HoaDonJPanel();
        hd.setLocation((pnlChinh.getWidth() - hd.getWidth()) / 2, (pnlChinh.getHeight() - hd.getHeight()) / 2);
        pnlChinh.add(hd).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblThanhToanMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        pnlChinh.removeAll();
        NhanVienJPanel nv = new NhanVienJPanel();
        nv.setLocation((pnlChinh.getWidth() - nv.getWidth()) / 2, (pnlChinh.getHeight() - nv.getHeight()) / 2);
        pnlChinh.add(nv).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDichVuMouseClicked
        pnlChinh.removeAll();
        DichVuJPanel dv = new DichVuJPanel();
        dv.setLocation((pnlChinh.getWidth() - dv.getWidth()) / 2, (pnlChinh.getHeight() - dv.getHeight()) / 2);
        pnlChinh.add(dv).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblDichVuMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        pnlChinh.removeAll();
        KhachHangJPanel kh = new KhachHangJPanel();
        kh.setLocation((pnlChinh.getWidth() - kh.getWidth()) / 2, (pnlChinh.getHeight() - kh.getHeight()) / 2);
        pnlChinh.add(kh).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        pnlChinh.removeAll();
        ThongKeJPanel tk = new ThongKeJPanel();
        tk.setLocation((pnlChinh.getWidth() - tk.getWidth()) / 2, (pnlChinh.getHeight() - tk.getHeight()) / 2);
        pnlChinh.add(tk).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        pnlChinh.removeAll();
        pnlChinh.repaint();
        pnlChinh.revalidate();

        Auth.clear();
        new DangNhapJDialog(this, true).setVisible(true);

        pnlChinh.removeAll();
        BanJPanel b = new BanJPanel();
        b.setLocation((pnlChinh.getWidth() - b.getWidth()) / 2, (pnlChinh.getHeight() - b.getHeight()) / 2);
        pnlChinh.add(b).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();

        if (!Auth.isManager()) {
            pnlBan.setVisible(true);
            pnlHoaDon.setVisible(true);
            pnlDangXuat.setVisible(true);

            pnlNhanVien.setVisible(false);
            pnlDichVu.setVisible(false);
            pnlKhachHang.setVisible(false);
            pnlThongKe.setVisible(false);
        }
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        pnlChinh.removeAll();
        DoiMatKhauJPanel dmk = new DoiMatKhauJPanel();
        dmk.setLocation((pnlChinh.getWidth() - dmk.getWidth()) / 2, (pnlChinh.getHeight() - dmk.getHeight()) / 2);
        pnlChinh.add(dmk).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();
    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    private void pnlDoiMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDoiMatKhauMouseEntered
        onLeaveHover(pnlBan);
        onLeaveHover(pnlHoaDon);
        onLeaveHover(pnlNhanVien);
        onLeaveHover(pnlDichVu);
        onLeaveHover(pnlKhachHang);
        onLeaveHover(pnlThongKe);
        onLeaveHover(pnlDangXuat);
        onHover(pnlDoiMatKhau);
    }//GEN-LAST:event_pnlDoiMatKhauMouseEntered

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlChinh;
    private javax.swing.JPanel pnlDangXuat;
    private javax.swing.JPanel pnlDichVu;
    private javax.swing.JPanel pnlDoiMatKhau;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlText;
    private javax.swing.JPanel pnlThongKe;
    // End of variables declaration//GEN-END:variables
    private void onHover(JPanel panel) {
        panel.setBackground(new Color(255, 153, 153));
    }

    private void onLeaveHover(JPanel panel) {
        panel.setBackground(new Color(255, 204, 204));
    }

    private void init() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setIconImage(XImage.getAppIcon());
        new DangNhapJDialog(this, true).setVisible(true);

        pnlChinh.removeAll();
        BanJPanel b = new BanJPanel();
        b.setLocation((pnlChinh.getWidth() - b.getWidth()) / 2, (pnlChinh.getHeight() - b.getHeight()) / 2);
        pnlChinh.add(b).setVisible(true);
        pnlChinh.repaint();
        pnlChinh.revalidate();

        if (!Auth.isManager()) {
            pnlBan.setVisible(true);
            pnlHoaDon.setVisible(true);
            pnlDangXuat.setVisible(true);

            pnlNhanVien.setVisible(false);
            pnlDichVu.setVisible(false);
            pnlKhachHang.setVisible(false);
            pnlThongKe.setVisible(false);
        }
    }
}
