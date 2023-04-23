package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_ThongKeLoaiXe extends JPanel {
	private JTextField txtMaLoaiXe;
	private JTextField txtTenLoaiXe;
	private JTextField txtTenHang;
	private JTextField txtSoPhanKhoi;
	private JTextField txtDongTietKiem;
	private JTextField txtSoLo;
	private JTextField txtNhaCungCap;
	private JTextField txtTenNuocNhap;
	private JTextField txtSoLuongNhap;
	private JTextField txtNgayNhapKho;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public GUI_ThongKeLoaiXe() {
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Thống kê loại xe");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblTitle.setBounds(505, 23, 356, 37);
		add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin lo\u1EA1i xe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 81, 469, 378);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMaLoaiXe = new JLabel("Mã loại xe");
		lblMaLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaLoaiXe.setBounds(23, 28, 80, 14);
		panel.add(lblMaLoaiXe);
		
		txtMaLoaiXe = new JTextField();
		txtMaLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaLoaiXe.setBounds(139, 25, 302, 20);
		panel.add(txtMaLoaiXe);
		txtMaLoaiXe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên loại xe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(23, 64, 69, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên hãng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 89, 69, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số phân khối");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(23, 127, 93, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dòng tiết kiệm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 163, 93, 14);
		panel.add(lblNewLabel_3);
		
		txtTenLoaiXe = new JTextField();
		txtTenLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenLoaiXe.setColumns(10);
		txtTenLoaiXe.setBounds(139, 56, 302, 20);
		panel.add(txtTenLoaiXe);
		
		txtTenHang = new JTextField();
		txtTenHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenHang.setColumns(10);
		txtTenHang.setBounds(139, 90, 302, 20);
		panel.add(txtTenHang);
		
		txtSoPhanKhoi = new JTextField();
		txtSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoPhanKhoi.setColumns(10);
		txtSoPhanKhoi.setBounds(139, 124, 302, 20);
		panel.add(txtSoPhanKhoi);
		
		txtDongTietKiem = new JTextField();
		txtDongTietKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDongTietKiem.setColumns(10);
		txtDongTietKiem.setBounds(139, 160, 302, 20);
		panel.add(txtDongTietKiem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "L\u00F4 h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(23, 191, 424, 176);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Số lô");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 25, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nhà cung cấp");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 53, 93, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tên nước nhập");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 82, 107, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Số lượng nhập");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 109, 107, 19);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày nhập kho");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(10, 139, 107, 18);
		panel_1.add(lblNewLabel_8);
		
		txtSoLo = new JTextField();
		txtSoLo.setBounds(121, 23, 293, 20);
		panel_1.add(txtSoLo);
		txtSoLo.setColumns(10);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setColumns(10);
		txtNhaCungCap.setBounds(121, 51, 293, 20);
		panel_1.add(txtNhaCungCap);
		
		txtTenNuocNhap = new JTextField();
		txtTenNuocNhap.setColumns(10);
		txtTenNuocNhap.setBounds(121, 80, 293, 20);
		panel_1.add(txtTenNuocNhap);
		
		txtSoLuongNhap = new JTextField();
		txtSoLuongNhap.setColumns(10);
		txtSoLuongNhap.setBounds(121, 107, 293, 20);
		panel_1.add(txtSoLuongNhap);
		
		txtNgayNhapKho = new JTextField();
		txtNgayNhapKho.setColumns(10);
		txtNgayNhapKho.setBounds(121, 137, 293, 20);
		panel_1.add(txtNgayNhapKho);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(505, 87, 855, 368);
		add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 855, 368);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 lo\u1EA1i xe", "T\u00EAn lo\u1EA1i xe", "T\u00EAn h\u00E3ng", "S\u1ED1 ph\u00E2n kh\u1ED1i", "D\u00F2ng ti\u1EBFt ki\u1EC7m", "S\u1ED1 l\u00F4", "Nh\u00E0 cung c\u1EA5p", "T\u00EAn n\u01B0\u1EDBc", "S\u1ED1 l\u01B0\u1EE3ng nh\u1EADp", "Ng\u00E0y nh\u1EADp"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNhapKho = new JButton("Nhập kho");
		btnNhapKho.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNhapKho.setBounds(39, 496, 118, 37);
		add(btnNhapKho);
		
		JButton btnChinhKho = new JButton("Điều chỉnh kho");
		btnChinhKho.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChinhKho.setBounds(178, 496, 153, 37);
		add(btnChinhKho);
		
		JButton btnXoaLoaiXe = new JButton("Xóa ");
		btnXoaLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaLoaiXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaLoaiXe.setBounds(352, 496, 89, 37);
		add(btnXoaLoaiXe);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(505, 466, 855, 123);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Nhập mã loại xe");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(31, 21, 114, 22);
		panel_3.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(155, 23, 125, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTim.setBounds(301, 21, 53, 23);
		panel_3.add(btnTim);
		
		textField_1 = new JTextField();
		textField_1.setBounds(509, 23, 152, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Nhập tên loại xe");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(394, 26, 144, 14);
		panel_3.add(lblNewLabel_10);
		
		JButton btnThongKeLoaiXe = new JButton("Thống kê ");
		btnThongKeLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThongKeLoaiXe.setBounds(671, 22, 106, 23);
		panel_3.add(btnThongKeLoaiXe);
		
		JLabel lblNewLabel_11 = new JLabel("Nhập tên hãng");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(394, 59, 106, 22);
		panel_3.add(lblNewLabel_11);
		
		textField_2 = new JTextField();
		textField_2.setBounds(509, 61, 152, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnThongKeTenHang = new JButton("Thống kê ");
		btnThongKeTenHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThongKeTenHang.setBounds(671, 60, 106, 23);
		panel_3.add(btnThongKeTenHang);
		
	}
}
