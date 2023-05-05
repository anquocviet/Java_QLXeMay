package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.XeMay;

public class LoaiXe_DAO {
	/**
	 * @author Dang Thi Quyen Co
	 * @return
	 */
	public ArrayList<LoaiXe> getAllLoaiXe() {
		ArrayList<LoaiXe> dsLoaiXe = new ArrayList<LoaiXe>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maLoaiXe = rs.getString("MaLoai");
				LoHang loHang = new LoHang(rs.getString("SoLo"));
				String tenLoaiXe = rs.getString("TenLoai");
				String tenHang = rs.getString("TenHang");
				int soPhanKhoi = rs.getInt("SoPhanKhoi");
				boolean dongTietKiem = rs.getBoolean("DongTietKiem");
				LoaiXe loaiXe = new LoaiXe(maLoaiXe, loHang, tenLoaiXe, tenHang, soPhanKhoi, dongTietKiem);
				dsLoaiXe.add(loaiXe);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoaiXe;
	}

	/**
	 * @author Dang Thi Quyen Co lấy loại xe theo mã có sẵn
	 * @param maLoaiXe
	 * @return
	 */
	public LoaiXe getLoaiXeTheoMa(String maLoaiXe) {
		LoaiXe loaiXe = null;
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe where MaLoai ='" + maLoaiXe + "'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				LoHang loHang = new LoHang(rs.getString("SoLo"));
				String tenLoaiXe = rs.getString("TenLoai");
				String tenHang = rs.getString("TenHang");
				int soPhanKhoi = rs.getInt("SoPhanKhoi");
				boolean dongTietKiem = rs.getBoolean("DongTietKiem");
				loaiXe = new LoaiXe(maLoaiXe, loHang, tenLoaiXe, tenHang, soPhanKhoi, dongTietKiem);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return loaiXe;
	}

	/**
	 * @author Dang Thi Quyen Co
	 * @param tenLoaiXe
	 * @return
	 */
	public LoaiXe getLoaiXeTheoTen(String tenLoaiXe) {
		LoaiXe loaiXe = null;
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe where TenLoai =N'" + tenLoaiXe + "'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				LoHang loHang = new LoHang(rs.getString("SoLo"));
				String maLoaiXe = rs.getString("MaLoai");
				String tenHang = rs.getString("TenHang");
				int soPhanKhoi = rs.getInt("SoPhanKhoi");
				boolean dongTietKiem = rs.getBoolean("DongTietKiem");
				loaiXe = new LoaiXe(maLoaiXe, loHang, tenLoaiXe, tenHang, soPhanKhoi, dongTietKiem);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return loaiXe;
	}

	/**
	 * @author An Quoc Viet
	 * @return
	 */
	public ArrayList<Integer> getAllPhanKhoi() {
		ArrayList<Integer> dsPhanKhoi = new ArrayList<Integer>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM LoaiXe";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int soPhanKhoi = rs.getInt("SoPhanKhoi");
				if (!dsPhanKhoi.contains(soPhanKhoi))
					dsPhanKhoi.add(soPhanKhoi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsPhanKhoi;
	}

	/**
	 * @author An Quoc Viet
	 * @return
	 */
	public ArrayList<String> getAllHangXe() {
		ArrayList<String> dsHangXe = new ArrayList<String>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM LoaiXe";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String hangXe = rs.getString("TenHang");
				if (!dsHangXe.contains(hangXe))
					dsHangXe.add(hangXe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsHangXe;
	}
	public ArrayList<LoaiXe> getDSLoaiXeTheoMaNCC(String maNCC) {
	    ArrayList<LoaiXe> dsLoaiXe = new ArrayList<>();
	    Connection con = ConnectDB.getInstance().getConnection();
	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        String sql = String.format("SELECT * FROM XeMay x join LoaiXe lx ON x.MaLoai = lx.MaLoai WHERE x.MaNCC = '%s'", maNCC);
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	            String maLoaiXe = rs.getString("MaLoai");
	            String tenLoaiXe = rs.getString("TenLoai");
	            LoaiXe loaiXe = new LoaiXe(maLoaiXe, tenLoaiXe);
	            dsLoaiXe.add(loaiXe);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return dsLoaiXe;
	}

}
