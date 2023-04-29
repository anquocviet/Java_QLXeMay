package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.XeMay;

public class XeMay_DAO {
//	public XeMay getXeMayTheoSoKhung(String soKhung) {
//		XeMay xe = null;
//		Connection con = ConnectDB.getInstance().getConnection();
//		Statement stmt = null;
//		try {
//			stmt = con.createStatement();
//			String sql = String.format("SELECT * FROM XeMay"
//					+ "WHERE MaKH = '%s'", soKhung);
//			ResultSet rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				String soKhung =  rs.getString("SoKhung");
//				xe = new 
////				dsXe.add(x);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}
//		return xe;
//	}
	
	/**
	 * @author An Quoc Viet
	 */
	public ArrayList<XeMay> getDSXeMayCuaKhachHang(String maKH) {
		ArrayList<XeMay> dsXe = new ArrayList<XeMay>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM HopDong h JOIN CT_HopDong ct ON h.SoHopDong = ct.SoHopDong"
					+ "WHERE MaKH = '%s'", maKH);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String soKhung =  rs.getString("SoKhung");
//				dsXe.add(x);
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
		return dsXe;
	}
}
