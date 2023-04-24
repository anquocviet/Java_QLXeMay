package entity;

import java.sql.Date;

public  abstract class NhanVien   {
	private String MaNhanVien;
	private CanCuocCongDan cccd;
	private Date NgayVaoLamViec;
	private String SoDienThoai;
	private String email;
	private double Luong;
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) throws Exception {
		if (maNhanVien.trim().equals(""))
			throw new Exception("Mã nhân viên không được để trống");
		else 
		MaNhanVien = maNhanVien;
	}
	public CanCuocCongDan getCccd() {
		return cccd;
	}
	public void setCccd(CanCuocCongDan cccd) {
		this.cccd = cccd;
	}
	public Date getNgayVaoLamViec() {
		return NgayVaoLamViec;
	}
	public void setNgayVaoLamViec(Date ngayVaoLamViec) {
		NgayVaoLamViec = ngayVaoLamViec;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) throws Exception  {
		if (soDienThoai.trim().equals("") && !(soDienThoai.matches("/[0-9]{10}/")))
			throw new Exception("Số điện thoại không được để trống và phải đủ 10 số");
		else
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws Exception {
		if (email.trim().equals("") && !(email.matches("/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/")))
			throw new Exception("Email không được để trống và phải đúng theo cú pháp");
		else
		this.email = email;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) throws Exception {
		if (luong < 0 ) throw new Exception ("Lương không được nhỏ hơn 0");
		else
		Luong = luong;
	}
	public NhanVien(String maNhanVien, CanCuocCongDan cccd, Date ngayVaoLamViec, String soDienThoai, String email,
			double luong) {
		super();
		MaNhanVien = maNhanVien;
		this.cccd = cccd;
		NgayVaoLamViec = ngayVaoLamViec;
		SoDienThoai = soDienThoai;
		this.email = email;
		Luong = luong;
	}
	public NhanVien(String maNhanVien) {
		super();
		MaNhanVien = maNhanVien;
	}
	public double Luong()
	{
		return Luong;
	}
	
	
}
