package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
import java.util.ArrayList;

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
	private JComboBox cbLoaiXe;
	private JComboBox cbMauXe;
	private JComboBox cbHangXe;
	private JButton btnThemXe;
	private JButton btnNhapHang;
	private JLabel lblSoTien;
	private Image imgXeMay;
	private JTextField txtNgayDatHang;
	private XeMay_DAO xe_dao;
	private NhaCungCap_DAO ncc_dao;
	private HopDong_DAO hd_dao;
	private LoaiXe_DAO loaiXe_dao;

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
		gbl_panelInfoXe.rowHeights = new int[]{24, 24, 24, 24, 24, 0};
		gbl_panelInfoXe.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInfoXe.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
						
								cbLoaiXe = new JComboBox();
								GridBagConstraints gbc_cbLoaiXe = new GridBagConstraints();
								gbc_cbLoaiXe.fill = GridBagConstraints.BOTH;
								gbc_cbLoaiXe.insets = new Insets(0, 0, 5, 0);
								gbc_cbLoaiXe.gridx = 1;
								gbc_cbLoaiXe.gridy = 1;
								panelInfoXe.add(cbLoaiXe, gbc_cbLoaiXe);
				
						JLabel lblMauXe = new JLabel("Màu xe");
						lblMauXe.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblMauXe = new GridBagConstraints();
						gbc_lblMauXe.fill = GridBagConstraints.BOTH;
						gbc_lblMauXe.insets = new Insets(0, 0, 5, 5);
						gbc_lblMauXe.gridx = 0;
						gbc_lblMauXe.gridy = 2;
						panelInfoXe.add(lblMauXe, gbc_lblMauXe);
		
				cbMauXe = new JComboBox();
				GridBagConstraints gbc_cbMauXe = new GridBagConstraints();
				gbc_cbMauXe.fill = GridBagConstraints.BOTH;
				gbc_cbMauXe.insets = new Insets(0, 0, 5, 0);
				gbc_cbMauXe.gridx = 1;
				gbc_cbMauXe.gridy = 2;
				panelInfoXe.add(cbMauXe, gbc_cbMauXe);
				
						JLabel lblHangXe = new JLabel("Hãng xe");
						lblHangXe.setFont(new Font("Dialog", Font.BOLD, 12));
						GridBagConstraints gbc_lblHangXe = new GridBagConstraints();
						gbc_lblHangXe.fill = GridBagConstraints.BOTH;
						gbc_lblHangXe.insets = new Insets(0, 0, 5, 5);
						gbc_lblHangXe.gridx = 0;
						gbc_lblHangXe.gridy = 3;
						panelInfoXe.add(lblHangXe, gbc_lblHangXe);
				
						cbHangXe = new JComboBox();
						GridBagConstraints gbc_cbHangXe = new GridBagConstraints();
						gbc_cbHangXe.fill = GridBagConstraints.BOTH;
						gbc_cbHangXe.insets = new Insets(0, 0, 5, 0);
						gbc_cbHangXe.gridx = 1;
						gbc_cbHangXe.gridy = 3;
						panelInfoXe.add(cbHangXe, gbc_cbHangXe);
		
				JLabel lblSoLuong = new JLabel("Số lượng");
				lblSoLuong.setFont(new Font("Dialog", Font.BOLD, 12));
				GridBagConstraints gbc_lblSoLuong = new GridBagConstraints();
				gbc_lblSoLuong.fill = GridBagConstraints.BOTH;
				gbc_lblSoLuong.insets = new Insets(0, 0, 0, 5);
				gbc_lblSoLuong.gridx = 0;
				gbc_lblSoLuong.gridy = 4;
				panelInfoXe.add(lblSoLuong, gbc_lblSoLuong);
		
				txtSoLuong = new JTextField();
				GridBagConstraints gbc_txtSoLuong = new GridBagConstraints();
				gbc_txtSoLuong.fill = GridBagConstraints.BOTH;
				gbc_txtSoLuong.gridx = 1;
				gbc_txtSoLuong.gridy = 4;
				panelInfoXe.add(txtSoLuong, gbc_txtSoLuong);
				txtSoLuong.setColumns(10);

		String headerTableXe[] = "Tên xe;Màu sắc;Số lượng".split(";");
		tableModelXe = new DefaultTableModel(headerTableXe, 0);
		JScrollPane scrollPaneXe = new JScrollPane(tableXe = new JTable(tableModelXe));
		tableXe.setSelectionForeground(UIManager.getColor("Table.selectionInactiveForeground"));
		tableXe.setSelectionBackground(UIManager.getColor("Table.selectionInactiveBackground"));
		tableXe.getTableHeader().setFont(new Font(f.getName(), f.getStyle(), 13));
		tableXe.setFont(new Font(f.getName(), f.getStyle(), 14));
		tableXe.setRowHeight(24);
		panelChonXeLeft.add(scrollPaneXe, BorderLayout.CENTER);

		JPanel panelChonXeRight = new JPanel();
		panelChonXe.add(panelChonXeRight, BorderLayout.EAST);

		panelChonXeRight.setLayout(new BorderLayout(0, 0));
		JLabel lblAnhMinhHoa = new JLabel(new ImageIcon(imgXeMay));
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
//		loadDSXe();

		
		tableNCC.addMouseListener(this);
		tableXe.addMouseListener(this);

		btnChonNCC.addActionListener(this);
		btnNhapHang.addActionListener(this);
		btnThemXe.addActionListener(this);
	}
	
	private void themDSLoaiXeVaoComboBox() {
		loaiXe_dao.getAllLoaiXe().forEach(loaiXe -> {
			cbLoaiXe.addItem(loaiXe.getTenLoaiXe());
		});
	}
	private void themDSMauXeVaoComboBox() {
		xe_dao.getAllMauXe().forEach(mau -> {
			cbMauXe.addItem(mau);
		});
	}
	private void themDSHangXeVaoComboBox() {
		loaiXe_dao.getAllHangXe().forEach(hang -> {
			cbHangXe.addItem(hang);
		});

	}
	
	private void loadDSXe() {
		String maNCC = txtMaNCC.getText();
		tableModelXe.setRowCount(0);
		ArrayList<XeMay> dsXe = xe_dao.getDSXeMayTheoMaNCC(maNCC);
		xe_dao.getDSXeMayTheoMaNCC(maNCC).forEach(xe -> {
			tableModelXe.addRow(new Object[] { xe.getTenXe(), xe.getMauXe()});
		});
		themDSHangXeVaoComboBox();
		themDSLoaiXeVaoComboBox();
		themDSMauXeVaoComboBox();
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
		}
		
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
		Object o = e.getSource();
		if(o.equals(btnChonNCC)) {
			
			loadDSXe();
		}
		
	}

}