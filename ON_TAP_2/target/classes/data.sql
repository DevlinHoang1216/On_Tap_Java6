-- Tạo bảng moi_quan_he
CREATE TABLE moi_quan_he (
                             id INT AUTO_INCREMENT PRIMARY KEY,   -- ID tự tăng
                             ma VARCHAR(50) NOT NULL,            -- Mã mối quan hệ
                             loai_quan_he NVARCHAR(50),          -- Loại quan hệ
                             ngay_bat_dau DATE                   -- Ngày bắt đầu quan hệ
);

-- Tạo bảng ban
CREATE TABLE ban (
                     id INT AUTO_INCREMENT PRIMARY KEY,   -- ID tự tăng
                     ma VARCHAR(50) NOT NULL,            -- Mã bạn
                     ho_ten NVARCHAR(100) NOT NULL,      -- Họ tên
                     email NVARCHAR(100),                -- Email
                     so_dien_thoai VARCHAR(20),          -- Số điện thoại
                     ngay_sinh DATE,                     -- Ngày sinh
                     dia_chi NVARCHAR(255),              -- Địa chỉ
                     ngay_tham_gia DATE,                 -- Ngày tham gia
                     moi_quan_he_id INT,                 -- ID mối quan hệ
                     gioi_tinh BOOLEAN,                  -- Giới tính (Nam: 1, Nữ: 0)
                     FOREIGN KEY (moi_quan_he_id) REFERENCES moi_quan_he(id)
);

-- Chèn dữ liệu vào bảng moi_quan_he
INSERT INTO moi_quan_he (ma, loai_quan_he, ngay_bat_dau)
VALUES
    ('QH001', 'Bạn bè', '2010-01-01'),
    ('QH002', 'Đồng nghiệp', '2015-03-12'),
    ('QH003', 'Họ hàng', '2012-07-22'),
    ('QH004', 'Bạn học', '2008-09-15'),
    ('QH005', 'Cộng sự', '2020-05-10'),
    ('QH006', 'Bạn bè', '2013-06-18'),
    ('QH007', 'Đồng nghiệp', '2016-11-09'),
    ('QH008', 'Bạn học', '2009-04-25'),
    ('QH009', 'Bạn bè', '2017-08-30'),
    ('QH010', 'Cộng sự', '2021-01-11');

-- Chèn dữ liệu vào bảng ban
INSERT INTO ban (ma, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, ngay_tham_gia, moi_quan_he_id, gioi_tinh)
VALUES
    ('B001', 'Nguyễn Văn A', 'nguyenvana@gmail.com', '0912345678', '1990-05-10', 'Hà Nội', '2020-03-12', 1, 1),
    ('B002', 'Trần Thị B', 'tranthib@gmail.com', '0912345679', '1988-02-25', 'Hồ Chí Minh', '2018-07-14', 2, 0),
    ('B003', 'Phạm Minh C', 'phamminhc@gmail.com', '0912345680', '1995-01-18', 'Đà Nẵng', '2021-09-25', 3, 1),
    ('B004', 'Lê Thị D', 'lethid@gmail.com', '0912345681', '1992-11-05', 'Hải Phòng', '2016-11-29', 4, 0),
    ('B005', 'Vũ Quang E', 'vuquange@gmail.com', '0912345682', '1994-07-22', 'Nha Trang', '2021-05-14', 5, 1),
    ('B006', 'Nguyễn Thị F', 'nguyenthif@gmail.com', '0912345683', '1991-03-13', 'Vũng Tàu', '2019-12-19', 6, 0),
    ('B007', 'Phan Minh G', 'phanming@gmail.com', '0912345684', '1993-06-01', 'Cần Thơ', '2017-08-08', 7, 1),
    ('B008', 'Lê Quang H', 'lequangh@gmail.com', '0912345685', '1990-10-23', 'Hà Nội', '2015-02-10', 8, 1),
    ('B009', 'Trần Thiên I', 'tranthieni@gmail.com', '0912345686', '1992-09-09', 'Huế', '2020-11-11', 9, 0),
    ('B010', 'Vũ Quỳnh J', 'vuquynhj@gmail.com', '0912345687', '1996-12-30', 'Sài Gòn', '2022-01-05', 10, 0);