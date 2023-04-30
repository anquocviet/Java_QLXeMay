package entity;

import java.util.Objects;

public class XeMay {
	private String soKhung;
	private String soMay;
	private LoaiXe loaiXe;
	private NhaCungCap nhaCungCap;
	private String tenXe;
	private String nuocSanXuat;
	private String mauXe;
	private double gia;
	private int namSanXuat;
	private String anhMinhHoa;

	public XeMay() {
		super();
	}

	public XeMay(String soKhung) {
		super();
		this.soKhung = soKhung;
	}

	public XeMay(String soKhung, String soMay, LoaiXe loaiXe, NhaCungCap nhaCungCap, String tenXe, String nuocSanXuat,
			String mauXe, double gia, int namSanXuat, String anhMinhHoa) {
		super();
		this.soKhung = soKhung;
		this.soMay = soMay;
		this.loaiXe = loaiXe;
		this.nhaCungCap = nhaCungCap;
		this.tenXe = tenXe;
		this.nuocSanXuat = nuocSanXuat;
		this.mauXe = mauXe;
		this.gia = gia;
		this.namSanXuat = namSanXuat;
		this.anhMinhHoa = anhMinhHoa;
	}

	public String getSoKhung() {
		return soKhung;
	}

	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}

	public String getSoMay() {
		return soMay;
	}

	public void setSoMay(String soMay) {
		this.soMay = soMay;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getAnhMinhHoa() {
		return anhMinhHoa;
	}

	public void setAnhMinhHoa(String anhMinhHoa) {
		this.anhMinhHoa = anhMinhHoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soKhung);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XeMay other = (XeMay) obj;
		return Objects.equals(soKhung, other.soKhung);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
