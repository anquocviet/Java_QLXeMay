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

public class GUI_QLBanXe extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTable table_1;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table_2;
	private JTextField textField_12;

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
		panel.setBounds(0, 70, 600, 260);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1.setBounds(10, 20, 90, 20);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(110, 20, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CCCD :");
		lblNewLabel_2.setBounds(10, 50, 90, 20);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 50, 150, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setBounds(10, 80, 90, 20);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 80, 150, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Thường trú :");
		lblNewLabel_4.setBounds(300, 20, 90, 20);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(374, 20, 212, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tạm trú :");
		lblNewLabel_5.setBounds(300, 50, 90, 20);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(374, 50, 212, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày sinh :");
		lblNewLabel_6.setBounds(300, 80, 90, 20);
		panel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(374, 80, 90, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(480, 80, 50, 20);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		rdbtnNewRadioButton_1.setBounds(536, 80, 50, 20);
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(64, 128, 128)));
		panel_6.setBounds(10, 110, 576, 30);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Thêm mới khách hàng");
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		btnNewButton_1.setBounds(10, 5, 178, 20);
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Chọn khách");
		btnNewButton_2.setBackground(new Color(64, 128, 128));
		btnNewButton_2.setBounds(447, 5, 122, 20);
		panel_6.add(btnNewButton_2);
		
		JLabel lblNewLabel_17 = new JLabel("CCCD :");
		lblNewLabel_17.setBounds(286, 5, 45, 20);
		panel_6.add(lblNewLabel_17);
		
		textField_9 = new JTextField();
		textField_9.setBounds(341, 6, 96, 20);
		panel_6.add(textField_9);
		textField_9.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 576, 100);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"T\u00EAn kh\u00E1ch h\u00E0ng", "CCCD", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Th\u01B0\u1EDDng tr\u00FA", "T\u1EA1m tr\u00FA", "Gi\u1EDBi t\u00EDnh"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0110\u01A1n h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 128, 128)));
		panel_1.setBounds(0, 352, 600, 260);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Mã hóa đơn :");
		lblNewLabel_9.setBounds(30, 30, 100, 20);
		panel_1.add(lblNewLabel_9);
		
		textField_10 = new JTextField();
		textField_10.setForeground(new Color(192, 192, 192));
		textField_10.setEnabled(false);
		textField_10.setBounds(140, 31, 205, 20);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Tên khách hàng :");
		lblNewLabel_18.setBounds(30, 60, 100, 20);
		panel_1.add(lblNewLabel_18);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setBounds(140, 60, 205, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 90, 580, 93);
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
		lblNewLabel_19.setBounds(30, 207, 106, 31);
		panel_1.add(lblNewLabel_19);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_12.setEnabled(false);
		textField_12.setBounds(140, 215, 180, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Thanh toán");
		btnNewButton_3.setBackground(new Color(64, 128, 128));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(360, 203, 205, 42);
		panel_1.add(btnNewButton_3);
		
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
		
		JButton btnNewButton = new JButton("Thêm vào giỏ hàng");
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setBounds(393, 281, 154, 21);
		panel_4.add(btnNewButton);
		
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
			},
			new String[] {
				"M\u00E3 lo\u1EA1i", "T\u00EAn xe", "S\u1ED1 khung", "Gi\u00E1"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setBackground(Color.LIGHT_GRAY);

	}
}
