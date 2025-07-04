-- Tạo database
CREATE DATABASE QuanLyBilliards;
GO

-- Sử dụng database vừa tạo
USE QuanLyBilliards;
GO

-- Bảng Khuyến Mãi
-- CREATE TABLE KhuyenMai
-- (
--     ID INT PRIMARY KEY IDENTITY(1,1),
--     TenKhuyenMai NVARCHAR(100),
--     GiamGia INT,
--     NgayBatDau DATE,
--     NgayKetThuc DATE,
--     TrangThai BIT
-- );
-- -- Thêm 10 dữ liệu vào bảng KhuyenMai
-- INSERT INTO KhuyenMai (TenKhuyenMai, GiamGia, NgayBatDau, NgayKetThuc, TrangThai) 
-- VALUES 
-- (N'Không Khuyến Mãi', 0, '1900-01-01', '2999-12-31', 1),
-- (N'Khuyến mãi 8/3', 15, '2024-03-01', '2024-03-08', 1),
-- (N'Khuyến mãi 30/4', 10, '2024-04-25', '2024-05-01', 1),
-- (N'Khuyến mãi Hè', 25, '2024-06-01', '2024-06-15', 1),
-- (N'Khuyến mãi 2/9', 18, '2024-08-25', '2024-09-02', 1),
-- (N'Khuyến mãi Giáng sinh', 30, '2024-12-20', '2024-12-25', 1),
-- (N'Khuyến mãi Black Friday', 50, '2024-11-23', '2024-11-29', 1),
-- (N'Khuyến mãi Trung thu', 12, '2024-09-20', '2024-09-30', 1),
-- (N'Khuyến mãi khai trương', 35, '2024-10-01', '2024-10-07', 1),
-- (N'Khuyến mãi mùa đông', 20, '2024-12-01', '2024-12-10', 1);

-- Bảng Bàn
CREATE TABLE Ban
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    TrangThai BIT,
    Gia DECIMAL(10,2)
);

-- Bảng Khách Hàng
CREATE TABLE KhachHang
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    TenKhachHang NVARCHAR(100),
    GioiTinh BIT,
    NgaySinh DATE,
    SoDienThoai NVARCHAR(15)
);


-- Bảng Nhân Viên
CREATE TABLE NhanVien
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    TenNhanVien NVARCHAR(100),
    TenDangNhap NVARCHAR(50) UNIQUE,
    MatKhau NVARCHAR(255),
    GioiTinh BIT,
    NgaySinh DATE,
    VaiTro BIT,
    SoDienThoai NVARCHAR(15),
);

-- Bảng Hóa Đơn
CREATE TABLE HoaDon
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    NguoiTao NVARCHAR(100),
    NgayTao DATE,
    TenKhachHang NVARCHAR(100),
    GioBatDau TIME,
    GioKetThuc TIME,
    TongGioChoi DECIMAL(20,2),
    TongTien DECIMAL(20,2),
    TrangThai BIT,
    IDBan INT,
    -- IDKhuyenMai INT,
    IDKhachHang INT,
    IDNhanVien INT,
    FOREIGN KEY (IDBan) REFERENCES Ban(ID),
    -- FOREIGN KEY (IDKhuyenMai) REFERENCES KhuyenMai(ID),
    FOREIGN KEY (IDKhachHang) REFERENCES KhachHang(ID),
    FOREIGN KEY (IDNhanVien) REFERENCES NhanVien(ID)
);

-- Bảng Loại Dịch Vụ
CREATE TABLE LoaiDichVu
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    TenLoaiDichVu NVARCHAR(100)
);

-- Bảng Dịch Vụ
CREATE TABLE DichVu
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    TenDichVu NVARCHAR(100) UNIQUE,
    Gia FLOAT,
    SoLuong INT,
    TrangThai BIT,
    IDLoaiDichVu INT,
    FOREIGN KEY (IDLoaiDichVu) REFERENCES LoaiDichVu(ID)
);

-- Bảng Hóa Đơn Chi Tiết
CREATE TABLE HoaDonChiTiet
(
    ID INT PRIMARY KEY IDENTITY(1,1),
    Ten NVARCHAR(100),
    Gia DECIMAL(20,2),
    SoLuong INT,
    ThanhTien DECIMAL(20,2),
    IDDichVu INT,
    IDHoaDon INT,
    FOREIGN KEY (IDDichVu) REFERENCES DichVu(ID),
    FOREIGN KEY (IDHoaDon) REFERENCES HoaDon(ID)
);

