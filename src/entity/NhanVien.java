package entity;

import java.time.LocalDate;

public abstract class NhanVien {
	protected String maNhanVien;
	protected CanCuocCongDan cccd;
	protected LocalDate ngayVaoLamViec;
	protected String soDienThoai;
	protected String email;
	protected String chucVu;
	protected double luong;

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) throws Exception {
		if (maNhanVien.trim().equals(""))
			throw new Exception("Mã nhân viên không được để trống");
		else
			this.maNhanVien = maNhanVien;
	}

	public CanCuocCongDan getCccd() {
		return cccd;
	}

	public void setCccd(CanCuocCongDan cccd) {
		this.cccd = cccd;
	}

	public LocalDate getNgayVaoLamViec() {
		return ngayVaoLamViec;
	}

	public void setNgayVaoLamViec(LocalDate ngayVaoLamViec) {
		this.ngayVaoLamViec = ngayVaoLamViec;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws Exception {
		if (soDienThoai.trim().equals("") && !(soDienThoai.matches("/[0-9]{10}/")))
			throw new Exception("Số điện thoại không được để trống và phải đủ 10 số");
		else
			this.soDienThoai = soDienThoai;
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) throws Exception {
		if (chucVu.trim().equals(""))
			throw new Exception("Chức vụ không được để trống");
		else
			this.chucVu = chucVu;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) throws Exception {
		if (luong < 0)
			throw new Exception("Lương không được nhỏ hơn 0");
		else
			this.luong = luong;
	}

	public double Luong() {
		return luong;
	}

	public NhanVien() {
	}

	public NhanVien(String maNhanVien, CanCuocCongDan cccd, LocalDate ngayVaoLamViec, String soDienThoai, String email,
			String chucVu, double luong) throws Exception {
		super();
		setMaNhanVien(maNhanVien);
		setCccd(cccd);
		setNgayVaoLamViec(ngayVaoLamViec);
		setSoDienThoai(soDienThoai);
		setEmail(email);
		setChucVu(chucVu);
		setLuong(luong);
	}

	public NhanVien(String maNhanVien) throws Exception {
		setMaNhanVien(maNhanVien);
	}

}
