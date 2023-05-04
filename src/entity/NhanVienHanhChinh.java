package entity;

import java.time.LocalDate;

public class NhanVienHanhChinh extends NhanVien {
	private String trinhDoHocVan;
	private String phongBan;

	public String getTrinhDoHocVan() {
		return trinhDoHocVan;
	}

	public void setTrinhDoHocVan(String trinhDoHocVan) throws Exception {
		if (trinhDoHocVan.trim().equals(""))
			throw new Exception("Trình độ hoc vấn không được để trống");
		else
			this.trinhDoHocVan = trinhDoHocVan;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) throws Exception {
		if (phongBan.trim().equals(""))
			throw new Exception("Phòng ban không được để trống");
		else
			this.phongBan = phongBan;
	}

	public NhanVienHanhChinh(String maNhanVien, CanCuocCongDan cccd, LocalDate ngayVaoLamViec, String soDienThoai,
			String email, String chucVu, double luong, String trinhDoHocVan, String phongBan) throws Exception {
		super(maNhanVien, cccd, ngayVaoLamViec, soDienThoai, email, chucVu, luong);
		setTrinhDoHocVan(trinhDoHocVan);
		setPhongBan(phongBan);
		setChucVu(chucVu);
	}
	
	public NhanVienHanhChinh() {
		super();
	}
	
	public NhanVienHanhChinh(String maNhanVien) throws Exception {
		super(maNhanVien);
	}

}
