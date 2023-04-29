package dao;

import java.sql.Connection;
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
	 * @author AnQuocViet
	 */
	public CanCuocCongDan getCCCD(String maCC) {
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
}
