package ul;

import dao.NhanVienDAO;
import entity.NhanVien;
import java.awt.Color;
import utils.Auth;
import utils.HashingPass;
import utils.MsgBox;

public class DangNhapJDialog extends javax.swing.JDialog {

    private NhanVienDAO nvDAO = new NhanVienDAO();

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lblAnh = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new com.k33ptoo.components.KButton();
        lblQuen = new javax.swing.JLabel();
        lblAn = new javax.swing.JLabel();
        lblHien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 153, 153));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/male_user_50px.png"))); // NOI18N
        kGradientPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 53));

        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_25px.png"))); // NOI18N
        lblThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tên đăng nhập");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 30));

        txtTenDN.setBackground(new Color(0,0,0,0)
        );
        txtTenDN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(txtTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Mật Khẩu");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, 30));

        txtMatKhau.setBackground(new Color(0,0,0,0)
        );
        txtMatKhau.setToolTipText("");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 320, 30));

        btnDangNhap.setBorder(null);
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.setkBorderRadius(40);
        btnDangNhap.setkEndColor(new java.awt.Color(255, 153, 153));
        btnDangNhap.setkHoverColor(new java.awt.Color(0, 153, 153));
        btnDangNhap.setkHoverEndColor(new java.awt.Color(255, 153, 153));
        btnDangNhap.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnDangNhap.setkHoverStartColor(new java.awt.Color(255, 204, 204));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 122, -1));

        lblQuen.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblQuen.setForeground(new java.awt.Color(204, 204, 204));
        lblQuen.setText("Quên mật khẩu ?");
        lblQuen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblQuen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        lblAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        lblAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 30, 30));

        lblHien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        lblHien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHienMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblHien, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 30, 30));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnMouseClicked
        txtMatKhau.setEchoChar((char) 0);
        lblAn.setVisible(false);
        lblAn.setEnabled(false);
        lblHien.setEnabled(true);
        lblHien.setEnabled(true);
    }//GEN-LAST:event_lblAnMouseClicked

    private void lblHienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHienMouseClicked
        txtMatKhau.setEchoChar((char) 8226);
        lblAn.setVisible(true);
        lblAn.setEnabled(true);
        lblHien.setEnabled(false);
        lblHien.setEnabled(true);
    }//GEN-LAST:event_lblHienMouseClicked

    private void lblQuenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMouseClicked
        System.out.println("Chưa hoàn thiện");
    }//GEN-LAST:event_lblQuenMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
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
    private com.k33ptoo.components.KButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAn;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblHien;
    private javax.swing.JLabel lblQuen;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables

    private void dangNhap() {
        try {
            String tenDN = txtTenDN.getText();
            String matKhau = HashingPass.doHasing(new String(txtMatKhau.getPassword()));

            NhanVien nv = nvDAO.selectByTenDN(tenDN);

            if (nv == null) {
                MsgBox.alert(this, "Sai tên đăng nhập");
            } else if (!matKhau.equals(nv.getMatKhau())) {
                MsgBox.alert(this, "Sai mật khẩu");
                System.out.println(matKhau);
                System.out.println(nv.getMatKhau());
            } else {
                Auth.user = nv;
                MsgBox.alert(this, "Đăng nhập thành công");
                dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
