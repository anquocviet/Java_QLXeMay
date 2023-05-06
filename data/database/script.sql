CREATE DATABASE QuanLyBanXeMay
GO
USE QuanLyBanXeMay

CREATE TABLE CuaHang
(
    MaCuaHang VARCHAR(10) NOT NULL PRIMARY KEY,
    TenCuaHang NVARCHAR(30),
    DiaChi NVARCHAR(60)
)

CREATE TABLE CanCuocCongDan
(
    MaCCCD VARCHAR(12) PRIMARY KEY NOT NULL,
    Ho NVARCHAR(30) NOT NULL,
    HoDem NVARCHAR(30),
    Ten NVARCHAR(30) NOT NULL,
    GioiTinh BIT,
    -- 0: Nữ, 1: Nam
    NgaySinh DATE,
    TamTru NVARCHAR(50),
    ThuongTru NVARCHAR(50)
)

CREATE TABLE KhachHang
(
    MaKH VARCHAR(10) PRIMARY KEY NOT NULL,
    MaCCCD VARCHAR(12) NOT NULL,
    SoDienThoai VARCHAR(10),
    CONSTRAINT FK_KH_CCCD FOREIGN KEY (MaCCCD) REFERENCES CanCuocCongDan(MaCCCD)
)

CREATE TABLE NhanVien
(
    MaNV VARCHAR(10) PRIMARY KEY NOT NULL,
    MaCCCD VARCHAR(12) NOT NULL,
    NgayVaoLamViec DATE,
    SoDienThoai VARCHAR(10),
    Email VARCHAR(30),
    ChucVu NVARCHAR(30),
    MucLuong MONEY,
    CONSTRAINT FK_NV_CCCD FOREIGN KEY (MaCCCD) REFERENCES CanCuocCongDan(MaCCCD)
)

CREATE TABLE NhanVienHanhChinh
(
    MaNV VARCHAR(10) PRIMARY KEY NOT NULL,
    TrinhDoHoc NVARCHAR(30),
    ThuocPhongBan NVARCHAR(30),
    CONSTRAINT FK_NVHC_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)

CREATE TABLE NhanVienKyThuat
(
    MaNV VARCHAR(10) PRIMARY KEY NOT NULL,
    BacTho INT,
    SoNamKN INT,
    CONSTRAINT FK_NVKT_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)

CREATE TABLE NhaCungCap
(
    MaNCC VARCHAR(10) PRIMARY KEY NOT NULL,
    TenNCC NVARCHAR(30),
    DiaChi NVARCHAR(60),
    SoDienThoai VARCHAR(10)
)

CREATE TABLE LoHang
(
    SoLo VARCHAR(10) PRIMARY KEY NOT NULL,
    MaNCC VARCHAR(10) NOT NULL,
    TenNuocNhap NVARCHAR(30),
    SoLuong INT,
    NgayNhapKho DATE,
    CONSTRAINT FK_LH_NCC FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
)

CREATE TABLE LoaiXe
(
    MaLoai VARCHAR(10) PRIMARY KEY NOT NULL,
    SoLo VARCHAR(10) NOT NULL,
    TenLoai NVARCHAR(30),
    TenHang NVARCHAR(30),
    SoPhanKhoi INT,
    DongTietKiem BIT,
    CONSTRAINT FK_LX_LH FOREIGN KEY (SoLo) REFERENCES LoHang(SoLo)
)

CREATE TABLE XeMay
(
    SoKhung VARCHAR(17) PRIMARY KEY NOT NULL,       --> Tối đa 17 ký tự: 0 - 9, ký tự từ A-Z (trừ I, O, Q)
    SoMay VARCHAR(17) NOT NULL,                     --> Tối đa 17 ký tự: 0 - 9, ký tự từ A-Z (trừ I, O, Q)
    MaLoai VARCHAR(10) NOT NULL,
    MaNCC VARCHAR(10) NOT NULL,
    TenXe NVARCHAR(30),
    NuocSX NVARCHAR(30),
    MauXe NVARCHAR(30),
    Gia MONEY,
    NamSX INT,
    AnhMinhHoa NVARCHAR(30),
    CONSTRAINT FK_XM_LX FOREIGN KEY (MaLoai) REFERENCES LoaiXe(MaLoai),
    CONSTRAINT FK_XM_NCC FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
)

