package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_DAO {
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		ArrayList<NhaCungCap> dsncc = new ArrayList<NhaCungCap>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM NhaCungCap";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString("MaNCC");
				String tenNCC = rs.getString("TenNCC");
				String sdt = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				NhaCungCap ncc = new NhaCungCap(maNCC,tenNCC,diaChi,sdt);
				dsncc.add(ncc);
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
		return dsncc;
	}
	
	public NhaCungCap findNhaCungCapByMaNCC(String maNCC) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    NhaCungCap ncc = null;
	    try {
	        stmt = con.prepareStatement("SELECT * FROM NhaCungCap WHERE MaNCC=?");
	        stmt.setString(1, maNCC);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String tenNCC = rs.getString("TenNCC");
	            String sdt = rs.getString("SoDienThoai");
	            String diaChi = rs.getString("DiaChi");
	            ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
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
	    return ncc;
	}

	public boolean themNhaCungCap(NhaCungCap ncc) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    int rows = 0;
	    try {
	        stmt = con.prepareStatement("INSERT INTO NhaCungCap(MaNCC, TenNCC, DiaChi, SoDienThoai) VALUES (?, ?, ?, ?)");
	        stmt.setString(1, ncc.getMaNCC());
	        stmt.setString(2, ncc.getTenNCC());
	        stmt.setString(3, ncc.getDiaChi());
	        stmt.setString(4, ncc.getSdt());
	        rows = stmt.executeUpdate();
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
	    return rows > 0;
	}
	
	public boolean suaThongTinNhaCungCap(NhaCungCap ncc) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    int rows = 0;
	    try {
	        stmt = con.prepareStatement("UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, SoDienThoai = ? WHERE MaNCC = ?");
	        stmt.setString(1, ncc.getTenNCC());
	        stmt.setString(2, ncc.getDiaChi());
	        stmt.setString(3, ncc.getSdt());
	        stmt.setString(4, ncc.getMaNCC());
	        rows = stmt.executeUpdate();
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
	    return rows > 0;
	}

	public boolean xoaNhaCungCap(String maNCC) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    int rows = 0;
	    try {
	        stmt = con.prepareStatement("DELETE FROM NhaCungCap WHERE MaNCC = ?");
	        stmt.setString(1, maNCC);
	        rows = stmt.executeUpdate();
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
	    return rows > 0;
	}

	
}
