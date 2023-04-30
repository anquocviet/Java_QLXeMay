package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.XeMay;

public class XeMay_DAO {
	public XeMay getXeMayTheoSoKhung(String soKhung) {
		XeMay xe = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM XeMay WHERE SoKhung = '%s'", soKhung);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String soMay = rs.getString("SoMay");
				String maLoai = rs.getString("MaLoai");
				String maNCC = rs.getString("MaNCC");
				String tenXe = rs.getString("TenXe");
				String nuocSX = rs.getString("NuocSX");
				String mauXe = rs.getString("MauXe");
				double gia = rs.getDouble("Gia");
				int namSX = rs.getInt("NamSX");
				String anhMinhHoa = rs.getString("AnhMinhHoa");
				xe = new XeMay(soKhung, soMay, new LoaiXe(maLoai), new NhaCungCap(), tenXe, nuocSX, mauXe, gia, namSX,
						anhMinhHoa);
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
		return xe;
	}

	/**
	 * @author An Quoc Viet
	 */
	public ArrayList<XeMay> getDSXeMayCuaKhachHang(String maKH) {
		ArrayList<XeMay> dsXe = new ArrayList<XeMay>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format(
					"SELECT * FROM HopDong h JOIN CT_HopDong ct ON h.SoHopDong = ct.SoHopDong WHERE h.MaKH = '%s'",
					maKH);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String soKhung = rs.getString("SoKhung");
				XeMay xe = getXeMayTheoSoKhung(soKhung);
				if (xe != null)
					dsXe.add(xe);
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
