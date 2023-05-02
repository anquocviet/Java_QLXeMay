//package gui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.SortedSet;
//import java.util.TreeSet;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
//import connect.ConnectDB;
//import dao.LoaiXe_DAO;
//import dao.XeMay_DAO;
//import entity.LoaiXe;
//import entity.NhaCungCap;
//import entity.XeMay;
//
//import javax.swing.SwingConstants;
//
//public class GUI_QLXe extends JPanel implements ActionListener, MouseListener {
//
//	private JTable table;
//	private DefaultTableModel tableModel;
//	private JTextField txtSoKhung;
//	private JTextField txtTenXe;
//	private JTextField txtNuocSanXuat;
//	private JTextField txtSoMay;
//	private JTextField txtGia;
//	private JTextField txtNamSanXuat;
//	private JButton btnThem;
//	private JButton btnXoa;
//	private JButton btnSua;
//	private JButton btnLamMoi;
//	private JButton btnLoc;
//	private JTextField txtNhaCungCap;
//	private String anhMinhHoa;
//	private JComboBox cbxLoaiXe;
//	private JComboBox cbxMauXe;
//
//	private XeMay_DAO xeMay_DAO;
//	private LoaiXe_DAO loaiXe_DAO;
//	private JLabel lblIMG;
//	private JTextField txtAnhMinhHoa;
//
//	/**
//	 * Create the panel.
//	 */
//	public GUI_QLXe() {
//
//		try {
//			ConnectDB.getInstance().connect();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		xeMay_DAO = new XeMay_DAO();
//		loaiXe_DAO = new LoaiXe_DAO();
//
//		setBackground(new Color(255, 255, 255));
//		setLayout(null);
//
//		JPanel pThongTinXeMay = new JPanel();
//		pThongTinXeMay.setBackground(new Color(255, 255, 255));
//		pThongTinXeMay.setBounds(0, 0, 1180, 305);
//		add(pThongTinXeMay);
//		pThongTinXeMay.setLayout(null);
//		pThongTinXeMay.setBorder(
//				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin xe máy"));
//
//		JPanel pSoKhung = new JPanel();
//		pSoKhung.setBackground(new Color(255, 255, 255));
//		pSoKhung.setBounds(20, 21, 383, 45);
//		pThongTinXeMay.add(pSoKhung);
//		pSoKhung.setLayout(null);
//		JLabel lblNewLabel = new JLabel("Số khung: ");
//		lblNewLabel.setBounds(0, 12, 80, 14);
//		pSoKhung.add(lblNewLabel);
//		txtSoKhung = new JTextField();
//		txtSoKhung.setBounds(106, 5, 260, 29);
//		pSoKhung.add(txtSoKhung);
//		txtSoKhung.setColumns(10);
//
//		JPanel pTenXe = new JPanel();
//		pTenXe.setBackground(new Color(255, 255, 255));
//		pTenXe.setLayout(null);
//		pTenXe.setBounds(20, 105, 383, 45);
//		pThongTinXeMay.add(pTenXe);
//		JLabel lblNewLabel_1 = new JLabel("Tên xe:");
//		lblNewLabel_1.setBounds(0, 12, 82, 14);
//		pTenXe.add(lblNewLabel_1);
//		txtTenXe = new JTextField();
//		txtTenXe.setColumns(10);
//		txtTenXe.setBounds(106, 5, 260, 29);
//		pTenXe.add(txtTenXe);
//
//		JPanel pSoMay = new JPanel();
//		pSoMay.setBackground(new Color(255, 255, 255));
//		pSoMay.setLayout(null);
//		pSoMay.setBounds(20, 62, 383, 45);
//		pThongTinXeMay.add(pSoMay);
//		JLabel lblNewLabel_2 = new JLabel("Số máy:");
//		lblNewLabel_2.setBounds(0, 12, 78, 14);
//		pSoMay.add(lblNewLabel_2);
//		txtSoMay = new JTextField();
//		txtSoMay.setColumns(10);
//		txtSoMay.setBounds(106, 5, 260, 29);
//		pSoMay.add(txtSoMay);
//
//		JPanel pNuocSanXua = new JPanel();
//		pNuocSanXua.setBackground(new Color(255, 255, 255));
//		pNuocSanXua.setLayout(null);
//		pNuocSanXua.setBounds(20, 194, 383, 45);
//		pThongTinXeMay.add(pNuocSanXua);
//		JLabel lblNewLabel_3 = new JLabel("Nước sản xuất:");
//		lblNewLabel_3.setBounds(0, 12, 90, 14);
//		pNuocSanXua.add(lblNewLabel_3);
//		txtNuocSanXuat = new JTextField();
//		txtNuocSanXuat.setColumns(10);
//		txtNuocSanXuat.setBounds(106, 5, 260, 29);
//		pNuocSanXua.add(txtNuocSanXuat);
//
//		JPanel pLoaiXe = new JPanel();
//		pLoaiXe.setBackground(new Color(255, 255, 255));
//		pLoaiXe.setLayout(null);
//		pLoaiXe.setBounds(413, 21, 352, 45);
//		pThongTinXeMay.add(pLoaiXe);
//		JLabel lblLoiXe = new JLabel("Loại xe:");
//		lblLoiXe.setBounds(0, 12, 80, 14);
//		pLoaiXe.add(lblLoiXe);
//		cbxLoaiXe = new JComboBox();
//		cbxLoaiXe.setEditable(true);
//		cbxLoaiXe.setBounds(84, 8, 268, 26);
//		pLoaiXe.add(cbxLoaiXe);
//		docDanhSachLoaiXeVaoComboBox();
//
//		JPanel pMauXe = new JPanel();
//		pMauXe.setBackground(new Color(255, 255, 255));
//		pMauXe.setLayout(null);
//		pMauXe.setBounds(413, 62, 352, 45);
//		pThongTinXeMay.add(pMauXe);
//		JLabel lblNewLabel_5 = new JLabel("Màu xe:");
//		lblNewLabel_5.setBounds(0, 12, 74, 14);
//		pMauXe.add(lblNewLabel_5);
//		cbxMauXe = new JComboBox();
//		cbxMauXe.setEditable(true);
//		cbxMauXe.setBounds(84, 8, 268, 26);
//		pMauXe.add(cbxMauXe);
//		docDanhSachMauVaoComboBox();
//
//		JPanel pGia = new JPanel();
//		pGia.setBackground(new Color(255, 255, 255));
//		pGia.setLayout(null);
//		pGia.setBounds(413, 105, 352, 45);
//		pThongTinXeMay.add(pGia);
//		JLabel lblNewLabel_6 = new JLabel("Giá:");
//		lblNewLabel_6.setBounds(0, 12, 74, 14);
//		pGia.add(lblNewLabel_6);
//		txtGia = new JTextField();
//		txtGia.setColumns(10);
//		txtGia.setBounds(84, 5, 268, 29);
//		pGia.add(txtGia);
//
//		JPanel pNamSanXuat = new JPanel();
//		pNamSanXuat.setBackground(new Color(255, 255, 255));
//		pNamSanXuat.setLayout(null);
//		pNamSanXuat.setBounds(413, 149, 352, 45);
//		pThongTinXeMay.add(pNamSanXuat);
//		JLabel lblNewLabel_7 = new JLabel("Năm sản xuất:");
//		lblNewLabel_7.setBounds(0, 12, 84, 14);
//		pNamSanXuat.add(lblNewLabel_7);
//		txtNamSanXuat = new JTextField();
//		txtNamSanXuat.setColumns(10);
//		txtNamSanXuat.setBounds(84, 5, 268, 29);
//		pNamSanXuat.add(txtNamSanXuat);
//
//		Image imgThem = new ImageIcon("data/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//		btnThem = new JButton("Thêm");
//		btnThem.setIcon(new ImageIcon(imgThem));
//		btnThem.setBackground(new Color(75, 209, 254));
//		btnThem.setForeground(new Color(128, 0, 0));
//		btnThem.setBounds(20, 256, 98, 37);
//		pThongTinXeMay.add(btnThem);
//
//		btnXoa = new JButton("Xóa");
//		btnXoa.setIcon(new ImageIcon("data\\xoa.png"));
//		btnXoa.setForeground(new Color(128, 0, 0));
//		btnXoa.setBackground(new Color(75, 209, 254));
//		btnXoa.setBounds(128, 256, 98, 37);
//		pThongTinXeMay.add(btnXoa);
//
//		btnSua = new JButton("Sửa");
//		btnSua.setIcon(new ImageIcon("data\\sua.png"));
//		btnSua.setForeground(new Color(128, 0, 0));
//		btnSua.setBackground(new Color(75, 209, 254));
//		btnSua.setBounds(236, 256, 98, 37);
//		pThongTinXeMay.add(btnSua);
//
//		btnLamMoi = new JButton("Làm mới");
//		btnLamMoi.setIcon(new ImageIcon("data\\lamMoi.png"));
//		btnLamMoi.setForeground(new Color(128, 0, 0));
//		btnLamMoi.setBackground(new Color(75, 209, 254));
//		btnLamMoi.setBounds(345, 256, 122, 37);
//		pThongTinXeMay.add(btnLamMoi);
//
//		btnLoc = new JButton("Lọc");
//		btnLoc.setIcon(new ImageIcon("data\\filter.png"));
//		btnLoc.setForeground(new Color(128, 0, 0));
//		btnLoc.setBackground(new Color(75, 209, 254));
//		btnLoc.setBounds(480, 256, 98, 37);
//		pThongTinXeMay.add(btnLoc);
//
//		Box bTable = Box.createVerticalBox();
//		bTable.setBounds(0, 305, 1180, 294);
//		add(bTable);
//		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
//		String head[] = { "Số khung", "Số máy", "Tên xe", "Loại xe", "Màu xe", "Giá", "Tên nhà cung cấp",
//				"Nước sản xuất", "Năm sản xuất" };
//		tableModel = new DefaultTableModel(head, 0);
//		table = new JTable(tableModel);
//		table.setBackground(new Color(255, 255, 255));
//		bTable.add(new JScrollPane(table));
//
//		ArrayList<XeMay> dsXeMay = xeMay_DAO.getAllXeMay();
//		docDanhSachXeMayVaoTable(dsXeMay);
//
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(new Color(255, 255, 255));
//		panel_2.setBounds(810, 21, 345, 246);
//		pThongTinXeMay.add(panel_2);
//
//		lblIMG = new JLabel();
//		panel_2.add(lblIMG);
//		// =====ảnh tạm
//		anhMinhHoa = "data\\feature125.jpg";
//		createIconImage(lblIMG, 400, 230, anhMinhHoa);
//
//		JPanel pNhaCC = new JPanel();
//		pNhaCC.setLayout(null);
//		pNhaCC.setBackground(Color.WHITE);
//		pNhaCC.setBounds(20, 149, 383, 45);
//		pThongTinXeMay.add(pNhaCC);
//
//		JLabel lblNewLabel_3_1 = new JLabel("Tên nhà cung cấp:");
//		lblNewLabel_3_1.setBounds(0, 12, 106, 14);
//		pNhaCC.add(lblNewLabel_3_1);
//
//		txtNhaCungCap = new JTextField();
//		txtNhaCungCap.setColumns(10);
//		txtNhaCungCap.setBounds(106, 5, 260, 29);
//		pNhaCC.add(txtNhaCungCap);
//		
//		JPanel pNuocSanXua_1 = new JPanel();
//		pNuocSanXua_1.setLayout(null);
//		pNuocSanXua_1.setBackground(Color.WHITE);
//		pNuocSanXua_1.setBounds(413, 194, 352, 45);
//		pThongTinXeMay.add(pNuocSanXua_1);
//		
//		JLabel lblNewLabel_3_2 = new JLabel("Ảnh minh họa:");
//		lblNewLabel_3_2.setBounds(0, 12, 90, 14);
//		pNuocSanXua_1.add(lblNewLabel_3_2);
//		
//		txtAnhMinhHoa = new JTextField();
//		txtAnhMinhHoa.setColumns(10);
//		txtAnhMinhHoa.setBounds(85, 5, 267, 29);
//		pNuocSanXua_1.add(txtAnhMinhHoa);
//
//		btnLamMoi.addActionListener(this);
//		btnLoc.addActionListener(this);
//		btnSua.addActionListener(this);
//		btnThem.addActionListener(this);
//		btnXoa.addActionListener(this);
//
//		table.addMouseListener(this);
//
//	}
//
//	public void createIconImage(JLabel x, int W, int H, String path) {
//		ImageIcon image = new ImageIcon(
//				new ImageIcon(path).getImage().getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH));
//		x.setIcon(image);
//		repaint();
//		revalidate();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		if (o.equals(btnThem)) {
//			themXeMay();
//		}
//		if (o.equals(btnXoa)) {
//			xoaXeMay();
//		}
//		if (o.equals(btnSua)) {
//			suaXeMay();
//		}
//		if (o.equals(btnLamMoi)) {
//			lamMoi();
//		}
//		if (o.equals(btnLoc)) {
//			locTheoLoaiXe();
//		}
//
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		int row = table.getSelectedRow();
//		txtSoKhung.setText(tableModel.getValueAt(row, 0).toString());
//		txtSoMay.setText(tableModel.getValueAt(row, 1).toString());
//		txtTenXe.setText(tableModel.getValueAt(row, 2).toString());
//		cbxLoaiXe.setSelectedItem(tableModel.getValueAt(row, 3).toString());
//		cbxMauXe.setSelectedItem(tableModel.getValueAt(row, 4).toString());
//		txtGia.setText(tableModel.getValueAt(row, 5).toString());
//		txtNhaCungCap.setText(tableModel.getValueAt(row, 6).toString());
//		txtNuocSanXuat.setText(tableModel.getValueAt(row, 7).toString());
//		txtNamSanXuat.setText(tableModel.getValueAt(row, 8).toString());
//		// tìm ảnh minh họa theo số khung
//		anhMinhHoa ="data\\"+tableModel.getValueAt(row, 9).toString();
//		createIconImage(lblIMG, 400, 230, anhMinhHoa);
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
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
//	/**
//	 * Đọc danh sách loại xe vào combo box
//	 */
//	private void docDanhSachLoaiXeVaoComboBox() {
//		ArrayList<LoaiXe> dsLoaiXe = new ArrayList<LoaiXe>();
//		dsLoaiXe = loaiXe_DAO.getAllLoaiXe();
//		cbxLoaiXe.addItem("");
//		for (LoaiXe loaiXe : dsLoaiXe) {
//			cbxLoaiXe.addItem(loaiXe.getTenLoaiXe());
//		}
//	}
//
//	/**
//	 * đọc màu vào combo box nên sử dụng enum
//	 */
//	private void docDanhSachMauVaoComboBox() {
//		ArrayList<XeMay> dsXeMay = xeMay_DAO.getAllXeMay();
//		SortedSet<String> dsMauXe = new TreeSet<String>();
//		cbxMauXe.addItem("");
//		for (XeMay xeMay : dsXeMay) {
//			dsMauXe.add(xeMay.getMauXe());
//		}
//		for (String mau : dsMauXe) {
//			cbxMauXe.addItem(mau);
//		}
//	}
//
//	/**
//	 * đọc danh sách xe máy vào table
//	 */
//	private void docDanhSachXeMayVaoTable(ArrayList<XeMay> dsXeMay) {
//		LoaiXe loaiXe;
//		for (XeMay xeMay : dsXeMay) {
//			loaiXe = loaiXe_DAO.getLoaiXeTheoMa(xeMay.getLoaiXe().getMaLoaiXe());
//			tableModel.addRow(new Object[] { xeMay.getSoKhung(), xeMay.getSoMay(), xeMay.getTenXe(),
//					loaiXe.getTenLoaiXe(), xeMay.getMauXe(), xeMay.getGia(), xeMay.getNhaCungCap().getMaNCC(),
//					xeMay.getNuocSanXuat(), xeMay.getNamSanXuat() });
//		}
//	}
//
//	private void lamMoi() {
//		txtGia.setText("");
//		txtNamSanXuat.setText("");
//		txtNhaCungCap.setText("");
//		txtNuocSanXuat.setText("");
//		txtSoKhung.setText("");
//		txtSoMay.setText("");
//		txtTenXe.setText("");
//		cbxLoaiXe.setSelectedIndex(0);
//		cbxMauXe.setSelectedIndex(0);
//		txtAnhMinhHoa.setText("");
//		ArrayList<XeMay> dsXeMay = xeMay_DAO.getAllXeMay();
//		xoaDuLieuTrongTable();
//		docDanhSachXeMayVaoTable(dsXeMay);
//	}
//
//	private void xoaDuLieuTrongTable() {
//		DefaultTableModel dm = (DefaultTableModel) table.getModel();
//		dm.getDataVector().removeAllElements();
//		dm.fireTableDataChanged();
//	}
//
//	/**
//	 * loc xe theo loai xe
//	 */
//	private void locTheoLoaiXe() {
//		String tenLoaiXe = cbxLoaiXe.getSelectedItem().toString();
//		if (cbxLoaiXe.getSelectedIndex() == 0) {
//			ArrayList<XeMay> dsXeMay = xeMay_DAO.getAllXeMay();
//			docDanhSachXeMayVaoTable(dsXeMay);
//			return;
//		}
//		LoaiXe loaiXe = loaiXe_DAO.getLoaiXeTheoTen(tenLoaiXe);
//		xoaDuLieuTrongTable();
//		ArrayList<XeMay> dsXeMayTheoTen = xeMay_DAO.getDanhSachXeMayTheoMaLoaiXe(loaiXe.getMaLoaiXe());
//		if (dsXeMayTheoTen == null) {
//			String thongBao = "Không tìm thấy thông tin xe máy tương ứng với loại xe: " + tenLoaiXe;
//			JOptionPane.showMessageDialog(this, thongBao);
//			return;
//		} else {
//			docDanhSachXeMayVaoTable(dsXeMayTheoTen);
//		}
//	}
//
//	private void themXeMay() {
//		String soKhung = txtSoKhung.getText();
//		if(!kiemTraSoKhungHopLe(soKhung)) return;
//		String soMay = txtSoMay.getText();
//		String tenXe = txtTenXe.getText();
//		String tenLoaiXe = cbxLoaiXe.getSelectedItem().toString();
//		LoaiXe loaiXe = loaiXe_DAO.getLoaiXeTheoTen(tenLoaiXe);
//		String mauXe = cbxMauXe.getSelectedItem().toString();
//		double gia = Double.parseDouble(txtGia.getText());
//		// chưa có dao nhà cung cấp
//		String tenNCC = txtNhaCungCap.getText();
//		NhaCungCap nhaCC = null;
//		try {
//			nhaCC = new NhaCungCap(tenNCC);
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(this, e);
//		}
//		String nuocSX = txtNuocSanXuat.getText();
//		String anh = txtAnhMinhHoa.getText();
//		if (kiemTraTrungSoKhung(soKhung) && kiemTraTrungSoMay(soMay) && kiemTraSoKhungHopLe(soKhung)) {
////			Date namSX = Date.valueOf(txtNamSanXuat.getText());
//			int namSX = Integer.parseInt(txtNamSanXuat.getText());
//			XeMay xeMay = new XeMay(soKhung, soMay, loaiXe, nhaCC, tenXe, nuocSX, mauXe, gia, namSX, anh);
//			xeMay_DAO.themXeMay(xeMay);
//			ArrayList<XeMay> dsXeMay = xeMay_DAO.getAllXeMay();
//			xoaDuLieuTrongTable();
//			docDanhSachXeMayVaoTable(dsXeMay);
//		}
//
//	}
//
//	private boolean kiemTraChonHangTable(int row) {
//		if (row < 0) {
//			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng dòng trên table");
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	private void xoaXeMay() {
//		int row = table.getSelectedRow();
//		if (kiemTraChonHangTable(row)) {
//			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không !!!");
//			if (result == JOptionPane.NO_OPTION) {
//				lamMoi();
//				return;
//			} else if (result == JOptionPane.CANCEL_OPTION) {
//				return;
//			} else {
//				String soKhung = tableModel.getValueAt(row, 0).toString();
//				xeMay_DAO.xoaXeTheoSoKhung(soKhung);
//				xoaDuLieuTrongTable();
//				ArrayList<XeMay> dsXemay = xeMay_DAO.getAllXeMay();
//				docDanhSachXeMayVaoTable(dsXemay);
//			}
//		}
//	}
//
//	private void suaXeMay() {
//		int row = table.getSelectedRow();
//		if (kiemTraChonHangTable(row)) {
//			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không !!!");
//			if (result == JOptionPane.NO_OPTION) {
//				lamMoi();
//				return;
//			} else if (result == JOptionPane.CANCEL_OPTION) {
//				return;
//			} else {
//				String soKhung = txtSoKhung.getText();
//				String soMay = txtSoMay.getText();
//				String tenXe = txtTenXe.getText();
//				String tenLoaiXe = cbxLoaiXe.getSelectedItem().toString();
//				LoaiXe loaiXe = loaiXe_DAO.getLoaiXeTheoTen(tenLoaiXe);
//				String mauXe = cbxMauXe.getSelectedItem().toString();
//				double gia = Double.parseDouble(txtGia.getText());
//				String anh = txtAnhMinhHoa.getText();
//				// chưa có dao nhà cung cấp
//				String tenNCC = txtNhaCungCap.getText();
//				NhaCungCap nhaCC = null;
//				try {
//					nhaCC = new NhaCungCap(tenNCC);
//				} catch (Exception e) {
//					// TODO: handle exception
//					JOptionPane.showMessageDialog(this, e);
//				}
//				String nuocSX = txtNuocSanXuat.getText();
//				
//				if(kiemTraTrungSoKhung(soKhung)) {
//					JOptionPane.showMessageDialog(this, "Không được đổi số khung! ");
//					txtSoKhung.setText(tableModel.getValueAt(row, 0).toString());
//					txtSoKhung.requestFocus();
//					return; 
//				}
//				if (kiemTraTrungSoMay(soMay)) {
//					JOptionPane.showMessageDialog(this, "Không được đổi số máy! ");
//					txtSoMay.setText(tableModel.getValueAt(row, 0).toString());
//					txtSoMay.requestFocus();
//					return; 
//				}
//				int namSX = Integer.parseInt(txtNamSanXuat.getText());
//				XeMay xeMay = new XeMay(soKhung, soMay, loaiXe, nhaCC, tenXe, nuocSX, mauXe, gia, namSX, "abc");
//				xeMay_DAO.updateXeMay(xeMay);
//				xoaDuLieuTrongTable();
//				ArrayList<XeMay> dsXemay = xeMay_DAO.getAllXeMay();
//				docDanhSachXeMayVaoTable(dsXemay);
//
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * @param soKhung
//	 * @return true là không trùng, false là trùng
//	 */
//	private boolean kiemTraTrungSoKhung(String soKhung) {
//		ArrayList<XeMay> dsXemay = xeMay_DAO.getAllXeMay();
//		for (XeMay xeMay : dsXemay) {
//			if (soKhung.trim().equals(xeMay.getSoKhung())) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * 
//	 * @param soKhung
//	 * @return true là không trùng, false là trùng
//	 */
//	private boolean kiemTraTrungSoMay(String soMay) {
//		ArrayList<XeMay> dsXemay = xeMay_DAO.getAllXeMay();
//		for (XeMay xeMay : dsXemay) {
//			if (soMay.trim().equals(xeMay.getSoMay())) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * 
//	 * @param soKhung
//	 * @return true nếu hợp lệ, false nếu không hợp lệ
//	 */
//	private boolean kiemTraSoKhungHopLe(String soKhung) {
//		if(soKhung.equals("")) {
//			JOptionPane.showMessageDialog(this, "Số khung không được rỗng!");
//			txtSoKhung.selectAll();
//			txtSoKhung.requestFocus();
//			return false;
//		}
//		String regex = "(([0-9A-Z]){4,5}-([0-9A-Z]){6,12})";
//		if (!soKhung.matches(regex)) {
//			JOptionPane.showMessageDialog(this,
//					"Số khung có chiều dài từ 10-17 ký tự và có dạng XXXX-XXXXXX.. trong đó X là các kí tự số hoặc chữ hoa. Ví dụ: 082U-12H1268712");
//			txtSoKhung.selectAll();
//			txtSoKhung.requestFocus();
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	private boolean kiemTraSoMay(String soMay) {
//		if(soMay.equals("")) {
//			JOptionPane.showMessageDialog(this, "Số máy không được rỗng!");
//			txtSoKhung.selectAll();
//			txtSoKhung.requestFocus();
//			return false;
//		}
//		if(soMay.matches("(([0-9A-Z]){4,5}-([0-9A-Z]){6,12})")) {
//			JOptionPane.showMessageDialog(this,
//					"Số máy có chiều dài từ 10-17 ký tự và có dạng XXXX-XXXXXX.. trong đó X là các kí tự số hoặc chữ hoa. Ví dụ: 082U-12H1268712");
//			txtSoKhung.selectAll();
//			txtSoKhung.requestFocus();
//			return false;
//		}
//		return true;
//	}
//	
//	
//}
