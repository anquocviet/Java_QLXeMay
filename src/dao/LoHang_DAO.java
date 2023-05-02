package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoHang;
import entity.NhaCungCap;

public class LoHang_DAO {
	public ArrayList<LoHang> getAllLoHang() {
		ArrayList<LoHang> dsLoHang = new ArrayList<LoHang>();
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql ="select*from LoHang";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String soLo=rs.getString("SoLo");
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MaNCC"));
				String tenNuocNhap = rs.getString("TenNuocNhap");
				int soLuong = rs.getInt("SoLuong");
				Date ngayNhapKho = rs.getDate("NgayNhapKho");
				LoHang loHang = new LoHang(soLo, nhaCungCap, tenNuocNhap, soLuong, ngayNhapKho);
				dsLoHang.add(loHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoHang;
	}
	
	public LoHang getLoHangTheoSoLo() {
		LoHang loHang = null;
		Connection conn = ConnectDB.getInstance().getConnection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			String sql = "";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String soLo=rs.getString("SoLo");
				NhaCungCap nhaCungCap = new NhaCungCap(rs.getString("MaNCC"));
				String tenNuocNhap = rs.getString("TenNuocNhap");
				int soLuong = rs.getInt("SoLuong");
				Date ngayNhapKho = rs.getDate("NgayNhapKho");
				loHang = new LoHang(soLo, nhaCungCap, tenNuocNhap, soLuong, ngayNhapKho);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return loHang;
	}
	
}
