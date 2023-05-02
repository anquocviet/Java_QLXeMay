package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoHang;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.XeMay;

public class LoaiXe_DAO {
	public ArrayList<LoaiXe> getAllLoaiXe() {
		ArrayList<LoaiXe> dsLoaiXe = new ArrayList<LoaiXe>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
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
	 * lấy loại xe theo mã có sẵn
	 * @param maLoaiXe
	 * @return
	 */
	public LoaiXe getLoaiXeTheoMa(String maLoaiXe) {
		LoaiXe loaiXe = null;
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe where MaLoai ='"+maLoaiXe+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
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
		}finally {
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
	 * lấy loai xe theo tên có sẵn
	 * @param tenLoaiXe
	 * @return
	 */
	public LoaiXe getLoaiXeTheoTen(String tenLoaiXe) {
		LoaiXe loaiXe = null;
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from LoaiXe where TenLoai =N'"+tenLoaiXe+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
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
		}finally {
			try {
				stm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return loaiXe;
	}
}
