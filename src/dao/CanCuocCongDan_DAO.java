package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;

public class CanCuocCongDan_DAO {
	/**
	 * @author AnQuocViet
	 */
	public ArrayList<CanCuocCongDan> getAllCCCD() {
		ArrayList<CanCuocCongDan> dscc = new ArrayList<CanCuocCongDan>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM CanCuocCongDan";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maCCCD = rs.getString("MaCCCD");
				String ho = rs.getString("Ho");
				String hoDem = rs.getString("HoDem");
				String ten = rs.getString("Ten");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				String tamTru = rs.getString("TamTru");
				String thuongTru = rs.getString("ThuongTru");
				CanCuocCongDan c = new CanCuocCongDan(maCCCD, ho, hoDem, ten, gioiTinh, ngaySinh, tamTru, thuongTru);
				dscc.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return dscc;
	}

	/**
	 * @author Dang Thi Quyen Co
	 */
	public CanCuocCongDan getCCCDTheoMa(String maCC) {
		CanCuocCongDan cc = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM CanCuocCongDan WHERE MaCCCD = '%s'", maCC);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maCCCD = rs.getString("MaCCCD");
				String ho = rs.getString("Ho");
				String hoDem = rs.getString("HoDem");
				String ten = rs.getString("Ten");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				String tamTru = rs.getString("TamTru");
				String thuongTru = rs.getString("ThuongTru");
				cc = new CanCuocCongDan(maCCCD, ho, hoDem, ten, gioiTinh, ngaySinh, tamTru, thuongTru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return cc;
	}
	
	/**
	 * @author Dang Thi Quyen Co
	 * @param cccd
	 * @return
	 */
	public boolean themCanCuocCongDan(CanCuocCongDan cccd) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			String sql = "INSERT INTO CanCuocCongDan (MaCCCD, Ho, HoDem, Ten, GioiTinh, NgaySinh, TamTru, ThuongTru) VALUES(?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cccd.getMaCCCD());
			pstm.setString(2, cccd.getHo());
			pstm.setString(3, cccd.getHoDem());
			pstm.setString(4, cccd.getTen());
			pstm.setBoolean(5, cccd.getGioiTinh());
			pstm.setDate(6, Date.valueOf(cccd.getNgaySinh()));
			pstm.setString(7, cccd.getTamTru());
			pstm.setString(8, cccd.getThuongTru());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean xoaCCCDTheoMa(String maCCCD) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "delete from CanCuocCongDan where MaCCCD ='"+maCCCD+"'";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean updateCanCuocCongDan(CanCuocCongDan cccd) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			String sql = "update  CanCuocCongDan set Ho=?, HoDem=?, Ten=?, GioiTinh=?, NgaySinh=?, TamTru=?, ThuongTru=? where  MaCCCD=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(8, cccd.getMaCCCD());
			pstm.setString(1, cccd.getHo());
			pstm.setString(2, cccd.getHoDem());
			pstm.setString(3, cccd.getTen());
			pstm.setBoolean(4, cccd.getGioiTinh());
			pstm.setDate(5, Date.valueOf(cccd.getNgaySinh()));
			pstm.setString(6, cccd.getTamTru());
			pstm.setString(7, cccd.getThuongTru());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
}
