package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.KhachHang;
import entity.NhanVien;

public class KhachHang_DAO {
	private CanCuocCongDan_DAO cccd_dao;

	/**
	 * @author AnQuocViet
	 */
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select MaKH, Ho, HoDem, Ten, cccd.MaCCCD, NgaySinh, SoDienThoai, GioiTinh, TamTru, ThuongTru " +
					"from KhachHang kh " +
					"inner join CanCuocCongDan cccd on kh.MaCCCD = cccd.MaCCCD";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String ho = rs.getString("Ho");
				String hoDem = rs.getString("HoDem");
				String ten = rs.getString("Ten");
				String maCCCD = rs.getString("MaCCCD");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				String sdt = rs.getString("SoDienThoai");
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String tamTru = rs.getString("TamTru");
				String thuongTru = rs.getString("ThuongTru");

				CanCuocCongDan canCuocCongDan = new CanCuocCongDan(maCCCD, ho, hoDem, ten, gioiTinh, ngaySinh, tamTru, thuongTru);

				KhachHang kh = new KhachHang(maKH, canCuocCongDan, sdt);
				dskh.add(kh);
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
		return dskh;
	}

	/**
	 * @author AnQuocViet
	 */
	public KhachHang getKhachHangTheoMaKH(String maKhachHang) {
		KhachHang kh = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();

			String sql = "SELECT * FROM KhachHang WHERE MaKH = '" + maKhachHang + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String maCCCD = rs.getString("MaCCCD");
				String sdt = rs.getString("SoDienThoai");
				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan cc = cccd_dao.getCCCDTheoMa(maCCCD);
				kh = new KhachHang(maKH, cc, sdt);
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
		return kh;
	}
	
	/**
	 * @author AnQuocViet
	 */
	public KhachHang getKhachHangTheoMaCCCD(String maCCCD) {
		KhachHang kh = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();

			String sql = "SELECT * FROM KhachHang WHERE MaCCCD = '" + maCCCD + "'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String sdt = rs.getString("SoDienThoai");
				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan cc = cccd_dao.getCCCDTheoMa(maCCCD);
				kh = new KhachHang(maKH, cc , sdt);
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
		return kh;
	}

}
