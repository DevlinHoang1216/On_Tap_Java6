Use master
Go
CREATE DATABASE SOF306_DeMau_2;
GO
USE SOF306_DeMau_2;
GO
-- Tạo bảng moi_quan_he với id tự tăng
CREATE TABLE moi_quan_he (
    id INT IDENTITY(1,1) PRIMARY KEY,   -- ID khoá chính tự tăng
    ma VARCHAR(50) NOT NULL,             -- Mã mối quan hệ
    loai_quan_he NVARCHAR(50),           -- Loại quan hệ
    ngay_bat_dau DATE                    -- Ngày bắt đầu quan hệ
);

-- Tạo bảng ban với id tự tăng
CREATE TABLE ban (
    id INT IDENTITY(1,1) PRIMARY KEY,   -- ID khoá chính tự tăng
    ma VARCHAR(50) NOT NULL,             -- Mã bạn
    ho_ten NVARCHAR(100) NOT NULL,       -- Họ tên
    email NVARCHAR(100),                 -- Email
    so_dien_thoai VARCHAR(20),           -- Số điện thoại
    ngay_sinh DATE,                      -- Ngày sinh
    dia_chi NVARCHAR(255),               -- Địa chỉ
    ngay_tham_gia DATE,                  -- Ngày tham gia
    moi_quan_he_id INT,                  -- ID mối quan hệ (liên kết với bảng moi_quan_he)
    FOREIGN KEY (moi_quan_he_id) REFERENCES moi_quan_he(id)  -- Khoá ngoại liên kết với bảng moi_quan_he
);

-- Bật chế độ cho phép chèn dữ liệu vào cột IDENTITY của bảng moi_quan_he
SET IDENTITY_INSERT moi_quan_he ON;

-- Thêm dữ liệu vào bảng moi_quan_he (bao gồm cả giá trị cho cột id)
INSERT INTO moi_quan_he (id, ma, loai_quan_he, ngay_bat_dau)
VALUES
(1, 'QH001', 'Bạn bè', '2010-01-01'),
(2, 'QH002', 'Đồng nghiệp', '2015-03-12'),
(3, 'QH003', 'Họ hàng', '2012-07-22'),
(4, 'QH004', 'Bạn học', '2008-09-15'),
(5, 'QH005', 'Cộng sự', '2020-05-10'),
(6, 'QH006', 'Bạn bè', '2013-06-18'),
(7, 'QH007', 'Đồng nghiệp', '2016-11-09'),
(8, 'QH008', 'Bạn học', '2009-04-25'),
(9, 'QH009', 'Bạn bè', '2017-08-30'),
(10, 'QH010', 'Cộng sự', '2021-01-11');

-- Tắt chế độ cho phép chèn dữ liệu vào cột IDENTITY của bảng moi_quan_he
SET IDENTITY_INSERT moi_quan_he OFF;

-- Bật chế độ cho phép chèn dữ liệu vào cột IDENTITY của bảng ban
SET IDENTITY_INSERT ban ON;

-- Thêm dữ liệu vào bảng ban (bao gồm cả giá trị cho cột id)
INSERT INTO ban (id, ma, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, ngay_tham_gia, moi_quan_he_id)
VALUES
(1, 'B001', 'Nguyễn Văn A', 'nguyenvana@gmail.com', '0912345678', '1990-05-10', 'Hà Nội', '2020-03-12', 1),
(2, 'B002', 'Trần Thị B', 'tranthib@gmail.com', '0912345679', '1988-02-25', 'Hồ Chí Minh', '2018-07-14', 2),
(3, 'B003', 'Phạm Minh C', 'phamminhc@gmail.com', '0912345680', '1995-01-18', 'Đà Nẵng', '2021-09-25', 3),
(4, 'B004', 'Lê Thị D', 'lethid@gmail.com', '0912345681', '1992-11-05', 'Hải Phòng', '2016-11-29', 4),
(5, 'B005', 'Vũ Quang E', 'vuquange@gmail.com', '0912345682', '1994-07-22', 'Nha Trang', '2021-05-14', 5),
(6, 'B006', 'Nguyễn Thị F', 'nguyenthif@gmail.com', '0912345683', '1991-03-13', 'Vũng Tàu', '2019-12-19', 6),
(7, 'B007', 'Phan Minh G', 'phanming@gmail.com', '0912345684', '1993-06-01', 'Cần Thơ', '2017-08-08', 7),
(8, 'B008', 'Lê Quang H', 'lequangh@gmail.com', '0912345685', '1990-10-23', 'Hà Nội', '2015-02-10', 8),
(9, 'B009', 'Trần Thiên I', 'tranthieni@gmail.com', '0912345686', '1992-09-09', 'Huế', '2020-11-11', 9),
(10, 'B010', 'Vũ Quỳnh J', 'vuquynhj@gmail.com', '0912345687', '1996-12-30', 'Sài Gòn', '2022-01-05', 10);

-- Tắt chế độ cho phép chèn dữ liệu vào cột IDENTITY của bảng ban
SET IDENTITY_INSERT ban OFF;