CREATE TABLE HopDong
(
    SoHopDong VARCHAR(10) PRIMARY KEY NOT NULL,
    MaKH VARCHAR(10) NOT NULL,
    MaNV VARCHAR(10) NOT NULL,
    NgayLapHopDong DATE,
    ThoiGianBaoHanh DATE,
    PhuongThucThanhToan NVARCHAR(30),
    SoLanTraGop INT,
    TongTien MONEY,
    CONSTRAINT FK_HD_KH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    CONSTRAINT FK_HD_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)

CREATE TABLE CT_HopDong
(
    MaCT_HopDong INT IDENTITY NOT NULL,
    SoHopDong VARCHAR(10) NOT NULL,
    SoKhung VARCHAR(17) NOT NULL,
    ThanhTien MONEY,
    PRIMARY KEY (MaCT_HopDong, SoHopDong),
    CONSTRAINT FK_CTHD_HD FOREIGN KEY (SoHopDong) REFERENCES HopDong(SoHopDong),
    CONSTRAINT FK_CTHD_XM FOREIGN KEY (SoKhung) REFERENCES XeMay(SoKhung)
)

CREATE TABLE CT_TraGop
(
    MaTraGop VARCHAR(10) NOT NULL,
    SoHopDong VARCHAR(10) NOT NULL,
    SoTienTraGop MONEY,
    NgayTraGop DATE,
    MaNguoiTra VARCHAR(12) NOT NULL,
    MaNguoiNhan VARCHAR(10) NOT NULL,
    PRIMARY KEY (MaTraGop, SoHopDong),
    CONSTRAINT FK_CTTG_HD FOREIGN KEY (SoHopDong) REFERENCES HopDong(SoHopDong),
    CONSTRAINT FK_CTTG_KH FOREIGN KEY (MaNguoiNhan) REFERENCES NhanVien(MaNV),
    CONSTRAINT FK_CTTG_CCCD FOREIGN KEY (MaNguoiTra) REFERENCES CanCuocCongDan(MaCCCD)
)

CREATE TABLE LinhKien
(
    MaLinhKien VARCHAR(10) NOT NULL PRIMARY KEY,
    TenLinhKien NVARCHAR(30),
    Gia MONEY
)

CREATE TABLE PhieuNhanXetBaoHanh
(
    MaPhieu VARCHAR(10) NOT NULL PRIMARY KEY,
    NgayLap DATE,
    MaNV VARCHAR(10) NOT NULL,
    MaKH VARCHAR(10) NOT NULL,
    SoKhung VARCHAR(17) NOT NULL,
    TienCong MONEY,
    CONSTRAINT FK_PBH_NV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
    CONSTRAINT FK_PBH_KH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
)

CREATE TABLE CT_BaoHanh
(
    MaCT_BaoHanh INT IDENTITY NOT NULL ,
    MaPhieu VARCHAR(10) NOT NULL,
    MaLinhKien VARCHAR(10) NOT NULL,
    LyDo NVARCHAR(50),
    LoiThuocSanPham BIT,
    SoLuong INT,
    Gia MONEY,
    ThanhTien MONEY,
    PRIMARY KEY (MaCT_BaoHanh, MaPhieu),
    CONSTRAINT FK_CTBH_PBH FOREIGN KEY (MaPhieu) REFERENCES PhieuNhanXetBaoHanh(MaPhieu),
    CONSTRAINT FK_CTBH_LK FOREIGN KEY (MaLinhKien) REFERENCES LinhKien(MaLinhKien),
)

INSERT INTO [dbo].[CuaHang]
VALUES
    ('Store01', N'Công Nghiệp Motor', '12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, TpHCM')
GO

