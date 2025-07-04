package ul;

import dao.BanDAO;
import dao.HoaDonDAO;
import entity.Ban;
import entity.HoaDon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import utils.Auth;
import utils.MsgBox;

public class BanJPanel extends javax.swing.JPanel implements ActionListener, Runnable {

    private static List<Ban> listB;
    private static JButton[] btn;
    private static boolean runTime = true;
    private Thread t;

    public BanJPanel() {
        initComponents();
        fillBan();

        t = new Thread(this);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu = new javax.swing.JPopupMenu();
        mnuChuyenBan = new javax.swing.JMenuItem();
        mnuBan = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlSuDung = new javax.swing.JPanel();
        pnlTrong = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlChinh = new javax.swing.JPanel();

        mnuChuyenBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_chuyen.png"))); // NOI18N
        mnuChuyenBan.setText("Chuyển Bàn");
        mnuChuyenBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChuyenBanActionPerformed(evt);
            }
        });
        jMenu.add(mnuChuyenBan);

        mnuBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_bida.png"))); // NOI18N
        mnuBan.setText("Quản Lý Bàn");
        mnuBan.setToolTipText("");
        mnuBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBanActionPerformed(evt);
            }
        });
        jMenu.add(mnuBan);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel3.setText("Bàn Đang Sử Dụng");

        pnlSuDung.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout pnlSuDungLayout = new javax.swing.GroupLayout(pnlSuDung);
        pnlSuDung.setLayout(pnlSuDungLayout);
        pnlSuDungLayout.setHorizontalGroup(
            pnlSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnlSuDungLayout.setVerticalGroup(
            pnlSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlTrong.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout pnlTrongLayout = new javax.swing.GroupLayout(pnlTrong);
        pnlTrong.setLayout(pnlTrongLayout);
        pnlTrongLayout.setHorizontalGroup(
            pnlTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnlTrongLayout.setVerticalGroup(
            pnlTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel2.setText("Bàn Trống");

        pnlChinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlChinhLayout = new javax.swing.GroupLayout(pnlChinh);
        pnlChinh.setLayout(pnlChinhLayout);
        pnlChinhLayout.setHorizontalGroup(
            pnlChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1304, Short.MAX_VALUE)
        );
        pnlChinhLayout.setVerticalGroup(
            pnlChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlChinh);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(pnlSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(460, 460, 460))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mnuChuyenBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChuyenBanActionPerformed
        ChuyenBanJFrame cb = new ChuyenBanJFrame();
        cb.setVisible(true);

//        t = new Thread(this);
//        t.start();
    }//GEN-LAST:event_mnuChuyenBanActionPerformed

    private void mnuBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBanActionPerformed
        BanJFrame b = new BanJFrame();
        b.setVisible(true);

//        t = new Thread(this);
//        t.start();
    }//GEN-LAST:event_mnuBanActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            jMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jMenu;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuBan;
    private javax.swing.JMenuItem mnuChuyenBan;
    private javax.swing.JPanel pnlChinh;
    private javax.swing.JPanel pnlSuDung;
    private javax.swing.JPanel pnlTrong;
    // End of variables declaration//GEN-END:variables

    public JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }

    private void fillBan() {
        BanDAO banD = new BanDAO();
        listB = banD.getAllBan();
        pnlChinh.setLayout(new GridLayout(5, 5, 40, 40));

        btn = new JButton[listB.size()];
        for (int i = 0; i < listB.size(); i++) {
            btn[i] = createButton(i + "");
            btn[i].setPreferredSize(new Dimension(200, 100));
            btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/banbida.jpg")));
            if (listB.get(i).isTrangThai()) {
                btn[i].setBackground(new Color(51, 255, 51));
            } else {
                btn[i].setBackground(new Color(255, 51, 51));
            }
            btn[i].setText(listB.get(i).getID() + "");
            btn[i].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            pnlChinh.add(btn[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < listB.size(); i++) {
            if (e.getActionCommand().equalsIgnoreCase(String.valueOf(listB.get(i).getID()))) {
                if (listB.get(i).isTrangThai()) {
                    if (MsgBox.confirm(this, "Bạn muốn mở bàn số " + listB.get(i).getID())) {
                        insert(listB.get(i).getID());
                        MsgBox.alert(this, "Mở bàn thành công");
                        System.out.println(listB.get(i).getID());
                        openBan(listB.get(i).getID());
                    } else {
                        MsgBox.alert(this, "Không mở bàn nữa !");
                    }
                } else {
                    openBan(listB.get(i).getID());
                }
            }
        }
//        t = new Thread(this);
//        t.start();
    }

    private void insert(int ID) {
        try {
            HoaDon hd = new HoaDon();

            hd.setNguoiTao(Auth.user.getTenNV());
            hd.setTenKhachHang("Khách Lạ");
            hd.setNgayTao(new Date());
            hd.setTongTien(0);
            hd.setTrangThai(false);
            hd.setIdBan(ID);
            hd.setIdKhachHang(1);
            hd.setIdNhanVien(Auth.user.getId());

            HoaDonDAO hdDAO = new HoaDonDAO();
            hdDAO.add(hd);
            updateTT(ID);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Insert thất bại");
        }
    }

    private void updateTT(int id) {
        Ban b = new Ban();
        b.setTrangThai(false);
        BanDAO banD = new BanDAO();
        banD.update(b, id);
    }

    private void openBan(int id) {
        ThanhToanJFrame tt = new ThanhToanJFrame(id);
        tt.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tt.setResizable(false);
        tt.setVisible(true);
    }

    @Override
    public void run() {
        while (runTime) {
            try {
                pnlChinh.removeAll();
                fillBan();
                updateUI();

                t.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t.start();
    }
}
