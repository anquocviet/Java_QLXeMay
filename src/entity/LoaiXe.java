package entity;

import java.util.Objects;

public class LoaiXe {
	private String maLoaiXe;
	private LoHang loHang;
	private String tenLoaiXe;
	private String tenNhaSanXuat;
	private int soPhanKhoi;
	private boolean dongTietKiem;

	public LoaiXe() {
		super();
	}

	public LoaiXe(String maLoaiXe) {
		super();
		this.maLoaiXe = maLoaiXe;
	}
	public LoaiXe(String tenNhaSanXuat ,String tenLoaiXe) {
		super();
		this.tenNhaSanXuat = tenNhaSanXuat;
		this.tenLoaiXe = tenLoaiXe;
	}

	public LoaiXe(String maLoaiXe, LoHang loHang, String tenLoaiXe, String tenNhaSanXuat, int soPhanKhoi,
			boolean dongTietKiem) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.loHang = loHang;
		this.tenLoaiXe = tenLoaiXe;
		this.tenNhaSanXuat = tenNhaSanXuat;
		this.soPhanKhoi = soPhanKhoi;
		this.dongTietKiem = dongTietKiem;
	}

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

	public String getTenNhaSanXuat() {
		return tenNhaSanXuat;
	}

	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	public int getSoPhanKhoi() {
		return soPhanKhoi;
	}

	public void setSoPhanKhoi(int soPhanKhoi) {
		this.soPhanKhoi = soPhanKhoi;
	}

	public boolean isDongTietKiem() {
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
