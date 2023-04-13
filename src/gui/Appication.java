package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Appication implements ActionListener, MouseListener, KeyListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appication window = new Appication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Appication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNav = new JPanel();
		panel.add(panelNav, BorderLayout.NORTH);
		panel.add(new GUI_QLBanHang(), 0);			// Auto load GUI_BanHang when open app
		
		JButton btnBanXe = new JButton("Bán xe");
		btnBanXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLBanHang(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnBanXe);
		
		JButton btnNhapXe = new JButton("Nhập xe");
		btnNhapXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLNhapHang(), 0);
				panel.validate();
				panel.repaint();
				
			}
		});
		panelNav.add(btnNhapXe);
		
		JButton btnBaoHanh = new JButton("Bảo hành");
		btnBaoHanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLBaoHanh(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnBaoHanh);
		
		JButton btnQLXe = new JButton("QL Xe");
		btnQLXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLXe(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnQLXe);
		
		JButton btnQLLoaiXe = new JButton("QL Loại xe");
		btnQLLoaiXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLLoaiXe(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnQLLoaiXe);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLNhanVien(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnNhanVien);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLKhachHang(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnKhachHang);
		
		JButton btnNCC = new JButton("Nhà cung cấp");
		btnNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(0);
				panel.add(new GUI_QLNhaCungCap(), 0);
				panel.validate();
				panel.repaint();
			}
		});
		panelNav.add(btnNCC);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFIile = new JMenu("File");
		menuBar.add(mnFIile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFIile.add(mntmExit);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
