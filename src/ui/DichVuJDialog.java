package ui;
import java.awt.Color;
import java.awt.Frame;
import DAO.DichVuDAO;
import DAO.ThanhToanDAO;
import Entity.DichVu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DichVuJDialog extends javax.swing.JDialog {
    private Frame parent;
    public DichVuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        Color Blue = Color.decode("#3ABEF9");
        getContentPane().setBackground(Blue);
        initComponents();
        // readDichVu();
        loadLoaiDichVu();
    }
     private void readDichVu() {
         String tenLoai = (String) cboLoaiDichVu.getSelectedItem();
        if (tenLoai != null) {
            List<DichVu> dichVulst = ThanhToanDAO.readDichVu(tenLoai);
            DefaultTableModel tblBangDV = (DefaultTableModel) this.tblBangDV.getModel();
            tblBangDV.setRowCount(0);
            for (DichVu dichVu : dichVulst) {
                tblBangDV.addRow(new Object[]{
                    dichVu.getTenDichVu(),
                    dichVu.getGia(),
                    dichVu.getSoLuong(),
                    dichVu.isTrangThai() ? "còn" : "Hết"
                });
            }
        }
   }

    public void loadLoaiDichVu() {
        List<String> loadLoaiDVlst = ThanhToanDAO.loadLoaiDichVu();
        cboLoaiDichVu.removeAllItems();
        for (String string : loadLoaiDVlst) {
            cboLoaiDichVu.addItem(string);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTDV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboLoaiDichVu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        rdoNB = new javax.swing.JRadioButton();
        rdoCB = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangDV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Dịch Vụ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Loại Dịch Vụ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Dịch vụ");

        cboLoaiDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiDichVuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Số Lượng");

        buttonGroup1.add(rdoNB);
        rdoNB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNB.setText("Hết");

        buttonGroup1.add(rdoCB);
        rdoCB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoCB.setText("Còn");
        rdoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCBActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Trạng Thái");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giá");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Loại Dich Vụ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTDV, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)
                        .addComponent(rdoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(330, 330, 330))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cboLoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCB)
                    .addComponent(jLabel5)
                    .addComponent(rdoNB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblBangDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên", "Giá", "Số Lượng", "Trạng Thái"
            }
        ));
        tblBangDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangDV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8-back-50.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(btnThem)
                .addGap(69, 69, 69)
                .addComponent(btnSua)
                .addGap(81, 81, 81)
                .addComponent(btnXoa)
                .addGap(83, 83, 83)
                .addComponent(btnLamMoi)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7)
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiDichVuActionPerformed
       readDichVu();
    }//GEN-LAST:event_cboLoaiDichVuActionPerformed

    private void rdoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoCBActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        LoaiDichVuJDialog loaidichvu = new LoaiDichVuJDialog(parent, rootPaneCheckingEnabled);
        loaidichvu.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ UI
        String tenDichVu = txtTDV.getText();
        double gia = Double.parseDouble(txtGia.getText());
        int soLuong = Integer.parseInt(txtSL.getText());
        boolean trangThai = rdoCB.isSelected();

// Lấy tên loại dịch vụ từ combobox (đây sẽ truyền vào WHERE trong SQL)
        String tenLoaiDichVu = (String) cboLoaiDichVu.getSelectedItem();

// Chuyển boolean trangThai thành 0 hoặc 1 để lưu DB
        int trangThaiInt = trangThai ? 1 : 0;

// Gọi hàm DAO thêm dịch vụ theo tên loại
        int ketQua = DichVuDAO.themDichVuTheoTenLoai(tenDichVu, gia, soLuong, trangThaiInt, tenLoaiDichVu    );

        if (ketQua > 0) {
            JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công");
            // Load lại danh sách
            this.readDichVu();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy loại dịch vụ hoặc thêm thất bại");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
     String TenDV = txtTDV.getText();
       int idDichVu = DichVuDAO.getIDByTenDichVu(TenDV);
        double giaMoi = Double.parseDouble(txtGia.getText());
        int soLuongMoi = Integer.parseInt(txtSL.getText());
        boolean trangThaiMoi = rdoCB.isSelected();
        String tenLoaiDichVu = (String) cboLoaiDichVu.getSelectedItem();

        int ketQua = DichVuDAO.suaDichVuTheoIDVaLoai(idDichVu, tenLoaiDichVu, giaMoi, soLuongMoi, trangThaiMoi);

        if (ketQua > 0) {
            JOptionPane.showMessageDialog(this, "Sửa dịch vụ thành công!");
            this.readDichVu();
        } 
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String TenDichVu = txtTDV.getText();
        if (TenDichVu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn người cần xóa");
            return;
        }
        int KetQua = DichVuDAO.DeleteDichVu(TenDichVu);
        if (KetQua == 1) {
            JOptionPane.showMessageDialog(this, "Da xoa thanh cong");
            // readDichVu();
        } else {
            JOptionPane.showMessageDialog(this, "Ban xoa that bai");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblBangDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangDVMouseClicked
        // TODO add your handling code here:
        int chonHang = tblBangDV.getSelectedRow();
        String TenDichVuChon = tblBangDV.getValueAt(chonHang, 0).toString();
        double GiaChon = Double.parseDouble(tblBangDV.getValueAt(chonHang, 1).toString());
        int SoLuongChon = Integer.parseInt(tblBangDV.getValueAt(chonHang, 2).toString());
        txtTDV.setText(TenDichVuChon);
        txtGia.setText(String.valueOf(GiaChon));
        txtSL.setText(String.valueOf(SoLuongChon));
    }//GEN-LAST:event_tblBangDVMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        TrangChuJFrame trangChu = new TrangChuJFrame();
        this.dispose();
        trangChu.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    
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
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DichVuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DichVuJDialog dialog = new DichVuJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiDichVu;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoCB;
    private javax.swing.JRadioButton rdoNB;
    private javax.swing.JTable tblBangDV;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTDV;
    // End of variables declaration//GEN-END:variables
}
