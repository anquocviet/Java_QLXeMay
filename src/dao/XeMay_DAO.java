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
			while(rs.next()) {
				String soKhung =rs.getString("SoKhung");
				String soMay =  rs.getString("SoMay");
				LoaiXe loaiXe =new LoaiXe(rs.getString("MaLoai"));
				NhaCungCap nhaCungCap= new NhaCungCap(rs.getString("MaNCC"));
				String tenXe = rs.getString("TenXe");
				String nuocSanXuat =rs.getString("NuocSX");
				String mauXe = rs.getString("MauXe");
				double gia = rs.getDouble("Gia");
				int namSanXuat = rs.getInt("NamSX");
				String anh = rs.getString("AnhMinhHoa");
				XeMay xeMay = new XeMay(soKhung, soMay, loaiXe, nhaCungCap, tenXe, nuocSanXuat, mauXe, gia, namSanXuat, anh);
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
}
