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
import javax.swing.SwingConstants;

public class GUI_QLXe extends JPanel implements ActionListener, MouseListener{

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtSoKhung;
	private JTextField txtTenXe;
	private JTextField txtNuocSanXuat;
	private JTextField txtSoMay;
	private JTextField txtGia;
	private JTextField txtNamSanXuat;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnLoc;
	private JTextField txtNhaCungCap;
	private String anhMinhHoa;
	private JComboBox cbxLoaiXe;
	private JComboBox cbxMauXe;

	/**
	 * Create the panel.
	 */
	public GUI_QLXe() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel pThongTinXeMay = new JPanel();
		pThongTinXeMay.setBackground(new Color(255, 255, 255));
		pThongTinXeMay.setBounds(0, 0, 1180, 305);
		add(pThongTinXeMay);
		pThongTinXeMay.setLayout(null);
		pThongTinXeMay.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin xe máy"));
		
		JPanel pSoKhung = new JPanel();
		pSoKhung.setBackground(new Color(255, 255, 255));
		pSoKhung.setBounds(20, 21, 383, 45);
		pThongTinXeMay.add(pSoKhung);
		pSoKhung.setLayout(null);
		JLabel lblNewLabel = new JLabel("Số khung: ");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pSoKhung.add(lblNewLabel);
		txtSoKhung = new JTextField();
		txtSoKhung.setBounds(106, 5, 260, 29);
		pSoKhung.add(txtSoKhung);
		txtSoKhung.setColumns(10);
		
		JPanel pTenXe = new JPanel();
		pTenXe.setBackground(new Color(255, 255, 255));
		pTenXe.setLayout(null);
		pTenXe.setBounds(20, 105, 383, 45);
		pThongTinXeMay.add(pTenXe);
		JLabel lblNewLabel_1 = new JLabel("Tên xe:");
		lblNewLabel_1.setBounds(0, 12, 82, 14);
		pTenXe.add(lblNewLabel_1);
		txtTenXe = new JTextField();
		txtTenXe.setColumns(10);
		txtTenXe.setBounds(106, 5, 260, 29);
		pTenXe.add(txtTenXe);
		
		JPanel pSoMay = new JPanel();
		pSoMay.setBackground(new Color(255, 255, 255));
		pSoMay.setLayout(null);
		pSoMay.setBounds(20, 62, 383, 45);
		pThongTinXeMay.add(pSoMay);
		JLabel lblNewLabel_2 = new JLabel("Số máy:");
		lblNewLabel_2.setBounds(0, 12, 78, 14);
		pSoMay.add(lblNewLabel_2);
		txtSoMay = new JTextField();
		txtSoMay.setColumns(10);
		txtSoMay.setBounds(106, 5, 260, 29);
		pSoMay.add(txtSoMay);
		
		JPanel pNuocSanXua = new JPanel();
		pNuocSanXua.setBackground(new Color(255, 255, 255));
		pNuocSanXua.setLayout(null);
		pNuocSanXua.setBounds(20, 194, 383, 45);
		pThongTinXeMay.add(pNuocSanXua);
		JLabel lblNewLabel_3 = new JLabel("Nước sản xuất:");
		lblNewLabel_3.setBounds(0, 12, 90, 14);
		pNuocSanXua.add(lblNewLabel_3);
		txtNuocSanXuat = new JTextField();
		txtNuocSanXuat.setColumns(10);
		txtNuocSanXuat.setBounds(106, 5, 260, 29);
		pNuocSanXua.add(txtNuocSanXuat);
		
		JPanel pLoaiXe = new JPanel();
		pLoaiXe.setBackground(new Color(255, 255, 255));
		pLoaiXe.setLayout(null);
		pLoaiXe.setBounds(413, 21, 352, 45);
		pThongTinXeMay.add(pLoaiXe);
		JLabel lblLoiXe = new JLabel("Loại xe:");
		lblLoiXe.setBounds(0, 12, 80, 14);
		pLoaiXe.add(lblLoiXe);
		cbxLoaiXe = new JComboBox();
		cbxLoaiXe.setEditable(true);
		cbxLoaiXe.setBounds(84, 8, 268, 26);
		pLoaiXe.add(cbxLoaiXe);
		
		JPanel pMauXe = new JPanel();
		pMauXe.setBackground(new Color(255, 255, 255));
		pMauXe.setLayout(null);
		pMauXe.setBounds(413, 62, 352, 45);
		pThongTinXeMay.add(pMauXe);
		JLabel lblNewLabel_5 = new JLabel("Màu xe:");
		lblNewLabel_5.setBounds(0, 12, 74, 14);
		pMauXe.add(lblNewLabel_5);
		cbxMauXe = new JComboBox();
		cbxMauXe.setEditable(true);
		cbxMauXe.setBounds(84, 8, 268, 26);
		pMauXe.add(cbxMauXe);