--Tạo Dữ Liệu vào bảng Ban
INSERT INTO Ban
    (TrangThai, Gia)
VALUES
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000),
    (1, 50000);


-- Thêm 50 dữ liệu vào bảng KhachHang
INSERT INTO KhachHang
    (TenKhachHang, GioiTinh, NgaySinh, SoDienThoai)
VALUES
    (N'Khách Lạ', 1, '1900-01-01', null),
    (N'Phạm Huy Hoàng', 1, '1991-02-01', '0902234567'),
    (N'Văn Thị Ngọc Hà', 0, '1992-03-01', '0903234567'),
    (N'Nguyễn Kim Dũng', 1, '1993-04-01', '0904234567'),
    (N'Lưu Chí Mạnh', 1, '1994-05-01', '0905234567'),
    (N'Ngô Thị Phượng', 0, '1995-06-01', '0906234567'),
    (N'Đỗ Văn Hùng', 1, '1996-07-01', '0907234567'),
    (N'Bùi Thị Lan', 0, '1997-08-01', '0908234567'),
    (N'Phạm Văn Kiên', 1, '1998-09-01', '0909234567'),
    (N'Vũ Thị Mai', 0, '1999-10-01', '0910234567'),
    (N'Nguyễn Văn Nam', 1, '2000-11-01', '0911234567'),
    (N'Trần Thị Nga', 0, '2001-12-01', '0912234567'),
    (N'Lê Văn Quang', 1, '1990-01-15', '0913234567'),
    (N'Phạm Thị Quyên', 0, '1991-02-15', '0914234567'),
    (N'Hoàng Văn Sơn', 1, '1992-03-15', '0915234567'),
    (N'Ngô Thị Thảo', 0, '1993-04-15', '0916234567'),
    (N'Đỗ Văn Tuấn', 1, '1994-05-15', '0917234567'),
    (N'Bùi Thị Vân', 0, '1995-06-15', '0918234567'),
    (N'Phạm Văn Việt', 1, '1996-07-15', '0919234567'),
    (N'Vũ Thị Yến', 0, '1997-08-15', '0920234567'),
    (N'Nguyễn Văn Hòa', 1, '1998-09-15', '0921234567'),
    (N'Trần Thị Hương', 0, '1999-10-15', '0922234567'),
    (N'Lê Văn Lợi', 1, '2000-11-15', '0923234567'),
    (N'Phạm Thị Lý', 0, '2001-12-15', '0924234567'),
    (N'Hoàng Văn Minh', 1, '1990-01-30', '0925234567'),
    (N'Ngô Thị Ngọc', 0, '1991-02-28', '0926234567'),
    (N'Đỗ Văn Phúc', 1, '1992-03-30', '0927234567'),
    (N'Bùi Thị Sang', 0, '1993-04-30', '0928234567'),
    (N'Phạm Văn Thanh', 1, '1994-05-30', '0929234567'),
    (N'Vũ Thị Thu', 0, '1995-06-30', '0930234567'),
    (N'Nguyễn Văn Tiến', 1, '1996-07-30', '0931234567'),
    (N'Trần Thị Trang', 0, '1997-08-30', '0932234567'),
    (N'Lê Văn Trường', 1, '1998-09-30', '0933234567'),
    (N'Phạm Thị Tuyết', 0, '1999-10-30', '0934234567'),
    (N'Hoàng Văn Việt', 1, '2000-11-30', '0935234567'),
    (N'Ngô Thị Xuân', 0, '2001-12-30', '0936234567'),
    (N'Đỗ Văn Vinh', 1, '1990-01-20', '0937234567'),
    (N'Bùi Thị Yến', 0, '1991-02-20', '0938234567'),
    (N'Phạm Văn Vũ', 1, '1992-03-20', '0939234567'),
    (N'Vũ Thị Ánh', 0, '1993-04-20', '0940234567'),
    (N'Nguyễn Văn Cảnh', 1, '1994-05-20', '0941234567'),
    (N'Trần Thị Đào', 0, '1995-06-20', '0942234567'),
    (N'Lê Văn Dũng', 1, '1996-07-20', '0943234567'),
    (N'Phạm Thị Giang', 0, '1997-08-20', '0944234567'),
    (N'Hoàng Văn Hậu', 1, '1998-09-20', '0945234567'),
    (N'Ngô Thị Lan', 0, '1999-10-20', '0946234567'),
    (N'Đỗ Văn Lộc', 1, '2000-11-20', '0947234567'),
    (N'Bùi Thị Phương', 0, '2001-12-20', '0948234567');

