package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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

public class GUI_QLBaoHanh extends JPanel {
	private JTable table;
	private DefaultTableModel tableModelLinhKien;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtChucVu;
	private JTextField txtTenXe;
	private JTextField txtSoMay;
	private JTextField textField_9;
	private JTextField textField_12;
	private JTextField textField_11;
	private JTextField textField_10;
	private JButton btnNewButton;

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
		gbl_panelTitle.columnWidths = new int[] { 94, 300, 502, 0, 0 };
		gbl_panelTitle.rowHeights = new int[] { 30, 25, 20, 0 };
		gbl_panelTitle.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelTitle.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTitle.setLayout(gbl_panelTitle);

		JLabel lblPhiuBoHnh = new JLabel("PHIẾU BẢO HÀNH");
		lblPhiuBoHnh.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		lblPhiuBoHnh.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhiuBoHnh = new GridBagConstraints();
		gbc_lblPhiuBoHnh.gridwidth = 4;
		gbc_lblPhiuBoHnh.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhiuBoHnh.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhiuBoHnh.gridx = 0;
		gbc_lblPhiuBoHnh.gridy = 0;
		panelTitle.add(lblPhiuBoHnh, gbc_lblPhiuBoHnh);

		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelTitle.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("001");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panelTitle.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Giờ (nhận/giao xe):");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 1;
		panelTitle.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_7 = new JLabel("9h/10h");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 1;
		panelTitle.add(lblNewLabel_7, gbc_lblNewLabel_7);

		JLabel lblNewLabel_2 = new JLabel("Ngày lập:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panelTitle.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("01/01/2023");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panelTitle.add(lblNewLabel_3, gbc_lblNewLabel_3);

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
		txtChucVu.setColumns(10);
		GridBagConstraints gbc_txtChucVu = new GridBagConstraints();
		gbc_txtChucVu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChucVu.insets = new Insets(0, 0, 0, 5);
		gbc_txtChucVu.gridx = 1;
		gbc_txtChucVu.gridy = 1;
		panelThongTinNV.add(txtChucVu, gbc_txtChucVu);

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
		GridBagConstraints gbc_txtTenKH = new GridBagConstraints();
		gbc_txtTenKH.insets = new Insets(0, 0, 5, 0);
		gbc_txtTenKH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenKH.gridx = 3;
		gbc_txtTenKH.gridy = 0;
		panelThongTinKH.add(txtTenKH, gbc_txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSDT = new GridBagConstraints();
		gbc_lblSDT.anchor = GridBagConstraints.EAST;
		gbc_lblSDT.insets = new Insets(0, 0, 5, 5);
		gbc_lblSDT.gridx = 0;
		gbc_lblSDT.gridy = 1;
		panelThongTinKH.add(lblSDT, gbc_lblSDT);

		txtSDT = new JTextField();
		GridBagConstraints gbc_txtSDT = new GridBagConstraints();
		gbc_txtSDT.insets = new Insets(0, 0, 5, 5);
		gbc_txtSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSDT.gridx = 1;
		gbc_txtSDT.gridy = 1;
		panelThongTinKH.add(txtSDT, gbc_txtSDT);
		txtSDT.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.EAST;
		gbc_lblDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaChi.gridx = 2;
		gbc_lblDiaChi.gridy = 1;
		panelThongTinKH.add(lblDiaChi, gbc_lblDiaChi);

		txtDiaChi = new JTextField();
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.insets = new Insets(0, 0, 5, 0);
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridx = 3;
		gbc_txtDiaChi.gridy = 1;
		panelThongTinKH.add(txtDiaChi, gbc_txtDiaChi);
		txtDiaChi.setColumns(10);

		JLabel lblTenXe = new JLabel("Tên xe");
		lblTenXe.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblTenXe = new GridBagConstraints();
		gbc_lblTenXe.anchor = GridBagConstraints.EAST;
		gbc_lblTenXe.insets = new Insets(0, 0, 0, 5);
		gbc_lblTenXe.gridx = 0;
		gbc_lblTenXe.gridy = 2;
		panelThongTinKH.add(lblTenXe, gbc_lblTenXe);

		txtTenXe = new JTextField();
		GridBagConstraints gbc_txtTenXe = new GridBagConstraints();
		gbc_txtTenXe.insets = new Insets(0, 0, 0, 5);
		gbc_txtTenXe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenXe.gridx = 1;
		gbc_txtTenXe.gridy = 2;
		panelThongTinKH.add(txtTenXe, gbc_txtTenXe);
		txtTenXe.setColumns(10);

		JLabel lblSoMay = new JLabel("Số máy");
		lblSoMay.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSoMay = new GridBagConstraints();
		gbc_lblSoMay.anchor = GridBagConstraints.EAST;
		gbc_lblSoMay.insets = new Insets(0, 0, 0, 5);
		gbc_lblSoMay.gridx = 2;
		gbc_lblSoMay.gridy = 2;
		panelThongTinKH.add(lblSoMay, gbc_lblSoMay);

		txtSoMay = new JTextField();
		GridBagConstraints gbc_txtSoMay = new GridBagConstraints();
		gbc_txtSoMay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSoMay.gridx = 3;
		gbc_txtSoMay.gridy = 2;
		panelThongTinKH.add(txtSoMay, gbc_txtSoMay);
		txtSoMay.setColumns(10);

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
				if (column == 0) return false;
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

		JLabel lblNewLabel_5_1 = new JLabel("Tổng tiền công");
		lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 0;
		panelTinhTien.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);

		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.BOTH;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 0;
		panelTinhTien.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tổng tiền linh kiện");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panelTinhTien.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textField_12 = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.fill = GridBagConstraints.BOTH;
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 1;
		panelTinhTien.add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Thuế GTGT");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 2;
		panelTinhTien.add(lblNewLabel_8, gbc_lblNewLabel_8);

		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.BOTH;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 2;
		panelTinhTien.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Tổng tiền phải trả");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panelTinhTien.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.fill = GridBagConstraints.BOTH;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 3;
		panelTinhTien.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);

		btnNewButton = new JButton("In hóa đơn");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setIcon(new ImageIcon(imagePrinter));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		panelTinhTien.add(btnNewButton, gbc_btnNewButton);

	}

}
