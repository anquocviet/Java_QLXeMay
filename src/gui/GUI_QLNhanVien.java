package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

public class GUI_QLNhanVien extends JPanel implements ActionListener, MouseListener{

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtNgaySinh;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtMaMV;
	private JTextField txtNgayVaoLam;
	private JTextField txtMucLuong;
	private JTextField txtBacTho;
	private JTextField txtPhongBan;
	private JTextField txtNamKinhNghiem;
	private JTextField txtTrinhDoHocVan;
	private JTextField txtChucVu;
	private JComboBox cbxLoaiNhanVien;
	private JPanel pNhanVienHanhChinh;
	private JPanel pNhanVienKyThuat;
	private JPanel pThongTinCongViec;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JTextField txtTimKiem;

	/**
	 * Create the panel.
	 */
	public GUI_QLNhanVien() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel pThongTinXeMay = new JPanel();
		pThongTinXeMay.setBackground(new Color(255, 255, 255));
		pThongTinXeMay.setBounds(0, 0, 568, 248);
		add(pThongTinXeMay);
		pThongTinXeMay.setLayout(null);
		pThongTinXeMay.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin cá nhân"));

		JPanel pHo = new JPanel();
		pHo.setBackground(new Color(255, 255, 255));
		pHo.setBounds(17, 40, 273, 45);
		pThongTinXeMay.add(pHo);
		pHo.setLayout(null);
		JLabel lblNewLabel = new JLabel("Họ:");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pHo.add(lblNewLabel);
		txtHo = new JTextField();
		txtHo.setBounds(73, 5, 200, 29);
		pHo.add(txtHo);
		txtHo.setColumns(10);

		JPanel pMaNV_1 = new JPanel();
		pMaNV_1.setLayout(null);
		pMaNV_1.setBackground(Color.WHITE);
		pMaNV_1.setBounds(316, 40, 242, 45);
		pThongTinXeMay.add(pMaNV_1);

		JLabel lblNewLabel_1 = new JLabel("Tên:");
		lblNewLabel_1.setBounds(0, 12, 80, 14);
		pMaNV_1.add(lblNewLabel_1);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(50, 5, 186, 29);
		pMaNV_1.add(txtTen);

		JPanel pMaNV_2 = new JPanel();
		pMaNV_2.setLayout(null);
		pMaNV_2.setBackground(Color.WHITE);
		pMaNV_2.setBounds(17, 84, 273, 45);
		pThongTinXeMay.add(pMaNV_2);

		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setBounds(0, 12, 80, 14);
		pMaNV_2.add(lblNewLabel_2);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(73, 5, 200, 29);
		pMaNV_2.add(txtNgaySinh);

