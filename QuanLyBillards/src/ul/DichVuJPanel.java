package ul;

import dao.*;
import entity.*;
import utils.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DichVuJPanel extends javax.swing.JPanel {

    private static List<LoaiDichVu> listLDV;
    private static List<DichVu> listDV;
    private static DichVuDAO dvDAO;
    private static LoaiDichVuDAO ldvDAO;
    private static DefaultTableModel model;
    private static int index = -1;

    public DichVuJPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu = new javax.swing.JPopupMenu();
        mnuResert = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbIDLoaiDV = new javax.swing.JComboBox<>();
        txtTenDV = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        btnThemLDV = new javax.swing.JButton();
        rdoCon = new javax.swing.JRadioButton();
        rdoHet = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        mnuResert.setText("Cập Nhật");
        mnuResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuResertActionPerformed(evt);
            }
        });
        jMenu.add(mnuResert);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Dịch Vụ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel2.setText("Loại Dịch Vụ:");

        jLabel3.setText("Tên Dịch Vụ:");

        jLabel4.setText("Giá:");

        jLabel5.setText("Số lượng:");

        jLabel6.setText("Trạng Thái");

        cbbIDLoaiDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbIDLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbIDLoaiDVActionPerformed(evt);
            }
        });

        btnThemLDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_32px.png"))); // NOI18N
        btnThemLDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLDVActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoCon);
        rdoCon.setText("Còn");

        buttonGroup1.add(rdoHet);
        rdoHet.setText("Hết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbbIDLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemLDV))
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoCon)
                        .addGap(30, 30, 30)
                        .addComponent(rdoHet)))
                .addGap(448, 448, 448))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbIDLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemLDV))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCon)
                    .addComponent(rdoHet)
                    .addComponent(jLabel6))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

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

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 527, Short.MAX_VALUE)
                        .addComponent(btnFirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrev)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(516, 516, 516))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbIDLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbIDLoaiDVActionPerformed
        index = cbbIDLoaiDV.getSelectedIndex();

        if (index == -1) {
            return;
        }

        LoaiDichVu ldv = listLDV.get(index);
        int idLDV = ldv.getId();
        fillTable(idLDV);
        clearCBB();
        updateStatus();
    }//GEN-LAST:event_cbbIDLoaiDVActionPerformed

    private void tblDichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMouseClicked
        if (evt.getClickCount() == 1) {
            index = tblDichVu.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblDichVuMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateForm() == true) {
            insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (validateForm() == true) {
            update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnThemLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLDVActionPerformed
        loaiDV();
    }//GEN-LAST:event_btnThemLDVActionPerformed

    private void mnuResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuResertActionPerformed
        fillCBB();
    }//GEN-LAST:event_mnuResertActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            jMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemLDV;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbIDLoaiDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuResert;
    private javax.swing.JRadioButton rdoCon;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
    private void init() {
        ldvDAO = new LoaiDichVuDAO();
        fillCBB();
        rdoCon.setSelected(true);
        updateStatus();
    }

    private void fillCBB() {
        cbbIDLoaiDV.removeAllItems();
        listLDV = ldvDAO.getAllLoaiDichVu();
        for (LoaiDichVu ldv : listLDV) {
            cbbIDLoaiDV.addItem(ldv.getTenLoaiDV());
        }
    }

    private void fillTable(int idLDV) {
        dvDAO = new DichVuDAO();
        listDV = dvDAO.getAllDichVu(idLDV);

        model = new DefaultTableModel();
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

    private void updateStatus() {
        // Kiểm tra xem có dòng nào được chọn không
        boolean edit = (tblDichVu.getSelectedRow() >= 0);
        boolean first = (tblDichVu.getSelectedRow() == 0);
        boolean last = (tblDichVu.getSelectedRow() == tblDichVu.getRowCount() - 1);

        // Trạng thái form
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

        // Trạng thái điều hướng
        btnPrev.setEnabled(edit && !first);
        btnFirst.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    private void edit() {
        dvDAO = new DichVuDAO();
        int id = Integer.parseInt(tblDichVu.getValueAt(index, 0).toString());
        DichVu dv = dvDAO.selectByID(id);
        setForm(dv);
        tblDichVu.setRowSelectionInterval(index, index);
        updateStatus();

        txtTenDV.setText(tblDichVu.getValueAt(index, 1).toString());
        txtGia.setText(tblDichVu.getValueAt(index, 2).toString());
        txtSoLuong.setText(tblDichVu.getValueAt(index, 3).toString());
        rdoCon.setText(tblDichVu.getValueAt(index, 4).toString());
    }

    private void setForm(DichVu dv) {
        txtTenDV.setText(dv.getTenDV());
        txtGia.setText(String.valueOf(dv.getGiaDV()));
        txtSoLuong.setText(String.valueOf(dv.getSoLuong()));
        rdoCon.setSelected(dv.isTrangThai());
        rdoHet.setSelected(!dv.isTrangThai());
    }

    private DichVu getForm() {
        try {
            DichVu dv = new DichVu();
            dv.setTenDV(txtTenDV.getText().trim());
            dv.setGiaDV(Double.parseDouble(txtGia.getText().trim()));
            dv.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
            dv.setTrangThai(rdoCon.isSelected());
            index = cbbIDLoaiDV.getSelectedIndex();
            LoaiDichVu ldv = listLDV.get(index);
            dv.setIdLoaiDV(ldv.getId());
            return dv;
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Có lỗi xảy ra khi lấy dữ liệu từ form.");
            return null;
        }
    }

    private void insert() {
        index = cbbIDLoaiDV.getSelectedIndex();
        LoaiDichVu ldv = listLDV.get(index);
        try {
            dvDAO = new DichVuDAO();
            DichVu dv = getForm();
            try {
                dvDAO.add(dv);
                fillTable(ldv.getId());
                clear();
                MsgBox.alert(this, "Thêm dịch vụ mới thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm dịch vụ mới  thất bại");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Có lỗi xảy ra khi lấy dữ liệu từ form.");
        }
    }

    private void update() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền cập nhật dịch vụ !");
        } else {
            index = cbbIDLoaiDV.getSelectedIndex();
            LoaiDichVu ldv = listLDV.get(index);
            int vitri = tblDichVu.getSelectedRow();
            int id = Integer.parseInt(tblDichVu.getValueAt(vitri, 0).toString());
            try {
                dvDAO = new DichVuDAO();
                DichVu dv = getForm();
                try {
                    dvDAO.update(dv, id);
                    fillTable(ldv.getId());
                    clear();
                    MsgBox.alert(this, "Cập nhật dịch vụ thành công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Cập nhât dịch vụ thất bại");
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Có lỗi xảy ra khi lấy dữ liệu từ form.");
            }
        }
    }

    private void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xoá dịch vụ !");
        } else {
            index = cbbIDLoaiDV.getSelectedIndex();
            LoaiDichVu ldv = listLDV.get(index);
            try {
                dvDAO = new DichVuDAO();
                int viTri = tblDichVu.getSelectedRow();
                int id = Integer.parseInt(tblDichVu.getValueAt(viTri, 0).toString());
                try {
                    int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dịch vụ này ?", "Xác nhận xoá", JOptionPane.YES_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        System.out.println(id);
                        dvDAO.delete(id);
                        fillTable(ldv.getId());
                        MsgBox.alert(this, "Xoá dịch vụ thành công");
                        clear();
                    } else {
                        MsgBox.alert(this, "Bạn không xoá dịch vụ nữa");
                    }
                } catch (Exception e) {
                    MsgBox.alert(this, "Xoá dịch vụ thất bại");
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Có lỗi xảy ra khi lấy dữ liệu từ form.");
            }
        }
    }

    private void clear() {
        cbbIDLoaiDV.setSelectedIndex(0);
        txtTenDV.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        rdoCon.isSelected();
        tblDichVu.clearSelection();

        index = -1;
        updateStatus();
    }

    private void clearCBB() {
        txtTenDV.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        rdoCon.setSelected(true);
        tblDichVu.clearSelection();

        index = -1;
        updateStatus();
    }

    private void first() {
        index = 0;
        edit();
    }

    private void prev() {
        if (index > 0) {
            index--;
            edit();
        }
    }

    private void next() {
        if (index < tblDichVu.getRowCount() - 1) {
            index++;
            edit();
        }
    }

    private void last() {
        index = tblDichVu.getRowCount() - 1;
        edit();
    }

    private void loaiDV() {
        DichVuJFrame dv = new DichVuJFrame();
        dv.setVisible(true);
        fillCBB();
    }

    private boolean validateForm() {
        // Kiểm tra Tên Dịch Vụ
        if (txtTenDV.getText().trim().isEmpty()) {
            MsgBox.alert(this, "Tên dịch vụ không được để trống !");
            return false;
        }

        if (txtGia.getText().trim().isEmpty()) {
            MsgBox.alert(this, "Giá không được để trống !");
            return false;
        }
        // Kiểm tra Giá
        try {
            double gia = Double.parseDouble(txtGia.getText());
            // Kiểm tra giá trị có âm không
            if (gia < 0) {
                MsgBox.alert(this, "Giá phải lớn hơn 0 !");
                return false;
            }
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Giá phải là một số hợp lệ !");
            return false;
        }

        if (txtSoLuong.getText().trim().isEmpty()) {
            MsgBox.alert(this, "Số lượng không được để trống !");
            return false;
        }

        // Kiểm tra Số Lượng
        try {
            int sl = Integer.parseInt(txtSoLuong.getText());
            if (sl < 0) {
                MsgBox.alert(this, "Số lượng phải lớn hơn 0 !");
                return false;
            }
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Số lượng phải là một số hợp lệ !");
            return false;
        }

        return true;
    }
}
