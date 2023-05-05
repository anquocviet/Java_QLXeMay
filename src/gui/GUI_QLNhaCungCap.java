package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

import java.awt.List;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class GUI_QLNhaCungCap extends JPanel implements ActionListener,MouseListener{
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable tableNCC;
	private JTextField txtSearch;
	private NhaCungCap_DAO ncc_dao;

	/**
	 * Create the panel.
	 */
	public GUI_QLNhaCungCap() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblNewLabel.setForeground(new Color(64, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-44, -49, 1200, 60);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin nh\u00E0 cung c\u1EA5p", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 128, 128)));
		panel.setBounds(0, 70, 1171, 543);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp :");
		lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaNCC.setBounds(10, 30, 192, 40);
		panel.add(lblMaNCC);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaNCC.setBounds(185, 38, 338, 30);
		panel.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp :");
		lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenNCC.setBounds(10, 80, 192, 40);
		panel.add(lblTenNCC);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTenNCC.setColumns(10);
		txtTenNCC.setBounds(185, 88, 338, 30);
		panel.add(txtTenNCC);
		
		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSDT.setBounds(605, 80, 124, 40);
		panel.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDT.setBounds(739, 88, 192, 30);
		panel.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ :");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiaChi.setBounds(605, 30, 90, 40);
		panel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setBounds(739, 38, 422, 30);
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 1151, 292);
		panel.add(scrollPane);
		
		tableNCC = new JTable();
		tableNCC.setForeground(new Color(0, 0, 0));
		tableNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableNCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableNCC.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableNCC.getColumnModel().getColumn(0).setMinWidth(100);
		tableNCC.getColumnModel().getColumn(0).setMaxWidth(200);
		tableNCC.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableNCC.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableNCC.getColumnModel().getColumn(3).setMinWidth(100);
		tableNCC.getColumnModel().getColumn(3).setMaxWidth(200);
		scrollPane.setViewportView(tableNCC);
		tableNCC.setToolTipText("");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 128, 1151, 78);
		panel.add(splitPane);
		
		JPanel panel_left = new JPanel();
		splitPane.setLeftComponent(panel_left);
		panel_left.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
		
		JLabel lblSearch = new JLabel("Mã nhà cung cấp :");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_left.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSearch.setColumns(15);
		panel_left.add(txtSearch);
		
		JButton btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setBackground(new Color(64, 128, 128));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_left.add(btnSearch);
		
		JPanel panel_right = new JPanel();
		splitPane.setRightComponent(panel_right);
		panel_right.setLayout(new GridLayout(3, 3, 20, 5));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setEnabled(false);
		panel_right.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setEnabled(false);
		panel_right.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setEnabled(false);
		panel_right.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_6 = new JLabel("");
		lblNewLabel_4_6.setEnabled(false);
		panel_right.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_8 = new JLabel("");
		lblNewLabel_4_8.setEnabled(false);
		panel_right.add(lblNewLabel_4_8);
		
		JLabel lblNewLabel_4_10 = new JLabel("");
		lblNewLabel_4_10.setEnabled(false);
		panel_right.add(lblNewLabel_4_10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_right.add(lblNewLabel_7);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBackground(new Color(64, 128, 128));
		panel_right.add(btnAdd);
		
		JButton btnUpdate = new JButton("Chỉnh sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBackground(new Color(64, 128, 128));
		panel_right.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(64, 128, 128));
		panel_right.add(btnDelete);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.setBackground(new Color(64, 128, 128));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_right.add(btnSave);
		
		JLabel lblNewLabel_4_11 = new JLabel("");
		lblNewLabel_4_11.setEnabled(false);
		panel_right.add(lblNewLabel_4_11);
		
		JLabel lblNewLabel_4_9 = new JLabel("");
		lblNewLabel_4_9.setEnabled(false);
		panel_right.add(lblNewLabel_4_9);
		
		JLabel lblNewLabel_4_7 = new JLabel("");
		lblNewLabel_4_7.setEnabled(false);
		panel_right.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_4 = new JLabel("");
		lblNewLabel_4_4.setEnabled(false);
		panel_right.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("");
		lblNewLabel_4_5.setEnabled(false);
		panel_right.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setEnabled(false);
		panel_right.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_6 = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblNewLabel_6.setForeground(new Color(64, 128, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 21, 1171, 38);
		add(lblNewLabel_6);
		
		ncc_dao = new NhaCungCap_DAO();
		
		loadDSNCC();
		
		tableNCC.addMouseListener(this);
	}
	
	public void loadDSNCC() {
		DefaultTableModel tableModelNCC = (DefaultTableModel) tableNCC.getModel();
		tableModelNCC.setRowCount(0);
		ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		if (!dsNCC.isEmpty()) {
	        for (NhaCungCap ncc : dsNCC) {
	            String maNCC = ncc.getMaNCC();
	            String tenNCC = ncc.getTenNCC();
	            String diaChi = ncc.getDiaChi();
	            String soDienThoai = ncc.getSdt();
	            tableModelNCC.addRow(new Object[] { maNCC, tenNCC,diaChi ,soDienThoai });
	        }
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableNCC)) {
			int rowSl = tableNCC.getSelectedRow();
			txtMaNCC.setText(tableNCC.getValueAt(rowSl, 0).toString());
			txtTenNCC.setText(tableNCC.getValueAt(rowSl, 1).toString());
			txtDiaChi.setText(tableNCC.getValueAt(rowSl, 2).toString());
			txtSDT.setText(tableNCC.getValueAt(rowSl, 3).toString());
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
		// TODO Auto-generated method stub
		
	}
}