		JPanel pMaNV_3_1 = new JPanel();
		pMaNV_3_1.setLayout(null);
		pMaNV_3_1.setBackground(Color.WHITE);
		pMaNV_3_1.setBounds(17, 180, 541, 45);
		pThongTinXeMay.add(pMaNV_3_1);

		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_3_1.setBounds(0, 12, 80, 14);
		pMaNV_3_1.add(lblNewLabel_3_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(76, 5, 455, 29);
		pMaNV_3_1.add(txtDiaChi);

		JPanel pMaNV_3_2 = new JPanel();
		pMaNV_3_2.setLayout(null);
		pMaNV_3_2.setBackground(Color.WHITE);
		pMaNV_3_2.setBounds(17, 130, 273, 45);
		pThongTinXeMay.add(pMaNV_3_2);

		JLabel lblNewLabel_3_2 = new JLabel("Số điện thoại:");
		lblNewLabel_3_2.setBounds(0, 12, 80, 14);
		pMaNV_3_2.add(lblNewLabel_3_2);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(76, 5, 197, 29);
		pMaNV_3_2.add(txtSDT);

		JPanel pMaNV_3_3 = new JPanel();
		pMaNV_3_3.setLayout(null);
		pMaNV_3_3.setBackground(Color.WHITE);
		pMaNV_3_3.setBounds(315, 130, 243, 45);
		pThongTinXeMay.add(pMaNV_3_3);

		JLabel lblNewLabel_3_3 = new JLabel("Email");
		lblNewLabel_3_3.setBounds(0, 12, 80, 14);
		pMaNV_3_3.add(lblNewLabel_3_3);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(52, 5, 184, 29);
		pMaNV_3_3.add(txtEmail);

		JPanel pMaNV_1_1 = new JPanel();
		pMaNV_1_1.setLayout(null);
		pMaNV_1_1.setBackground(Color.WHITE);
		pMaNV_1_1.setBounds(316, 84, 242, 45);
		pThongTinXeMay.add(pMaNV_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setBounds(0, 12, 56, 14);
		pMaNV_1_1.add(lblNewLabel_1_1);

		JCheckBox chckbxGioiTinh = new JCheckBox("Nam");
		chckbxGioiTinh.setBackground(new Color(255, 255, 255));
		chckbxGioiTinh.setBounds(49, 8, 187, 23);
		pMaNV_1_1.add(chckbxGioiTinh);

		pThongTinCongViec = new JPanel();
		pThongTinCongViec.setBackground(new Color(255, 255, 255));
		pThongTinCongViec.setBounds(567, 0, 613, 248);
		add(pThongTinCongViec);
		pThongTinCongViec.setLayout(null);
		pThongTinCongViec.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin công việc"));

		JPanel pLoaiNhanVien = new JPanel();
		pLoaiNhanVien.setLayout(null);
		pLoaiNhanVien.setBackground(Color.WHITE);
		pLoaiNhanVien.setBounds(10, 22, 254, 45);
		pThongTinCongViec.add(pLoaiNhanVien);
		JLabel lblNewLabel_3_1_1 = new JLabel("Loại nhân viên:");
		lblNewLabel_3_1_1.setBounds(0, 12, 116, 14);
		pLoaiNhanVien.add(lblNewLabel_3_1_1);
		cbxLoaiNhanVien = new JComboBox();
		cbxLoaiNhanVien.setBounds(102, 6, 152, 26);
		pLoaiNhanVien.add(cbxLoaiNhanVien);
		cbxLoaiNhanVien.addItem("Nhân viên hành chính");
		cbxLoaiNhanVien.addItem("Nhân viên kỹ thuật");

		themGiaoDienLoaiNhanVien();

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ thường trú", "SĐT", "Email",
				"Ngày vào làm", "Mức lương", "Chức vụ", "Trình độ học vấn", "Phòng ban", "Bậc thợ",
				"Số năm kinh nghiệm" };
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("data\\lamMoi.png"));
		btnLamMoi.setBounds(414, 259, 122, 37);
		add(btnLamMoi);
		btnLamMoi.setForeground(new Color(128, 0, 0));
		btnLamMoi.setBackground(new Color(75, 209, 254));

		btnSua = new JButton("Sửa");
		btnSua.setBounds(282, 259, 98, 37);
		add(btnSua);
		btnSua.setIcon(new ImageIcon("data\\sua.png"));
		btnSua.setForeground(new Color(128, 0, 0));
		btnSua.setBackground(new Color(75, 209, 254));

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(154, 259, 98, 37);
		add(btnXoa);
		btnXoa.setIcon(new ImageIcon("data\\xoa.png"));
		btnXoa.setForeground(new Color(128, 0, 0));
		btnXoa.setBackground(new Color(75, 209, 254));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(30, 259, 98, 37);
		add(btnThem);
		btnThem.setIcon(new ImageIcon("data\\them.png"));
		btnThem.setBackground(new Color(75, 209, 254));
		btnThem.setForeground(new Color(128, 0, 0));

		cbxLoaiNhanVien.addActionListener(this);
		
