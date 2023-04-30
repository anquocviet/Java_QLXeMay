package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuNhanXetBaoHanh_DAO;
import dao.XeMay_DAO;
import entity.KhachHang;
import entity.NhanVien;
import entity.NhanVienKiThuat;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

public class GUI_QLBaoHanh extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JTable table;
	private DefaultTableModel tableModelLinhKien;
	private JTextField txtDiaChi;
	private JTextField txtSDTKH;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtChucVu;
	private JTextField txtTenXe;
	private JTextField txtThue;
	private JTextField txtTongTienLK;
	private JTextField txtTienCong;
	private JTextField txtTienPhaiTra;
	private JButton btnInHoaDon;
	private KhachHang_DAO kh_dao;
	private JTextField txtSdtNV;
	private NhanVien_DAO nv_dao;
	private PhieuNhanXetBaoHanh_DAO phieuBH;
	private JLabel lblMaHD;
	private JLabel lblNgayLap;
	private XeMay_DAO xemay_dao;
	private JComboBox cbSoKhung;

	/**
	 * Create the panel.
	 */
	public GUI_QLBaoHanh() {
		Font font = getFont();
		setLayout(new BorderLayout(0, 0));
		Image imagePrinter = new ImageIcon("data/image/printer.png").getImage().getScaledInstance(20, 20,
				Image.SCALE_SMOOTH);
		JPanel panelTitle = new JPanel();
		add(panelTitle, BorderLayout.NORTH);
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[] { 94, 300, 420, 0, 0 };
		gbl_panelTitle.rowHeights = new int[] { 30, 25, 0 };
		gbl_panelTitle.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelTitle.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelTitle.setLayout(gbl_panelTitle);

		JLabel lblPhieuBH = new JLabel("PHIẾU BẢO HÀNH");
		lblPhieuBH.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		lblPhieuBH.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhieuBH = new GridBagConstraints();
		gbc_lblPhieuBH.gridwidth = 4;
		gbc_lblPhieuBH.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhieuBH.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhieuBH.gridx = 0;
		gbc_lblPhieuBH.gridy = 0;
		panelTitle.add(lblPhieuBH, gbc_lblPhieuBH);

		JLabel lblTitleMaHD = new JLabel("Mã hóa đơn:");
		lblTitleMaHD.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTitleMaHD = new GridBagConstraints();
		gbc_lblTitleMaHD.anchor = GridBagConstraints.WEST;
		gbc_lblTitleMaHD.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitleMaHD.gridx = 0;
		gbc_lblTitleMaHD.gridy = 1;
		panelTitle.add(lblTitleMaHD, gbc_lblTitleMaHD);

		lblMaHD = new JLabel("");
		lblMaHD.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMaHD.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		GridBagConstraints gbc_lblMaHD = new GridBagConstraints();
		gbc_lblMaHD.anchor = GridBagConstraints.WEST;
		gbc_lblMaHD.insets = new Insets(0, 0, 0, 5);
		gbc_lblMaHD.gridx = 1;
		gbc_lblMaHD.gridy = 1;
		panelTitle.add(lblMaHD, gbc_lblMaHD);

		JLabel lblTitleNgayLap = new JLabel("Ngày lập:");
		lblTitleNgayLap.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTitleNgayLap = new GridBagConstraints();
		gbc_lblTitleNgayLap.anchor = GridBagConstraints.EAST;
		gbc_lblTitleNgayLap.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitleNgayLap.gridx = 2;
		gbc_lblTitleNgayLap.gridy = 1;
		panelTitle.add(lblTitleNgayLap, gbc_lblTitleNgayLap);

		lblNgayLap = new JLabel("");
		GridBagConstraints gbc_lblNgayLap = new GridBagConstraints();
		gbc_lblNgayLap.anchor = GridBagConstraints.WEST;
		gbc_lblNgayLap.gridx = 3;
		gbc_lblNgayLap.gridy = 1;
		panelTitle.add(lblNgayLap, gbc_lblNgayLap);

		JPanel panelChiTietBH = new JPanel();
		add(panelChiTietBH, BorderLayout.CENTER);
		panelChiTietBH.setLayout(new BoxLayout(panelChiTietBH, BoxLayout.Y_AXIS));

		JPanel panelThongTinNV = new JPanel();
		panelThongTinNV.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelChiTietBH.add(panelThongTinNV);
		GridBagLayout gbl_panelThongTinNV = new GridBagLayout();
		gbl_panelThongTinNV.columnWidths = new int[] { 123, 0, 0, 0, 0 };
		gbl_panelThongTinNV.rowHeights = new int[] { 30, 30, 0 };
		gbl_panelThongTinNV.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelThongTinNV.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelThongTinNV.setLayout(gbl_panelThongTinNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMaNV = new GridBagConstraints();
		gbc_lblMaNV.anchor = GridBagConstraints.EAST;
		gbc_lblMaNV.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaNV.gridx = 0;
		gbc_lblMaNV.gridy = 0;
		panelThongTinNV.add(lblMaNV, gbc_lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		GridBagConstraints gbc_txtMaNV = new GridBagConstraints();
		gbc_txtMaNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaNV.insets = new Insets(0, 0, 5, 5);
		gbc_txtMaNV.gridx = 1;
		gbc_txtMaNV.gridy = 0;
		panelThongTinNV.add(txtMaNV, gbc_txtMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTenNV = new GridBagConstraints();
		gbc_lblTenNV.anchor = GridBagConstraints.EAST;
		gbc_lblTenNV.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNV.gridx = 2;
		gbc_lblTenNV.gridy = 0;
		panelThongTinNV.add(lblTenNV, gbc_lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		GridBagConstraints gbc_txtTenNV = new GridBagConstraints();
		gbc_txtTenNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNV.insets = new Insets(0, 0, 5, 0);
		gbc_txtTenNV.gridx = 3;
		gbc_txtTenNV.gridy = 0;
		panelThongTinNV.add(txtTenNV, gbc_txtTenNV);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblChucVu = new GridBagConstraints();
		gbc_lblChucVu.anchor = GridBagConstraints.EAST;
		gbc_lblChucVu.insets = new Insets(0, 0, 0, 5);
		gbc_lblChucVu.gridx = 0;
		gbc_lblChucVu.gridy = 1;
		panelThongTinNV.add(lblChucVu, gbc_lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		GridBagConstraints gbc_txtChucVu = new GridBagConstraints();
		gbc_txtChucVu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChucVu.insets = new Insets(0, 0, 0, 5);
		gbc_txtChucVu.gridx = 1;
		gbc_txtChucVu.gridy = 1;
		panelThongTinNV.add(txtChucVu, gbc_txtChucVu);

		JLabel lblSdtNV = new JLabel("Số điện thoại");
		GridBagConstraints gbc_lblSdtNV = new GridBagConstraints();
		gbc_lblSdtNV.anchor = GridBagConstraints.EAST;
		gbc_lblSdtNV.insets = new Insets(0, 0, 0, 5);
		gbc_lblSdtNV.gridx = 2;
		gbc_lblSdtNV.gridy = 1;
		panelThongTinNV.add(lblSdtNV, gbc_lblSdtNV);

		txtSdtNV = new JTextField();
		txtSdtNV.setEditable(false);
		GridBagConstraints gbc_txtSdtNV = new GridBagConstraints();
		gbc_txtSdtNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSdtNV.gridx = 3;
		gbc_txtSdtNV.gridy = 1;
		panelThongTinNV.add(txtSdtNV, gbc_txtSdtNV);
		txtSdtNV.setColumns(10);

		JPanel panelThongTinKH = new JPanel();
		panelThongTinKH.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelChiTietBH.add(panelThongTinKH);
		GridBagLayout gbl_panelThongTinKH = new GridBagLayout();
		gbl_panelThongTinKH.columnWidths = new int[] { 123, 0, 0, 0, 0 };
		gbl_panelThongTinKH.rowHeights = new int[] { 30, 30, 0 };
		gbl_panelThongTinKH.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelThongTinKH.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panelThongTinKH.setLayout(gbl_panelThongTinKH);

		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblMaKH = new GridBagConstraints();
		gbc_lblMaKH.anchor = GridBagConstraints.EAST;
		gbc_lblMaKH.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaKH.gridx = 0;
		gbc_lblMaKH.gridy = 0;
		panelThongTinKH.add(lblMaKH, gbc_lblMaKH);

		txtMaKH = new JTextField();
		GridBagConstraints gbc_txtMaKH = new GridBagConstraints();
		gbc_txtMaKH.insets = new Insets(0, 0, 5, 5);
		gbc_txtMaKH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaKH.gridx = 1;
		gbc_txtMaKH.gridy = 0;
		panelThongTinKH.add(txtMaKH, gbc_txtMaKH);
		txtMaKH.setColumns(10);

		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTenKH = new GridBagConstraints();
		gbc_lblTenKH.anchor = GridBagConstraints.EAST;
		gbc_lblTenKH.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenKH.gridx = 2;
		gbc_lblTenKH.gridy = 0;
		panelThongTinKH.add(lblTenKH, gbc_lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		GridBagConstraints gbc_txtTenKH = new GridBagConstraints();
		gbc_txtTenKH.insets = new Insets(0, 0, 5, 0);
		gbc_txtTenKH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenKH.gridx = 3;
		gbc_txtTenKH.gridy = 0;
		panelThongTinKH.add(txtTenKH, gbc_txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblSDTKH = new JLabel("Số điện thoại");
		lblSDTKH.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSDTKH = new GridBagConstraints();
		gbc_lblSDTKH.anchor = GridBagConstraints.EAST;
		gbc_lblSDTKH.insets = new Insets(0, 0, 5, 5);
		gbc_lblSDTKH.gridx = 0;
		gbc_lblSDTKH.gridy = 1;
		panelThongTinKH.add(lblSDTKH, gbc_lblSDTKH);

		txtSDTKH = new JTextField();
		txtSDTKH.setEditable(false);
		GridBagConstraints gbc_txtSDTKH = new GridBagConstraints();
		gbc_txtSDTKH.insets = new Insets(0, 0, 5, 5);
		gbc_txtSDTKH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSDTKH.gridx = 1;
		gbc_txtSDTKH.gridy = 1;
		panelThongTinKH.add(txtSDTKH, gbc_txtSDTKH);
		txtSDTKH.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.EAST;
		gbc_lblDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaChi.gridx = 2;
		gbc_lblDiaChi.gridy = 1;
		panelThongTinKH.add(lblDiaChi, gbc_lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.insets = new Insets(0, 0, 5, 0);
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridx = 3;
		gbc_txtDiaChi.gridy = 1;
		panelThongTinKH.add(txtDiaChi, gbc_txtDiaChi);
		txtDiaChi.setColumns(10);

		JLabel lblSoKhung1 = new JLabel("Số khung");
		lblSoKhung1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSoKhung1 = new GridBagConstraints();
		gbc_lblSoKhung1.anchor = GridBagConstraints.EAST;
		gbc_lblSoKhung1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSoKhung1.gridx = 0;
		gbc_lblSoKhung1.gridy = 2;
		panelThongTinKH.add(lblSoKhung1, gbc_lblSoKhung1);

		cbSoKhung = new JComboBox();
		GridBagConstraints gbc_cbSoKhung = new GridBagConstraints();
		gbc_cbSoKhung.insets = new Insets(0, 0, 0, 5);
		gbc_cbSoKhung.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSoKhung.gridx = 1;
		gbc_cbSoKhung.gridy = 2;
		panelThongTinKH.add(cbSoKhung, gbc_cbSoKhung);

		JLabel lblTenXe = new JLabel("Tên xe");
		lblTenXe.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTenXe = new GridBagConstraints();
		gbc_lblTenXe.anchor = GridBagConstraints.EAST;
		gbc_lblTenXe.insets = new Insets(0, 0, 0, 5);
		gbc_lblTenXe.gridx = 2;
		gbc_lblTenXe.gridy = 2;
		panelThongTinKH.add(lblTenXe, gbc_lblTenXe);

		txtTenXe = new JTextField();
		GridBagConstraints gbc_txtTenXe = new GridBagConstraints();
		gbc_txtTenXe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenXe.gridx = 3;
		gbc_txtTenXe.gridy = 2;
		panelThongTinKH.add(txtTenXe, gbc_txtTenXe);
		txtTenXe.setColumns(10);

		String headerTableLinkKien[] = "STT;Mã linh kiện;Tên linh kiện;Lý do BH;Lỗi do SP;Số lượng;Đơn giá;Thành tiền"
				.split(";");
		tableModelLinhKien = new DefaultTableModel(headerTableLinkKien, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex != 4)
					return String.class;
				else
					return Boolean.class;
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0)
					return false;
				return true;
			};

		};
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModelLinhKien));
		table.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
		table.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
		tableModelLinhKien.addRow(new Object[] { 1 });
		table.setRowSelectionInterval(0, 0);
		table.getTableHeader().setFont(new Font(font.getName(), font.getStyle(), 13));
		table.setFont(new Font(font.getName(), font.getStyle(), 14));
		table.setRowHeight(24);
		panelChiTietBH.add(scrollPane);

		JPanel panelTinhTien = new JPanel();
		add(panelTinhTien, BorderLayout.SOUTH);
		GridBagLayout gbl_panelTinhTien = new GridBagLayout();
		gbl_panelTinhTien.columnWidths = new int[] { 846, 358, 0 };
		gbl_panelTinhTien.rowHeights = new int[] { 30, 30, 30, 30, 30, 0 };
		gbl_panelTinhTien.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelTinhTien.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTinhTien.setLayout(gbl_panelTinhTien);

		JLabel lblTienCong = new JLabel("Tổng tiền công");
		lblTienCong.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTienCong.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTienCong = new GridBagConstraints();
		gbc_lblTienCong.anchor = GridBagConstraints.EAST;
		gbc_lblTienCong.fill = GridBagConstraints.VERTICAL;
		gbc_lblTienCong.insets = new Insets(0, 0, 5, 5);
		gbc_lblTienCong.gridx = 0;
		gbc_lblTienCong.gridy = 0;
		panelTinhTien.add(lblTienCong, gbc_lblTienCong);

		txtTienCong = new JTextField();
		GridBagConstraints gbc_txtTienCong = new GridBagConstraints();
		gbc_txtTienCong.insets = new Insets(0, 0, 5, 0);
		gbc_txtTienCong.fill = GridBagConstraints.BOTH;
		gbc_txtTienCong.gridx = 1;
		gbc_txtTienCong.gridy = 0;
		panelTinhTien.add(txtTienCong, gbc_txtTienCong);
		txtTienCong.setColumns(10);

		JLabel lblTongTienLK = new JLabel("Tổng tiền linh kiện");
		lblTongTienLK.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTongTienLK.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTongTienLK = new GridBagConstraints();
		gbc_lblTongTienLK.fill = GridBagConstraints.BOTH;
		gbc_lblTongTienLK.insets = new Insets(0, 0, 5, 5);
		gbc_lblTongTienLK.gridx = 0;
		gbc_lblTongTienLK.gridy = 1;
		panelTinhTien.add(lblTongTienLK, gbc_lblTongTienLK);

		txtTongTienLK = new JTextField();
		GridBagConstraints gbc_txtTongTienLK = new GridBagConstraints();
		gbc_txtTongTienLK.fill = GridBagConstraints.BOTH;
		gbc_txtTongTienLK.insets = new Insets(0, 0, 5, 0);
		gbc_txtTongTienLK.gridx = 1;
		gbc_txtTongTienLK.gridy = 1;
		panelTinhTien.add(txtTongTienLK, gbc_txtTongTienLK);
		txtTongTienLK.setColumns(10);

		JLabel lblThue = new JLabel("Thuế GTGT");
		lblThue.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblThue.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblThue = new GridBagConstraints();
		gbc_lblThue.fill = GridBagConstraints.BOTH;
		gbc_lblThue.insets = new Insets(0, 0, 5, 5);
		gbc_lblThue.gridx = 0;
		gbc_lblThue.gridy = 2;
		panelTinhTien.add(lblThue, gbc_lblThue);

		txtThue = new JTextField();
		GridBagConstraints gbc_txtThue = new GridBagConstraints();
		gbc_txtThue.insets = new Insets(0, 0, 5, 0);
		gbc_txtThue.fill = GridBagConstraints.BOTH;
		gbc_txtThue.gridx = 1;
		gbc_txtThue.gridy = 2;
		panelTinhTien.add(txtThue, gbc_txtThue);
		txtThue.setColumns(10);

		JLabel lblTienPhaiTra = new JLabel("Tổng tiền phải trả");
		lblTienPhaiTra.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblTienPhaiTra.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTienPhaiTra = new GridBagConstraints();
		gbc_lblTienPhaiTra.fill = GridBagConstraints.BOTH;
		gbc_lblTienPhaiTra.insets = new Insets(0, 0, 5, 5);
		gbc_lblTienPhaiTra.gridx = 0;
		gbc_lblTienPhaiTra.gridy = 3;
		panelTinhTien.add(lblTienPhaiTra, gbc_lblTienPhaiTra);

		txtTienPhaiTra = new JTextField();
		GridBagConstraints gbc_txtTienPhaiTra = new GridBagConstraints();
		gbc_txtTienPhaiTra.insets = new Insets(0, 0, 5, 0);
		gbc_txtTienPhaiTra.fill = GridBagConstraints.BOTH;
		gbc_txtTienPhaiTra.gridx = 1;
		gbc_txtTienPhaiTra.gridy = 3;
		panelTinhTien.add(txtTienPhaiTra, gbc_txtTienPhaiTra);
		txtTienPhaiTra.setColumns(10);

		btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnInHoaDon.setIcon(new ImageIcon(imagePrinter));
		GridBagConstraints gbc_btnInHoaDon = new GridBagConstraints();
		gbc_btnInHoaDon.gridx = 1;
		gbc_btnInHoaDon.gridy = 4;
		panelTinhTien.add(btnInHoaDon, gbc_btnInHoaDon);

		kh_dao = new KhachHang_DAO();
		nv_dao = new NhanVien_DAO();
		phieuBH = new PhieuNhanXetBaoHanh_DAO();
		xemay_dao = new XeMay_DAO();

		txtMaKH.addKeyListener(this);
		txtMaNV.addKeyListener(this);

		generateMaPhieuBH();
		generateNgayLapHD();
	}

	public void clearInfoKhachHang() {
		txtTenKH.setText("");
		txtSDTKH.setText("");
		txtDiaChi.setText("");
	}

	public void clearInfoNhanVien() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtChucVu.setText("");
	}

	public void loadNhanVien(String maNV) {
		if (maNV.equals("")) {
			clearInfoNhanVien();
			return;
		}
		NhanVien nv = nv_dao.getNhanVienTheoMaNV(txtMaNV.getText().trim());
		if (nv != null) {
			String tenNV = nv.getCccd().getHo() + " " + nv.getCccd().getHoDem() + " " + nv.getCccd().getTen();
			txtTenNV.setText(tenNV);
			txtChucVu.setText(nv.getChucVu());
			txtSdtNV.setText(nv.getSoDienThoai());
		} else {
			JOptionPane.showMessageDialog(null,
					"Không tìm thấy nhân viên trong hệ thống! Hãy kiểm tra lại mã Khách hàng", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtMaNV.requestFocus();
			txtMaNV.selectAll();
		}
	}

	public void loadKhachHang(String maKH) {
		if (maKH.equals("")) {
			clearInfoKhachHang();
			return;
		}
		KhachHang kh = kh_dao.getKhachHangTheoMaKH(txtMaKH.getText());
		if (kh != null) {
			String tenKH = kh.getCccd().getHo() + " " + kh.getCccd().getHoDem() + " " + kh.getCccd().getTen();
			txtTenKH.setText(tenKH);
			txtSDTKH.setText(kh.getSoDienThoai());
			txtDiaChi.setText(kh.getCccd().getThuongTru());
		} else {
			JOptionPane.showMessageDialog(null,
					"Không tìm thấy khách hàng trong hệ thống! Hãy kiểm tra lại mã Khách hàng", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtMaKH.requestFocus();
			txtMaKH.selectAll();
		}
	}
	
	private void loadXeCuaKhach(String maKH) {
		if (maKH.equals("")) {
			clearInfoKhachHang();
			return;
		}
		xemay_dao.getDSXeMayCuaKhachHang(maKH).forEach(xe -> {
//			cbSoKhung.addItem()
		});
		
		
	}

	public void generateMaPhieuBH() {
		String maPhieu = "P";
		LocalDate ngayHT = LocalDate.now();
		int slPhieuTrongNgay = phieuBH.countPhieuBaoHanhInDate(ngayHT);
		DecimalFormat df = new DecimalFormat("000");
		maPhieu += df.format(++slPhieuTrongNgay);
		maPhieu += ngayHT.format(DateTimeFormatter.ofPattern("ddMMyy"));
		lblMaHD.setText(maPhieu);
	}

	public void generateNgayLapHD() {
		LocalDate ngayHT = LocalDate.now();
		lblNgayLap.setText(ngayHT.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(txtMaNV)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				loadNhanVien(txtMaNV.getText().trim());
		}
		if (o.equals(txtMaKH)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				loadKhachHang(txtMaKH.getText().trim());
				loadXeCuaKhach(txtMaKH.getText().trim());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}