		JPanel pGia = new JPanel();
		pGia.setBackground(new Color(255, 255, 255));
		pGia.setLayout(null);
		pGia.setBounds(413, 105, 352, 45);
		pThongTinXeMay.add(pGia);
		JLabel lblNewLabel_6 = new JLabel("Giá:");
		lblNewLabel_6.setBounds(0, 12, 74, 14);
		pGia.add(lblNewLabel_6);
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(84, 5, 268, 29);
		pGia.add(txtGia);
		
		JPanel pNamSanXuat = new JPanel();
		pNamSanXuat.setBackground(new Color(255, 255, 255));
		pNamSanXuat.setLayout(null);
		pNamSanXuat.setBounds(413, 149, 352, 45);
		pThongTinXeMay.add(pNamSanXuat);
		JLabel lblNewLabel_7 = new JLabel("Năm sản xuất:");
		lblNewLabel_7.setBounds(0, 12, 84, 14);
		pNamSanXuat.add(lblNewLabel_7);
		txtNamSanXuat = new JTextField();
		txtNamSanXuat.setColumns(10);
		txtNamSanXuat.setBounds(84, 5, 268, 29);
		pNamSanXuat.add(txtNamSanXuat);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\them.png"));
		btnThem.setBackground(new Color(75, 209, 254));
		btnThem.setForeground(new Color(128, 0, 0));
		btnThem.setBounds(20, 256, 98, 37);
		pThongTinXeMay.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("data\\xoa.png"));
		btnXoa.setForeground(new Color(128, 0, 0));
		btnXoa.setBackground(new Color(75, 209, 254));
		btnXoa.setBounds(128, 256, 98, 37);
		pThongTinXeMay.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("data\\sua.png"));
		btnSua.setForeground(new Color(128, 0, 0));
		btnSua.setBackground(new Color(75, 209, 254));
		btnSua.setBounds(236, 256, 98, 37);
		pThongTinXeMay.add(btnSua);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("data\\lamMoi.png"));
		btnLamMoi.setForeground(new Color(128, 0, 0));
		btnLamMoi.setBackground(new Color(75, 209, 254));
		btnLamMoi.setBounds(345, 256, 122, 37);
		pThongTinXeMay.add(btnLamMoi);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setIcon(new ImageIcon("data\\filter.png"));
		btnLoc.setForeground(new Color(128, 0, 0));
		btnLoc.setBackground(new Color(75, 209, 254));
		btnLoc.setBounds(480, 256, 98, 37);
		pThongTinXeMay.add(btnLoc);
		
		
		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = {"Số khung","Số máy","Tên xe","Loại xe","Màu xe","Giá","Tên nhà cung cấp","Nước sản xuất","Năm sản xuất"};
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		table.setBackground(new Color(255, 255, 255));
		bTable.add(new JScrollPane(table));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(810, 21, 345, 246);
		pThongTinXeMay.add(panel_2);
		
		JLabel lblIMG = new JLabel();
		panel_2.add(lblIMG);
		//=====ảnh tạm
		anhMinhHoa ="data\\feature125.jpg";
		createIconImage(lblIMG, 400, 230, anhMinhHoa);
		
		JPanel pNhaCC = new JPanel();
		pNhaCC.setLayout(null);
		pNhaCC.setBackground(Color.WHITE);
		pNhaCC.setBounds(20, 149, 383, 45);
		pThongTinXeMay.add(pNhaCC);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên nhà cung cấp:");
		lblNewLabel_3_1.setBounds(0, 12, 106, 14);
		pNhaCC.add(lblNewLabel_3_1);
		
		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setColumns(10);
		txtNhaCungCap.setBounds(106, 5, 260, 29);
		pNhaCC.add(txtNhaCungCap);
		
		
		
		
		
		
	}

	public void createIconImage(JLabel x, int W, int H, String path) {
		ImageIcon image = new ImageIcon(
				new ImageIcon(path).getImage().getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH));
		x.setIcon(image);
		repaint();
		revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			
		}if(o.equals(btnXoa)) {
			
		}if(o.equals(btnSua)) {
			
		}if(o.equals(btnLamMoi)) {
			
		}if(o.equals(btnLoc)) {
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtSoKhung.setText(tableModel.getValueAt(row, 0).toString());
		txtSoMay.setText(tableModel.getValueAt(row, 1).toString());
		txtTenXe.setText(tableModel.getValueAt(row,2 ).toString());
		cbxLoaiXe.setSelectedItem(tableModel.getValueAt(row, 3).toString());
		cbxMauXe.setSelectedItem(tableModel.getValueAt(row, 4).toString());
		txtGia.setText(tableModel.getValueAt(row, 5).toString());
		txtNhaCungCap.setText(tableModel.getValueAt(row, 6).toString());
		txtNuocSanXuat.setText(tableModel.getValueAt(row, 7).toString());
		txtNamSanXuat.setText(tableModel.getValueAt(row, 8).toString());
		//tìm ảnh minh họa theo số khung
//		anhMinhHoa =tableModel.getValueAt(row, 9).toString();
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
