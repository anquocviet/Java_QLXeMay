//package gui;
//
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.border.TitledBorder;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//import dao.CanCuocCongDan_DAO;
//import dao.HopDong_DAO;
//import dao.KhachHang_DAO;
//import dao.LoaiXe_DAO;
//import dao.NhanVien_DAO;
//import dao.XeMay_DAO;
//import entity.CanCuocCongDan;
//import entity.HopDong;
//import entity.HopDongTraGop;
//import entity.KhachHang;
//import entity.NhanVien;
//import entity.PhuongThucThanhToan;
//import entity.XeMay;
//
//import java.awt.List;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.text.DecimalFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//
//import javax.swing.JRadioButton;
//import java.awt.Choice;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.border.EtchedBorder;
//import javax.swing.ImageIcon;
//import javax.swing.border.LineBorder;
//import javax.swing.JCheckBox;
//import javax.swing.JScrollBar;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.JButton;
//import javax.swing.JSplitPane;
//import java.awt.Component;
//import javax.swing.Box;
//import javax.swing.JScrollPane;
//
//public class GUI_QLBanXe extends JPanel implements ActionListener, MouseListener, KeyListener {
//	private JTextField txtTenKH;
//	private JTextField txtCCCD;
//	private JTextField txtTenXe;
//	private JTextField txtSoKhung;
//	private JTextField txtGia;
//	private JTable tableKH;
//	private JTable tableChonXe;
//	private JTable tableXe;
//	private JTextField txtThanhTien;
//	private JTextField txtMaNV;
//	private JTextField txtNgayLapHD;
//	private JTextField txtThoiGianBaoHanh;
//	private JTextField txtTienDaNhan;
//	private JTextField txtConNo;
//	private JTextField txtNguoiTra;
//	private JTextField txtMaNVNhan;
//	private JTextField txtNgayTra;
//	private JTextField txtSoTienTraGop;
//	private JButton btnChonKhach;
//	private JButton btnLuu;
//	private JButton btnThem;
//	private KhachHang_DAO kh_dao;
//	private DefaultTableModel tableModelKH;
//	private CanCuocCongDan_DAO cccd_dao;
//	private XeMay_DAO xe_dao;
//	private DefaultTableModel tableModelXe;
//	private DefaultTableModel tableModelChonXe;
//	private JLabel lbAnhXe;
//	private LoaiXe_DAO loaiXe_dao;
//	private JComboBox cbLoaiXe;
//	private JComboBox cbMauXe;
//	private JComboBox cbSoPhanKhoi;
//	private JCheckBox chckbxDongXe;
//	private JComboBox cbHangXe;
//	private JComboBox cbPTThanhToan;
//	private JComboBox cbMaTraGop;
//	private HopDong_DAO hopDong_dao;
//	private JComboBox cbMaHopDong;
//	private JComboBox cbSoLanTra;
//	private NhanVien_DAO nv_dao;
//	private PhuongThucThanhToan TRAHET = PhuongThucThanhToan.TRAHET;
//
//	/**
//	 * Create the panel.
//	 */
//	public GUI_QLBanXe() {
//		setLayout(null);
//
//		JLabel lbTitle = new JLabel("QUẢN LÝ BÁN HÀNG");
//		lbTitle.setForeground(new Color(64, 128, 128));
//		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		lbTitle.setBounds(0, 0, 1200, 60);
//		add(lbTitle);
//
//		JPanel pnInfoKH = new JPanel();
//		pnInfoKH.setBorder(new TitledBorder(
//				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
//				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null,
//				new Color(64, 128, 128)));
//		pnInfoKH.setBounds(0, 70, 600, 130);
//		add(pnInfoKH);
//		pnInfoKH.setLayout(null);
//
//		JLabel lbTenKH = new JLabel("Tên khách hàng :");
//		lbTenKH.setBounds(10, 52, 108, 20);
//		pnInfoKH.add(lbTenKH);
//
//		txtTenKH = new JTextField();
//		txtTenKH.setEditable(false);
//		txtTenKH.setBounds(130, 52, 150, 20);
//		pnInfoKH.add(txtTenKH);
//		txtTenKH.setColumns(10);
//
//		JLabel lbCCCD = new JLabel("CCCD :");
//		lbCCCD.setBounds(10, 20, 90, 20);
//		pnInfoKH.add(lbCCCD);
//
//		txtCCCD = new JTextField();
//		txtCCCD.setColumns(10);
//		txtCCCD.setBounds(130, 20, 150, 20);
//		pnInfoKH.add(txtCCCD);
//
//		JScrollPane scrPaneKH = new JScrollPane();
//		scrPaneKH.setBounds(292, 22, 302, 102);
//		pnInfoKH.add(scrPaneKH);
//
//		tableModelKH = new DefaultTableModel(new String[] { "T\u00EAn kh\u00E1ch h\u00E0ng", "CCCD" }, 0);
//		tableKH = new JTable(tableModelKH);
//		tableKH.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		tableKH.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
//		scrPaneKH.setViewportView(tableKH);
//		tableKH.setToolTipText("");
//
//		JButton btnChonKhach = new JButton("Chọn khách");
//		btnChonKhach.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnChonKhach.setBackground(new Color(64, 128, 128));
//		btnChonKhach.setBounds(60, 80, 171, 32);
//		pnInfoKH.add(btnChonKhach);
//
//		JPanel pnHoaDon = new JPanel();
//		pnHoaDon.setBorder(new TitledBorder(
//				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
//				"H\u1EE3p \u0111\u1ED3ng", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 128, 128)));
//		pnHoaDon.setBounds(0, 210, 600, 402);
//		add(pnHoaDon);
//		pnHoaDon.setLayout(null);
//
//		JLabel lbMaHD = new JLabel("Mã hợp đồng");
//		lbMaHD.setBounds(10, 29, 100, 20);
//		pnHoaDon.add(lbMaHD);
//
//		JScrollPane scrXe = new JScrollPane();
//		scrXe.setBounds(10, 202, 580, 110);
//		pnHoaDon.add(scrXe);
//
//		tableModelXe = new DefaultTableModel(new String[] { "T\u00EAn xe", "S\u1ED1 khung", "Số máy", "Gi\u00E1" }, 0);
//		tableXe = new JTable(tableModelXe);
//		scrXe.setViewportView(tableXe);
//
//		JLabel lbThanhTien = new JLabel("Thành tiền :");
//		lbThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lbThanhTien.setBounds(30, 324, 106, 30);
//		pnHoaDon.add(lbThanhTien);
//
//		txtThanhTien = new JTextField();
//		txtThanhTien.setText("0");
//		txtThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		txtThanhTien.setEnabled(false);
//		txtThanhTien.setBounds(146, 330, 149, 20);
//		pnHoaDon.add(txtThanhTien);
//		txtThanhTien.setColumns(10);
//
//		JButton btnLuu = new JButton("In hợp đồng");
//		btnLuu.setBackground(new Color(64, 128, 128));
//		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnLuu.setBounds(371, 358, 177, 34);
//		pnHoaDon.add(btnLuu);
//
//		JLabel lbPTThanhToan = new JLabel("Chọn cách thức thanh toán :");
//		lbPTThanhToan.setBounds(10, 60, 184, 20);
//		pnHoaDon.add(lbPTThanhToan);
//
//		cbPTThanhToan = new JComboBox();
//		cbPTThanhToan.setModel(new DefaultComboBoxModel(new String[] { "Trả hết", "Trả góp" }));
//		cbPTThanhToan.setBounds(192, 61, 103, 20);
//		pnHoaDon.add(cbPTThanhToan);
//
//		JLabel lbMaNV = new JLabel("Nhân viên lập HĐ:");
//		lbMaNV.setBounds(10, 92, 149, 20);
//		pnHoaDon.add(lbMaNV);
//
//		txtMaNV = new JTextField();
//		txtMaNV.setBounds(160, 92, 135, 20);
//		pnHoaDon.add(txtMaNV);
//		txtMaNV.setColumns(10);
//
//		JLabel lbNgayLapHD = new JLabel("Ngày lập hợp đồng:");
//		lbNgayLapHD.setBounds(10, 122, 138, 20);
//		pnHoaDon.add(lbNgayLapHD);
//
//		txtNgayLapHD = new JTextField();
//		txtNgayLapHD.setEditable(false);
//		txtNgayLapHD.setBounds(160, 122, 135, 20);
//		pnHoaDon.add(txtNgayLapHD);
//		txtNgayLapHD.setColumns(10);
//
//		JLabel lbThoiGianBaoHanh = new JLabel("Thời gian bảo hành:");
//		lbThoiGianBaoHanh.setBounds(10, 152, 138, 20);
//		pnHoaDon.add(lbThoiGianBaoHanh);
//
//		txtThoiGianBaoHanh = new JTextField();
//		txtThoiGianBaoHanh.setBounds(160, 152, 135, 20);
//		pnHoaDon.add(txtThoiGianBaoHanh);
//		txtThoiGianBaoHanh.setColumns(10);
//
//		JLabel lbTienDaNhan = new JLabel("Đã nhận :");
//		lbTienDaNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lbTienDaNhan.setBounds(316, 324, 100, 30);
//		pnHoaDon.add(lbTienDaNhan);
//
//		txtTienDaNhan = new JTextField();
//		txtTienDaNhan.setForeground(Color.GRAY);
//		txtTienDaNhan.setEditable(false);
//		txtTienDaNhan.setText("0");
//		txtTienDaNhan.setBounds(420, 330, 149, 20);
//		pnHoaDon.add(txtTienDaNhan);
//		txtTienDaNhan.setColumns(10);
//
//		JLabel lbConNo = new JLabel("Còn nợ :");
//		lbConNo.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lbConNo.setBounds(30, 360, 106, 30);
//		pnHoaDon.add(lbConNo);
//
//		txtConNo = new JTextField();
//		txtConNo.setText("0");
//		txtConNo.setEnabled(false);
//		txtConNo.setBounds(146, 368, 149, 20);
//		pnHoaDon.add(txtConNo);
//		txtConNo.setColumns(10);
//
//		JPanel pnTraGop = new JPanel();
//		pnTraGop.setLayout(null);
//		pnTraGop.setForeground(new Color(64, 128, 128));
//		pnTraGop.setBorder(
//				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Chi ti\u1EBFt thanh to\u00E1n",
//						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 128, 128)));
//		pnTraGop.setBounds(319, 10, 250, 190);
//		pnHoaDon.add(pnTraGop);
//
//		JLabel lbMaTraGop = new JLabel("Mã trả");
//		lbMaTraGop.setBounds(10, 14, 90, 20);
//		pnTraGop.add(lbMaTraGop);
//
//		JLabel lbTenNguoiTra = new JLabel("Người trả :");
//		lbTenNguoiTra.setBounds(10, 44, 109, 20);
//		pnTraGop.add(lbTenNguoiTra);
//
//		txtNguoiTra = new JTextField();
//		txtNguoiTra.setColumns(10);
//		txtNguoiTra.setBounds(119, 44, 122, 20);
//		pnTraGop.add(txtNguoiTra);
//
//		JLabel lbMaNVNhan = new JLabel("Nhân viên nhận :");
//		lbMaNVNhan.setBounds(10, 74, 115, 20);
//		pnTraGop.add(lbMaNVNhan);
//
//		txtMaNVNhan = new JTextField();
//		txtMaNVNhan.setColumns(10);
//		txtMaNVNhan.setBounds(119, 74, 122, 20);
//		pnTraGop.add(txtMaNVNhan);
//
//		JLabel lbNgayTra = new JLabel("Ngày trả :");
//		lbNgayTra.setBounds(10, 104, 110, 20);
//		pnTraGop.add(lbNgayTra);
//
//		JLabel lbSoLanTra = new JLabel("Số lần trả :");
//		lbSoLanTra.setBounds(10, 134, 110, 20);
//		pnTraGop.add(lbSoLanTra);
//
//		txtNgayTra = new JTextField();
//		txtNgayTra.setColumns(10);
//		txtNgayTra.setBounds(119, 104, 122, 20);
//		pnTraGop.add(txtNgayTra);
//
//		JLabel lbSoTienTraGop = new JLabel("Số tiền trả:");
//		lbSoTienTraGop.setBounds(10, 164, 102, 20);
//		pnTraGop.add(lbSoTienTraGop);
//
//		txtSoTienTraGop = new JTextField();
//		txtSoTienTraGop.setBounds(131, 164, 110, 20);
//		pnTraGop.add(txtSoTienTraGop);
//		txtSoTienTraGop.setColumns(10);
//
//		cbMaTraGop = new JComboBox();
//		cbMaTraGop.setBounds(119, 12, 122, 27);
//		pnTraGop.add(cbMaTraGop);
//
//		cbSoLanTra = new JComboBox();
//		cbSoLanTra.setBounds(119, 132, 122, 27);
//		cbSoLanTra.addItem(1);
//		cbSoLanTra.addItem(2);
//		cbSoLanTra.addItem(3);
//		pnTraGop.add(cbSoLanTra);
//
//		cbMaHopDong = new JComboBox();
//		cbMaHopDong.setBounds(160, 27, 135, 27);
//		pnHoaDon.add(cbMaHopDong);
//
//		JPanel pnInfoXe = new JPanel();
//		pnInfoXe.setBorder(new TitledBorder(
//				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
//				"Th\u00F4ng tin Xe", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(64, 128, 128)));
//		pnInfoXe.setBounds(612, 70, 567, 542);
//		add(pnInfoXe);
//		pnInfoXe.setLayout(null);
//
//		JPanel pnTxtXe = new JPanel();
//		pnTxtXe.setBounds(10, 335, 244, 197);
//		pnInfoXe.add(pnTxtXe);
//		pnTxtXe.setLayout(null);
//
//		JLabel lbTenXe = new JLabel("Tên xe :");
//		lbTenXe.setBounds(12, 10, 78, 20);
//		pnTxtXe.add(lbTenXe);
//
//		txtTenXe = new JTextField();
//		txtTenXe.setBounds(100, 10, 131, 20);
//		txtTenXe.setColumns(10);
//		pnTxtXe.add(txtTenXe);
//
//		JLabel lbLoaiXe = new JLabel("Loại xe :");
//		lbLoaiXe.setBounds(12, 40, 78, 20);
//		pnTxtXe.add(lbLoaiXe);
//
//		cbLoaiXe = new JComboBox();
//		cbLoaiXe.setModel(new DefaultComboBoxModel(new String[] { "--Tất cả--" }));
//		cbLoaiXe.setBounds(100, 40, 131, 20);
//		pnTxtXe.add(cbLoaiXe);
//
//		JLabel lbMauXe = new JLabel("Màu xe :");
//		lbMauXe.setBounds(12, 70, 78, 20);
//		pnTxtXe.add(lbMauXe);
//
//		cbSoPhanKhoi = new JComboBox();
//		cbSoPhanKhoi.setModel(new DefaultComboBoxModel(new String[] { "--Tất cả--" }));
//		cbSoPhanKhoi.setBounds(100, 100, 131, 20);
//		pnTxtXe.add(cbSoPhanKhoi);
//
//		JLabel lbSoPhanKhoi = new JLabel("Số phân khối :");
//		lbSoPhanKhoi.setBounds(12, 100, 93, 20);
//		pnTxtXe.add(lbSoPhanKhoi);
//
//		cbMauXe = new JComboBox();
//		cbMauXe.setModel(new DefaultComboBoxModel(new String[] { "--Tất cả--" }));
//		cbMauXe.setBounds(100, 70, 130, 20);
//		pnTxtXe.add(cbMauXe);
//
//		JLabel lbDongXe = new JLabel("Dòng xe :");
//		lbDongXe.setBounds(12, 160, 78, 20);
//		pnTxtXe.add(lbDongXe);
//
//		chckbxDongXe = new JCheckBox("Tiết kiệm xăng");
//		chckbxDongXe.setBounds(100, 160, 131, 20);
//		chckbxDongXe.setHorizontalAlignment(SwingConstants.CENTER);
//		pnTxtXe.add(chckbxDongXe);
//
//		JLabel lbHangXe = new JLabel("Hãng xe :");
//		lbHangXe.setBounds(12, 130, 78, 20);
//		pnTxtXe.add(lbHangXe);
//
//		cbHangXe = new JComboBox();
//		cbHangXe.setModel(new DefaultComboBoxModel(new String[] { "--Tất cả--" }));
//		cbHangXe.setBounds(100, 130, 131, 20);
//		pnTxtXe.add(cbHangXe);
//
//		JPanel pnAnhVaGia = new JPanel();
//		pnAnhVaGia.setBounds(10, 21, 547, 303);
//		pnInfoXe.add(pnAnhVaGia);
//		pnAnhVaGia.setLayout(null);
//
//		lbAnhXe = new JLabel("");
//		lbAnhXe.setBounds(0, 5, 547, 266);
//		pnAnhVaGia.add(lbAnhXe);
//
//		JLabel lbSoKhung = new JLabel("Số khung :");
//		lbSoKhung.setBounds(10, 280, 70, 20);
//		pnAnhVaGia.add(lbSoKhung);
//
//		txtSoKhung = new JTextField();
//		txtSoKhung.setEnabled(false);
//		txtSoKhung.setBounds(80, 281, 151, 20);
//		pnAnhVaGia.add(txtSoKhung);
//		txtSoKhung.setColumns(10);
//
//		JLabel lbGia = new JLabel("Giá :");
//		lbGia.setBounds(245, 280, 45, 20);
//		pnAnhVaGia.add(lbGia);
//
//		txtGia = new JTextField();
//		txtGia.setEnabled(false);
//		txtGia.setBounds(280, 281, 96, 20);
//		pnAnhVaGia.add(txtGia);
//		txtGia.setColumns(10);
//
//		btnThem = new JButton("Thêm vào giỏ hàng");
//		btnThem.setBackground(new Color(64, 128, 128));
//		btnThem.setBounds(393, 281, 154, 21);
//		pnAnhVaGia.add(btnThem);
//
//		JPanel pnTableChonXe = new JPanel();
//		pnTableChonXe.setBounds(264, 335, 293, 197);
//		pnInfoXe.add(pnTableChonXe);
//		pnTableChonXe.setLayout(null);
//
//		JScrollPane scrPaneChonXe = new JScrollPane();
//		scrPaneChonXe.setBounds(10, 10, 273, 177);
//		pnTableChonXe.add(scrPaneChonXe);
//
//		tableModelChonXe = new DefaultTableModel(
//				new String[] { "M\u00E3 lo\u1EA1i", "T\u00EAn xe", "S\u1ED1 khung", "Gi\u00E1" }, 0);
//		tableChonXe = new JTable(tableModelChonXe);
//		tableChonXe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrPaneChonXe.setViewportView(tableChonXe);
//		tableChonXe.setBackground(Color.LIGHT_GRAY);
//
//		kh_dao = new KhachHang_DAO();
//		cccd_dao = new CanCuocCongDan_DAO();
//		xe_dao = new XeMay_DAO();
//		loaiXe_dao = new LoaiXe_DAO();
//		hopDong_dao = new HopDong_DAO();
//		nv_dao = new NhanVien_DAO();
//
//		generateMaHD();
//		generateMaTG();
//		getNgayHienTai(txtNgayLapHD);
//		getNgayHienTai(txtNgayTra);
//		loadDSMaHopDongVaoComboBox();
//		loadDSKhachHang();
//		loadDSXe();
//
//		txtCCCD.addKeyListener(this);
//		txtMaNV.addKeyListener(this);
//		txtMaNVNhan.addKeyListener(this);
//		txtSoTienTraGop.addKeyListener(this);
//		tableKH.addMouseListener(this);
//		tableChonXe.addMouseListener(this);
//		cbMaHopDong.addActionListener(this);
//		cbMauXe.addActionListener(this);
//		cbLoaiXe.addActionListener(this);
//		cbSoPhanKhoi.addActionListener(this);
//		cbHangXe.addActionListener(this);
//		btnThem.addActionListener(this);
//	}
//
//	public void generateMaHD() {
//		String maHD = "HD";
//		LocalDate ngayHT = LocalDate.now();
//		int slHDTrongNgay = hopDong_dao.countHopDongInDate(ngayHT);
//		DecimalFormat df = new DecimalFormat("00");
//		maHD += df.format(++slHDTrongNgay);
//		maHD += ngayHT.format(DateTimeFormatter.ofPattern("ddMMyy"));
//		cbMaHopDong.addItem(maHD);
//	}
//
//	public void generateMaTG() {
//		String maTG = "TG";
//		LocalDate ngayHT = LocalDate.now();
//		int slLuotTGTrongNgay = hopDong_dao.countLuotTraGopTrongNgay(ngayHT);
//		DecimalFormat df = new DecimalFormat("00");
//		maTG += df.format(++slLuotTGTrongNgay);
//		maTG += ngayHT.format(DateTimeFormatter.ofPattern("ddMMyy"));
//		cbMaTraGop.addItem(maTG);
//	}
//
//	public void getNgayHienTai(JTextField jtext) {
//		LocalDate ngayHT = LocalDate.now();
//		jtext.setText(ngayHT.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//	}
//
//	public void loadDSMaHopDongVaoComboBox() {
//		hopDong_dao.getAllListHopDong().forEach(hd -> {
//			cbMaHopDong.addItem(hd.getSoHopDong());
//		});
//	}
//
//	public void loadDSKhachHang() {
//		kh_dao.getAllKhachHang().forEach(kh -> {
//			String maCCCD = kh.getCccd().getMaCCCD();
//			CanCuocCongDan cccd = cccd_dao.getCCCDTheoMa(maCCCD);
//			String ten = String.format("%s %s %s", cccd.getHo(), cccd.getHoDem(), cccd.getTen());
//			tableModelKH.addRow(new Object[] { ten, maCCCD });
//		});
//	}
//
//	public void loadDSXe() {
//		DecimalFormat df = new DecimalFormat("#,###,###,##0.##");
//		xe_dao.getAllXeMayConTrongKho().forEach(xe -> {
//			tableModelChonXe.addRow(new Object[] { xe.getLoaiXe().getMaLoaiXe(), xe.getTenXe(), xe.getSoKhung(),
//					df.format(xe.getGia() + 0.1 * xe.getGia() + 0.05 * xe.getGia()), xe.getAnhMinhHoa() });
//		});
//		tableChonXe.setRowSelectionInterval(0, 0);
//		loadThongTinXe(0);
//		themDSLoaiXeVaoComboBox();
//		themDSMauXeVaoComboBox();
//		themDSSoPhanKhoiVaoComboBox();
//		themDSHangXeVaoComboBox();
//
//	}
//
//	private void themDSMauXeVaoComboBox() {
//		xe_dao.getAllMauXe().forEach(mau -> {
//			cbMauXe.addItem(mau);
//		});
//
//	}
//
//	private void themDSHangXeVaoComboBox() {
//		loaiXe_dao.getAllHangXe().forEach(hang -> {
//			cbHangXe.addItem(hang);
//		});
//
//	}
//
//	private void themDSSoPhanKhoiVaoComboBox() {
//		loaiXe_dao.getAllPhanKhoi().forEach(pk -> {
//			cbSoPhanKhoi.addItem(pk);
//		});
//	}
//
//	public void themDSLoaiXeVaoComboBox() {
//		loaiXe_dao.getAllLoaiXe().forEach(loaiXe -> {
//			cbLoaiXe.addItem(loaiXe.getTenLoaiXe());
//		});
//	}
//
//	public void loadThongTinXe(int rowSelected) {
//		txtTenXe.setText(tableChonXe.getValueAt(rowSelected, 1).toString());
//		String soKhung = tableChonXe.getValueAt(rowSelected, 2).toString();
//		txtSoKhung.setText(soKhung);
//		txtGia.setText(tableChonXe.getValueAt(rowSelected, 3).toString());
//		XeMay xe = xe_dao.getXeMayTheoSoKhung(soKhung);
//		Image img = new ImageIcon("data//image//" + xe.getAnhMinhHoa()).getImage().getScaledInstance(lbAnhXe.getWidth(),
//				lbAnhXe.getHeight(), Image.SCALE_SMOOTH);
//		lbAnhXe.setIcon(new ImageIcon(img));
//	}
//
//	public void kiemTraThongTinNhanVien(JTextField jtext) {
//		String maNV = jtext.getText().trim();
//		if (maNV.equals("")) {
//			JOptionPane.showMessageDialog(null, "Hãy nhập thông tin của nhân viên!", "Cảnh báo",
//					JOptionPane.WARNING_MESSAGE);
//			return;
//		}
//		if (nv_dao.getNhanVienTheoMaNV(maNV) == null)
//			JOptionPane.showMessageDialog(null,
//					"Không có nhân viên này trong hệ thống, hãy thêm nhân viên mới ở trong giao diện Nhân Viên", "Lỗi",
//					JOptionPane.ERROR_MESSAGE);
//	}
//
//	private void filterDSXe() {
//		String loaiXe = cbLoaiXe.getSelectedItem().toString();
//		String mauXe = cbMauXe.getSelectedItem().toString();
//		String soPhanKhoi = cbSoPhanKhoi.getSelectedItem().toString();
//		String hangXe = cbHangXe.getSelectedItem().toString();
//		boolean isDongTietKiem = chckbxDongXe.isSelected();
//		Object props[] = { "%", "%", "%", "%", 0 };
//		if (!loaiXe.equals("--Tất cả--"))
//			props[0] = loaiXe;
//		if (!mauXe.equals("--Tất cả--"))
//			props[1] = mauXe;
//		if (!soPhanKhoi.equals("--Tất cả--"))
//			props[2] = soPhanKhoi;
//		if (!hangXe.equals("--Tất cả--"))
//			props[3] = hangXe;
//		if (isDongTietKiem)
//			props[4] = 1;
//	}
//
//	public void loadThongTinHopDong() {
//		String soHD = cbMaHopDong.getSelectedItem().toString();
//		DecimalFormat df = new DecimalFormat("#,###,###,##0.##");
//
//		HopDong hd = hopDong_dao.getHopDongTheoSoHopDong(soHD);
//		if (hd == null) {
//			clearThongTinHopDong();
//			return;
//		}
//
//		txtCCCD.setText(hd.getKhachHang().getMaKhachHang());
//		String ptThanhToan = hd.getPhuongThucThanhToan() == TRAHET ? "Trả hết" : "Trả góp";
//		cbPTThanhToan.setSelectedItem(ptThanhToan);
//		txtMaNV.setText(hd.getNhanVienLapHopDong().getMaNhanVien());
//		txtNgayLapHD.setText(hd.getNgayHopDong().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//		txtThoiGianBaoHanh.setText(hd.getThoiGianBaoHanh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//
//		cbMaTraGop.removeAllItems();
//		hopDong_dao.getAllMaTraGopTheoMaHopDong(soHD).forEach(ma -> {
//			cbMaTraGop.addItem(ma);
//		});
//		cbSoLanTra.setSelectedItem(hd.getSoLanTra());
//		HopDong thongTinTra = hopDong_dao.getThongTinTraGopTheoMaTraGop(cbMaTraGop.getSelectedItem().toString());
//		txtNguoiTra.setText(((HopDongTraGop) thongTinTra).getNguoiTra().getMaCCCD());
//		txtMaNVNhan.setText(((HopDongTraGop) thongTinTra).getNguoiNhan().getMaNhanVien());
//		txtNgayTra.setText(
//				((HopDongTraGop) thongTinTra).getNgayTraGop().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//		double soTienTra = ((HopDongTraGop) thongTinTra).getSoTienTraGop();
//		txtSoTienTraGop.setText(df.format(soTienTra));
//		txtThanhTien.setText(df.format(hd.getTongTien()));
//		double tienDaNhan = hopDong_dao.getTienDaNhan(soHD);
//		txtTienDaNhan.setText(df.format(tienDaNhan));
//		txtConNo.setText(df.format(hd.getTongTien() - tienDaNhan));
//
//		tableModelXe.getDataVector().removeAllElements();
//		hd.getDanhSachXe().forEach(xe -> {
//			tableModelXe.addRow(new Object[] { xe.getTenXe(), xe.getSoKhung(), xe.getSoMay(), df.format(xe.getGia()) });
//		});
//	}
//
//	public void clearThongTinHopDong() {
//		cbPTThanhToan.setSelectedIndex(0);
//		txtMaNV.setText("");
//		txtThoiGianBaoHanh.setText("");
//		cbMaTraGop.removeAllItems();
//		generateMaTG();
//		cbSoLanTra.setSelectedIndex(0);
//		txtNguoiTra.setText("");
//		txtMaNVNhan.setText("");
//		txtSoTienTraGop.setText("");
//		getNgayHienTai(txtNgayLapHD);
//		getNgayHienTai(txtNgayTra);
//		txtThanhTien.setText("");
//		txtTienDaNhan.setText("");
//		txtConNo.setText("");
//		tableModelXe.getDataVector().removeAllElements();
//		tableModelXe.fireTableDataChanged();
//	}
//
//	public boolean validateData() {
//		String cccdKH = txtCCCD.getText().trim();
//		String maNVLapHD = txtMaNV.getText().trim();
//		String thoiGianBH = txtThoiGianBaoHanh.getText().trim();
//		String soTienTra = txtSoTienTraGop.getText().trim();
//		String cccdNguoiTra = txtNguoiTra.getText().trim();
//		String maNVNhan = txtMaNVNhan.getText().trim();
//		if (kh_dao.getKhachHangTheoMaCCCD(cccdKH) == null) {
//			JOptionPane.showMessageDialog(null,
//					"Không tồn tại khách hàng này trong hệ thống, hãy kiểm tra lại hoặc thêm mới khách hàng trong giao diện Quản lý khách hàng",
//					"Cảnh báo", JOptionPane.WARNING_MESSAGE);
//			txtCCCD.selectAll();
//			txtCCCD.requestFocus();
//			return false;
//		}
//		if (nv_dao.getNhanVienTheoMaNV(maNVLapHD) == null) {
//			JOptionPane.showMessageDialog(null,
//					"Không tồn tại nhân viên này trong hệ thống, hãy kiểm tra lại hoặc thêm mới nhân viên trong giao diện Quản lý Nhân viên",
//					"Cảnh báo", JOptionPane.WARNING_MESSAGE);
//			txtMaNV.selectAll();
//			txtMaNV.requestFocus();
//			return false;
//		}
////		------ Continue
//		return true;
//	}
//
//	public void luuThongTinHopDong() {
//
//	}
//
////================================ Implement action ================================
//	@Override
//	public void mouseClicked(MouseEvent e) {
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		Object o = e.getSource();
//		if (o.equals(tableKH)) {
//			int rowSelected = tableKH.getSelectedRow();
//			txtTenKH.setText(tableKH.getValueAt(rowSelected, 0).toString());
//			txtCCCD.setText(tableKH.getValueAt(rowSelected, 1).toString());
//		}
//		if (o.equals(tableChonXe)) {
//			int rowSelected = tableChonXe.getSelectedRow();
//			loadThongTinXe(rowSelected);
//		}
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		if (o.equals(btnChonKhach)) {
//
//		}
//		if (o.equals(btnThem)) {
//			int rowSelected = tableChonXe.getSelectedRow();
//			if (rowSelected == -1) {
//				JOptionPane.showMessageDialog(null, "Vui lòng chọn xe để thêm vào hợp đồng!", "Lỗi",
//						JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//			String tenXe = tableChonXe.getValueAt(rowSelected, 1).toString();
//			String soKhung = tableChonXe.getValueAt(rowSelected, 2).toString();
//			String soMay = xe_dao.getXeMayTheoSoKhung(soKhung).getSoMay();
//			String gia = tableChonXe.getValueAt(rowSelected, 3).toString();
//			tableModelXe.addRow(new Object[] { tenXe, soKhung, soMay, gia });
//			tableModelChonXe.removeRow(rowSelected);
//
//			DecimalFormat df = new DecimalFormat("#,###,###,##0.##");
//			String tienXe = gia.replaceAll(",", "");
//			double tongTien = Double.parseDouble(txtThanhTien.getText().replaceAll(",", ""))
//					+ Double.parseDouble(tienXe);
//			txtThanhTien.setText(df.format(tongTien));
//
//		}
//		if (o.equals(btnLuu)) {
//			if (validateData())
//				luuThongTinHopDong();
//		}
//		if (o.equals(cbMauXe) || o.equals(cbLoaiXe) || o.equals(cbSoPhanKhoi) || o.equals(cbHangXe)) {
//			filterDSXe();
//		}
//		if (o.equals(cbMaHopDong)) {
//			loadThongTinHopDong();
//		}
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		Object o = e.getSource();
//		if (o.equals(txtCCCD)) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//				String maCCCD = txtCCCD.getText().trim();
//				KhachHang kh = kh_dao.getKhachHangTheoMaCCCD(maCCCD);
//				if (kh == null) {
//					JOptionPane.showMessageDialog(null,
//							"Chưa có khách hàng trong hệ thống, hãy thêm khách hàng mới ở trong giao diện Khách Hàng",
//							"Lỗi", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//				CanCuocCongDan cccd = cccd_dao.getCCCDTheoMa(maCCCD);
//				String ten = String.format("%s %s %s", cccd.getHo(), cccd.getHoDem(), cccd.getTen());
//				txtTenKH.setText(ten);
//			}
//		}
//		if (o.equals(txtMaNV)) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
//				kiemTraThongTinNhanVien(txtMaNV);
//			}
//		}
//		if (o.equals(txtMaNVNhan)) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
//				kiemTraThongTinNhanVien(txtMaNVNhan);
//			}
//		}
//
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		Object o = e.getSource();
//		if (o.equals(txtSoTienTraGop)) {
//			try {
//				double x = Double.parseDouble(txtSoTienTraGop.getText().trim().replaceAll(",", ""));
//			} catch (Exception e2) {
//				JOptionPane.showMessageDialog(null, "Số tiền trả sai định dạng, chỉ nhập bao gồm số, ký tự , hoặc .");
//				txtSoTienTraGop.selectAll();
//				txtSoTienTraGop.requestFocus();
//				return;
//			}
//			DecimalFormat df = new DecimalFormat("#,###,###,##0.##");
//			txtTienDaNhan.setText(txtSoTienTraGop.getText());
//			String tongTien = txtThanhTien.getText().toString();
//			String conNo = txtConNo.getText().toString();
//			double x = Double.parseDouble(tongTien.replaceAll(",", ""))
//					- Double.parseDouble(txtSoTienTraGop.getText().trim().replaceAll(",", ""));
//			txtConNo.setText(df.format(x));
//		}
//
//	}
//}
//
