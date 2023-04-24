package entity;

import java.time.LocalDate;
import java.util.Objects;

public class LoHang {
	private String soLo;
	private NhaCungCap nhaCungCap;
	private String tenNuocNhap;
	private int soLuong;
	private LocalDate ngayNhapKho;

	public LoHang() {
		super();
	}

	public LoHang(String soLo) {
		super();
		this.soLo = soLo;
	}

	public LoHang(String soLo, NhaCungCap nhaCungCap, String tenNuocNhap, int soLuong, LocalDate ngayNhapKho) {
		super();
		this.soLo = soLo;
		this.nhaCungCap = nhaCungCap;
		this.tenNuocNhap = tenNuocNhap;
		this.soLuong = soLuong;
		this.ngayNhapKho = ngayNhapKho;
	}

	public String getSoLo() {
		return soLo;
	}

	public void setSoLo(String soLo) {
		this.soLo = soLo;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getTenNuocNhap() {
		return tenNuocNhap;
	}

	public void setTenNuocNhap(String tenNuocNhap) {
		this.tenNuocNhap = tenNuocNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		this.ngayNhapKho = ngayNhapKho;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soLo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoHang other = (LoHang) obj;
		return Objects.equals(soLo, other.soLo);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
