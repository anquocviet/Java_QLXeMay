package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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

public class GUI_QLNhapXe extends JPanel {
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

	/**
	 * @author An Quốc Việt
	 */
	public GUI_QLNhapXe() {
		Image imgThemHD = new ImageIcon("data/image/them-hoa-don.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Image imgThem = new ImageIcon("data/image/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		imgXeMay = new ImageIcon("data/image/demo-xe-may.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
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
		panelInfoNCC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp ");
		lblMaNCC.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoNCC.add(lblMaNCC);

		txtMaNCC = new JTextField();
		panelInfoNCC.add(txtMaNCC);
		txtMaNCC.setColumns(10);

		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp");
		lblTenNCC.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoNCC.add(lblTenNCC);

		txtTenNCC = new JTextField();
		panelInfoNCC.add(txtTenNCC);
		txtTenNCC.setColumns(10);

		btnChonNCC = new JButton("Chọn nhà cung cấp");
		btnChonNCC.setIcon(new ImageIcon(imgThem));
		panelInfoNCC.add(btnChonNCC);

		String headerTableNCC[] = { "Mã NCC", "Tên NCC" };
		DefaultTableModel tableModelNCC = new DefaultTableModel(headerTableNCC, 0);
		JScrollPane scrollPaneNCC = new JScrollPane(tableNCC = new JTable(tableModelNCC));
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
		panelInfoXe.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblTenXe = new JLabel("Tên xe");
		panelInfoXe.add(lblTenXe);

		txtTenXe = new JTextField();
		panelInfoXe.add(txtTenXe);
		txtTenXe.setColumns(10);

		JLabel lblLoaiXe = new JLabel("Loại xe");
		panelInfoXe.add(lblLoaiXe);

		cbLoaiXe = new JComboBox();
		panelInfoXe.add(cbLoaiXe);

		JLabel lblMauXe = new JLabel("Màu xe");
		panelInfoXe.add(lblMauXe);

		cbMauXe = new JComboBox();
		panelInfoXe.add(cbMauXe);

		JLabel lblHangXe = new JLabel("Hãng xe");
		panelInfoXe.add(lblHangXe);

		cbHangXe = new JComboBox();
		panelInfoXe.add(cbHangXe);

		JLabel lblSoLuong = new JLabel("Số lượng");
		panelInfoXe.add(lblSoLuong);

		txtSoLuong = new JTextField();
		panelInfoXe.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		String headerTableXe[] = "Tên xe;Màu sắc;Số lượng".split(";");
		tableModelXe = new DefaultTableModel(headerTableXe, 0);
		JScrollPane scrollPaneXe = new JScrollPane(tableXe = new JTable(tableModelXe));
		panelChonXeLeft.add(scrollPaneXe, BorderLayout.CENTER);

		JPanel panelChonXeRight = new JPanel();
		panelChonXe.add(panelChonXeRight, BorderLayout.EAST);

		panelChonXeRight.setLayout(new BorderLayout(0, 0));
		JLabel lblAnhMinhHoa = new JLabel(new ImageIcon(imgXeMay));
		panelChonXeRight.add(lblAnhMinhHoa);

		btnThemXe = new JButton("Thêm vào hóa đơn");
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
		panelInfoHD.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		panelInfoHD.add(lblMaHD);

		txtMaHD = new JTextField();
		panelInfoHD.add(txtMaHD);
		txtMaHD.setColumns(10);

		JLabel lblHDTenNCC = new JLabel("Tên nhà cung cấp");
		panelInfoHD.add(lblHDTenNCC);

		txtHDTenNCC = new JTextField();
		panelInfoHD.add(txtHDTenNCC);
		txtHDTenNCC.setColumns(10);

		JPanel panelThanhTien = new JPanel();
		FlowLayout fl_panelThanhTien = (FlowLayout) panelThanhTien.getLayout();
		fl_panelThanhTien.setHgap(100);
		panelChiTietHD.add(panelThanhTien, BorderLayout.SOUTH);

		JLabel lblThanhTien = new JLabel("Thành tiền");
		panelThanhTien.add(lblThanhTien);

		lblSoTien = new JLabel("0 VND");
		panelThanhTien.add(lblSoTien);

		String headerCTHD[] = "STT;Tên xe;Số lượng;Đơn giá;Thành tiền".split(";");
		DefaultTableModel tableModelCTHD = new DefaultTableModel(headerCTHD, 0);
		JScrollPane scrollPaneCTHD = new JScrollPane(tableChiTietHD = new JTable(tableModelCTHD));
		panelChiTietHD.add(scrollPaneCTHD, BorderLayout.CENTER);

		JPanel panelNhapHang = new JPanel();
		panelHD.add(panelNhapHang, BorderLayout.SOUTH);

		btnNhapHang = new JButton("Nhập hàng");
		btnNhapHang.setIcon(new ImageIcon(imgThem));
		panelNhapHang.add(btnNhapHang);

	}

}