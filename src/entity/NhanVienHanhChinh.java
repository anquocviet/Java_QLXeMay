package entity;

import java.sql.Date;

public class NhanVienHanhChinh extends NhanVien {
	private String trinhDoHocVan;
	private String PhongBan;
	private String ChucVu;
	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}
	public void setTrinhDoHocVan(String trinhDoHocVan) throws Exception {
		if (trinhDoHocVan.trim().equals("")) throw new Exception("Trình độ hoc vấn không được để trống");
		else
		this.trinhDoHocVan = trinhDoHocVan;
	}
	public String getPhongBan() {
		return PhongBan;
	}
	public void setPhongBan(String phongBan) throws Exception {
		if (phongBan.trim().equals("")) throw new Exception("Phòng ban không được để trống");
		else
		PhongBan = phongBan;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) throws Exception {
		if (chucVu.trim().equals("")) throw new Exception("Chức vụ không được để trống");
		else
		ChucVu = chucVu;
	}
	public NhanVienHanhChinh(String maNhanVien, CanCuocCongDan cccd, Date ngayVaoLamViec, String soDienThoai,
			String email, double luong, String trinhDoHocVan, String phongBan, String chucVu) {
		super(maNhanVien, cccd, ngayVaoLamViec, soDienThoai, email, luong);
		this.trinhDoHocVan = trinhDoHocVan;
		PhongBan = phongBan;
		ChucVu = chucVu;
	}
	
	
}
