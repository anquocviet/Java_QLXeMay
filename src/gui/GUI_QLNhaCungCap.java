package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;
import entity.NhanVien;

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
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnRefresh;
	private JButton btnDelete;

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
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_left.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSearch.setColumns(10);
		panel_left.add(txtSearch);
		
		btnSearch = new JButton("Tìm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		
		btnAdd = new JButton("Thêm mới");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBackground(new Color(64, 128, 128));
		panel_right.add(btnAdd);
		
		btnUpdate = new JButton("Chỉnh sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBackground(new Color(64, 128, 128));
		panel_right.add(btnUpdate);
		
		btnRefresh = new JButton("Làm mới");
		btnRefresh.setBackground(new Color(64, 128, 128));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_right.add(btnRefresh);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(64, 128, 128));
		panel_right.add(btnDelete);
		
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
		
		JLabel lblTitle = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lblTitle.setForeground(new Color(64, 128, 128));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 21, 1171, 38);
		add(lblTitle);
		
		ncc_dao = new NhaCungCap_DAO();
		ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		loadDSNCC(dsNCC);
		
		tableNCC.addMouseListener(this);
		
		btnAdd.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnUpdate.addActionListener(this);
	}
	
	private void loadDSNCC(ArrayList<NhaCungCap> dsNCC) {
		DefaultTableModel tableModelNCC = (DefaultTableModel) tableNCC.getModel();
		tableModelNCC.setRowCount(0);
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
	
	private void xoaNCC() {
		int row = tableNCC.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần xóa");
	        return;
	    }
		String maNCC = tableNCC.getValueAt(row, 0).toString();
		int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không !!!");
		if (result == JOptionPane.NO_OPTION) {
			clearInput();
			return;
		} else if (result == JOptionPane.CANCEL_OPTION) {
			return;
		} else {
		    boolean resultncc = ncc_dao.xoaNhaCungCap(maNCC);
		    if (resultncc) {
		        JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp thành công!");
		        ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		        loadDSNCC(dsNCC);
		        clearInput();
		    } else {
		        JOptionPane.showMessageDialog(null, "Xóa nhà cung cấp thất bại!");
		    }
	    }
	}
	
	private void checkMaNCC(String maNCC) {
	    ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap ncc : dsNCC) {
	        if (ncc.getMaNCC().equals(maNCC)) {
	            JOptionPane.showMessageDialog(null, "Mã NCC đã tồn tại!");
	            txtMaNCC.requestFocus();
	            return;
	        }
	    }
	}

	
	private void themNCC() throws Exception{
		boolean result =  validateNCCInput();
		String maNCC = txtMaNCC.getText();
		String tenNCC = txtTenNCC.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		checkMaNCC(maNCC);
	    NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
	   
	    if (result) {
	    	ncc_dao.themNhaCungCap(ncc);
	        JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!");
		    ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
	        loadDSNCC(dsNCC);
	    } else {
	        JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thất bại!");
	    }
	}
	
	private void suaNCC() throws Exception {
	    int row = tableNCC.getSelectedRow();
	    if (row == -1) {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần sửa thông tin!");
	        return;
	    }
		validateNCCInput();
	    String maNCC = tableNCC.getValueAt(row, 0).toString();
	    String tenNCC = txtTenNCC.getText();
	    String diaChi = txtDiaChi.getText();
	    String sdt = txtSDT.getText();
	    if (!maNCC.equals(txtMaNCC.getText())) {
	        JOptionPane.showMessageDialog(null, "Không được sửa mã nhà cung cấp!");
	        txtMaNCC.requestFocus();
	        return;
	    }
	    NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
	    boolean result = ncc_dao.suaThongTinNhaCungCap(ncc);
	    if (result) {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhà cung cấp thành công!");
	        ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
	        loadDSNCC(dsNCC);
	    } else {
	        JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhà cung cấp thất bại!");
	    }
	}

	private void timNCCTheoMaNCC() {
	    String maNCC = txtSearch.getText().toUpperCase();
	    NhaCungCap ncc = ncc_dao.findNhaCungCapByMaNCC(maNCC);
	    if (ncc != null) {
	        txtMaNCC.setText(ncc.getMaNCC().toUpperCase());
	        txtTenNCC.setText(ncc.getTenNCC());
	        txtDiaChi.setText(ncc.getDiaChi());
	        txtSDT.setText(ncc.getSdt());
	        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
	        dsNCC.add(ncc);
	        loadDSNCC(dsNCC);
	    } else {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp có mã " + maNCC);
	    }
	}

	private void clearInput() {
	    txtMaNCC.setText("");
	    txtTenNCC.setText("");
	    txtSDT.setText("");
	    txtDiaChi.setText("");
	    txtSearch.setText("");
	}

	private boolean validateNCCInput() {
	    String maNCC = txtMaNCC.getText();
	    if (!maNCC.matches("^NCC\\d{3}$")) {
	        JOptionPane.showMessageDialog(null, "Mã NCC không đúng định dạng NCCxxx với xxx là 3 số!");
	        txtMaNCC.requestFocus();
	        return false;
	    }
	    String tenNCC = txtTenNCC.getText();
	    if (tenNCC.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp!");
	        txtTenNCC.requestFocus();
	        return false;
	    }

	    String diaChi = txtDiaChi.getText();
	    if (diaChi.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp!");
	        txtDiaChi.requestFocus();
	        return false;
	    }

	    String sdt = txtSDT.getText();
	    if (sdt.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhà cung cấp!");
	        txtSDT.requestFocus();
	        return false;
	    }

	    String sdtPattern = "^0\\d{9}";
	    if (!sdt.matches(sdtPattern)) {
	        JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng 0xxxxxxxxx với x là những số");
	        txtSDT.requestFocus();
	        return false;
	    }
	    return true;
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
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			try {
				themNCC();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o.equals(btnRefresh)) {
			clearInput();
			ArrayList<NhaCungCap> dsNCC = ncc_dao.getAllNhaCungCap();
			loadDSNCC(dsNCC);
		}
		if(o.equals(btnDelete)) {
			xoaNCC();
		}
		if(o.equals(btnUpdate)) {
			try {
				suaNCC();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSearch)) {
			timNCCTheoMaNCC();
		}
	}
}
