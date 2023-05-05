package entity;

import java.util.Objects;

public class LoaiXe {
	private String maLoaiXe;
	private LoHang loHang;
	private String tenLoaiXe;
	private String tenHang;
	private int soPhanKhoi;
	private boolean dongTietKiem;

	public LoaiXe() {
		super();
	}

	public LoaiXe(String maLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
	}

	public LoaiXe(String maLoaiXe, LoHang loHang, String tenLoaiXe, String tenHang, int soPhanKhoi,
			boolean dongTietKiem) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.loHang = loHang;
		this.tenLoaiXe = tenLoaiXe;
		this.tenHang = tenHang;
		this.soPhanKhoi = soPhanKhoi;
		this.dongTietKiem = dongTietKiem;
	}

	public LoaiXe(String maLoai, String tenLoai, String tenHang, int soPhanKhoi, boolean dongTietKiem, LoHang loHang) {
		this.maLoaiXe = maLoai;
		this.tenLoaiXe = tenLoai;
		this.tenHang = tenHang;
		this.soPhanKhoi = soPhanKhoi;
		this.dongTietKiem = dongTietKiem;
		this.loHang = loHang;

	}

//	public LoaiXe(String maLoaiXe)

	public String getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(String maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public LoHang getLoHang() {
		return loHang;
	}

	public void setLoHang(LoHang loHang) {
		this.loHang = loHang;
	}

	public String getTenLoaiXe() {
		return tenLoaiXe;
	}

	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getSoPhanKhoi() {
		return soPhanKhoi;
	}

	public void setSoPhanKhoi(int soPhanKhoi) {
		this.soPhanKhoi = soPhanKhoi;
	}

	public boolean getDongTietKiem() {
		return dongTietKiem;
	}


	public void setDongTietKiem(boolean dongTietKiem) {
		this.dongTietKiem = dongTietKiem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiXe other = (LoaiXe) obj;
		return Objects.equals(maLoaiXe, other.maLoaiXe);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
