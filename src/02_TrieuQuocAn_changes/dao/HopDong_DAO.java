package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.HopDong;
import entity.HopDongTraGop;
import entity.KhachHang;
import entity.NhanVien;
import entity.NhanVienHanhChinh;
import entity.PhieuNhanXetBaoHanh;
import entity.PhuongThucThanhToan;
import entity.XeMay;

public class HopDong_DAO {
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private XeMay_DAO xe_dao = new XeMay_DAO();
	PhuongThucThanhToan TRAHET = PhuongThucThanhToan.TRAHET;
	PhuongThucThanhToan TRAGOP = PhuongThucThanhToan.TRAGOP;

	/**
	 * @author An Quoc Viet
	 * @return
	 */
	public ArrayList<HopDong> getAllListHopDong() {
		ArrayList<HopDong> hopDongList = new ArrayList<HopDong>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM HopDong";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String soHopDong = rs.getString("SoHopDong");
				String maKH = rs.getString("MaKH");
				String maNV = rs.getString("MaNV");
				LocalDate ngayLapHopDong = rs.getDate("NgayLapHopDong").toLocalDate();
				LocalDate thoiGianBaoHanh = rs.getDate("ThoiGianBaoHanh").toLocalDate();
				String phuongThucThanhToan = rs.getString("PhuongThucThanhToan");
				int soLanTra = rs.getInt("SoLanTraGop");
				double tongTien = rs.getDouble("TongTien");
				KhachHang khachHang = kh_dao.getKhachHangTheoMaKH(maKH);
				NhanVien nhanVien = nv_dao.getNhanVienTheoMaNV(maNV);
				ArrayList<XeMay> dsXe = xe_dao.getDSXeMayCuaKhachHang(maKH);
				HopDong hopDong = new HopDong(soHopDong, khachHang, nhanVien, ngayLapHopDong,
						phuongThucThanhToan.equals("Trả hết") ? TRAHET : TRAGOP, soLanTra, tongTien, thoiGianBaoHanh,
						dsXe);
				hopDongList.add(hopDong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hopDongList;
	}

	/**
	 * @author AnQuocViet
	 */
	public int countHopDongInDate(LocalDate date) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		int count = 0;
		try {
			stmt = con.createStatement();
			String dateFormat = date.toString();
			String sql = String.format("SELECT * FROM HopDong WHERE NgayLapHopDong = '%s'", dateFormat);
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
	
	/**
	 * @ @author An Quoc Viet
	 * @param date
	 * @return
	 */
	public int countLuotTraGopTrongNgay(LocalDate date) {
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		int count = 0;
		try {
			stmt = con.createStatement();
			String dateFormat = date.toString();
			String sql = String.format("SELECT * FROM CT_TraGop WHERE NgayTraGop = '%s'", dateFormat);
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
	
	/**
	 * @author An Quoc Viet
	 * @param soHD
	 * @return
	 */
	public HopDong getHopDongTheoSoHopDong(String soHD) {
		HopDong hd = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM HopDong WHERE SoHopDong = '%s'", soHD);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String soHopDong = rs.getString("SoHopDong");
				String maKH = rs.getString("MaKH");
				String maNV = rs.getString("MaNV");
				LocalDate ngayLapHopDong = rs.getDate("NgayLapHopDong").toLocalDate();
				LocalDate thoiGianBaoHanh = rs.getDate("ThoiGianBaoHanh").toLocalDate();
				String phuongThucThanhToan = rs.getString("PhuongThucThanhToan");
				int soLanTra = rs.getInt("SoLanTraGop");
				double tongTien = rs.getDouble("TongTien");
				KhachHang khachHang = kh_dao.getKhachHangTheoMaKH(maKH);
				NhanVien nhanVien = nv_dao.getNhanVienTheoMaNV(maNV);
				ArrayList<XeMay> dsXe = xe_dao.getDSXeMayCuaKhachHang(maKH);
				hd = new HopDong(soHopDong, khachHang, nhanVien, ngayLapHopDong,
						phuongThucThanhToan.equals("Trả hết") ? TRAHET : TRAGOP, soLanTra, tongTien, thoiGianBaoHanh,
						dsXe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hd;
	}

	/**
	 * @author An Quoc Viet
	 * @param soHD
	 * @return
	 */
	public ArrayList<String> getAllMaTraGopTheoMaHopDong(String soHD) {
		ArrayList<String> dsMaTG = new ArrayList<String>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM CT_TraGop WHERE SoHopDong = '%s'", soHD);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maTG = rs.getString("MaTraGop");
				dsMaTG.add(maTG);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsMaTG;
	}

	public HopDong getThongTinTraGopTheoMaTraGop(String maTG) {
		HopDong hd = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format(
					"SELECT * FROM HopDong JOIN CT_TraGop ON HopDong.SoHopDong = CT_TraGop.SoHopDong WHERE MaTraGop = '%s'",
					maTG);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int soLanTra = rs.getInt("SoLanTraGop");
				double tongTien = rs.getDouble("TongTien");
				double soTienTra = rs.getDouble("SoTienTraGop");
				LocalDate ngayTra = rs.getDate("NgayTraGop").toLocalDate();
				String maNguoiTra = rs.getString("MaNguoiTra");
				String maNguoiNhan = rs.getString("MaNguoiNhan");
				CanCuocCongDan nguoiTra = new CanCuocCongDan(maNguoiTra);
				NhanVien nvNhan = new NhanVienHanhChinh(maNguoiNhan);
				hd = new HopDongTraGop(maTG, soLanTra, soTienTra, ngayTra, nguoiTra, nvNhan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hd;
	}

	/**
	 * @author An Quoc Viet
	 * @param maHD
	 * @return
	 */
	public double getTienDaNhan(String maHD) {
		double tienDaNhan = 0;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT SUM(SoTienTraGop) FROM CT_TraGop where SoHopDong = '%s'", maHD);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tienDaNhan = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tienDaNhan;
	}

}