package entity;

import java.time.LocalDate;

public class NhanVienKiThuat extends NhanVien {
	private int bacTho;
	private int soNamKN;

	public int getBacTho() {
		return bacTho;
	}

	public void setBacTho(int bacTho) {
		this.bacTho = bacTho;
	}

	public int getSoNamKN() {
		return soNamKN;
	}

	public void setSoNamKN(int soNamKN) {
		this.soNamKN = soNamKN;
	}

	public NhanVienKiThuat(String maNhanVien, CanCuocCongDan cccd, LocalDate ngayVaoLamViec, String soDienThoai,
			String email, String chucVu, double luong, int bacTho, int soNamKN) throws Exception {
		super(maNhanVien, cccd, ngayVaoLamViec, soDienThoai, email, chucVu, luong);
		setBacTho(bacTho);
		setSoNamKN(soNamKN);
	}

	public NhanVienKiThuat() {
		super();
	}

	public NhanVienKiThuat(String maNhanVien) throws Exception {
		super(maNhanVien);
	}

}
