package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.NhanVien;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;

public class NhanVien_DAO {

	private CanCuocCongDan_DAO cccd_dao;

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsnv = getAllNhanVienHanhChinh();
		dsnv.addAll(getAllNhanVienKyThuat());
		return dsnv;
	}

	public ArrayList<NhanVien> getAllNhanVienHanhChinh() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien JOIN NhanVienHanhChinh ON NhanVien.MaNV = NhanVienHanhChinh.MaNV");
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String maCCCD = rs.getString("MaCCCD");
				LocalDate ngayVaoLamViec = rs.getDate("NgayVaoLamViec").toLocalDate();
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				String chucVu = rs.getString("ChucVu");
				double luong = rs.getDouble("MucLuong");
				String trinhDoHoc = rs.getString("TrinhDoHoc");
				String thuocPhongBan = rs.getString("ThuocPhongBan");

				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan c = cccd_dao.getCCCD(maCCCD);
				NhanVien nv = new NhanVienHanhChinh(maNV, c, ngayVaoLamViec, sdt, email, chucVu, luong, trinhDoHoc,
						thuocPhongBan);
				dsnv.add(nv);
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
		return dsnv;
	}

	public ArrayList<NhanVien> getAllNhanVienKyThuat() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien JOIN NhanVienKyThuat ON NhanVien.MaNV = NhanVienKyThuat.MaNV");
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String maCCCD = rs.getString("MaCCCD");
				LocalDate ngayVaoLamViec = rs.getDate("NgayVaoLamViec").toLocalDate();
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				String chucVu = rs.getString("ChucVu");
				double luong = rs.getDouble("MucLuong");
				int bacTho = rs.getInt("BacTho");
				int soNamKN = rs.getInt("SoNamKN");

				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan c = cccd_dao.getCCCD(maCCCD);
				NhanVien nv = new NhanVienKiThuat(maNV, c, ngayVaoLamViec, sdt, email, chucVu, luong, bacTho, soNamKN);
				dsnv.add(nv);
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
		return dsnv;
	}

	public NhanVien getNhanVienTheoMaNV(String ma) {
		NhanVien nv = getNhanVienHanhChinhTheoMaNV(ma);
		if (nv != null) return nv;
		nv = getNhanVienKyThuatTheoMaNV(ma);
		if (nv != null) return nv;
		return null;
	}

	public NhanVien getNhanVienHanhChinhTheoMaNV(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien JOIN NhanVienHanhChinh ON NhanVien.MaNV = NhanVienHanhChinh.MaNV "
							+ "WHERE NhanVien.MaNV = '%s'", ma);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String maCCCD = rs.getString("MaCCCD");
				LocalDate ngayVaoLamViec = rs.getDate("NgayVaoLamViec").toLocalDate();
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				String chucVu = rs.getString("ChucVu");
				double luong = rs.getDouble("MucLuong");
				String trinhDoHocVan = rs.getString("TrinhDoHoc");
				String thuocPhongBan = rs.getString("ThuocPhongBan");

				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan c = cccd_dao.getCCCD(maCCCD);
				return new NhanVienHanhChinh(maNV, c, ngayVaoLamViec, sdt, email, chucVu, luong, trinhDoHocVan, thuocPhongBan);
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
		return null;
	}
	
	public NhanVien getNhanVienKyThuatTheoMaNV(String ma) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String
					.format("SELECT * FROM NhanVien JOIN NhanVienKyThuat ON NhanVien.MaNV = NhanVienKyThuat.MaNV "
							+ "WHERE NhanVien.MaNV = '%s'", ma);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String maCCCD = rs.getString("MaCCCD");
				LocalDate ngayVaoLamViec = rs.getDate("NgayVaoLamViec").toLocalDate();
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("Email");
				String chucVu = rs.getString("ChucVu");
				double luong = rs.getDouble("MucLuong");
				int bacTho = rs.getInt("BacTho");
				int soNamKN = rs.getInt("SoNamKN");

				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan c = cccd_dao.getCCCD(maCCCD);
				return new NhanVienKiThuat(maNV, c, ngayVaoLamViec, sdt, email, chucVu, luong, bacTho, soNamKN);
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
		return null;
	}
}
