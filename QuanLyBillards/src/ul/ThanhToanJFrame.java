package ul;

import entity.*;
import dao.*;

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
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;

public class ThanhToanJFrame extends javax.swing.JFrame {

    private static List<LoaiDichVu> listLDV;
    private static List<DichVu> listDV;
    private static List<KhachHang> listKH;
    private static List<ChiTietHoaDon> listCTHD;
    private static HoaDonDAO hdDAO;
    private static BanDAO banDAO;
    private static DefaultTableModel model;
    private static int index = -1;
    private static int idHD;
    private static int idB;

    public ThanhToanJFrame(int ID) {
        initComponents();
        init();
        fillThongTin(ID);

        if (lblTongTien.getText().equals("0.0 VND")) {
            btnThanhToan.setEnabled(false);
        } else {
            btnKetThuc.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu = new javax.swing.JPopupMenu();
        mnuXoa = new javax.swing.JMenuItem();
        jMeneKH = new javax.swing.JPopupMenu();
        mnuCapNhat = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbbLoaiDV = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblNguoiTao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSoBan = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblGioBD = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblGioKT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTongGioChoi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnKetThuc = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();

        mnuXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remove_32px.png"))); // NOI18N
        mnuXoa.setText("Xoá");
        mnuXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuXoaActionPerformed(evt);
            }
        });
        jMenu.add(mnuXoa);

        mnuCapNhat.setText("Cập Nhật");
        mnuCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCapNhatActionPerformed(evt);
            }
        });
        jMeneKH.add(mnuCapNhat);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        cbbLoaiDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiDVActionPerformed(evt);
            }
        });

        jLabel1.setText("Loại Dịch Vụ:");

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbbLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTHD);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Người Tạo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tên Khách Hàng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Ngày Tạo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Bàn:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Giờ Bắt Đầu:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Giờ Kết Thúc");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tổng giờ chơi:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tổng Tiền:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnKetThuc.setText("Kết Thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán & In Hoá Đơn");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(lblTongGioChoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGioBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGioKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(101, 101, 101)
                        .addComponent(lblSoBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55)
                        .addComponent(lblNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKetThuc)
                .addGap(56, 56, 56)
                .addComponent(btnThanhToan)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblGioBD, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblGioKT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTongGioChoi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKetThuc)
                    .addComponent(btnThanhToan))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhachHang);

        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });

        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_32px.png"))); // NOI18N
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemKH)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiDVActionPerformed
        index = cbbLoaiDV.getSelectedIndex();

        if (index == -1) {
            return;
        }

        LoaiDichVu ldv = listLDV.get(index);
        int idLDV = ldv.getId();
        fillTableDichVu(idLDV);
    }//GEN-LAST:event_cbbLoaiDVActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        insertDV();
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        btnKetThuc.setEnabled(false);
        ketThuc();
        btnThanhToan.setEnabled(true);
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        thanhToan();
        inBill();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        khachHang();
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            jMenu.show(this, evt.getX() + 50, evt.getY() + 50);
        }
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void mnuXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuXoaActionPerformed
        xoaDV();
    }//GEN-LAST:event_mnuXoaActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = tblKhachHang.getSelectedRow();
        if (evt.getClickCount() == 1) {
            lblTenKhachHang.setText(tblKhachHang.getValueAt(row, 1).toString());
            lblTenKhachHang.setToolTipText(tblKhachHang.getValueAt(row, 0).toString());
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        timKH();
    }//GEN-LAST:event_txtTimKeyPressed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            jMeneKH.show(jPanel4, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void mnuCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCapNhatActionPerformed
        fillKhachHang();
    }//GEN-LAST:event_mnuCapNhatActionPerformed

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
            java.util.logging.Logger.getLogger(ThanhToanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToanJFrame(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JComboBox<String> cbbLoaiDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jMeneKH;
    private javax.swing.JPopupMenu jMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGioBD;
    private javax.swing.JLabel lblGioKT;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblNguoiTao;
    private javax.swing.JLabel lblSoBan;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTongGioChoi;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JMenuItem mnuCapNhat;
    private javax.swing.JMenuItem mnuXoa;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

    private void init() {
        LoaiDichVuDAO ldvDAO = new LoaiDichVuDAO();
        listLDV = ldvDAO.getAllLoaiDichVu();

        fillCBB();
        fillKhachHang();
        tblKhachHang.setRowSelectionInterval(0, 0);
    }

    private void fillTableCTHD(int ID) {
        model = new DefaultTableModel();
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
        listCTHD = cthdDAO.getAllCTHDByID(ID);

        model.addColumn("Tên Dịch Vụ");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        model.addColumn("Thành Tiền");
        model.addColumn("ID Dịch Vụ");

        for (ChiTietHoaDon cthd : listCTHD) {
            model.addRow(new Object[]{cthd.getTenDV(), cthd.getGia(), cthd.getSoLuong(), cthd.thanhTien(), cthd.getIDDichVu()});
        }
        tblCTHD.setModel(model);
    }

    private void fillCBB() {
        cbbLoaiDV.removeAllItems();
        for (LoaiDichVu ldv : listLDV) {
            cbbLoaiDV.addItem(ldv.getTenLoaiDV());
        }
    }

    private void fillTableDichVu(int idLDV) {
        model = new DefaultTableModel();
        DichVuDAO dvDAO = new DichVuDAO();
        listDV = dvDAO.getAllDichVu(idLDV);

        model.addColumn("ID");
        model.addColumn("Tên Dịch Vụ");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        model.addColumn("Trạng Thái");

        for (DichVu dv : listDV) {
            model.addRow(new Object[]{dv.getId(), dv.getTenDV(), dv.getGiaDV(), dv.getSoLuong(), dv.isTrangThai() ? "Còn" : "Hết"});
        }
        tblDichVu.setModel(model);
    }

    private void fillKhachHang() {
        model = new DefaultTableModel();
        KhachHangDAO khDAO = new KhachHangDAO();
        listKH = khDAO.getAllKhachHang();

        model.addColumn("ID");
        model.addColumn("Tên Khách Hàng");
        model.addColumn("Số Điện Thoại");

        for (KhachHang kh : listKH) {
            model.addRow(new Object[]{kh.getId(), kh.getTenKH(), kh.getSoDienThoai()});
        }
        tblKhachHang.setModel(model);
    }

    private void fillThongTin(int ID) {
        hdDAO = new HoaDonDAO();
        HoaDon hd = hdDAO.selectByID(ID);
        idHD = hd.getId();
        idB = hd.getIdBan();
        lblNguoiTao.setText(Auth.user.getTenNV());
        int row = tblKhachHang.getSelectedRow();
        lblTenKhachHang.setText(tblKhachHang.getValueAt(index, 1).toString());
        lblTenKhachHang.setToolTipText(tblKhachHang.getValueAt(index, 0).toString());
        lblNgayTao.setText(hd.getNgayTao() + "");
        lblSoBan.setText(hd.getIdBan() + "");
        lblGioBD.setText(hd.getGioBatDau().toString());
        lblGioKT.setText(hd.getGioKetThuc().toString());
        lblTongGioChoi.setText(hd.getTongGioChoi() + " Phút");
        lblTongTien.setText(hd.getTongTien() + " VND");

        fillTableCTHD(Integer.parseInt(idHD + ""));
        if (tblCTHD.getRowCount() > 0) {
            tblCTHD.setRowSelectionInterval(0, 0);
        } else {
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setTenDV("Thuê Bàn");
            cthd.setGia(0);
            cthd.setSoLuong(1);
            cthd.setIDDichVu(1002);
            cthd.setIDHoaDon(idHD);
            ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
            cthdDAO.add(cthd);
            fillTableCTHD(Integer.parseInt(idHD + ""));
            tblCTHD.setRowSelectionInterval(0, 0);
        }
    }

    private boolean check() {
        int row = tblDichVu.getSelectedRow();
        int IDDichVu = Integer.parseInt(tblDichVu.getValueAt(row, 0).toString());
        ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
        listCTHD = cthdDAO.getCTHDByDichVu(idHD, IDDichVu);
        for (ChiTietHoaDon cthd : listCTHD) {
            if (IDDichVu == cthd.getIDDichVu()) {
                return true;
            }
        }
        return false;
    }

    private void insertDV() {
        int row = tblDichVu.getSelectedRow();
        int IDDichVu = Integer.parseInt(tblDichVu.getValueAt(row, 0).toString());

        try {
            ChiTietHoaDon cthd = new ChiTietHoaDon();

            cthd.setTenDV(tblDichVu.getValueAt(row, 1).toString());
            int sl = Integer.parseInt(MsgBox.prompt(this, "Mời bạn nhập số lượng"));
            cthd.setSoLuong(sl);
            cthd.setGia(Double.parseDouble(tblDichVu.getValueAt(row, 2).toString()));
            cthd.setIDDichVu(IDDichVu);
            cthd.setIDHoaDon(idHD);

            ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

            if (check() == true) {
                cthdDAO.updateTang(sl, IDDichVu, idHD);
            } else {
                cthdDAO.add(cthd);
            }

            MsgBox.alert(this, "Thêm dịch vụ thành công");
            fillTableCTHD(idHD);
            tblCTHD.setRowSelectionInterval(0, 0);

            try {
                DichVuDAO dvDAO = new DichVuDAO();
                dvDAO.updateGiam(sl, IDDichVu);
                fillCBB();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Không thêm dịch vụ nữa");
        }
    }

    private void xoaDV() {
        int row = tblCTHD.getSelectedRow();
        int IDDichVu = Integer.parseInt(tblCTHD.getValueAt(row, 4).toString());

        try {
            ChiTietHoaDon cthd = new ChiTietHoaDon();

            int sl = Integer.parseInt(MsgBox.prompt(this, "Mời bạn nhập số lượng:"));
            cthd.setSoLuong(sl);

            ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
            cthdDAO.updateGiam(sl, IDDichVu, idHD);

            MsgBox.alert(this, "Xoá dịch vụ thành công");
            fillTableCTHD(idHD);
            tblCTHD.setRowSelectionInterval(0, 0);

            try {
                DichVuDAO dvDAO = new DichVuDAO();
                dvDAO.updateTang(sl, IDDichVu);
                fillCBB();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Không xoá dịch vụ nữa");
        }
    }

    private void ketThuc() {
//        MsgBox.alert(this, idHD + " ");
        Date d = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String gioKT = sdf2.format(d);
        lblGioKT.setText(gioKT);
        hdDAO = new HoaDonDAO();
        hdDAO.updateGioKT(gioKT, idHD);
        hdDAO.updateTongGioChoi(idHD);
        hdDAO.updateTongTien(idHD);
        tt();
    }

    private void tt() {
        hdDAO = new HoaDonDAO();
        HoaDon hd = hdDAO.selectByID(idB);
        lblTongGioChoi.setText(hd.getTongGioChoi() + " Phút");
        lblTongTien.setText(hd.getTongTien() + " VND");
    }

    private void updateTT(int id) {
        Ban b = new Ban();
        b.setTrangThai(false);
        banDAO = new BanDAO();
        banDAO.update(b, id);
    }

    private void thanhToan() {
        try {
            String tenKH = lblTenKhachHang.getText();
            int IDKH = Integer.parseInt(lblTenKhachHang.getToolTipText());
            hdDAO = new HoaDonDAO();
            hdDAO.updateThanhToan(tenKH, IDKH, idHD);
            banDAO = new BanDAO();
            banDAO.updateTT(idHD);

            MsgBox.alert(this, "Thanh toán thành công");
            this.dispose();
        } catch (Exception e) {
            MsgBox.alert(this, "Thanh toán thất bại");
            e.printStackTrace();
        }
    }

    private void khachHang() {
        KhachHangJFrame kh = new KhachHangJFrame();
        kh.setVisible(true);
        fillKhachHang();
    }

    private void xoa() {
        int row = tblCTHD.getSelectedRow();
        try {
            try {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dịch vụ này ?", "Xác nhận xoá", JOptionPane.YES_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    ChiTietHoaDonDAO cthddao = new ChiTietHoaDonDAO();
                    cthddao.delete(idHD, tblCTHD.getValueAt(row, 0).toString());
                    MsgBox.alert(this, "Xoá dịch vụ thành công");
                } else {
                    MsgBox.alert(this, "Bạn không xoá dịch vụ nữa");
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Xoá dịch vụ thất bại");
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    private void timKH() {
        try {
            model = new DefaultTableModel();
            KhachHangDAO khDAO = new KhachHangDAO();
            listKH = khDAO.getKhachHang("%" + txtTim.getText() + "%", "%" + txtTim.getText() + "%");

            model.addColumn("ID");
            model.addColumn("Tên Khách Hàng");
            model.addColumn("Số Điện Thoại");

            for (KhachHang kh : listKH) {
                model.addRow(new Object[]{kh.getId(), kh.getTenKH(), kh.getSoDienThoai()});
            }
            tblKhachHang.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inBill() {
        String fontPath = "src\\font\\UTM Swiss 721 Black Condensed.ttf";
        BaseFont baseFont = null;
        try {
            baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }

        // Tạo Font sử dụng BaseFont vừa tạo
        Font vietnameseFont = new Font(baseFont, 12, Font.NORMAL);
        // tạo một document
        Document document = new Document();
        try {
            Random random = new Random();
            int rd = random.nextInt(999999);
            String filePath = "src\\Bill\\bill" + rd + ".pdf"; // Lưu đường dẫn tệp
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Paragraph p = new Paragraph("Hoá Đơn", new Font(baseFont, 20, Font.NORMAL));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph("Người Tạo: " + lblNguoiTao.getText(), vietnameseFont));
            document.add(new Paragraph("Tên Khách Hàng: " + lblTenKhachHang.getText(), vietnameseFont));
            document.add(new Paragraph("Ngày Tạo: " + lblNguoiTao.getText(), vietnameseFont));
            document.add(new Paragraph("Bàn: " + idB, vietnameseFont));
            document.add(new Paragraph("Giờ Bắt Đầu: " + lblGioBD.getText(), vietnameseFont));
            document.add(new Paragraph("Giờ Kết Thúc: " + lblGioKT.getText(), vietnameseFont));
            document.add(new Paragraph("Tổng Giờ Chơi: " + lblTongGioChoi.getText(), vietnameseFont));
            document.add(new Paragraph("Tổng Tiền: " + lblTongTien.getText(), vietnameseFont));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
            document.add(new Paragraph(" "));

            PdfPTable itemsTable = new PdfPTable(4);
            itemsTable.addCell(new PdfPCell(new Phrase("Tên Dịch Vụ", vietnameseFont)));
            itemsTable.addCell(new PdfPCell(new Phrase("Giá", vietnameseFont)));
            itemsTable.addCell(new PdfPCell(new Phrase("Số Lương", vietnameseFont)));
            itemsTable.addCell(new PdfPCell(new Phrase("Thành Tiền", vietnameseFont)));

            int rowCount = tblCTHD.getRowCount();
            if (rowCount > 0) {
                for (int i = 0; i < rowCount; i++) {
                    try {
                        String tenDV = tblCTHD.getValueAt(i + 1, 0).toString();
                        double gia = Double.parseDouble(tblCTHD.getValueAt(i, 1).toString());
                        int soLuong = Integer.parseInt(tblCTHD.getValueAt(i, 2).toString());
                        double thanhTien = Double.parseDouble(tblCTHD.getValueAt(i, 3).toString());

                        itemsTable.addCell(new PdfPCell(new Phrase(tenDV, vietnameseFont)));
                        itemsTable.addCell(new PdfPCell(new Phrase(String.valueOf(gia), vietnameseFont)));
                        itemsTable.addCell(new PdfPCell(new Phrase(String.valueOf(soLuong), vietnameseFont)));
                        itemsTable.addCell(new PdfPCell(new Phrase(String.valueOf(thanhTien), vietnameseFont)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            document.add(itemsTable);
            document.add(new Paragraph(" "));
            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
            Paragraph p2 = new Paragraph("***Cảm Ơn Quý Khách***", new Font(baseFont, 20, Font.NORMAL));
            p2.setAlignment(Element.ALIGN_CENTER);
            document.add(p2);
            MsgBox.alert(this, "Tạo Hoá Đơn Thành Công");

            document.close();
            File pdfFile = new File(filePath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop không được hỗ trợ trên hệ thống này.");
                }
            } else {
                System.out.println("Tệp không tồn tại: " + filePath);
            }
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