INSERT INTO [dbo].[CanCuocCongDan]
    ( MaCCCD, Ho, HoDem, Ten, GioiTinh, NgaySinh, TamTru, ThuongTru )
VALUES
    ( '087180000999', N'Trần', N'Ngọc', N'Linh', 0, '1980-06-12', N'45 Nguyễn Canh Chân, Q1, TpHCM', N'45 Nguyễn Canh Chân, Q1, TpHCM'),
    ( '031099758391', N'Trần', N'Minh', N'Long', 1, '1999-04-10', N'23/5 Nguyễn Trãi, Q5, TpHCM', N'23/5 Nguyễn Trãi, Q5, TpHCM'),
    ( '035200981263', N'Nguyễn', N'Văn', N'Tám', 1, '2000-11-09', N'873 Lê Hồng Phong, Phú Nhuận, TpHCM', N'873 Lê Hồng Phong, Phú Nhuận, TpHCM'),
    ( '083189938126', N'Lê', N'Hoài', N'Thương', 0, '1989-01-30', N'731 Trần Hưng Đạo, Bình Thạnh, TpHCM', N'731 Trần Hưng Đạo, Bình Thạnh, TpHCM'),
    ( '001091252513', N'Võ', N'Ngọc Phú', N'Pháp', 1, '1991-12-01', N'34 Trườnng Chinh, Q3, TpHCM', N'34 Trườnng Chinh, Q3, TpHCM'),
    ( '012102832782', N'Bùi', N'Thị Yến', N'Nhi', 0, '2002-06-18', N'14 Nguyễn Kiệm, Bình Tân, TpHCM', N'14 Nguyễn Kiệm, Bình Tân, TpHCM'),
    ( '071203948221', N'Bùi', N'Nam', N'Hải', 1, '2003-09-15', N'123 Hoàng Diệu, Tân Bình, TpHCM', N'123 Hoàng Diệu, Tân Bình, TpHCM'),
    ( '096195928378', N'Lê', N'Thu', N'Hằng', 0, '1995-12-29', N'60/5A Cách Mạng T8, Bình Thạnh, TpHCM', N'60/5A Cách Mạng T8, Bình Thạnh, TpHCM'),
    ( '093088675125', N'Nguyễn', NULL, N'Anh', 1, '1988-12-31', N'55B Bạch Đằng, Q9, TpHCM', N'55B Bạch Đằng, Q9, TpHCM'),
    ( '064090892739', N'Hoàng', N'Phú', N'Khang', 1, '1990-02-28', N'34/34B Nguyễn Trãi, Q1, TpHCM', N'34/34B Nguyễn Trãi, Q1, TpHCM'),
    ( '019197908232', N'Lê', N'Thị Hồng', N'Như', 0, '1997-01-13', N'45/2 An Dương Vương, Q5, TpHCM', N'45/2 An Dương Vương, Q5, TpHCM'),
    ( '017086152512', N'Lê', N'Anh', N'Khoa', 1, '1986-07-07', N'87 Hoàng Mai, Hà Nội', N'87 Hoàng Mai, Hà Nội'),
    ( '015077008912', N'Phan', N'Hoàng', N'Thành', 1, '1977-03-09', N'98 Võ Văn Việt, Thủ Đức, TpHCM', N'98 Võ Văn Việt, Thủ Đức, TpHCM'),
    ( '020196251520', N'Dương', NULL, N'Linh', 0, '1996-04-12', N'20 Quang Trung, Gò Vấp, TpHCM', N'20 Quang Trung, Gò Vấp, TpHCM'),
    ( '031173747512', N'Phan', N'Thị', N'Thư', 0, '1973-09-30', N'87 Tôn Đức Thắng, Q7, TpHCM', N'87 Tôn Đức Thắng, Q7, TpHCM'),
    ( '083190719279', N'Huỳnh', N'Trọng', N'Nghĩa', 1, '1990-07-02', N'34 Phạm Ngũ Lão, Gò Vấp, TpHCM', N'34 Phạm Ngũ Lão, Gò Vấp, TpHCM')
GO

INSERT INTO [dbo].[KhachHang]
    ( MaKH, SoDienThoai, MaCCCD )
