package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_QLKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtHoTenKH;
	private JTextField txtNgaySinh;
	private JTextField txtQueQuan;
	private JTextField txtNoiThuongTru;
	private JTextField txtSoCCCD;
	private JTable table;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QLKhachHang frame = new GUI_QLKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_QLKhachHang() {
		setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1535, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbQLKH = new JLabel("Quản lý khách hàng");
		lbQLKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbQLKH.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lbQLKH.setBounds(453, 11, 540, 38);
		contentPane.add(lbQLKH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 49, 420, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbMaKH.setBounds(25, 21, 125, 29);
		panel.add(lbMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(156, 26, 234, 20);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lbHoTenKH = new JLabel("Họ tên khách hàng");
		lbHoTenKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbHoTenKH.setBounds(25, 61, 125, 29);
		panel.add(lbHoTenKH);
		
		txtHoTenKH = new JTextField();
		txtHoTenKH.setColumns(10);
		txtHoTenKH.setBounds(156, 103, 234, 20);
		panel.add(txtHoTenKH);
		
		JLabel lbNgaySinh = new JLabel("Ngày sinh");
		lbNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNgaySinh.setBounds(25, 140, 107, 20);
		panel.add(lbNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(156, 141, 234, 20);
		panel.add(txtNgaySinh);
		
		JLabel lbGioiTinh = new JLabel("Giới tính");
		lbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbGioiTinh.setBounds(25, 224, 125, 14);
		panel.add(lbGioiTinh);
		
		JCheckBox checkboxNam = new JCheckBox("Nam");
		checkboxNam.setBounds(156, 221, 97, 23);
		panel.add(checkboxNam);
		
		JCheckBox checkboxNu = new JCheckBox("Nữ");
		checkboxNu.setBounds(259, 221, 97, 23);
		panel.add(checkboxNu);
		
		JLabel lbQueQuan = new JLabel("Quê quán");
		lbQueQuan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbQueQuan.setBounds(25, 258, 61, 20);
		panel.add(lbQueQuan);
		
		txtQueQuan = new JTextField();
		txtQueQuan.setColumns(10);
		txtQueQuan.setBounds(156, 258, 234, 20);
		panel.add(txtQueQuan);
		
		JLabel lblNewLabel = new JLabel("Nơi thường trú");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 301, 107, 20);
		panel.add(lblNewLabel);
		
		txtNoiThuongTru = new JTextField();
		txtNoiThuongTru.setColumns(10);
		txtNoiThuongTru.setBounds(156, 302, 234, 20);
		panel.add(txtNoiThuongTru);
		
		JLabel lbSoCCCD = new JLabel("Số CCCD");
		lbSoCCCD.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSoCCCD.setBounds(25, 105, 97, 14);
		panel.add(lbSoCCCD);
		
		txtSoCCCD = new JTextField();
		txtSoCCCD.setColumns(10);
		txtSoCCCD.setBounds(156, 66, 234, 20);
		panel.add(txtSoCCCD);
		
		JLabel lbSoDienThoai = new JLabel("Số điện thoại");
		lbSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSoDienThoai.setBounds(25, 186, 107, 14);
		panel.add(lbSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(156, 184, 234, 20);
		panel.add(txtSoDienThoai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(440, 54, 920, 349);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 920, 349);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD t\u00EAn", "S\u1ED1 CCCD", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Gi\u1EDBi t\u00EDnh", "Qu\u00EA qu\u00E1n", "N\u01A1i th\u01B0\u1EDDng tr\u00FA"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lbTimKiem = new JLabel("Nhập mã khách hàng hoặc số CCCD cần tìm");
		lbTimKiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbTimKiem.setBounds(498, 423, 328, 30);
		contentPane.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTimKiem.setBounds(796, 428, 159, 20);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(969, 427, 77, 23);
		contentPane.add(btnTim);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(14, 427, 74, 23);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(99, 426, 67, 23);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(179, 425, 70, 23);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLuu.setBounds(263, 425, 70, 23);
		contentPane.add(btnLuu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(349, 424, 76, 23);
		contentPane.add(btnThoat);
		
		JButton txtSapXepTheoHoTen = new JButton("Sắp xếp theo họ tên");
		txtSapXepTheoHoTen.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSapXepTheoHoTen.setBounds(1066, 427, 187, 23);
		contentPane.add(txtSapXepTheoHoTen);
	}
}
