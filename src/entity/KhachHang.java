package entity;

public class KhachHang {
	private String maKhachHang;
	private String soDienThoai;
	private CanCuocCongDan cccd;

	public KhachHang() {
	}

	public KhachHang(String maKhachHang,CanCuocCongDan cccd, String soDienThoai) throws Exception {
		setMaKhachHang(maKhachHang);
		setSoDienThoai(soDienThoai);
		setCccd(cccd);
	}

	public KhachHang(String maKhachHang, CanCuocCongDan cccd) throws Exception {
		setMaKhachHang(maKhachHang);
		setCccd(cccd);
	}
	
	public KhachHang(String maKH) throws Exception {
		setMaKhachHang(maKH);
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) throws Exception {
		if (maKhachHang.trim().equals(""))
			throw new Exception("Mã khách hàng không được rỗng");
		else
			this.maKhachHang = maKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws Exception {
		if (soDienThoai.trim().equals(""))
			throw new Exception("Số điện thoại của khách hàng không được rỗng");
		else
			this.soDienThoai = soDienThoai;
	}

	public CanCuocCongDan getCccd() {
		return cccd;
	}

	public void setCccd(CanCuocCongDan cccd) throws Exception {
		if (cccd == null)
			throw new Exception("Căn cước công dân của khách hàng không được rỗng");
		else
			this.cccd = cccd;
	}

}