VALUES
    ( 'KH01230322', '0242941923', '087180000999' ),
    ( 'KH02230322', '0368871212', '031099758391' ),
    ( 'KH01290522', '0337781201', '035200981263' ),
    ( 'KH01010622', '0896667122', '083189938126' ),
    ( 'KH01150622', '0897126812', '083190719279' ),
    ( 'KH01150223', '0333371287', '001091252513' )
GO

INSERT INTO [dbo].[NhanVien]
    ( MaNV, MaCCCD, NgayVaoLamViec, SoDienThoai, Email, ChucVu, MucLuong )
VALUES
    ( 'NV01120321', '012102832782', '2021-03-12', '0871817463', 'yennhi@gmail.com', N'Thực tập', 4000000 ),
    ( 'NV02120321', '071203948221', '2021-03-12', '0779812936', 'namhai@gmail.com', N'Trưởng phòng', 12000000 ),
    ( 'NV03120321', '096195928378', '2021-03-12', '0348971298', 'thuhang@gmail.com', N'Nhân viên', 6000000 ),
    ( 'NV01250321', '093088675125', '2021-03-25', '0997862386', 'anh992@gmail.com', N'Nhân viên', 7500000 ),
    ( 'NV01080821', '064090892739', '2021-08-08', '0657862166', 'phukhang981@gmail.com', N'Trưởng phòng', 15000000 ),
    ( 'NV01010322', '019197908232', '2022-03-01', '0329871928', 'hongnhu@hotmail.com', N'Trưởng phòng KT', 14000000 ),
    ( 'NV02010322', '017086152512', '2022-03-01', '0367788991', 'anhkhoa009@outlook.com', N'Phó phòng KT', 11000000 ),
    ( 'NV03010322', '015077008912', '2022-03-01', '0997127666', 'hoangthanh34@gmail.com', N'Thợ máy', 9500000 ),
    ( 'NV04010322', '020196251520', '2022-03-01', '0999967612', 'duonglinh96@yahoo.com', N'Thực tập', 6500000 ),
    ( 'NV01040123', '031173747512', '2023-01-04', '0878812776', 'phannnhu981@gmail.com', N'Quản lý', 20000000 )
GO

INSERT INTO [dbo].[NhanVienHanhChinh]
    (MaNV, TrinhDoHoc, ThuocPhongBan)
VALUES
    ( 'NV01120321', N'Đại học', N'Kế toán'),
    ( 'NV02120321', N'Đại học', N'Kế toán'),
    ( 'NV03120321', N'Đại học', N'Tài chính'),
    ( 'NV01250321', N'Đại học', N'Tài chính'),
    ( 'NV01080821', N'Thạc sĩ', N'Tài chính')
GO

INSERT INTO [dbo].[NhanVienKyThuat]
    (MaNV, BacTho, SoNamKN)
VALUES
    ( 'NV01010322', 3, 3),
    ( 'NV02010322', 2, 3),
    ( 'NV03010322', 2, 2),
    ( 'NV04010322', 1, 1),
    ( 'NV01040123', 4, 3)
GO

INSERT INTO [dbo].[NhaCungCap]
    ( MaNCC, TenNCC, DiaChi, SoDienThoai )
VALUES
    ( 'NCC001', N'CTy CP Xuất Nhập Khẩu An Giang', N'Số 1, Ngô Gia Tự, Tp. Long Xuyên,An Giang', '0989877612' ),
    ( 'NCC002', N'CTy TNHH SX Và TM Khang Thịnh', N'Tòa nhà An Huy, KCN Ngọc Hồi, Thanh Trì,Hà Nội', '0343363612' ),
    ( 'NCC003', N'CTy TNHH Tiến Thu', N'179 Phan Chu Trinh, P. Phước Ninh, Q. Hải Châu,Tp. Đà Nẵng', '0303888972' )
GO

INSERT INTO [dbo].[LoHang]
    ( SoLo, MaNCC, TenNuocNhap, SoLuong, NgayNhapKho )
