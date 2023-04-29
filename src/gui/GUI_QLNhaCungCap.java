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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class GUI_QLNhaCungCap extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 192, 40);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(167, 38, 338, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên nhà cung cấp :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 80, 135, 40);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 88, 338, 30);
		panel.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(605, 80, 124, 40);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(739, 88, 192, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(605, 30, 90, 40);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(739, 38, 422, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 1151, 292);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(64, 128, 128));
		table.setFont(new Font("Tahoma", Font.BOLD, 17));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"T\u00EAn nh\u00E0 cung c\u1EA5p", "M\u00E3 nh\u00E0 cung c\u1EA5p", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 128, 1151, 78);
		panel.add(splitPane);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
		
		JLabel lblNewLabel_17 = new JLabel("Mã nhà cung cấp :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_17);
		
		textField_3 = new JTextField();
		textField_3.setColumns(15);
		panel_1.add(textField_3);
		
		JButton btnNewButton_3 = new JButton("Tìm");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(64, 128, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new GridLayout(3, 3, 20, 5));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setEnabled(false);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setEnabled(false);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setEnabled(false);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_6 = new JLabel("");
		lblNewLabel_4_6.setEnabled(false);
		panel_2.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_8 = new JLabel("");
		lblNewLabel_4_8.setEnabled(false);
		panel_2.add(lblNewLabel_4_8);
		
		JLabel lblNewLabel_4_10 = new JLabel("");
		lblNewLabel_4_10.setEnabled(false);
		panel_2.add(lblNewLabel_4_10);
		
		JButton btnNewButton_1 = new JButton("Thêm mới");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Chỉnh sửa");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(64, 128, 128));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(64, 128, 128));
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_11 = new JLabel("");
		lblNewLabel_4_11.setEnabled(false);
		panel_2.add(lblNewLabel_4_11);
		
		JLabel lblNewLabel_4_9 = new JLabel("");
		lblNewLabel_4_9.setEnabled(false);
		panel_2.add(lblNewLabel_4_9);
		
		JLabel lblNewLabel_4_7 = new JLabel("");
		lblNewLabel_4_7.setEnabled(false);
		panel_2.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_4 = new JLabel("");
		lblNewLabel_4_4.setEnabled(false);
		panel_2.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("");
		lblNewLabel_4_5.setEnabled(false);
		panel_2.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_3 = new JLabel("");
		lblNewLabel_4_3.setEnabled(false);
		panel_2.add(lblNewLabel_4_3);

	}
}
