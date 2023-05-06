package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CanCuocCongDan_DAO;
import dao.HopDong_DAO;
import dao.KhachHang_DAO;
import dao.LoaiXe_DAO;
import dao.NhaCungCap_DAO;
import dao.XeMay_DAO;
import entity.HopDong;
import entity.NhaCungCap;
import entity.XeMay;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class GUI_QLNhapXe extends JPanel implements ActionListener,MouseListener,KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtSoLuong;
	private JTable tableChiTietHD;
	private JTable tableXe;
	private JTable tableNCC;
	private DefaultTableModel tableModelXe;
	private JTextField txtMaHD;
	private JTextField txtHDTenNCC;
	private JButton btnChonNCC;
	private JTextField txtTenXe;
	private JButton btnThemXe;
	private JButton btnNhapHang;
	private JLabel lblSoTien;
	private Image imgXeMay;
	private JTextField txtNgayDatHang;
	private XeMay_DAO xe_dao;
	private NhaCungCap_DAO ncc_dao;
	private HopDong_DAO hd_dao;
	private LoaiXe_DAO loaiXe_dao;
	private JTextField txtLoaiXe;
	private JTextField txtMauXe;
	private JTextField txtHangXe;
	private JLabel lblAnhMinhHoa;
	
	private int stt = 1;
    private int sttXe = 1;
	private String linkimgXeMay;
	private int soTien = 0;

	/**
	 * @author An Quốc Việt
	 */
	public GUI_QLNhapXe() {
		Image imgThemHD = new ImageIcon("data/image/them-hoa-don.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Image imgThem = new ImageIcon("data/image/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgXeMay = new ImageIcon("data/image/demo-xe-may.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		Font f = getFont();
		setFont(new Font(f.getName(), f.getStyle(), 14));
		
		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelNhapInfo = new JPanel();
		add(panelNhapInfo);
		panelNhapInfo.setLayout(new BorderLayout(0, 0));

		JPanel panelChonNCC = new JPanel();
		panelChonNCC.setBorder(new TitledBorder(null, "Ch\u1ECDn nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelNhapInfo.add(panelChonNCC, BorderLayout.NORTH);
		panelChonNCC.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panelInfoNCC = new JPanel();
		panelInfoNCC.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelChonNCC.add(panelInfoNCC);
		GridBagLayout gbl_panelInfoNCC = new GridBagLayout();
		gbl_panelInfoNCC.columnWidths = new int[]{117, 86, 0};
		gbl_panelInfoNCC.rowHeights = new int[]{15, 15, 27, 0};
		gbl_panelInfoNCC.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoNCC.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfoNCC.setLayout(gbl_panelInfoNCC);
						
								JLabel lblMaNCC = new JLabel("Mã nhà cung cấp ");
								lblMaNCC.setFont(new Font("Dialog", Font.BOLD, 12));
								lblMaNCC.setHorizontalAlignment(SwingConstants.CENTER);
								GridBagConstraints gbc_lblMaNCC = new GridBagConstraints();
								gbc_lblMaNCC.anchor = GridBagConstraints.NORTHWEST;
								gbc_lblMaNCC.insets = new Insets(0, 0, 5, 5);
								gbc_lblMaNCC.gridx = 0;
								gbc_lblMaNCC.gridy = 0;
								panelInfoNCC.add(lblMaNCC, gbc_lblMaNCC);
				
						txtMaNCC = new JTextField();
						txtMaNCC.setEnabled(false);
						GridBagConstraints gbc_txtMaNCC = new GridBagConstraints();
						gbc_txtMaNCC.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtMaNCC.anchor = GridBagConstraints.NORTH;
						gbc_txtMaNCC.insets = new Insets(0, 0, 5, 0);
						gbc_txtMaNCC.gridx = 1;
						gbc_txtMaNCC.gridy = 0;
						panelInfoNCC.add(txtMaNCC, gbc_txtMaNCC);
						txtMaNCC.setColumns(10);
		
				JLabel lblTenNCC = new JLabel("Tên nhà cung cấp");
				lblTenNCC.setFont(new Font("Dialog", Font.BOLD, 12));
				lblTenNCC.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblTenNCC = new GridBagConstraints();
				gbc_lblTenNCC.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblTenNCC.insets = new Insets(0, 0, 5, 5);
				gbc_lblTenNCC.gridx = 0;
				gbc_lblTenNCC.gridy = 1;
				panelInfoNCC.add(lblTenNCC, gbc_lblTenNCC);
				
						txtTenNCC = new JTextField();
						txtTenNCC.setEnabled(false);
						GridBagConstraints gbc_txtTenNCC = new GridBagConstraints();
						gbc_txtTenNCC.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtTenNCC.anchor = GridBagConstraints.NORTH;
						gbc_txtTenNCC.insets = new Insets(0, 0, 5, 0);
						gbc_txtTenNCC.gridx = 1;
						gbc_txtTenNCC.gridy = 1;
						panelInfoNCC.add(txtTenNCC, gbc_txtTenNCC);
						txtTenNCC.setColumns(10);
		
				btnChonNCC = new JButton("Chọn nhà cung cấp");
				btnChonNCC.setFont(new Font("Dialog", Font.PLAIN, 14));
				btnChonNCC.setIcon(new ImageIcon(imgThem));
				GridBagConstraints gbc_btnChonNCC = new GridBagConstraints();
				gbc_btnChonNCC.gridwidth = 2;
				gbc_btnChonNCC.insets = new Insets(0, 0, 0, 5);
				gbc_btnChonNCC.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnChonNCC.gridx = 0;
				gbc_btnChonNCC.gridy = 2;
				panelInfoNCC.add(btnChonNCC, gbc_btnChonNCC);

		String headerTableNCC[] = { "Mã NCC", "Tên NCC" };
		DefaultTableModel tableModelNCC = new DefaultTableModel(headerTableNCC, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		JScrollPane scrollPaneNCC = new JScrollPane(tableNCC = new JTable(tableModelNCC));
		tableNCC.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
		tableNCC.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
		tableNCC.getTableHeader().setFont(new Font(getName(), f.getStyle(), 13));
		tableNCC.setFont(new Font(f.getName(), f.getStyle(), 14));
		tableNCC.setRowHeight(24);
		
		scrollPaneNCC.setPreferredSize(new Dimension(100, 100));
		panelChonNCC.add(scrollPaneNCC);

		JPanel panelChonXe = new JPanel();
		panelChonXe
				.setBorder(new TitledBorder(null, "Ch\u1ECDn xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNhapInfo.add(panelChonXe, BorderLayout.CENTER);
		panelChonXe.setLayout(new BorderLayout(0, 0));

		JPanel panelChonXeLeft = new JPanel();
		panelChonXe.add(panelChonXeLeft, BorderLayout.CENTER);
		panelChonXeLeft.setLayout(new BorderLayout(0, 0));

		JPanel panelInfoXe = new JPanel();
		panelChonXeLeft.add(panelInfoXe, BorderLayout.NORTH);
		GridBagLayout gbl_panelInfoXe = new GridBagLayout();
		gbl_panelInfoXe.columnWidths = new int[]{85, 119, 0};
		gbl_panelInfoXe.rowHeights = new int[]{24, 24, 24, 24, 24, 0, 0};
		gbl_panelInfoXe.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoXe.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfoXe.setLayout(gbl_panelInfoXe);
												
														JLabel lblTenXe = new JLabel("Tên xe");
														lblTenXe.setFont(new Font("Dialog", Font.BOLD, 12));
														GridBagConstraints gbc_lblTenXe = new GridBagConstraints();
														gbc_lblTenXe.fill = GridBagConstraints.BOTH;
														gbc_lblTenXe.insets = new Insets(0, 0, 5, 5);
														gbc_lblTenXe.gridx = 0;
														gbc_lblTenXe.gridy = 0;
														panelInfoXe.add(lblTenXe, gbc_lblTenXe);
										
												txtTenXe = new JTextField();
												txtTenXe.setEnabled(false);
												GridBagConstraints gbc_txtTenXe = new GridBagConstraints();
												gbc_txtTenXe.fill = GridBagConstraints.BOTH;
												gbc_txtTenXe.insets = new Insets(0, 0, 5, 0);
												gbc_txtTenXe.gridx = 1;
												gbc_txtTenXe.gridy = 0;
												panelInfoXe.add(txtTenXe, gbc_txtTenXe);
												txtTenXe.setColumns(10);
								
										JLabel lblLoaiXe = new JLabel("Loại xe");
										lblLoaiXe.setFont(new Font("Dialog", Font.BOLD, 12));
										GridBagConstraints gbc_lblLoaiXe = new GridBagConstraints();
										gbc_lblLoaiXe.fill = GridBagConstraints.BOTH;
										gbc_lblLoaiXe.insets = new Insets(0, 0, 5, 5);
										gbc_lblLoaiXe.gridx = 0;
										gbc_lblLoaiXe.gridy = 1;
										panelInfoXe.add(lblLoaiXe, gbc_lblLoaiXe);
						
						txtLoaiXe = new JTextField();
						txtLoaiXe.setEnabled(false);
						GridBagConstraints gbc_txtLoaiXe = new GridBagConstraints();
						gbc_txtLoaiXe.insets = new Insets(0, 0, 5, 0);
						gbc_txtLoaiXe.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtLoaiXe.gridx = 1;
						gbc_txtLoaiXe.gridy = 1;
						panelInfoXe.add(txtLoaiXe, gbc_txtLoaiXe);
						txtLoaiXe.setColumns(10);
				
						JLabel lblMauXe = new JLabel("Màu xe");
						lblMauXe.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblMauXe = new GridBagConstraints();
						gbc_lblMauXe.fill = GridBagConstraints.BOTH;
						gbc_lblMauXe.insets = new Insets(0, 0, 5, 5);
						gbc_lblMauXe.gridx = 0;
						gbc_lblMauXe.gridy = 2;
						panelInfoXe.add(lblMauXe, gbc_lblMauXe);
						
						txtMauXe = new JTextField();
						txtMauXe.setEnabled(false);
						GridBagConstraints gbc_txtMauXe = new GridBagConstraints();
						gbc_txtMauXe.insets = new Insets(0, 0, 5, 0);
						gbc_txtMauXe.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtMauXe.gridx = 1;
						gbc_txtMauXe.gridy = 2;
						panelInfoXe.add(txtMauXe, gbc_txtMauXe);
						txtMauXe.setColumns(10);
				
						JLabel lblHangXe = new JLabel("Hãng xe");
						lblHangXe.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblHangXe = new GridBagConstraints();
						gbc_lblHangXe.fill = GridBagConstraints.BOTH;
						gbc_lblHangXe.insets = new Insets(0, 0, 5, 5);
						gbc_lblHangXe.gridx = 0;
						gbc_lblHangXe.gridy = 3;
						panelInfoXe.add(lblHangXe, gbc_lblHangXe);
				
				txtHangXe = new JTextField();
				txtHangXe.setEnabled(false);
				GridBagConstraints gbc_txtHangXe = new GridBagConstraints();
				gbc_txtHangXe.insets = new Insets(0, 0, 5, 0);
				gbc_txtHangXe.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtHangXe.gridx = 1;
				gbc_txtHangXe.gridy = 3;
				panelInfoXe.add(txtHangXe, gbc_txtHangXe);
				txtHangXe.setColumns(10);
		
				JLabel lblSoLuong = new JLabel("Số lượng");
				lblSoLuong.setFont(new Font("Dialog", Font.BOLD, 12));
				GridBagConstraints gbc_lblSoLuong = new GridBagConstraints();
				gbc_lblSoLuong.fill = GridBagConstraints.BOTH;
				gbc_lblSoLuong.insets = new Insets(0, 0, 5, 5);
				gbc_lblSoLuong.gridx = 0;
				gbc_lblSoLuong.gridy = 4;
				panelInfoXe.add(lblSoLuong, gbc_lblSoLuong);
		
				txtSoLuong = new JTextField();
				GridBagConstraints gbc_txtSoLuong = new GridBagConstraints();
				gbc_txtSoLuong.insets = new Insets(0, 0, 5, 0);
				gbc_txtSoLuong.fill = GridBagConstraints.BOTH;
				gbc_txtSoLuong.gridx = 1;
				gbc_txtSoLuong.gridy = 4;
				panelInfoXe.add(txtSoLuong, gbc_txtSoLuong);
				txtSoLuong.setColumns(10);

		String headerTableXe[] = "Tên xe;Loại xe;Màu sắc;Hãng xe;Số lượng".split(";");
		tableModelXe = new DefaultTableModel(headerTableXe, 0);
		JScrollPane scrollPaneXe = new JScrollPane(tableXe = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn xe", "Lo\u1EA1i xe", "M\u00E0u s\u1EAFc", "H\u00E3ng xe", "\u1EA2nh"
			}
		)));
		tableXe.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
		tableXe.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
		tableXe.getTableHeader().setFont(new Font(f.getName(), f.getStyle(), 13));
		tableXe.setFont(new Font(f.getName(), f.getStyle(), 14));
		tableXe.setRowHeight(24);
		panelChonXeLeft.add(scrollPaneXe, BorderLayout.CENTER);

		JPanel panelChonXeRight = new JPanel();
		panelChonXe.add(panelChonXeRight, BorderLayout.EAST);

		panelChonXeRight.setLayout(new BorderLayout(0, 0));
		lblAnhMinhHoa = new JLabel(new ImageIcon());
		panelChonXeRight.add(lblAnhMinhHoa);

		btnThemXe = new JButton("Thêm vào hóa đơn");
		btnThemXe.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnThemXe.setIcon(new ImageIcon(imgThemHD));
		panelChonXeRight.add(btnThemXe, BorderLayout.SOUTH);

		JPanel panelHD = new JPanel();
		add(panelHD);
		panelHD.setLayout(new BorderLayout(0, 0));

		JPanel panelChiTietHD = new JPanel();
		panelChiTietHD.setBorder(new TitledBorder(null, "Chi ti\u1EBFt h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelHD.add(panelChiTietHD, BorderLayout.CENTER);
		panelChiTietHD.setLayout(new BorderLayout(0, 0));

		JPanel panelInfoHD = new JPanel();
		panelChiTietHD.add(panelInfoHD, BorderLayout.NORTH);
		GridBagLayout gbl_panelInfoHD = new GridBagLayout();
		gbl_panelInfoHD.columnWidths = new int[]{137, 200, 0};
		gbl_panelInfoHD.rowHeights = new int[]{19, 19, 19, 0};
		gbl_panelInfoHD.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoHD.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfoHD.setLayout(gbl_panelInfoHD);
				
						JLabel lblMaHD = new JLabel("Mã hóa đơn");
						lblMaHD.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblMaHD = new GridBagConstraints();
						gbc_lblMaHD.fill = GridBagConstraints.BOTH;
						gbc_lblMaHD.insets = new Insets(0, 0, 5, 5);
						gbc_lblMaHD.gridx = 0;
						gbc_lblMaHD.gridy = 0;
						panelInfoHD.add(lblMaHD, gbc_lblMaHD);
		
				txtMaHD = new JTextField();
				txtMaHD.setEnabled(false);
				GridBagConstraints gbc_txtMaHD = new GridBagConstraints();
				gbc_txtMaHD.fill = GridBagConstraints.BOTH;
				gbc_txtMaHD.insets = new Insets(0, 0, 5, 0);
				gbc_txtMaHD.gridx = 1;
				gbc_txtMaHD.gridy = 0;
				panelInfoHD.add(txtMaHD, gbc_txtMaHD);
				txtMaHD.setColumns(10);
				
						JLabel lblHDTenNCC = new JLabel("Tên nhà cung cấp");
						lblHDTenNCC.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblHDTenNCC = new GridBagConstraints();
						gbc_lblHDTenNCC.fill = GridBagConstraints.BOTH;
						gbc_lblHDTenNCC.insets = new Insets(0, 0, 5, 5);
						gbc_lblHDTenNCC.gridx = 0;
						gbc_lblHDTenNCC.gridy = 1;
						panelInfoHD.add(lblHDTenNCC, gbc_lblHDTenNCC);
		
				txtHDTenNCC = new JTextField();
				txtHDTenNCC.setEnabled(false);
				GridBagConstraints gbc_txtHDTenNCC = new GridBagConstraints();
				gbc_txtHDTenNCC.fill = GridBagConstraints.BOTH;
				gbc_txtHDTenNCC.insets = new Insets(0, 0, 5, 0);
				gbc_txtHDTenNCC.gridx = 1;
				gbc_txtHDTenNCC.gridy = 1;
				panelInfoHD.add(txtHDTenNCC, gbc_txtHDTenNCC);
				txtHDTenNCC.setColumns(10);
		
		JLabel lblNgayDatHang = new JLabel("Ngày đặt hàng");
		lblNgayDatHang.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblNgayDatHang = new GridBagConstraints();
		gbc_lblNgayDatHang.fill = GridBagConstraints.BOTH;
		gbc_lblNgayDatHang.insets = new Insets(0, 0, 0, 5);
		gbc_lblNgayDatHang.gridx = 0;
		gbc_lblNgayDatHang.gridy = 2;
		panelInfoHD.add(lblNgayDatHang, gbc_lblNgayDatHang);
		
		txtNgayDatHang = new JTextField();
		txtNgayDatHang.setEnabled(false);
		GridBagConstraints gbc_txtNgayDatHang = new GridBagConstraints();
		gbc_txtNgayDatHang.fill = GridBagConstraints.BOTH;
		gbc_txtNgayDatHang.gridx = 1;
		gbc_txtNgayDatHang.gridy = 2;
		panelInfoHD.add(txtNgayDatHang, gbc_txtNgayDatHang);
		txtNgayDatHang.setColumns(10);

		JPanel panelThanhTien = new JPanel();
		FlowLayout fl_panelThanhTien = (FlowLayout) panelThanhTien.getLayout();
		fl_panelThanhTien.setHgap(100);
		panelChiTietHD.add(panelThanhTien, BorderLayout.SOUTH);

		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Dialog", Font.BOLD, 12));
		panelThanhTien.add(lblThanhTien);

		lblSoTien = new JLabel("0 VND");
		panelThanhTien.add(lblSoTien);

		String headerCTHD[] = "STT;Tên xe;Số lượng;Đơn giá;Thành tiền".split(";");
		DefaultTableModel tableModelCTHD = new DefaultTableModel(headerCTHD, 0);
		JScrollPane scrollPaneCTHD = new JScrollPane(tableChiTietHD = new JTable(tableModelCTHD));
		tableChiTietHD.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
		tableChiTietHD.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
		tableChiTietHD.getTableHeader().setFont(new Font(f.getName(), f.getStyle(), 13));
		tableChiTietHD.setFont(new Font(f.getName(), f.getStyle(), 14));
		tableChiTietHD.setRowHeight(24);
		panelChiTietHD.add(scrollPaneCTHD, BorderLayout.CENTER);

		JPanel panelNhapHang = new JPanel();
		panelHD.add(panelNhapHang, BorderLayout.SOUTH);

		btnNhapHang = new JButton("Nhập hàng");
		btnNhapHang.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNhapHang.setIcon(new ImageIcon(imgThem));
		panelNhapHang.add(btnNhapHang);
		
		ncc_dao = new NhaCungCap_DAO();
		xe_dao = new XeMay_DAO();
		loaiXe_dao = new LoaiXe_DAO();
		
		
		loadDSNhaCungCap();

		txtMaHD.setText(generateMaHoaDon());
    	txtNgayDatHang.setText(getCurrentDate());
		
		tableNCC.addMouseListener(this);
		tableXe.addMouseListener(this);

		btnChonNCC.addActionListener(this);
		btnNhapHang.addActionListener(this);
		btnThemXe.addActionListener(this);
	}
	

	private String taoSoKhungXe() {
	    String[] characters = "0123456789ABCDEFGHJKLMNPRSTUVWXYZ".split("");
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 4; i++) {
	        int index = random.nextInt(characters.length);
	        sb.append(characters[index]);
	    }
	    sb.append("-"); 
	    for (int i = 0; i < 12; i++) {
	        int index = random.nextInt(characters.length);
	        sb.append(characters[index]);
	    }
	    return sb.toString();
	}

	private boolean kiemTraTrungSoKhung(String soKhung) {
		ArrayList<XeMay> dsXemay = xe_dao.getAllXeMay();
		for (XeMay xeMay : dsXemay) {
			if (soKhung.trim().equals(xeMay.getSoKhung())) {
				return false;
			}
		}
		return true;
	}
	
	public String sinhSoKhungXe() {
	    String soKhung = "";
	    boolean trung;
	    do {
	        soKhung = taoSoKhungXe();
	        trung = kiemTraTrungSoKhung(soKhung);
	    } while (!trung);
	    return soKhung;
	}

	
	
	
	private void nhapXE() throws Exception {
		DefaultTableModel tableModel = (DefaultTableModel) tableChiTietHD.getModel();
	    int rowCount = tableModel.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        String tenXe = tableModel.getValueAt(i, 1).toString();
	        String maNCC = txtMaNCC.getText();
	        XeMay xeMay = xe_dao.getXeMayTheoTen(tenXe);
	        xeMay.setNhaCungCap(new NhaCungCap(maNCC));
	        xeMay.setSoKhung(sinhSoKhungXe());
	        xe_dao.themXeMay(xeMay);
	    }
	    JOptionPane.showMessageDialog(this, "Thêm xe thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    tableModel.setRowCount(0);
	    txtMaHD.setText(generateMaHoaDon());
	    txtHDTenNCC.setText("");
	    txtNgayDatHang.setText(getCurrentDate());
	    lblSoTien.setText("0 VND");
	}
	
	private void loadDSXe() {
	    String maNCC = txtMaNCC.getText();
	    DefaultTableModel tableModelXe = (DefaultTableModel) tableXe.getModel();
	    ArrayList<XeMay> dsXe = xe_dao.getDSXeMayTheoMaNCC(maNCC);
	    tableModelXe.setRowCount(0); 
	    for (XeMay xe : dsXe) {
	        String hangXe = xe.getLoaiXe().getTenHang();
	        String loaiXe = xe.getLoaiXe().getTenLoaiXe();
	        String mauXe = xe.getMauXe();
	        String tenXe = xe.getTenXe();
	        XeMay xeimg = xe_dao.getXeMayTheoTen(tenXe);
			String anhXe = xeimg.getAnhMinhHoa();
	        tableModelXe.addRow(new Object[] { tenXe ,loaiXe ,mauXe ,hangXe,anhXe}); 
	    }
	}

	private void loadDSNhaCungCap() {
		DefaultTableModel tableModel = (DefaultTableModel) tableNCC.getModel();
		tableModel.setRowCount(0);
		ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		    if (!dsNCC.isEmpty()) {
		        for (NhaCungCap ncc : dsNCC) {
		            String maNCC = ncc.getMaNCC();
		            String tenNCC = ncc.getTenNCC();
		            tableModel.addRow(new Object[] { maNCC, tenNCC });
		        }
		  }
	}
	

    
    private String generateMaHoaDon() {
        String prefix = "HD";
        String middle = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String suffix = String.format("%03d", stt++);
        return prefix + middle + suffix;
    }
    
    private String getCurrentDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(currentDate);
    }
	
    private void themXeHD() {
    	DecimalFormat df = new DecimalFormat("#,###,###,##0.##");
    	txtHDTenNCC.setText(txtTenNCC.getText());
    	DefaultTableModel tableModel = (DefaultTableModel) tableChiTietHD.getModel();
		String tenXe = txtTenXe.getText();
		String soLuong = txtSoLuong.getText();
		XeMay xe = xe_dao.getXeMayTheoTen(tenXe);
		double giaXe = xe.getGia();
		if (soLuong.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Số lượng không được rỗng!");
	        txtSoLuong.requestFocus();
	        return;
	    }
		try {
	        int soLuongInt = Integer.parseInt(soLuong);
	        if (soLuongInt == 0) {
	        	JOptionPane.showMessageDialog(this, "Số lượng không được bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        txtSoLuong.requestFocus();
		        return;
	        }
	        double thanhTien = soLuongInt*giaXe;
	        tableModel.addRow(new Object[] {sttXe, tenXe, soLuongInt , df.format(giaXe),df.format(soLuongInt*giaXe)});
	        soTien += thanhTien;
	        sttXe++;
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        txtSoLuong.requestFocus();
	    }
		lblSoTien.setText(df.format(soTien));
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableNCC)) {
			int rowSl = tableNCC.getSelectedRow();
			txtMaNCC.setText(tableNCC.getValueAt(rowSl, 0).toString());
			txtTenNCC.setText(tableNCC.getValueAt(rowSl, 1).toString());
		}
		if (o.equals(tableXe)) {
			int rowSl = tableXe.getSelectedRow();
			txtTenXe.setText(tableXe.getValueAt(rowSl, 0).toString());
			txtLoaiXe.setText(tableXe.getValueAt(rowSl, 1).toString());
			txtMauXe.setText(tableXe.getValueAt(rowSl, 2).toString());
			txtHangXe.setText(tableXe.getValueAt(rowSl, 3).toString());
			linkimgXeMay = "data//image//" + tableXe.getValueAt(rowSl, 4).toString();
			ImageIcon image = new ImageIcon( new ImageIcon(linkimgXeMay).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
			lblAnhMinhHoa.setIcon(image);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
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
		Object o = e.getSource();
		if(o.equals(btnChonNCC)) {
			loadDSXe();
		}
		if(o.equals(btnThemXe)) {
			themXeHD();
		}
		if(o.equals(btnNhapHang)) {
			try {
				nhapXE();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}