VALUES
    ( 'LH01220122', 'NCC001', N'Thái Lan', 2, '2022-08-22' ),
    ( 'LH02220122', 'NCC002', N'Việt Nam', 4, '2022-08-22' ),
    ( 'LH01250322', 'NCC003', N'Trung Quốc', 2, '2022-12-25' )
GO

INSERT INTO [dbo].[LoaiXe]
    ( MaLoai, SoLo, TenLoai, TenHang, SoPhanKhoi, DongTietKiem )
VALUES
    ( 'LX001', 'LH01220122', N'Xe số', 'Yamaha', 110, 1),
    ( 'LX002', 'LH01220122', N'Tay ga', 'Honda', 125, 1),
    ( 'LX003', 'LH02220122', N'Côn tay', 'Honda', 150, 0 ),
    ( 'LX004', 'LH02220122', N'Mô tô', 'Honda', 500, 0 ),
    ( 'LX005', 'LH01250322', N'Xe điện', 'DatBike', 125, 1 )
INSERT INTO [dbo].[XeMay]
    ( SoKhung, SoMay, MaLoai, MaNCC, TenXe, NuocSX, MauXe, Gia, NamSX, AnhMinhHoa )
VALUES
    ( '56C4-782636', '678CZ-778812', 'LX001', 'NCC002', N'Sirius FI 115cc', N'Việt Nam', N'Đen Cam', 24000000, 2022, 'Sirius-FI-115.png' ),
    ( '55B3-97817297', '9712N-971279126T', 'LX001', 'NCC002', N'Jupiter FI 115cc', N'Việt Nam', N'Xám', 31000000, 2022, 'Jupiter-FI-115.png' ),
    ( '581B-0812Y7122', '82711-HG9172', 'LX002', 'NCC002', N'SH Mode 125cc', N'Việt Nam', N'Bạc Đen', 58000000, 2022, 'SH-Mode-125.png' ),
    ( '89CB-9871276', '6129L-9172997712', 'LX002', 'NCC001', N'AirBlade 125cc', N'Thái Lan', N'Đỏ Đen', 43000000, 2023, 'AirBlade-125.png' ),
    ( '082U-12H1268712', '987E-1927ER12', 'LX003', 'NCC002', N'Winner X', N'Việt Nam', N'Đỏ Đen Trắng', 50000000, 2022, 'Winner-X.png' ),
    ( '621G-12N12797H', '9712Y-98127BN23', 'LX003', 'NCC002', N'CBR150R', N'Việt Nam', N'Đen Xám', 74000000, 2022, 'CBR-150R.png' ),
    ( '812K-9712T712FA', '08912-7766BV727', 'LX004', 'NCC002', N'CBR500R', N'Trung Quốc', N'Đỏ Đen', 193000000, 2022, 'CBR500R.jpeg' ),
    ( '98DN-JL97122', '9182H-129NBH612', 'LX004', 'NCC002', N'Rebel 500', N'Việt Nam', N'Đen', 182000000, 2022, 'Rebel-500.jpeg' ),
    ( '987KM-861268R', '098HA-912621LE', 'LX004', 'NCC003', N'CB500X', N'Trung Quốc', N'Đen Đỏ', 195000000, 2022, 'CB500X.jpeg' ),
    ( 'Y716-W1297972232', '9797129-JH7219', 'LX005', 'NCC002', N'Weaver++', N'Việt Nam', N'Đen Cam', 66000000, 2022, 'Weaver++.png' )
GO

INSERT INTO [dbo].[HopDong]
    ( SoHopDong, MaKH, MaNV, NgayLapHopDong, ThoiGianBaoHanh,PhuongThucThanhToan, SoLanTraGop, TongTien )
