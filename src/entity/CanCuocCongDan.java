package entity;

import java.time.LocalDate;

public class CanCuocCongDan {
	private String maCCCD;
	private String ho;
	private String hoDem;
	private String ten;
	private boolean gioiTinh;
	private LocalDate ngaySinh;
	private String tamTru;
	private String thuongTru;

	public CanCuocCongDan() {
	}

	public CanCuocCongDan(String maCCCD, String ho, String hoDem, String ten, boolean gioiTinh, LocalDate ngaySinh,
			String tamTru, String thuongTru) throws Exception {
		setMaCCCD(maCCCD);
		setHo(ho);
		setHoDem(hoDem);
		setTen(ten);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setTamTru(tamTru);
		setThuongTru(thuongTru);
	}

	public CanCuocCongDan(String maCCCD, String ho, String ten) throws Exception {
		setMaCCCD(maCCCD);
		setHo(ho);
		setTen(ten);
	}
	
	
	public CanCuocCongDan(String maCCCD) throws Exception {
		setMaCCCD(maCCCD);
	}

	public String getMaCCCD() {
		return maCCCD;
	}

	public void setMaCCCD(String maCCCD) throws Exception {
		if (maCCCD.trim().equals(""))
			throw new Exception("Mã Căn cước công dân không được rỗng");
		else
			this.maCCCD = maCCCD;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) throws Exception {
		if (ho.trim().equals(""))
			throw new Exception("Họ không được rỗng");
		else
			this.ho = ho;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) throws Exception {
		if (ten.trim().equals(""))
			throw new Exception("Tên không được rỗng");
		else
			this.ten = ten;
	}

	public Boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) throws Exception {
		if (ngaySinh == null)
			throw new Exception("Ngày sinh không được rỗng");
		else
			this.ngaySinh = ngaySinh;
	}

	public String getTamTru() {
		return tamTru;
	}

	public void setTamTru(String tamTru) throws Exception {
		if (tamTru.trim().equals(""))
			throw new Exception("Tạm trú không được rỗng");
		else
			this.tamTru = tamTru;
	}

	public String getThuongTru() {
		return thuongTru;
	}

	public void setThuongTru(String thuongTru) throws Exception {
		if (thuongTru.trim().equals(""))
			throw new Exception("Thường trú không được rỗng");
		else
			this.thuongTru = thuongTru;
	}

}
