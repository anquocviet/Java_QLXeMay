package entity;

import java.util.EmptyStackException;

public class CT_BaoHanh {
	private PhieuNhanXetBaoHanh phieu;
	private LinhKien linhKien;
	private String lyDo;
	private boolean loiThuocSP;
	private int soLuong;
	private double gia;
	private double thanhTien;

	public CT_BaoHanh() {
	}

	public CT_BaoHanh(PhieuNhanXetBaoHanh phieu, LinhKien linhKien, String lyDo, boolean loiThuocSP, int soLuong,
			double gia, double thanhTien) throws Exception {
		setPhieu(phieu);
		setLinhKien(linhKien);
		setLyDo(lyDo);
		setLoiThuocSP(loiThuocSP);
		setSoLuong(soLuong);
		setGia(gia);
		setThanhTien(thanhTien);
	}

	public PhieuNhanXetBaoHanh getPhieu() {
		return phieu;
	}

	public void setPhieu(PhieuNhanXetBaoHanh phieu) throws Exception {
		if (phieu == null)
			throw new Exception("Phiếu bảo hành không được trống");
		else
			this.phieu = phieu;
	}

	public LinhKien getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(LinhKien linhKien) throws Exception {
		if (linhKien == null)
			throw new Exception("Linh kiện không được trống");
		else
			this.linhKien = linhKien;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) throws Exception {
		if (lyDo.trim().equals(""))
			throw new Exception("Lý do không được trống");
		else
			this.lyDo = lyDo;
	}

	public boolean isLoiThuocSP() {
		return loiThuocSP;
	}

	public void setLoiThuocSP(boolean loiThuocSP) {
		this.loiThuocSP = loiThuocSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) throws Exception {
		if (soLuong < 0)
			throw new Exception("Số lượng linh kiện không được âm");
		else 
		this.soLuong = soLuong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) throws Exception {
		if (gia < 0)
			throw new Exception("Giá của linh kiện không được âm");
		else 
		this.gia = gia;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) throws Exception {
		if (thanhTien < 0)
			throw new Exception("Giá của linh kiện không được âm");
		else 
			this.thanhTien = thanhTien;
	}

}
