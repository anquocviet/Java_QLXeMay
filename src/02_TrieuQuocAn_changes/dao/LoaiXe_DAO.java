package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
			String sql = "select MaLoai, TenLoai, TenHang, SoPhanKhoi, DongTietKiem, LoHang.SoLo, NhaCungCap.MaNCC, TenNCC, TenNuocNhap, SoLuong, NgayNhapKho " +
					"from LoaiXe " +
					"inner join LoHang on LoaiXe.SoLo = LoHang.SoLo " +
					"inner join NhaCungCap on NhaCungCap.MaNCC = LoHang.MaNCC";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maLoai = rs.getString("MaLoai");
				String tenLoai = rs.getString("TenLoai");
				String tenHang = rs.getString("TenHang");
				int soPhanKhoi = rs.getInt("SoPhanKhoi");
				boolean dongTietKiem = rs.getBoolean("DongTietKiem");
				String soLo = rs.getString("SoLo");
				String tenNCC = rs.getString("TenNCC");
				String maNCC = rs.getString("MaNCC");
				String tenNuocNhap = rs.getString("TenNuocNhap");
				int soLuong = rs.getInt("SoLuong");
				Date ngayNhapKho = rs.getDate("NgayNhapKho");


				NhaCungCap nhaCungCap = new NhaCungCap(maNCC, tenNCC);
				LoHang loHang = new LoHang(soLo, nhaCungCap, tenNuocNhap, soLuong, ngayNhapKho);
				LoaiXe loaiXe = new LoaiXe(maLoai, tenLoai, tenHang, soPhanKhoi, dongTietKiem, loHang);
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
}
