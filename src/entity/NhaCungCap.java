package entity;

public class NhaCungCap {
	private String maNCC,tenNCC,diaChi,sdt;

	public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt) throws Exception {
		super();
		setMaNCC(maNCC);
		setTenNCC(tenNCC);
		setDiaChi(diaChi);
		setSdt(sdt);
	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhaCungCap(String maNCC) throws Exception {
		super();
		setMaNCC(maNCC);
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) throws Exception {
		if (maNCC.trim().equals(""))
			throw new Exception("Mã nhà cung cấp không được rỗng");
		else
			this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) throws Exception {
		if (tenNCC.trim().equals(""))
			throw new Exception("Tên nhà cung cấp không được rỗng");
		else
			this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		if (diaChi.trim().equals(""))
			throw new Exception("Địa chỉ nhà cung cấp không được rỗng");
		else
			this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) throws Exception {
		if (sdt.trim().equals(""))
			throw new Exception("Số điện thoại liên hệ nhà cung cấp không được rỗng");
		else
			this.sdt = sdt;
	}
	
}
