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
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class GUI_QLBanXe extends JPanel implements ActionListener, MouseListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTable table_1;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table_2;
	private JTextField textField_12;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JButton btnChonKhach;
	private JButton btnLuu;
	private JButton btnThem;

	/**
	 * Create the panel.
	 */
	public GUI_QLBanXe() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ BÁN HÀNG");
		lblNewLabel.setForeground(new Color(64, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1200, 60);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 128, 128)));
		panel.setBounds(0, 70, 600, 130);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1.setBounds(10, 20, 90, 20);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(120, 21, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CCCD :");
		lblNewLabel_2.setBounds(10, 50, 90, 20);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 51, 150, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(332, 22, 237, 90);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"T\u00EAn kh\u00E1ch h\u00E0ng", "CCCD"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		
		JButton btnChonKhach = new JButton("Chọn khách");
		btnChonKhach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChonKhach.setBackground(new Color(64, 128, 128));
		btnChonKhach.setBounds(60, 80, 171, 32);
		panel.add(btnChonKhach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00F3a \u0111\u01A1n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 128, 128)));
		panel_1.setBounds(0, 210, 600, 402);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Mã hóa đơn :");
		lblNewLabel_9.setBounds(10, 60, 100, 20);
		panel_1.add(lblNewLabel_9);
		
		textField_10 = new JTextField();
		textField_10.setForeground(new Color(192, 192, 192));
		textField_10.setEnabled(false);
		textField_10.setBounds(160, 60, 135, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Tên khách hàng :");
		lblNewLabel_18.setBounds(10, 90, 100, 20);
		panel_1.add(lblNewLabel_18);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setBounds(160, 90, 135, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 210, 580, 102);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"T\u00EAn xe", "M\u00E0u xe", "S\u1ED1 khung", "Gi\u00E1"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_19 = new JLabel("Thành tiền :");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_19.setBounds(30, 324, 106, 30);
		panel_1.add(lblNewLabel_19);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_12.setEnabled(false);
		textField_12.setBounds(146, 330, 149, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnLuu = new JButton("Lưu hóa đơn");
		btnLuu.setBackground(new Color(64, 128, 128));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuu.setBounds(371, 358, 177, 34);
		panel_1.add(btnLuu);
		
		JLabel lblNewLabel_20 = new JLabel("Chọn cách thức thanh toán :");
		lblNewLabel_20.setBounds(10, 30, 285, 20);
		panel_1.add(lblNewLabel_20);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Trả hết", "Trả góp"}));
		comboBox_4.setBounds(192, 30, 103, 20);
		panel_1.add(comboBox_4);
		
		JLabel lblNewLabel_3 = new JLabel("Nhân viên lập hợp đồng :");
		lblNewLabel_3.setBounds(10, 120, 149, 20);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 120, 135, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày lập hợp đồng :");
		lblNewLabel_4.setBounds(10, 150, 115, 20);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(160, 150, 135, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Thời gian bảo hành :");
		lblNewLabel_5.setBounds(10, 180, 115, 20);
		panel_1.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(160, 180, 135, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Đã nhận :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(316, 324, 100, 30);
		panel_1.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(420, 330, 149, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Còn nợ :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(30, 360, 106, 30);
		panel_1.add(lblNewLabel_17);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setBounds(146, 368, 149, 20);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setForeground(new Color(64, 128, 128));
		panel_6.setBorder(new TitledBorder(null, "Tr\u1EA3 g\u00F3p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 128, 128)));
		panel_6.setBounds(319, 10, 250, 194);
		panel_1.add(panel_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã trả góp:");
		lblNewLabel_1_1.setBounds(10, 14, 90, 20);
		panel_6.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên người trả :");
		lblNewLabel_2_1.setBounds(10, 44, 90, 20);
		panel_6.add(lblNewLabel_2_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(131, 14, 110, 20);
		panel_6.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(131, 44, 110, 20);
		panel_6.add(textField_14);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nhân viên nhận :");
		lblNewLabel_3_1.setBounds(10, 74, 133, 20);
		panel_6.add(lblNewLabel_3_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(131, 74, 110, 20);
		panel_6.add(textField_15);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ngày trả :");
		lblNewLabel_4_1.setBounds(10, 104, 110, 20);
		panel_6.add(lblNewLabel_4_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(131, 134, 110, 20);
		panel_6.add(textField_16);
		
		JLabel lblNewLabel_5_1 = new JLabel("Số lần trả :");
		lblNewLabel_5_1.setBounds(10, 134, 110, 20);
		panel_6.add(lblNewLabel_5_1);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(131, 104, 110, 20);
		panel_6.add(textField_17);
		
		JLabel lblNewLabel_21 = new JLabel("Số tiền trả góp :");
		lblNewLabel_21.setBounds(10, 164, 102, 20);
		panel_6.add(lblNewLabel_21);
		
		textField_18 = new JTextField();
		textField_18.setBounds(131, 164, 110, 20);
		panel_6.add(textField_18);
		textField_18.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin Xe", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(64, 128, 128)));
		panel_2.setBounds(612, 70, 567, 542);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 335, 244, 197);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Tên xe :");
		lblNewLabel_8.setBounds(12, 10, 78, 20);
		panel_3.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(100, 10, 131, 20);
		textField_6.setColumns(10);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_10 = new JLabel("Loại xe :");
		lblNewLabel_10.setBounds(12, 40, 78, 20);
		panel_3.add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Tất cả--"}));
		comboBox.setBounds(100, 40, 131, 20);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Màu xe :");
		lblNewLabel_11.setBounds(12, 70, 78, 20);
		panel_3.add(lblNewLabel_11);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Tất cả--"}));
		comboBox_1.setBounds(100, 100, 131, 20);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("Số phân khối :");
		lblNewLabel_12.setBounds(12, 100, 93, 20);
		panel_3.add(lblNewLabel_12);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"--Tất cả--"}));
		comboBox_2.setBounds(100, 70, 130, 20);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_13 = new JLabel("Dòng xe :");
		lblNewLabel_13.setBounds(12, 160, 78, 20);
		panel_3.add(lblNewLabel_13);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Tiết kiệm xăng");
		chckbxNewCheckBox.setBounds(100, 160, 131, 20);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_16 = new JLabel("Hãng xe :");
		lblNewLabel_16.setBounds(12, 130, 78, 20);
		panel_3.add(lblNewLabel_16);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"--Tất cả--"}));
		comboBox_3.setBounds(100, 130, 131, 20);
		panel_3.add(comboBox_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 21, 547, 303);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\TaiLieu\\Java\\Detai\\Nhom10_QuanLyBanXeMay\\data\\image\\demo-xe-may.png"));
		lblNewLabel_7.setBounds(0, 5, 547, 266);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_14 = new JLabel("Số khung :");
		lblNewLabel_14.setBounds(10, 280, 70, 20);
		panel_4.add(lblNewLabel_14);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setBounds(80, 281, 151, 20);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Giá :");
		lblNewLabel_15.setBounds(245, 280, 45, 20);
		panel_4.add(lblNewLabel_15);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setBounds(280, 281, 96, 20);
		panel_4.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnThem = new JButton("Thêm vào giỏ hàng");
		btnThem.setBackground(new Color(64, 128, 128));
		btnThem.setBounds(393, 281, 154, 21);
		panel_4.add(btnThem);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(264, 335, 293, 197);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 273, 177);
		panel_5.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 lo\u1EA1i", "T\u00EAn xe", "S\u1ED1 khung", "Gi\u00E1"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setBackground(Color.LIGHT_GRAY);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnChonKhach)) {
			
		}if(o.equals(btnThem)) {
			
		}if(o.equals(btnLuu)) {
		
		}
	}
}