		JButton btnLocTheoLoaiNV = new JButton("Làm mới");
		btnLocTheoLoaiNV.setForeground(new Color(128, 0, 0));
		btnLocTheoLoaiNV.setBackground(new Color(75, 209, 254));
		btnLocTheoLoaiNV.setBounds(567, 259, 122, 37);
		add(btnLocTheoLoaiNV);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(857, 259, 302, 35);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm nhân viên:");
		lblNewLabel_3.setBounds(10, 11, 99, 14);
		panel.add(lblNewLabel_3);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(103, 1, 189, 35);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);

	}

	public void createIconImage(JLabel x, int W, int H, String path) {
		ImageIcon image = new ImageIcon(
				new ImageIcon(path).getImage().getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH));
		x.setIcon(image);
		repaint();
		revalidate();
	}

	private void taoNhanVienHanhChinh(JPanel pThongTinCongViec) {
		pNhanVienHanhChinh = new JPanel();
		pNhanVienHanhChinh.setBackground(new Color(255, 255, 255));
		pNhanVienHanhChinh.setBounds(10, 66, 593, 177);
		pThongTinCongViec.add(pNhanVienHanhChinh);
		pNhanVienHanhChinh.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Nhân viên hành chính"));
		pNhanVienHanhChinh.setLayout(null);

		JPanel pMaNV = new JPanel();
		pMaNV.setLayout(null);
		pMaNV.setBackground(Color.WHITE);
		pMaNV.setBounds(47, 26, 254, 45);
		pNhanVienHanhChinh.add(pMaNV);
		JLabel lblNewLabel_3_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_1_2.setBounds(0, 12, 80, 14);
		pMaNV.add(lblNewLabel_3_1_2);
		txtMaMV = new JTextField();
		txtMaMV.setColumns(10);
		txtMaMV.setBounds(77, 5, 177, 29);
		pMaNV.add(txtMaMV);

		JPanel pNgayVaoLam = new JPanel();
		pNgayVaoLam.setLayout(null);
		pNgayVaoLam.setBackground(Color.WHITE);
		pNgayVaoLam.setBounds(47, 70, 254, 45);
		pNhanVienHanhChinh.add(pNgayVaoLam);
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào làm:");
		lblNewLabel_3_1_2_1.setBounds(0, 12, 80, 14);
		pNgayVaoLam.add(lblNewLabel_3_1_2_1);
		txtNgayVaoLam = new JTextField();
		txtNgayVaoLam.setColumns(10);
		txtNgayVaoLam.setBounds(77, 5, 177, 29);
		pNgayVaoLam.add(txtNgayVaoLam);

		JPanel pMucLuong = new JPanel();
		pMucLuong.setLayout(null);
		pMucLuong.setBackground(Color.WHITE);
		pMucLuong.setBounds(47, 115, 254, 45);
		pNhanVienHanhChinh.add(pMucLuong);
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Mức lương:");
		lblNewLabel_3_1_2_2.setBounds(0, 12, 80, 14);
		pMucLuong.add(lblNewLabel_3_1_2_2);
		txtMucLuong = new JTextField();
		txtMucLuong.setColumns(10);
		txtMucLuong.setBounds(77, 5, 177, 29);
		pMucLuong.add(txtMucLuong);

		JPanel pPhongBan = new JPanel();
		pPhongBan.setLayout(null);
		pPhongBan.setBackground(Color.WHITE);
		pPhongBan.setBounds(311, 26, 272, 45);
		pNhanVienHanhChinh.add(pPhongBan);
		JLabel lblNewLabel_3_1_2_3 = new JLabel("Phòng ban:");
		lblNewLabel_3_1_2_3.setBounds(0, 12, 80, 14);
		pPhongBan.add(lblNewLabel_3_1_2_3);
		txtPhongBan = new JTextField();
		txtPhongBan.setColumns(10);
		txtPhongBan.setBounds(95, 5, 177, 29);
		pPhongBan.add(txtPhongBan);

		JPanel pHocVan = new JPanel();
		pHocVan.setLayout(null);
		pHocVan.setBackground(Color.WHITE);
		pHocVan.setBounds(311, 70, 272, 45);
		pNhanVienHanhChinh.add(pHocVan);
		JLabel lblNewLabel_3_1_2_4 = new JLabel("Trình độ học vấn:");
		lblNewLabel_3_1_2_4.setBounds(0, 12, 98, 14);
		pHocVan.add(lblNewLabel_3_1_2_4);
		txtTrinhDoHocVan = new JTextField();
		txtTrinhDoHocVan.setColumns(10);
		txtTrinhDoHocVan.setBounds(95, 5, 177, 29);
		pHocVan.add(txtTrinhDoHocVan);

		JPanel pMaNV_8 = new JPanel();
		pMaNV_8.setLayout(null);
		pMaNV_8.setBackground(Color.WHITE);
		pMaNV_8.setBounds(311, 115, 272, 45);
		pNhanVienHanhChinh.add(pMaNV_8);
		JLabel lblNewLabel_3_1_2_5 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_2_5.setBounds(10, 12, 80, 14);
		pMaNV_8.add(lblNewLabel_3_1_2_5);
		txtChucVu = new JTextField();
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(95, 5, 177, 29);
		pMaNV_8.add(txtChucVu);
	}

	private void taoNhanVienKyThuat(JPanel pThongTinCongViec) {
		pNhanVienKyThuat = new JPanel();
		pNhanVienKyThuat.setBackground(new Color(255, 255, 255));
		pNhanVienKyThuat.setBounds(10, 66, 593, 177);
		pThongTinCongViec.add(pNhanVienKyThuat);
		pNhanVienKyThuat.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Nhân viên kỹ thuật"));
		pNhanVienKyThuat.setLayout(null);

		JPanel pMaNV = new JPanel();
		pMaNV.setLayout(null);
		pMaNV.setBackground(Color.WHITE);
		pMaNV.setBounds(47, 26, 254, 45);
		pNhanVienKyThuat.add(pMaNV);
		JLabel lblNewLabel_3_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_1_2.setBounds(0, 12, 80, 14);
		pMaNV.add(lblNewLabel_3_1_2);
		txtMaMV = new JTextField();
		txtMaMV.setColumns(10);
		txtMaMV.setBounds(77, 5, 177, 29);
		pMaNV.add(txtMaMV);

		JPanel pMaNV_4 = new JPanel();
		pMaNV_4.setLayout(null);
		pMaNV_4.setBackground(Color.WHITE);
		pMaNV_4.setBounds(47, 70, 254, 45);
		pNhanVienKyThuat.add(pMaNV_4);
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào làm:");
		lblNewLabel_3_1_2_1.setBounds(0, 12, 80, 14);
		pMaNV_4.add(lblNewLabel_3_1_2_1);
		txtNgayVaoLam = new JTextField();
		txtNgayVaoLam.setColumns(10);
		txtNgayVaoLam.setBounds(77, 5, 177, 29);
		pMaNV_4.add(txtNgayVaoLam);

		JPanel pMaNV_5 = new JPanel();
		pMaNV_5.setLayout(null);
		pMaNV_5.setBackground(Color.WHITE);
		pMaNV_5.setBounds(47, 115, 254, 45);
		pNhanVienKyThuat.add(pMaNV_5);
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Mức lương:");
		lblNewLabel_3_1_2_2.setBounds(0, 12, 80, 14);
		pMaNV_5.add(lblNewLabel_3_1_2_2);
		txtMucLuong = new JTextField();
		txtMucLuong.setColumns(10);
		txtMucLuong.setBounds(77, 5, 177, 29);
		pMaNV_5.add(txtMucLuong);

		JPanel pBacTho = new JPanel();
		pBacTho.setLayout(null);
		pBacTho.setBackground(Color.WHITE);
		pBacTho.setBounds(311, 26, 272, 45);
		pNhanVienKyThuat.add(pBacTho);
		JLabel lblNewLabel_3_1_2_3 = new JLabel("Bậc thợ:");
		lblNewLabel_3_1_2_3.setBounds(0, 12, 80, 14);
		pBacTho.add(lblNewLabel_3_1_2_3);
		txtBacTho = new JTextField();
		txtBacTho.setColumns(10);
		txtBacTho.setBounds(95, 5, 177, 29);
		pBacTho.add(txtBacTho);

		JPanel pMaNV_7 = new JPanel();
		pMaNV_7.setLayout(null);
		pMaNV_7.setBackground(Color.WHITE);
		pMaNV_7.setBounds(311, 70, 272, 45);
		pNhanVienKyThuat.add(pMaNV_7);
		JLabel lblNewLabel_3_1_2_4 = new JLabel("Số năm KN:");
		lblNewLabel_3_1_2_4.setBounds(0, 12, 98, 14);
		pMaNV_7.add(lblNewLabel_3_1_2_4);
		txtNamKinhNghiem = new JTextField();
		txtNamKinhNghiem.setColumns(10);
		txtNamKinhNghiem.setBounds(95, 5, 177, 29);
		pMaNV_7.add(txtNamKinhNghiem);

		JPanel pMaNV_8 = new JPanel();
		pMaNV_8.setLayout(null);
		pMaNV_8.setBackground(Color.WHITE);
		pMaNV_8.setBounds(311, 115, 272, 45);
		pNhanVienKyThuat.add(pMaNV_8);
		JLabel lblNewLabel_3_1_2_5 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_2_5.setBounds(10, 12, 80, 14);
		pMaNV_8.add(lblNewLabel_3_1_2_5);
		txtChucVu = new JTextField();
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(95, 5, 177, 29);
		pMaNV_8.add(txtChucVu);
	}

	private void themGiaoDienLoaiNhanVien() {

		if (cbxLoaiNhanVien.getSelectedIndex() == 1) {
			if(pNhanVienHanhChinh!=null) pThongTinCongViec.remove(pNhanVienHanhChinh);
			taoNhanVienKyThuat(pThongTinCongViec);
		} else {
			if(pNhanVienKyThuat!=null) pThongTinCongViec.remove(pNhanVienKyThuat);
			taoNhanVienHanhChinh(pThongTinCongViec);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(cbxLoaiNhanVien)) {
			themGiaoDienLoaiNhanVien();
		}if(o.equals(btnThem)) {
			
		}if(o.equals(btnXoa)) {
			
		}if(o.equals(btnSua)) {
			
		}if(o.equals(btnLamMoi)) {
			
		}

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
}
