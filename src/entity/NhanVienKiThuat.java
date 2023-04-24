package entity;

import java.sql.Date;

public class NhanVienKiThuat extends NhanVien {
	private int bacTho;
	private int SoNamKN;
	private String ChucVu;
	public int getBacTho() {
		return bacTho;
	}
	public void setBacTho(int bacTho) {
		this.bacTho = bacTho;
	}
	public int getSoNamKN() {
		return SoNamKN;
	}
	public void setSoNamKN(int soNamKN) {
		SoNamKN = soNamKN;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) throws Exception{
		if (chucVu.trim().equals("")) throw new Exception("Chức vụ không được để trống");
		else
		ChucVu = chucVu;	
	}
	public NhanVienKiThuat(String maNhanVien, CanCuocCongDan cccd, Date ngayVaoLamViec, String soDienThoai,
			String email, double luong, int bacTho, int soNamKN, String chucVu) {
		super(maNhanVien, cccd, ngayVaoLamViec, soDienThoai, email, luong);
		this.bacTho = bacTho;
		SoNamKN = soNamKN;
		ChucVu = chucVu;
	}
	
}
