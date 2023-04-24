package entity;

import java.time.LocalDate;
import java.util.ArrayList;
enum enum_ThanhToan{
	CHUYENKHOAN,TIENMAT,TRAGOP
}
public class HopDong {
	protected String soHopDong;
	protected KhachHang khachHang;
	protected NhanVien nhanVienLapHopDong;
	protected LocalDate ngayHopDong;
	protected enum_ThanhToan phuongThucThanhToan;
	protected LocalDate thoiGianBaoHanh;
	protected ArrayList<XeMay> danhSachXe;
	protected final int CHIETKHAUTHANHTOANNGAY = 2;
	protected final int CHIETKHAUMUANHIEU = 5;
	
	
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong(String soHopDong) throws Exception {
		super();
		setSoHopDong(soHopDong);
	}

	public HopDong(String soHopDong, KhachHang khachHang, NhanVien nhanVienLapHopDong, LocalDate ngayHopDong,
			enum_ThanhToan phuongThucThanhToan, LocalDate thoiGianBaoHanh, ArrayList<XeMay> danhSachXe) throws Exception {
		super();
		setSoHopDong(soHopDong);
		setKhachHang(khachHang);
		setNhanVienLapHopDong(nhanVienLapHopDong);
		setPhuongThucThanhToan(phuongThucThanhToan);
		setThoiGianBaoHanh(thoiGianBaoHanh);
		setNgayHopDong(ngayHopDong);
		setDanhSachXe(danhSachXe);
	}
	
	public int getCHIETKHAUTHANHTOANNGAY() {
		return CHIETKHAUTHANHTOANNGAY;
	}
	public int getCHIETKHAUMUANHIEU() {
		return CHIETKHAUMUANHIEU;
	}
	public String getSoHopDong() {
		return soHopDong;
	}
	public void setSoHopDong(String soHopDong) throws Exception {
		if (soHopDong.trim().equals(""))
			throw new Exception("Số hợp đồng trả góp không được rỗng");
		else
			this.soHopDong = soHopDong;
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
	public NhanVien getNhanVienLapHopDong() {
		return nhanVienLapHopDong;
	}
	public void setNhanVienLapHopDong(NhanVien nhanVienLapHopDong) throws Exception {
		if (nhanVienLapHopDong == null)
			throw new Exception("Nhân viên lập hợp đồng không được rỗng");
		else
			this.nhanVienLapHopDong = nhanVienLapHopDong;
	}
	public LocalDate getNgayHopDong() {
		return ngayHopDong;
	}
	public void setNgayHopDong(LocalDate ngayHopDong) throws Exception {
		if (ngayHopDong == null)
			throw new Exception("Ngày lập hợp đồng không được rỗng");
		else
			this.ngayHopDong = ngayHopDong;
	}
	public enum_ThanhToan getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(enum_ThanhToan phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public LocalDate getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(LocalDate thoiGianBaoHanh) throws Exception {
		if (thoiGianBaoHanh == null)
			throw new Exception("Thời gian bảo hành không được rỗng");
		else
			this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public ArrayList<XeMay> getDanhSachXe() {
		return danhSachXe;
	}
	public void setDanhSachXe(ArrayList<XeMay> danhSachXe) {
		this.danhSachXe = danhSachXe;
	}
	
	
}
