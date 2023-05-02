package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	/**
	 * @author Dang Thi Quyen Co
	 * @return
	 */
	public ArrayList<XeMay> getAllXeMay() {
		ArrayList<XeMay> dsXeMay = new ArrayList<XeMay>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "select*from XeMay";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String soKhung = rs.getString("SoKhung");
				String soMay = rs.getString("SoMay");
				LoaiXe loaiXe = new LoaiXe(rs.getString("MaLoai"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MaNCC"));
				String tenXe = rs.getString("TenXe");
				String nuocSanXuat = rs.getString("NuocSX");
				String mauXe = rs.getString("MauXe");
				double gia = rs.getDouble("Gia");
				int namSanXuat = rs.getInt("NamSX");
				String anh = rs.getString("AnhMinhHoa");
				XeMay xeMay = new XeMay(soKhung, soMay, loaiXe, nhaCungCap, tenXe, nuocSanXuat, mauXe, gia, namSanXuat,
						anh);
				dsXeMay.add(xeMay);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsXeMay;
	}

	/**
	 * @author An Quoc Viet
	 * @param soKhung
	 * @return
	 */
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

	/**
	 * @author Dang Thi Quyen Co
	 * @param maLoaiXe
	 * @return
	 */
	public ArrayList<XeMay> getDSXeMayTheoLoaiXe(String maLoaiXe) {
		ArrayList<XeMay> dsXe = new ArrayList<XeMay>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format(
					"SELECT * FROM HopDong h JOIN CT_HopDong ct ON h.SoHopDong = ct.SoHopDong WHERE h.MaLoai = '%s'",
					maLoaiXe);
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

	/**
	 * @author Dang Thi Quyen Co
	 * @param maLoai
	 * @return
	 */
	public ArrayList<XeMay> getDanhSachXeMayTheoMaLoaiXe(String maLoai) {
		ArrayList<XeMay> dsXeMay = new ArrayList<XeMay>();
		Connection conn = ConnectDB.getInstance().getConnection();
		try {
			Statement stm;
			String sql = "select*from XeMay where MaLoai='" + maLoai + "'";
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String soKhung = rs.getString("SoKhung");
				String soMay = rs.getString("SoMay");
				LoaiXe loaiXe = new LoaiXe(rs.getString("MaLoai"));
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MaNCC"));
				String tenXe = rs.getString("TenXe");
				String nuocSanXuat = rs.getString("NuocSX");
				String mauXe = rs.getString("MauXe");
				double gia = rs.getDouble("Gia");
				int namSanXuat = rs.getInt("NamSX");
//				//dể tạm
//				int namSanXuat = 2000;
//				Date namSanXuat=rs.getDate("NamSX");
				String anh = rs.getString("AnhMinhHoa");
				XeMay xeMay = new XeMay(soKhung, soMay, loaiXe, nhaCungCap, tenXe, nuocSanXuat, mauXe, gia, namSanXuat,
						anh);
				dsXeMay.add(xeMay);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsXeMay;
	}

	/**
	 * @author Dang Thi Quyen Co
	 * @param xeMay
	 * @return
	 */
	public boolean themXeMay(XeMay xeMay) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			String sql = "INSERT INTO XeMay  ( SoKhung, SoMay, MaLoai, MaNCC, TenXe, NuocSX, MauXe, Gia, NamSX, AnhMinhHoa ) VALUES (?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, xeMay.getSoKhung());
			pstm.setString(2, xeMay.getSoMay());
			pstm.setString(3, xeMay.getLoaiXe().getMaLoaiXe());
			pstm.setString(4, xeMay.getNhaCungCap().getMaNCC());
			pstm.setString(5, xeMay.getTenXe());
			pstm.setString(6, xeMay.getNuocSanXuat());
			pstm.setString(7, xeMay.getMauXe());
			pstm.setDouble(8, xeMay.getGia());
			pstm.setInt(9, xeMay.getNamSanXuat());
			pstm.setString(10, xeMay.getAnhMinhHoa());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	/**
	 * @author Dang Thi Quyen Co
	 * @param soKhung
	 * @return
	 */
	public boolean xoaXeTheoSoKhung(String soKhung) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "delete from XeMay where SoKhung ='" + soKhung + "'";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * @author Dang Thi Quyen Co
	 * @param xeMay
	 * @return
	 */
	public boolean updateXeMay(XeMay xeMay) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			String sql = "update XeMay set MaLoai=?, MaNCC=?, TenXe=?, NuocSX=?, MauXe=?, Gia=?, NamSX=?, AnhMinhHoa=? where SoKhung=? and soMay=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, xeMay.getLoaiXe().getMaLoaiXe());
			pstm.setString(2, xeMay.getNhaCungCap().getMaNCC());
			pstm.setString(3, xeMay.getTenXe());
			pstm.setString(4, xeMay.getNuocSanXuat());
			pstm.setString(5, xeMay.getMauXe());
			pstm.setDouble(6, xeMay.getGia());
			pstm.setInt(7, xeMay.getNamSanXuat());
			pstm.setString(8, xeMay.getAnhMinhHoa());
			pstm.setString(9, xeMay.getSoKhung());
			pstm.setString(10, xeMay.getSoMay());
			n = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	/**
	 * @author An Quoc Viet
	 * @return
	 */
	public ArrayList<String> getAllMauXe() {
		ArrayList<String> dsMauXe = new ArrayList<String>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "SELECT * FROM XeMay";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String mauXe = rs.getString("MauXe");
				if (!dsMauXe.contains(mauXe)) 
					dsMauXe.add(mauXe);
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
		return dsMauXe;
	}
}