-- Thêm 3 dữ liệu vào bảng NhanVien
INSERT INTO NhanVien
    (TenNhanVien, TenDangNhap, MatKhau, GioiTinh, NgaySinh, VaiTro, SoDienThoai)
VALUES
    (N'Đào Gia Huy', N'admin', N'4297f44b13955235245b2497399d7a93', 1, '1985-01-01', 1, '0912618528'),
    (N'Nguyễn Kim Dũng', N'user1', N'4297f44b13955235245b2497399d7a93', 0, '1986-02-02', 0, '0901234562'),
    (N'Văn Thị Ngọc Hà', N'user2', N'4297f44b13955235245b2497399d7a93', 1, '1987-03-03', 0, '0901234563');


-- Thêm 4dữ liệu vào bảng LoaiDichVu
INSERT INTO LoaiDichVu
    (TenLoaiDichVu)
VALUES
    (N'Nước giải khát'),
    (N'Đồ ăn '),
    (N'Gậy Billiards'),
    (N'Dịch vụ khác');

-- Thêm 7 dữ liệu vào bảng DichVu
INSERT INTO DichVu
    (TenDichVu, Gia, SoLuong, TrangThai, IDLoaiDichVu)
VALUES
    (N'Coca-Cola', 10000, 50, 1, 1),
    (N'Pepsi', 10000, 50, 1, 1),
    (N'Bánh mì', 15000, 50, 1, 2),
    (N'Khoai tây chiên', 25000, 50, 1, 2),
    (N'Mỳ Tôm', 30000, 50, 1, 2),
    (N'Thuê gậy gỗ', 50000, 20, 1, 3),
    (N'Thuê gậy cacbon', 30000, 20, 1, 3);
GO

-- UPDATE Ban SET TrangThai = 1

-- UPDATE HoaDon SET TongGioChoi = DATEDIFF(MINUTE, GioBatDau, GioKetThuc) WHERE ID = 1

-- SELECT * FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.IDBan = 1 and A.TrangThai = 0;

-- UPDATE HoaDon SET TongTien = (SELECT 
--     ((B.TongGioChoi / 60) * C.Gia) + SUM(A.ThanhTien) AS TongTien
-- FROM 
--     HoaDonChiTiet A 
-- INNER JOIN 
--     HoaDon B ON A.IDHoaDon = B.ID 
-- INNER JOIN 
--     Ban C ON B.IDBan = C.ID
-- WHERE B.ID = 6
-- GROUP BY 
--       B.TongGioChoi, C.Gia)
-- WHERE ID = 6


-- SELECT 
--     ((B.TongGioChoi / 60) * C.Gia) + SUM(A.ThanhTien) AS TongTien
-- FROM 
--     HoaDonChiTiet A 
-- INNER JOIN 
--     HoaDon B ON A.IDHoaDon = B.ID 
-- INNER JOIN 
--     Ban C ON B.IDBan = C.ID
-- WHERE B.ID = 6
-- GROUP BY 
--       B.TongGioChoi, C.Gia


-- UPDATE HoaDon SET TenKhachHang = 'Văn Thị Ngọc Hà', TrangThai = 1, IDKhachHang = 2 WHERE ID = 1;

-- SELECT * FROM HoaDon WHERE ID = 1 


-- UPDATE Ban SET TrangThai = 1 WHERE ID = (SELECT IDBan FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.ID = 1)

-- SELECT * FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.IDBan = 10 and A.TrangThai = 1;

UPDATE HoaDon SET TongTien = (SELECT ((B.TongGioChoi/60) * C.Gia) AS [Tổng Tiền]
FROM HoaDonChiTiet A INNER JOIN HoaDon B ON A.IDHoaDon = B.ID INNER JOIN Ban C ON B.IDBan = C.ID
WHERE B.ID = 3
GROUP BY B.TongGioChoi, C.Gia) WHERE ID = 2;


-- SELECT * FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.IDBan = 2 and A.TrangThai = 0
-- SELECT * FROM HoaDon A INNER JOIN Ban B ON A.IDBan = B.ID WHERE A.ID = 2 and A.TrangThai = 0

