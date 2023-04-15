package entity;

public class CuaHang {
	private String maCuaHang;
	private String tenCuaHang;
	private String diaChi;

	public CuaHang() {
	}

	public CuaHang(String maCuaHang, String tenCuaHang, String diaChi) throws Exception {
		setMaCuaHang(maCuaHang);
		setTenCuaHang(tenCuaHang);
		setDiaChi(diaChi);
	}

	public CuaHang(String maCuaHang) throws Exception {
		setMaCuaHang(maCuaHang);
	}

	public String getMaCuaHang() {
		return maCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) throws Exception {
		if (maCuaHang.trim().equals(""))
			throw new Exception("Mã cửa hàng không được rỗng");
		else
			this.maCuaHang = maCuaHang;
	}

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) throws Exception {
		if (tenCuaHang.trim().equals(""))
			throw new Exception("Tên cửa hàng không được rỗng");
		else
			this.tenCuaHang = tenCuaHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		if (diaChi.trim().equals(""))
			throw new Exception("Địa chỉ cửa hàng không được rỗng");
		else
			this.diaChi = diaChi;
	}

}
