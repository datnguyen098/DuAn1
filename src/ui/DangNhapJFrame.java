package ui;

import java.awt.Color;
import javax.swing.JOptionPane;
import DAO.DangNhapDAO;
import Entity.NhanVien;
import utils.Auth;
import utils.SendEmail;

public class DangNhapJFrame extends javax.swing.JFrame {

    public DangNhapJFrame() {
        //  super(parent, modal);
        initComponents();
        setEnabled(true);
        Color Blue = Color.decode("#3ABEF9");

        getContentPane().setBackground(Blue);
//yourButton.setBackground(techBlue);
        setLocationRelativeTo(null);
        txtTenDangNhap.setText("admin");
        pwdMatKhau.setText("admin123");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtTenDangNhap = new javax.swing.JTextField();
        pwdMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblAn = new javax.swing.JLabel();
        lblHien = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setEnabled(false);

        txtTenDangNhap.setBackground(new java.awt.Color(58, 190, 249));
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        pwdMatKhau.setBackground(new java.awt.Color(58, 190, 249));
        pwdMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pwdMatKhau.setOpaque(true);

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jLabel4.setText("Quên Mật Khẩu?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        lblAn.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8_invisible_20px_1.png")); // NOI18N
        lblAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnMouseClicked(evt);
            }
        });

        lblHien.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8_eye_20px_1.png")); // NOI18N
        lblHien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHienMouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8-user-100.png")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8-name-24.png")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\key.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Đăng Nhập");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAn)))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(btnDangNhap)
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(pwdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblHien))
                    .addComponent(lblAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if (txtTenDangNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "không được để trống tên đăng nhập");
            return;
        }
        String matKhau = new String(pwdMatKhau.getPassword());
        if (matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "không được để trống mật khẩu");
            return;
        }
        String tenDangNhap = txtTenDangNhap.getText();
        NhanVien nhanVien = DangNhapDAO.Login(tenDangNhap, matKhau);
        if (nhanVien != null) {
            /// gán tên đăng nhập vào user
            Auth.user = nhanVien;
            if (Auth.isManager()) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tư cách admin");
                TrangChuJFrame trangChuJFrame = new TrangChuJFrame();
                trangChuJFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công với tư cách nhân viên");
                TrangChuJFrame trangChuJFrame = new TrangChuJFrame();
                trangChuJFrame.setVisible(true);
            }
            this.dispose();
        } else
            JOptionPane.showMessageDialog(this, "sai tài khoản hoặc mật khẩu");
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnMouseClicked
        pwdMatKhau.setEchoChar((char) 0);
        lblAn.setEnabled(false);
        lblAn.setVisible(false);
        lblHien.setVisible(true);
        lblHien.setEnabled(true);
    }//GEN-LAST:event_lblAnMouseClicked

    private void lblHienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHienMouseClicked
        pwdMatKhau.setEchoChar('*');
        lblHien.setEnabled(false);
        lblHien.setVisible(false);
        lblAn.setEnabled(true);
        lblAn.setVisible(true);
    }//GEN-LAST:event_lblHienMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Tạm Biệt");
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        nhapEmailVaGuiOTP();
    }//GEN-LAST:event_jLabel4MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJFrame dialog = new DangNhapJFrame();
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
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAn;
    private javax.swing.JLabel lblHien;
    private javax.swing.JPasswordField pwdMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
    private void nhapEmailVaGuiOTP() {
        String email = JOptionPane.showInputDialog(this, "Nhập email để nhận mã OTP:");

        if (email != null && !email.trim().isEmpty()) {
            // Tạo mã OTP
            String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

            // Gửi email
            try {
                SendEmail.sendEmail(email, "Mã OTP của bạn", "Mã xác nhận OTP: " + otp);
                JOptionPane.showMessageDialog(this, "Đã gửi mã OTP đến email: " + email);
                EnterEmailJDialog otpDialog = new EnterEmailJDialog(this, true, otp);
                otpDialog.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gửi thất bại: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập email hợp lệ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }
}