VALUES
    -- Tong tien = Tong tien cac xe - Chiet khau (neu co) 
    -- Neu Mua va thanh toan 1 lan: - 2%
    -- Neu mua 3 chiec xe tro len va thanh toan 1 lan: - 5% 
    ( 'HD01230322', 'KH01230322', 'NV01120321', '2022-03-23', '2023-03-23', N'Trả hết', 1, 27048000 ),
    ( 'HD02230322', 'KH02230322', 'NV02120321', '2022-03-23', '2023-03-23', N'Trả góp', 2,  66700000),
    ( 'HD01290522', 'KH01290522', 'NV03120321', '2022-05-29', '2023-05-29', N'Trả hết', 1, 152950000 )
GO

INSERT INTO [dbo].[CT_HopDong]
    ( SoHopDong, SoKhung, ThanhTien )
VALUES
    -- Thanh tien = Gia xe + 10% VAT + 5% Lời
    ( 'HD01230322', '56C4-782636', 27600000 ),
    ( 'HD02230322', '581B-0812Y7122', 66700000 ),
    ( 'HD01290522', '55B3-97817297', 35650000),
    ( 'HD01290522', '89CB-9871276', 49450000),
    ( 'HD01290522', 'Y716-W1297972232', 75900000)
GO

INSERT INTO [dbo].[CT_TraGop]
    ( MaTraGop, SoHopDong, SoTienTraGop, NgayTraGop, MaNguoiTra, MaNguoiNhan )
VALUES
    ( 'TG01230322', 'HD01230322', 27048000, '2022-03-23', '087180000999', 'NV01120321' ),
    ( 'TG02230322', 'HD02230322', 20000000, '2022-03-23', '031099758391', 'NV02120321' ),
    ( 'TG01010422', 'HD02230322', 46700000, '2022-04-01', '031099758391', 'NV02120321' ),
    ( 'TG01290522', 'HD01290522', 152950000, '2022-05-29', '035200981263', 'NV03120321' )
GO

INSERT INTO [dbo].[LinhKien]
    ( MaLinhKien, TenLinhKien, Gia )
VALUES
    ( 'LK0001', 'Lọc gió và lọc dầu', 105000 ),
    ( 'LK0002', 'Nhông xích truyền động', 210000 ),
    ( 'LK0003', 'Bugi', 49000),
    ( 'LK0004', 'Má phanh thủy lực (Phanh Đĩa)', 146000 ),
    ( 'LK0005', 'Mút lọc gió', 60000 )
GO

INSERT INTO [dbo].[PhieuNhanXetBaoHanh]
    ( MaPhieu, NgayLap, MaNV, MaKH, SoKhung, TienCong )
VALUES
    ( 'P001260922', '2022-09-26', 'NV03010322', 'KH01230322', '56C4-782636', 800000 ),
    ( 'P002260922', '2022-09-26', 'NV02010322', 'KH01290522', '89CB-9871276', 300000 ),
    ( 'P001061122', '2022-11-06', 'NV04010322', 'KH01290522', 'Y716-W1297972232', 100000 )
GO

INSERT INTO [dbo].[CT_BaoHanh]
    ( MaPhieu, MaLinhKien, LyDo, LoiThuocSanPham, SoLuong, Gia, ThanhTien )
VALUES
    ( 'P001260922', 'LK0003', 'Hư Bugi', 0, 1, 54000, 54000 ),
    -- Gia = Gia Linh Kien + 10% 
    ( 'P001260922', 'LK0004', 'Mòn má phanh', 0, 2, 161000, 322000 ),
    ( 'P002260922', 'LK0005', 'Mút lọc gió lỏng ốc', 1, 1, NULL, NULL ),
    ( 'P001061122', 'LK0005', 'Mút lọc gió lỏng ốc', 1, 1, NULL, NULL ),
    ( 'P001061122', 'LK0002', 'Nhông xích dãn', 0, 1, 231000, 231000 )
GO

SELECT * FROM NhanVien JOIN NhanVienKyThuat ON NhanVien.MaNV = NhanVienKyThuat.MaNV
WHERE NhanVien.MaNV = 'NV01010322'
select * from PhieuNhanXetBaoHanh

-- Delete rows from table '[Phieu]' in schema '[dbo]'
DELETE FROM [dbo].[PhieuNhanXetBaoHanh]
WHERE MaPhieu = 'P001060523'
GO