-- UPDATE HoaDon SET IDBan = 2 WHERE IDBan = (SELECT IDBan FROM HoaDon WHERE IDBan = 1 AND TrangThai = 0) AND TrangThai = 0
-- UPDATE Ban SET TrangThai = 1 WHERE ID = 1
-- UPDATE BAN SET TrangThai = 0 WHERE ID = 2

UPDATE DichVu SET SoLuong = SoLuong - ? WHERE TenDichVu



SELECT A.ID
FROM HoaDonChiTiet A INNER JOIN HoaDon B ON A.IDHoaDon = B.ID
WHERE A.IDHoaDon = 1 AND Ten = 'Coca-Cola'

DELETE FROM HoaDonChiTiet WHERE ID = (SELECT A.ID
FROM HoaDonChiTiet A INNER JOIN HoaDon B ON A.IDHoaDon = B.ID
WHERE A.IDHoaDon = 1 AND Ten = 'Coca-Cola')


GO
CREATE PROCEDURE ThongKeDoanhThuVaHoaDon
    @NgayBatDau DATE,
    @NgayKetThuc DATE
AS
BEGIN
    SELECT
        NgayTao AS Ngay,
        COUNT(ID) AS SoLuongHoaDon,
        SUM(TongTien) AS DoanhThu
    FROM
        HoaDon
    WHERE 
        NgayTao BETWEEN @NgayBatDau AND @NgayKetThuc
    GROUP BY 
        NgayTao
    ORDER BY 
        NgayTao;
END;

EXEC ThongKeDoanhThuVaHoaDon @NgayBatDau = '2024-08-01', @NgayKetThuc = '2024-08-01';

GO
CREATE PROCEDURE ThongKeDoanhThuTheoBan
    @NgayBatDau DATE,
    @NgayKetThuc DATE
AS
BEGIN
    SELECT
        Ban.ID AS IDBan,
        CONVERT(DATE, HoaDon.NgayTao) AS Ngay,
        SUM(HoaDon.TongTien) AS TongDoanhThu
    FROM
        Ban
        LEFT JOIN
        HoaDon ON Ban.ID = HoaDon.IDBan
    WHERE
        HoaDon.NgayTao BETWEEN @NgayBatDau AND @NgayKetThuc
    GROUP BY 
        Ban.ID, CONVERT(DATE, HoaDon.NgayTao)
    ORDER BY 
        Ban.ID, Ngay;
END;

EXEC ThongKeDoanhThuTheoBan @NgayBatDau = '2024-08-01', @NgayKetThuc = '2024-12-31';
GO

GO
CREATE PROCEDURE ThongKeDichVu
    @NgayBatDau DATE,
    @NgayKetThuc DATE
AS
BEGIN
    SELECT A.TenDichVu,
        SUM(B.SoLuong) AS TongSoLuong,
        SUM(B.ThanhTien) AS TongTien,
        C.NgayTao
    FROM DichVu A
        INNER JOIN HoaDonChiTiet B ON A.ID = B.IDDichVu
        INNER JOIN HoaDon C ON B.IDHoaDon = C.ID
    WHERE 
        NgayTao BETWEEN @NgayBatDau AND @NgayKetThuc
    GROUP BY 
    A.TenDichVu, C.NgayTao
END;

EXEC ThongKeDichVu @NgayBatDau = '2024-07-01', @NgayKetThuc = '2024-08-01';


GO
-- Thực hiện thống kê số lượng khách hàng theo giới tính
CREATE PROCEDURE ThongKeKhachHang
AS
BEGIN

    SELECT
        CASE 
            WHEN GioiTinh = 1 THEN 'Nam'
            WHEN GioiTinh = 0 THEN N'Nữ'
            ELSE 'Khác'
        END AS GioiTinh,
        COUNT(*) AS SoLuong
    FROM
        KhachHang
    GROUP BY
        GioiTinh;
END;

EXEC ThongKeGioiTinhKhachHang
GO


SELECT * FROM  HoaDonChiTiet WHERE IDHoaDon = 1 AND IDDichVu= 1

UPDATE HoaDonChiTiet SET SoLuong = SoLuong + 2 WHERE IDDichVu = 1 AND IDHoaDon = 1
UPDATE HoaDonChiTiet SET ThanhTien = Gia*SoLuong WHERE IDDichVu = 1 AND IDHoaDon = 1