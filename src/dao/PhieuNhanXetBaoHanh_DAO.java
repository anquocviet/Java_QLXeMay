package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CT_BaoHanh;
import entity.CanCuocCongDan;
import entity.HopDong;
import entity.HopDongTraGop;
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

	public boolean themMoiPhieuBaoHanh(PhieuNhanXetBaoHanh p, double tienCong) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO PhieuNhanXetBaoHanh ( MaPhieu, NgayLap, MaNV, MaKH, SoKhung, TienCong )"
					+ "VALUES ( ?, ?, ?, ?, ?, ? )";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getMaPhieu());
			pstm.setDate(2, Date.valueOf(p.getNgayLap()));
			pstm.setString(3, p.getNhanvien().getMaNhanVien());
			pstm.setString(4, p.getKhachHang().getMaKhachHang());
			pstm.setString(5, p.getXe().getSoKhung());
			pstm.setDouble(6, tienCong);
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean themMoiCT_BaoHanh(CT_BaoHanh ct) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "INSERT INTO CT_BaoHanh ( MaPhieu, MaLinhKien, LyDo, LoiThuocSanPham, SoLuong, Gia, ThanhTien )"
					+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ct.getPhieu().getMaPhieu());
			pstm.setString(2, ct.getLinhKien().getMaLinhKien());
			pstm.setString(3, ct.getLyDo());
			pstm.setBoolean(4, ct.isLoiThuocSP());
			pstm.setInt(5, ct.getSoLuong());
			pstm.setDouble(6, ct.getGia());
			pstm.setDouble(7, ct.getThanhTien());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
