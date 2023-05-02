package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HopDongTraGop extends HopDong {
	private String maTraGop;
	private int soLanTraGop;
	private double soTienTraGop;
	private LocalDate ngayTraGop;
	private CanCuocCongDan nguoiTra;
	private NhanVien nguoiNhan;

	public HopDongTraGop(String soHopDong, KhachHang khachHang, NhanVien nhanVienLapHopDong, LocalDate ngayHopDong,
			PhuongThucThanhToan phuongThucThanhToan, int soLanTra, LocalDate thoiGianBaoHanh,
			ArrayList<XeMay> danhSachXe, String maTraGop, int soLanTraGop, double soTienTraGop, LocalDate ngayTraGop,
			CanCuocCongDan nguoiTra, NhanVien nguoiNhan) throws Exception {
		super(soHopDong, khachHang, nhanVienLapHopDong, ngayHopDong, phuongThucThanhToan, soLanTra, thoiGianBaoHanh,
				danhSachXe);
		this.maTraGop = maTraGop;
		this.soLanTraGop = soLanTraGop;
		this.soTienTraGop = soTienTraGop;
		this.ngayTraGop = ngayTraGop;
		this.nguoiTra = nguoiTra;
		this.nguoiNhan = nguoiNhan;
	}

	public HopDongTraGop(String maTraGop, int soLanTraGop, double soTienTraGop, LocalDate ngayTraGop,
			CanCuocCongDan nguoiTra, NhanVien nguoiNhan) throws Exception {
		super();
		setMaTraGop(maTraGop);
		setNgayTraGop(ngayTraGop);
		setSoLanTraGop(soLanTraGop);
		setSoTienTraGop(soTienTraGop);
		setNguoiNhan(nguoiNhan);
		setNguoiTra(nguoiTra);
	}

	public HopDongTraGop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HopDongTraGop(String maTraGop) throws Exception {
		super();
		setMaTraGop(maTraGop);
	}

	public String getMaTraGop() {
		return maTraGop;
	}

	public void setMaTraGop(String maTraGop) throws Exception {
		if (maTraGop.trim().equals(""))
			throw new Exception("Mã trả góp không được rỗng");
		else
			this.maTraGop = maTraGop;
	}

	public int getSoLanTraGop() {
		return soLanTraGop;
	}

	public void setSoLanTraGop(int soLanTraGop) throws Exception {
		if (soLanTraGop < 0)
			throw new Exception("Số lần trả góp không được bé hơn 0");
		else
			this.soLanTraGop = soLanTraGop;
	}

	public double getSoTienTraGop() {
		return soTienTraGop;
	}

	public void setSoTienTraGop(double soTienTraGop) throws Exception {
		if (soTienTraGop < 0)
			throw new Exception("Số tiền trả góp không được bé hơn 0");
		else
			this.soTienTraGop = soTienTraGop;
	}

	public LocalDate getNgayTraGop() {
		return ngayTraGop;
	}

	public void setNgayTraGop(LocalDate ngayTraGop) throws Exception {
		if (ngayTraGop == null)
			throw new Exception("Ngày trả góp không được rỗng");
		else
			this.ngayTraGop = ngayTraGop;
	}

	public CanCuocCongDan getNguoiTra() {
		return nguoiTra;
	}

	public void setNguoiTra(CanCuocCongDan nguoiTra) throws Exception {
		if (nguoiTra == null)
			throw new Exception("Người trả không được rỗng");
		else
			this.nguoiTra = nguoiTra;
	}

	public NhanVien getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(NhanVien nguoiNhan) throws Exception {
		if (nguoiNhan == null)
			throw new Exception("Người nhận không được rỗng");
		else
			this.nguoiNhan = nguoiNhan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTraGop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDongTraGop other = (HopDongTraGop) obj;
		return Objects.equals(maTraGop, other.maTraGop);
	}

}
