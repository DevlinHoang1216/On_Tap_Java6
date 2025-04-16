Use master
Go
CREATE DATABASE SOF306_DeMau_1;
GO
USE SOF306_DeMau_1;
GO

-- Bảng chức vụ
CREATE TABLE chuc_vu (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ma_chuc_vu NVARCHAR(20)  ,
    ten_chuc_vu NVARCHAR(100)  ,
    mo_ta NVARCHAR(255),
    he_so_luong FLOAT  
);

-- Bảng nhân viên (liên kết 1-N với chức vụ)
CREATE TABLE nhan_vien (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ma_nhan_vien NVARCHAR(20)  ,
    ho_ten NVARCHAR(255)  ,
    ngay_sinh DATE,
    gioi_tinh BIT,
    email NVARCHAR(255),
    so_dien_thoai VARCHAR(15),
    luong DECIMAL(18,2),
    dia_chi NVARCHAR(255),
    id_chuc_vu INT,
    FOREIGN KEY (id_chuc_vu) REFERENCES chuc_vu(id) ON DELETE CASCADE
);

SET IDENTITY_INSERT chuc_vu ON;
INSERT INTO chuc_vu (id, ma_chuc_vu, ten_chuc_vu, mo_ta, he_so_luong)
VALUES 
    (1, 'CV001', 'Giám Đốc', 'Quản lý toàn bộ công ty', 5.0),
    (2, 'CV002', 'Phó Giám Đốc', 'Hỗ trợ giám đốc', 4.5),
    (3, 'CV003', 'Trưởng Phòng', 'Quản lý một phòng ban', 4.0),
    (4, 'CV004', 'Phó Phòng', 'Hỗ trợ trưởng phòng', 3.5),
    (5, 'CV005', 'Nhân Viên Kinh Doanh', 'Bán hàng', 3.0),
    (6, 'CV006', 'Nhân Viên Kỹ Thuật', 'Sửa chữa và bảo trì', 3.0),
    (7, 'CV007', 'Nhân Viên Hành Chính', 'Hỗ trợ giấy tờ', 2.8),
    (8, 'CV008', 'Nhân Viên Marketing', 'Quảng bá thương hiệu', 3.2),
    (9, 'CV009', 'Nhân Viên Pháp Chế', 'Tư vấn luật', 3.6),
    (10, 'CV010', 'Nhân Viên CSKH', 'Chăm sóc khách hàng', 3.0);
SET IDENTITY_INSERT chuc_vu OFF;
SET IDENTITY_INSERT nhan_vien ON;
INSERT INTO nhan_vien (id, ma_nhan_vien, ho_ten, ngay_sinh, gioi_tinh, email, so_dien_thoai, luong, dia_chi, id_chuc_vu)
VALUES 
    (1, 'NV001', 'Nguyễn Văn A', '1990-05-10', 1, 'a@gmail.com', '0912345678', 50000000, 'Hà Nội', 1),
    (2, 'NV002', 'Trần Thị B', '1992-07-20', 0, 'b@gmail.com', '0912345679', 45000000, 'TP HCM', 2),
    (3, 'NV003', 'Lê Văn C', '1988-03-15', 1, 'c@gmail.com', '0912345680', 40000000, 'Đà Nẵng', 3),
    (4, 'NV004', 'Phạm Thị D', '1995-09-25', 0, 'd@gmail.com', '0912345681', 35000000, 'Hải Phòng', 4),
    (5, 'NV005', 'Hoàng Văn E', '1993-11-30', 1, 'e@gmail.com', '0912345682', 30000000, 'Cần Thơ', 5),
    (6, 'NV006', 'Bùi Thị F', '1991-06-18', 0, 'f@gmail.com', '0912345683', 32000000, 'Quảng Ninh', 6),
    (7, 'NV007', 'Đặng Văn G', '1994-08-22', 1, 'g@gmail.com', '0912345684', 28000000, 'Thanh Hóa', 7),
    (8, 'NV008', 'Vũ Thị H', '1989-04-05', 0, 'h@gmail.com', '0912345685', 31000000, 'Nghệ An', 8),
    (9, 'NV009', 'Phan Văn I', '1996-02-28', 1, 'i@gmail.com', '0912345686', 27000000, 'Bắc Giang', 9),
    (10, 'NV010', 'Ngô Thị J', '1997-12-12', 0, 'j@gmail.com', '0912345687', 29000000, 'Bình Dương', 10);
SET IDENTITY_INSERT nhan_vien OFF;


select nv.id,nv.ma_nhan_vien,nv.ho_ten,nv.gioi_tinh,nv.ngay_sinh, cv.ma_chuc_vu,cv.ten_chuc_vu 
from nhan_vien nv join chuc_vu cv on nv.id_chuc_vu = cv.id