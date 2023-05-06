package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ConnectDB;
import entity.LinhKien;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.XeMay;

public class LinhKien_DAO {
	public LinhKien getLinhKienTheoMaLK(String maLK) {
		LinhKien lk = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = String.format("SELECT * FROM LinhKien WHERE MaLinhKien = '%s'", maLK);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String tenLK = rs.getString("TenLinhKien");
				double gia = rs.getDouble("Gia");
				lk = new LinhKien(maLK, tenLK, gia);
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
		return lk;
	}
}
