package ui;
import DAO.NhanVienDAO;
import Entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class NhanVienJFrame extends javax.swing.JFrame {
    public NhanVienJFrame() {
        //super(parent, modal);
        initComponents();
          Color Blue = Color.decode("#3ABEF9");
        getContentPane().setBackground(Blue);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        readNhanVien();
    }
    public void readNhanVien(){
    List<NhanVien> nhanVienLst = NhanVienDAO.ReadNhanVien();
        DefaultTableModel tblBang = (DefaultTableModel) this.tblBang.getModel();
        tblBang.setRowCount(0);
        for (NhanVien nhanVien : nhanVienLst) {
            tblBang.addRow(new Object[]{
                nhanVien.getID(),
                nhanVien.getTenNhanVien(),
                nhanVien.getTenDangNhap(),
                nhanVien.getMatKhau(),
                nhanVien.isGioiTinh() ? "Nam" : "Nữ",
                nhanVien.getNgaySinh(),
                nhanVien.isVaiTro() ? "Quản lý" : "Nhân Viên",
                nhanVien.getSoDienThoai()

            });
        }}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTenNhanVien = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pwdMK = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        dteNS = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Nhân Viên", "Tên Đăng Nhập", "Mật Khẩu", "Giới Tính", "Ngày Sinh", "Vai Trò", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên Nhân Viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Đăng Nhập: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mật Khẩu:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Giới Tính:");

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Ngày Sinh:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Chức Vụ:");

        buttonGroup2.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNhanVien.setText("Nhân Viên");
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoQuanLy);
        rdoQuanLy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoQuanLy.setText("Quản Lý");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Số Điện Thoại:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
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

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Tìm Kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\DuAn1_QuanLyBia\\src\\icon\\icons8-back-50.png")); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(dteNS, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pwdMK, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(txtTenDangNhap))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pwdMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dteNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNhanVien)
                        .addComponent(rdoQuanLy)
                        .addComponent(jLabel7)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
            int row = tblBang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để sửa");
            return;
        }
        int id = Integer.parseInt(tblBang.getValueAt(row, 0).toString()); // lấy ID từ dòng

        String TenNhanVien = txtTenNhanVien.getText();
        String TenDangNhap = txtTenDangNhap.getText();
        String Mk = new String (pwdMK.getPassword());
        boolean VaiTro = rdoQuanLy.isSelected();
        boolean gioiTinh = rdoNam.isSelected();
        Date ngaySinh = dteNS.getDate();
        String sdt = txtSDT.getText();

        NhanVien nv = new NhanVien(TenNhanVien, TenDangNhap, Mk, gioiTinh, ngaySinh, VaiTro, sdt);
        int ketQua = NhanVienDAO.updateNhanVien(nv);
        if (ketQua > 0) {
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            readNhanVien();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Sửa  thất bại");
        }
        return;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        TrangChuJFrame trangChuJFrame = new TrangChuJFrame();
        this.dispose();
        trangChuJFrame.setVisible(true);
        DangNhapJFrame dangNhapJFrame = new DangNhapJFrame();
        dangNhapJFrame.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       if (dteNS.getDate() == null) {
           JOptionPane.showMessageDialog(rootPane, "vui lòng điền đầy đủ thông tin");
            return;
        }
        String TenNhanVien = txtTenNhanVien.getText();
            String TenDangNhap = txtTenDangNhap.getText();
            String MatKhau = new String(pwdMK.getPassword());
            boolean GioiTinh = rdoNam.isSelected();
            Date NgaySinh = dteNS.getDate();
            boolean VaiTro = rdoNhanVien.isSelected();
            String SoDienThoai = txtSDT.getText();
            if(TenDangNhap.isEmpty() || TenNhanVien.isEmpty() || !rdoNam.isSelected() && !rdoNu.isSelected() || SoDienThoai.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "vui lòng điền đầy đủ thông tin");
            return;
            }
           NhanVien nv = new NhanVien(WIDTH, TenNhanVien, TenDangNhap, MatKhau, GioiTinh, NgaySinh, VaiTro, SoDienThoai);
           int KetQua = NhanVienDAO.createNhanVien(nv);
           if (KetQua == 1) {
              this.readNhanVien();
              JOptionPane.showMessageDialog(this, "Thêm Thành Công");
               txtTenNhanVien.setText("");
        buttonGroup1.clearSelection();
        dteNS.setDate(null);
        txtSDT.setText("");
        tblBang.clearSelection();
        txtTenDangNhap.setText("");
        pwdMK.setText("");
        buttonGroup2.clearSelection();
        }else{
           JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
           }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
         int chonHang = tblBang.getSelectedRow();
        String TenNVChon = tblBang.getValueAt(chonHang, 1).toString();
        String TenDNChon = tblBang.getValueAt(chonHang, 2).toString();
        String MKChon = tblBang.getValueAt(chonHang,3).toString();
        String GioiTinh = tblBang.getValueAt(chonHang, 4).toString();
        String NgaySinh = tblBang.getValueAt(chonHang, 5).toString();
        String SDT = tblBang.getValueAt(chonHang, 7).toString();
        String VaiTro = tblBang.getValueAt(chonHang, 6).toString();
        txtTenNhanVien.setText(TenNVChon);
        txtTenDangNhap.setText(TenDNChon);
        txtSDT.setText(SDT);
        pwdMK.setText(MKChon);
         if (GioiTinh.equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
         if (VaiTro.equals("Quản lý")) {
            rdoQuanLy.setSelected(true);
        } else {
            rdoNhanVien.setSelected(true);
        }
         try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinh = sdf.parse(NgaySinh);
            dteNS.setDate(ngaySinh);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblBangMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  String TenNhanVien = JOptionPane.showInputDialog(this, "Nhập tên nv cần tìm:");
    if (TenNhanVien != null && !TenNhanVien.trim().isEmpty()) {
        List<NhanVien> list = NhanVienDAO.SearchNhanVien(TenNhanVien.trim());
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ

        for (NhanVien nv : list) {
            model.addRow(new Object[]{
                nv.getID(),
                nv.getTenNhanVien(),
                nv.getTenDangNhap(),
                nv.getMatKhau(),
                nv.isGioiTinh() ? "Nam" : "Nữ",
                nv.getNgaySinh(),
                nv.isVaiTro(),
                nv.getSoDienThoai()
            });
        }
    }      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
         txtTenNhanVien.setText("");
        buttonGroup1.clearSelection();
        dteNS.setDate(null);
        txtSDT.setText("");
        tblBang.clearSelection();
        txtTenDangNhap.setText("");
        pwdMK.setText("");
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       String TenNhanVien = txtTenNhanVien.getText();
        if(TenNhanVien.isEmpty()){
        JOptionPane.showMessageDialog(this, "Bạn chưa chọn người cần xóa");
        return;
        }
        int KetQua = NhanVienDAO.deleteNhanVien(TenNhanVien);
        if(KetQua == 1){
        JOptionPane.showMessageDialog(this, "Da xoa thanh cong");
        readNhanVien();
         txtTenNhanVien.setText("");
        buttonGroup1.clearSelection();
        dteNS.setDate(null);
        txtSDT.setText("");
        tblBang.clearSelection();
        txtTenDangNhap.setText("");
        pwdMK.setText("");
        buttonGroup2.clearSelection();
        }else{
        JOptionPane.showMessageDialog(this, "Ban xoa that bai");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienJFrame frame = new NhanVienJFrame();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser dteNS;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField pwdMK;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
