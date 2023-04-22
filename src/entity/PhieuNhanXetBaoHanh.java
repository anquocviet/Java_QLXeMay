package entity;

import java.time.LocalDate;

public class PhieuNhanXetBaoHanh {
	private String maPhieu;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private XeMay xe;
	private LocalDate ngayLap;

	public PhieuNhanXetBaoHanh() {
	}

	public PhieuNhanXetBaoHanh(String maPhieu, NhanVien nhanVien, KhachHang khachHang, XeMay xe, LocalDate ngayLap) throws Exception {
		setMaPhieu(maPhieu);
		setNhanvien(nhanVien);
		setKhachHang(khachHang);
		setXe(xe);
		setNgayLap(ngayLap);
	}

	public PhieuNhanXetBaoHanh(String maPhieu) throws Exception {
		setMaPhieu(maPhieu);
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) throws Exception {
		if (maPhieu.trim().equals(""))
			throw new Exception("Mã phiếu không được trống");
		else
			this.maPhieu = maPhieu;
	}

	public NhanVien getNhanvien() {
		return nhanVien;
	}

	public void setNhanvien(NhanVien nhanVien) throws Exception {
		if (nhanVien == null)
			throw new Exception("Nhân viên không được rỗng");
		else
			this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) throws Exception {
		if (khachHang == null)
			throw new Exception("Khách hàng không được rỗng");
		else
			this.khachHang = khachHang;
	}

	public XeMay getXe() {
		return xe;
	}

	public void setXe(XeMay xe) throws Exception {
		if (xe == null)
			throw new Exception("Xe máy không được rỗng");
		else
			this.xe = xe;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) throws Exception {
		if (ngayLap == null)
			throw new Exception("Ngày lập phiếu không được rỗng");
		else
			this.ngayLap = ngayLap;
	}

}
