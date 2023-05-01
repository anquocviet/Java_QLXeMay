package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.HopDong;
import entity.HopDongTraGop;
import entity.KhachHang;
import entity.NhanVien;
import entity.XeMay;

public class HopDong_DAO {
	public ArrayList<HopDong> getAllListHopDong() {
	    ArrayList<HopDong> hopDongList = new ArrayList<HopDong>();
	    Connection conn = ConnectDB.getInstance().getConnection();
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        String sql = "SELECT * FROM HopDong";
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	            String maHopDong = rs.getString("SoHopDong");
	            String maKH = rs.getString("MaKH");
	            String maNV = rs.getString("MaNV");
	            LocalDate ngayLapHopDong = rs.getDate("NgayLapHopDong").toLocalDate();
	            LocalDate thoiGianBaoHanh = rs.getDate("ThoiGianBaoHanh").toLocalDate();
	            String phuongThucThanhToan = rs.getString("PhuongThucThanhToan");
	            int soLanTraGop = rs.getInt("SoLanTraGop");
	            double tongTien = rs.getDouble("TongTien");
//	            KhachHang khachHang = KhachHang_DAO.getKhachHangTheoMaKH(maKH);
//	            NhanVien nhanVien = NhanVien_DAO.getNhanVienTheoMaNV(maNV);
//	            ArrayList<XeMay> dsXe = XeMay_DAO.getDSXeMayCuaKhachHang(maHopDong);
//	            HopDong hopDong = new HopDong(maHopDong, khachHang, nhanVien, ngayLapHopDong, phuongThucThanhToan, thoiGianBaoHanh, dsXe, soLanTraGop, tongTien);
//	            hopDongList.add(hopDong);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return hopDongList;
	}

}

