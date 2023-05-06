package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

	/**
	 * @author AnQuocViet
	 */
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsnv = getAllNhanVienHanhChinh();
		dsnv.addAll(getAllNhanVienKyThuat());
		return dsnv;
	}

	/**
	 * @author AnQuocViet
	 */
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
				CanCuocCongDan c = cccd_dao.getCCCDTheoMa(maCCCD);
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

	/**
	 * @author AnQuocViet
	 */
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
				CanCuocCongDan c = cccd_dao.getCCCDTheoMa(maCCCD);
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

	/**
	 * @author AnQuocViet
	 */
	public NhanVien getNhanVienTheoMaNV(String ma) {
		NhanVien nv = getNhanVienHanhChinhTheoMaNV(ma);
		if (nv != null)
			return nv;
		nv = getNhanVienKyThuatTheoMaNV(ma);
		if (nv != null)
			return nv;
		return null;
	}

	/**
	 * @author AnQuocViet
	 */
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
				CanCuocCongDan c = cccd_dao.getCCCDTheoMa(maCCCD);
				return new NhanVienHanhChinh(maNV, c, ngayVaoLamViec, sdt, email, chucVu, luong, trinhDoHocVan,
						thuocPhongBan);
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

	/**
	 * @author AnQuocViet
	 */
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
				CanCuocCongDan c = cccd_dao.getCCCDTheoMa(maCCCD);
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
	
	/**
	 * @author Dang Thi Quyen Co
	 * @param nhanVien
	 * @return
	 */
	public boolean themNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			String sql="INSERT INTO NhanVien ( MaNV, MaCCCD, NgayVaoLamViec, SoDienThoai, Email, ChucVu, MucLuong ) values(?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanVien.getMaNhanVien());
			pstm.setString(2, nhanVien.getCccd().getMaCCCD());
			pstm.setDate(3, Date.valueOf(nhanVien.getNgayVaoLamViec()));
			pstm.setString(4, nhanVien.getSoDienThoai());
			pstm.setString(5, nhanVien.getEmail());
			pstm.setString(6, nhanVien.getChucVu());
			pstm.setDouble(7, nhanVien.getLuong());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean themNhanVienHanhChinh( NhanVienHanhChinh nhanVienHC, CanCuocCongDan cc) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			cccd_dao.themCanCuocCongDan(cc);
			themNhanVien(nhanVienHC);
			String sql = "INSERT INTO NhanVienHanhChinh (MaNV, TrinhDoHoc, ThuocPhongBan) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanVienHC.getMaNhanVien());
			pstm.setString(2, nhanVienHC.getTrinhDoHocVan());
			pstm.setString(3, nhanVienHC.getPhongBan());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean themNhanVienKyThuat( NhanVienKiThuat nhanVienKT, CanCuocCongDan cc) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			cccd_dao.themCanCuocCongDan(cc);
			themNhanVien(nhanVienKT);
			String sql = "INSERT INTO NhanVienKyThuat (MaNV, BacTho, SoNamKN) VALUES(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanVienKT.getMaNhanVien());
			pstm.setInt(2, nhanVienKT.getBacTho());
			pstm.setInt(3, nhanVienKT.getSoNamKN());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean xoaNhanVien(String maNhanVien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		try {
			String sql = "delete from NhanVien where MaNV ='"+maNhanVien+"'";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean xoaNhanVienHanhChinh(String maNhanVien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		NhanVien nv = getNhanVienTheoMaNV(maNhanVien);
		try {
			String sql = "delete from NhanVienHanhChinh where MaNV ='"+maNhanVien+"'";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			xoaNhanVien(maNhanVien);
			cccd_dao.xoaCCCDTheoMa(nv.getCccd().getMaCCCD());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean xoaNhanVienKyThuat(String maNhanVien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		NhanVien nv = getNhanVienTheoMaNV(maNhanVien);
		try {
			String sql = "delete from NhanVienKyThuat where MaNV ='"+maNhanVien+"'";
			pstm = conn.prepareStatement(sql);
			pstm.executeUpdate();
			xoaNhanVien(maNhanVien);
			cccd_dao.xoaCCCDTheoMa(nv.getCccd().getMaCCCD());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean updateNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			String sql="update  NhanVien set  MaCCCD=?, NgayVaoLamViec=?, SoDienThoai=?, Email=?, ChucVu=?, MucLuong=? where MaNV=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanVien.getCccd().getMaCCCD());
			pstm.setDate(2, Date.valueOf(nhanVien.getNgayVaoLamViec()));
			pstm.setString(3, nhanVien.getSoDienThoai());
			pstm.setString(4, nhanVien.getEmail());
			pstm.setString(5, nhanVien.getChucVu());
			pstm.setDouble(6, nhanVien.getLuong());
			pstm.setString(7, nhanVien.getMaNhanVien());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean updateNhanVienHanhChinh(NhanVienHanhChinh nhanVienHC, CanCuocCongDan cc) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			cccd_dao.updateCanCuocCongDan(cc);
			updateNhanVien(nhanVienHC);
			String sql = "update  NhanVienHanhChinh set TrinhDoHoc=?, ThuocPhongBan=? where MaNV=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nhanVienHC.getTrinhDoHocVan());
			pstm.setString(2, nhanVienHC.getPhongBan());
			pstm.setString(3, nhanVienHC.getMaNhanVien());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public boolean updateNhanVienKyThuat(NhanVienKiThuat nhanVienKT, CanCuocCongDan cc) {
		ConnectDB.getInstance();
		Connection conn = ConnectDB.getInstance().getConnection();
		PreparedStatement pstm = null;
		int n=0;
		try {
			cccd_dao.updateCanCuocCongDan(cc);
			updateNhanVien(nhanVienKT);
			String sql = "update  NhanVienKyThuat set TrinhDoHoc=?, ThuocPhongBan=? where MaNV=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, nhanVienKT.getBacTho());
			pstm.setInt(2, nhanVienKT.getSoNamKN());
			pstm.setString(3, nhanVienKT.getMaNhanVien());
			n=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	
	public int countNhanVienTheoNgay(LocalDate date) {
		ArrayList<NhanVien> dsp = new ArrayList<NhanVien>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		int count = 0;
		try {
			stmt = con.createStatement();
			String dateFormat = date.toString();
			String sql = String.format("SELECT * FROM NhanVien WHERE NgayVaoLamViec = '%s'", dateFormat);
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

}
