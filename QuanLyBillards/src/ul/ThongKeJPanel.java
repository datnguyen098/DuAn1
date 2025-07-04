package ul;

import dao.ThongKeDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ThongKeJPanel extends javax.swing.JPanel {

    public ThongKeJPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdcNgayBD = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        pnlNgay = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdcNgayKT = new com.toedter.calendar.JDateChooser();
        btnTim = new javax.swing.JButton();
        pnlDichVu = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        pnlBan = new javax.swing.JPanel();

        pnlThang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tổng doanh thu");

        lblDoanhThu.setForeground(new java.awt.Color(255, 0, 51));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlThangLayout = new javax.swing.GroupLayout(pnlThang);
        pnlThang.setLayout(pnlThangLayout);
        pnlThangLayout.setHorizontalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThangLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel3)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(pnlThangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlThangLayout.setVerticalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel5.setText("Từ ngày:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        pnlNgay.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số lượng hoá đơn");

        lblHoaDon.setForeground(new java.awt.Color(255, 0, 51));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlNgayLayout = new javax.swing.GroupLayout(pnlNgay);
        pnlNgay.setLayout(pnlNgayLayout);
        pnlNgayLayout.setHorizontalGroup(
            pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlNgayLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnlNgayLayout.setVerticalGroup(
            pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel6.setText("Đến Ngày");

        btnTim.setText("Tìm Kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        pnlDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDichVu.setLayout(new java.awt.BorderLayout());

        pnlKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlKhachHang.setLayout(new java.awt.BorderLayout());

        pnlBan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlBan.setLayout(new javax.swing.BoxLayout(pnlBan, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(pnlNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(pnlThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(jdcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(38, 38, 38)
                        .addComponent(jdcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnTim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        timKiem();
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JDateChooser jdcNgayBD;
    private com.toedter.calendar.JDateChooser jdcNgayKT;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlDichVu;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlNgay;
    private javax.swing.JPanel pnlThang;
    // End of variables declaration//GEN-END:variables
    private void init() {
        // Hiện thị dịch vụ và doanh thu của ngày hôm nay
        fillThongTin();
        thongKeGioiTinh();
        thongKeDichVu();
        thongKeBan();
    }

    private void fillThongTin() {
        jdcNgayBD.setDate(new Date());
        jdcNgayKT.setDate(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(new Date());
        String ngayKT = sdf.format(new Date());
        int count = 0;
        double sum = 0;

        ThongKeDAO tkDAO = new ThongKeDAO();
        List<Object[]> list = tkDAO.getDoanhThuVaHoaDon(ngayBD, ngayKT);

        for (Object[] o : list) {
            int hoaDonCount = Integer.parseInt(o[0].toString());
            double doanhThu = Double.parseDouble(o[1].toString());

            count += hoaDonCount;
            sum += doanhThu;

        }
        lblHoaDon.setText(count + "");
        lblDoanhThu.setText(String.format("%.2f", sum));

    }

    private void timKiem() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(jdcNgayBD.getDate());
        String ngayKT = sdf.format(jdcNgayKT.getDate());
        int count = 0;
        double sum = 0;
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<Object[]> list = tkDAO.getDoanhThuVaHoaDon(ngayBD, ngayKT);
        for (Object[] o : list) {
            int hoaDonCount = Integer.parseInt(o[0].toString());
            double doanhThu = Double.parseDouble(o[1].toString());

            count += hoaDonCount;
            sum += doanhThu;

        }
        lblHoaDon.setText(count + "");
        lblDoanhThu.setText(String.format("%.2f", sum));

        thongKeBan();
        thongKeDichVu();
    }

    private void thongKeBan() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(jdcNgayBD.getDate());
        String ngayKT = sdf.format(jdcNgayKT.getDate());
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<Object[]> list = tkDAO.getBan(ngayBD, ngayKT);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object[] o : list) {
            String tenBan = "Bàn " + o[0];
            double tongTien = Double.parseDouble(o[2].toString());

            dataset.setValue(tongTien, "Doanh Thu", tenBan);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống Kê Doanh Thu Bàn",
                "Bàn",
                "Doanh Thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(300, 300)); // Thiết lập kích thước mong muốn

        pnlBan.removeAll();  // Xóa các thành phần cũ nếu có
        pnlBan.add(chartPanel, BorderLayout.CENTER); // Thêm ChartPanel vào pnlDichVu
        pnlBan.revalidate();  // Cập nhật giao diện người dùng
        pnlBan.repaint();     // Vẽ lại giao diện người dùng
    }

    private void thongKeDichVu() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(jdcNgayBD.getDate());
        String ngayKT = sdf.format(jdcNgayKT.getDate());
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<Object[]> list = tkDAO.getDichVu(ngayBD, ngayKT);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object[] o : list) {
            String tenDV = o[0].toString();
            double tongTien = Double.parseDouble(o[2].toString());

            dataset.setValue(tongTien, "Doanh Thu", tenDV);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống Kê Doanh Thu Dịch Vụ",
                "Dịch Vụ",
                "Doanh Thu",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(300, 300)); // Thiết lập kích thước mong muốn

        pnlDichVu.removeAll();  // Xóa các thành phần cũ nếu có
        pnlDichVu.add(chartPanel, BorderLayout.CENTER); // Thêm ChartPanel vào pnlDichVu
        pnlDichVu.revalidate();  // Cập nhật giao diện người dùng
        pnlDichVu.repaint();     // Vẽ lại giao diện người dùng
    }

    private void thongKeGioiTinh() {
        ThongKeDAO tkDAO = new ThongKeDAO();
        List<Object[]> list = tkDAO.getGioiTinh();

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Object[] o : list) {
            String gioiTinh = o[0].toString();
            int sl = Integer.parseInt(o[1].toString());
            dataset.setValue(gioiTinh, sl);
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Thống Kê Giới Tính Khách Hàng", // tiêu đề
                dataset, // dữ liệu
                true, // legend
                true, // tooltips
                false // URLs
        );
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", // Hiển thị tên, giá trị và phần trăm
                new java.text.DecimalFormat("0.00"),
                new java.text.DecimalFormat("0%")
        ));
        plot.setLabelBackgroundPaint(java.awt.Color.white); // Màu nền của nhãn
        plot.setLabelOutlinePaint(java.awt.Color.black);   // Đường viền của nhãn
        plot.setLabelShadowPaint(java.awt.Color.lightGray); // Bóng đổ của nhãn
        pnlKhachHang.add(new ChartPanel(pieChart));
    }

}
