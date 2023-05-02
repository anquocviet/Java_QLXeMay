package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.KhachHang;
import entity.NhanVien;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import entity.XeMay;
import entity.PhieuNhanXetBaoHanh;

public class PhieuNhanXetBaoHanh_DAO {
	/**
	 * @author AnQuocViet
	 */
	public ArrayList<PhieuNhanXetBaoHanh> getAllPhieuNhanXetBaoHanh() {
		ArrayList<PhieuNhanXetBaoHanh> dsp = new ArrayList<PhieuNhanXetBaoHanh>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM PhieuNhanXetBaoHanh";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maPhieu = rs.getString("MaPhieu");
				LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
				String maNV = rs.getString("MaNV");
				String maKH = rs.getString("MaKH");
				String soKhung = rs.getString("");
				double tienCong = rs.getDouble("TienCong");
				PhieuNhanXetBaoHanh p = new PhieuNhanXetBaoHanh(maPhieu, new NhanVienKiThuat(maNV), new KhachHang(maKH),
						new XeMay(soKhung), ngayNhap);
				dsp.add(p);
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
		return dsp;
	}

	/**
	 * @author AnQuocViet
	 */
	public int countPhieuBaoHanhInDate(LocalDate date) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		int count = 0;
		try {
			stmt = con.createStatement();
			String dateFormat = date.toString();
			String sql = String.format("SELECT * FROM PhieuNhanXetBaoHanh WHERE NgayLap = '%s'", dateFormat);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
				count++;
			return count;
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
		return count;
	}
}
