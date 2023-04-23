package entity;

public class LinhKien {
	private String maLinhKien;
	private String tenLinhKien;
	private double gia;

	public LinhKien() {
	}

	public LinhKien(String maLinhKien, String tenLinhKien, double gia) throws Exception {
		setMaLinhKien(maLinhKien);
		setTenLinhKien(tenLinhKien);
		setGia(gia);
	}

	public LinhKien(String maLinhKien) throws Exception {
		setMaLinhKien(maLinhKien);
	}

	public String getMaLinhKien() {
		return maLinhKien;
	}

	public void setMaLinhKien(String maLinhKien) throws Exception {
		if (maLinhKien.trim().equals(""))
			throw new Exception("Mã linh kiện không được phép trống");
		else
			this.maLinhKien = maLinhKien;
	}

	public String getTenLinhKien() {
		return tenLinhKien;
	}

	public void setTenLinhKien(String tenLinhKien) throws Exception {
		if (tenLinhKien.trim().equals(""))
			throw new Exception("Tên linh kiện không được phép trống");
		else
			this.tenLinhKien = tenLinhKien;
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

}
