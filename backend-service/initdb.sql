CREATE TABLE IF NOT EXISTS chu_dau_tu (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    so_dien_thoai VARCHAR(255)[]
);

CREATE TABLE IF NOT EXISTS cong_trinh (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    ma_chu_dau_tu BIGINT REFERENCES chu_dau_tu(id) ON DELETE SET NULL,
    dia_diem VARCHAR(255),
    don_vi_thi_cong VARCHAR(255),
    mo_ta TEXT,
    ngay_bat_dau DATE,
    ngay_ket_thuc DATE,
    tinh_trang VARCHAR(255),
    do_uu_tien VARCHAR(255),
    loai_du_quyet_dinh VARCHAR(255),
    loai_cong_trinh_ket_cau VARCHAR(255),
    loai_cong_trinh_cong_nang VARCHAR(255),
    loai_thiet_ke VARCHAR(255),
    cap_cong_trinh INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS nhan_vien (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    so_dien_thoai VARCHAR(255),
    dia_chi VARCHAR(255),
    email VARCHAR(255),
    chuc_vu VARCHAR(255),
    trang_thai VARCHAR(255),
    vai_tro VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS doi_thau_khoan (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE SET NULL,
    doi_truong VARCHAR(255),
    so_luong_thanh_vien INTEGER,
    so_dien_thoai VARCHAR(255),
    loai VARCHAR(255),
    nguoi_phu_trach BIGINT REFERENCES nhan_vien(id) ON DELETE SET NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS may_moc (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    loai VARCHAR(255),
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE SET NULL,
    trangThai VARCHAR(255),
    gia DECIMAL,
    dia_diem_hien_tai VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS nhan_vien_cong_trinh (
    ma_nhan_vien BIGINT NOT NULL,
    ma_cong_trinh BIGINT NOT NULL,
    PRIMARY KEY (ma_nhan_vien, ma_cong_trinh),
    FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(id),
    FOREIGN KEY (ma_cong_trinh) REFERENCES cong_trinh(id)
);

CREATE TABLE IF NOT EXISTS task (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE CASCADE,
    nguoi_phan_cong BIGINT REFERENCES nhan_vien(id) ON DELETE SET NULL,
    nguoi_thuc_hien BIGINT REFERENCES nhan_vien(id) ON DELETE SET NULL,
    ngay_bat_dau DATE,
    ngay_hoan_thanh DATE,
    thoi_han DATE,
    trang_thai VARCHAR(255),
    mo_ta TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS vat_tu (
    id SERIAL PRIMARY KEY,
    ten VARCHAR(255),
    don_vi VARCHAR(255),
    ma_chuan VARCHAR(255),
    nguon_mua VARCHAR(255),
    phi_van_chuyen DECIMAL,
    so_luong INTEGER,
    so_luong_muc_thap INTEGER,
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE SET NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS thanh_vien_doi_thi_cong (
    id SERIAL PRIMARY KEY,
    ma_doi_thi_cong BIGINT REFERENCES doi_thau_khoan(id) ON DELETE CASCADE,
    ho_ten VARCHAR(255),
    so_dien_thoai VARCHAR(20),
    so_ngay_cong REAL DEFAULT 0,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS nhat_ky_su_dung_may_moc (
    id SERIAL PRIMARY KEY,
    ma_may_moc BIGINT REFERENCES may_moc(id) ON DELETE CASCADE,
    ma_doi_thi_cong BIGINT REFERENCES doi_thau_khoan(id) ON DELETE CASCADE,
    ngay_bat_dau TIMESTAMP,
    ngay_ket_thuc TIMESTAMP,
    tong_so_gio_su_dung INTEGER,
    ghi_chu TEXT,
    nhan_vien_phu_trach BIGINT REFERENCES nhan_vien(id) ON DELETE SET NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tai_lieu (
    id SERIAL PRIMARY KEY,
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE CASCADE,
    loai_tai_lieu VARCHAR(255),
    file_path VARCHAR(255),
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS thu (
    id SERIAL PRIMARY KEY,
    nguon_thu VARCHAR(255),
    so_tien DECIMAL(18, 2),
    ngay_thu DATE,
    hinh_thuc_thanh_toan VARCHAR(255),
    trang_thai VARCHAR(50),
    don_vi_thanh_toan VARCHAR(255),
    tai_khoan_nhan VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chi (
    id SERIAL PRIMARY KEY,
    loai_chi_phi VARCHAR(255),
    so_tien DECIMAL(18, 2),
    ngay_chi DATE,
    hinh_thuc_thanh_toan VARCHAR(255),
    don_vi_nhan VARCHAR(255),
    tai_khoan_chi VARCHAR(255),
    trang_thai VARCHAR(50),
    ghi_chu TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chi_cong_trinh (
    id SERIAL PRIMARY KEY,
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE CASCADE,
    ma_chi BIGINT REFERENCES chi(id) ON DELETE CASCADE,
    so_tien_phan_bo DECIMAL(18, 2),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cong_no (
    id SERIAL PRIMARY KEY,
    loai_cong_no VARCHAR(255),
    so_tien_no DECIMAL(18, 2),
    ngay_phat_sinh DATE,
    han_thanh_toan DATE,
    trang_thai VARCHAR(50),
    doi_tuong VARCHAR(255),
    hinh_thuc_thanh_toan VARCHAR(255),
    lai_suat DECIMAL(5, 2),
    ghi_chu TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS hop_dong (
    id SERIAL PRIMARY KEY,
    ngay_ky DATE NOT NULL,
    gia_tri DECIMAL(18, 2),
    thoi_han DATE,
    ma_cong_trinh BIGINT REFERENCES cong_trinh(id) ON DELETE SET NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Sample data for chu_dau_tu (Investors)
INSERT INTO chu_dau_tu (ten, email, so_dien_thoai) VALUES
('Công ty CP Vingroup', 'contact@vingroup.com', ARRAY['0912345678', '0923456789']),
('Tập đoàn Sungroup', 'info@sungroup.com.vn', ARRAY['0934567890']),
('Tập đoàn BRG', 'contact@brg.com.vn', ARRAY['0945678901', '0956789012']),
('Công ty CP Hòa Bình', 'info@hoabinh.com.vn', ARRAY['0967890123']),
('Tập đoàn Bitexco', 'contact@bitexco.com.vn', ARRAY['0978901234', '0989012345']);

-- Sample data for nhan_vien (Employees)
INSERT INTO nhan_vien (ten, so_dien_thoai, dia_chi, email, chuc_vu, trang_thai, created_at, updated_at) VALUES
('Nguyễn Văn An', '0912345678', 'Hà Nội', 'an.nguyen@gmail.com', 'Kỹ sư xây dựng', 'hoạt động', NOW(), NOW()),
('Trần Thị Bình', '0923456789', 'Hồ Chí Minh', 'binh.tran@gmail.com', 'Kiến trúc sư', 'hoạt động',  NOW(), NOW()),
('Phạm Văn Cường', '0934567890', 'Đà Nẵng', 'cuong.pham@gmail.com', 'Giám sát', 'hoạt động',  NOW(), NOW()),
('Lê Thị Dung', '0945678901', 'Hải Phòng', 'dung.le@gmail.com', 'Quản lý dự án', 'hoạt động',  NOW(), NOW()),
('Hoàng Văn Eo', '0956789012', 'Cần Thơ', 'eo.hoang@gmail.com', 'Kỹ thuật viên', 'hoạt động',  NOW(), NOW()),
('Ngô Thị Phương', '0967890123', 'Huế', 'phuong.ngo@gmail.com', 'Kế toán', 'hoạt động', NOW(), NOW()),
('Vũ Văn Giang', '0978901234', 'Quảng Ninh', 'giang.vu@gmail.com', 'Thợ xây', 'hoạt động',  NOW(), NOW()),
('Mai Thị Hoa', '0989012345', 'Nghệ An', 'hoa.mai@gmail.com', 'Thư ký', 'hoạt động',  NOW(), NOW());

-- Sample data for cong_trinh (Construction Projects)
INSERT INTO cong_trinh (ten, ma_chu_dau_tu, dia_diem, don_vi_thi_cong, mo_ta, ngay_bat_dau, ngay_ket_thuc, tinh_trang, created_at, updated_at) VALUES
('Trung tâm thương mại Vincom Center', 1, 'Hà Nội', 'Công ty XD ABC', 'Xây dựng TTTM hiện đại tại trung tâm thành phố', '2023-01-15', '2024-06-30', 'thi công', NOW(), NOW()),
('Khu nghỉ dưỡng Sun Paradise', 2, 'Phú Quốc', 'Tập đoàn XD DEF', 'Khu nghỉ dưỡng cao cấp ven biển', '2023-03-10', '2024-12-20', 'thi công', NOW(), NOW()),
('Tòa nhà văn phòng BRG Tower', 3, 'Hồ Chí Minh', 'Công ty XD GHI', 'Tòa nhà văn phòng hạng A tại trung tâm Q1', '2022-11-05', '2024-04-15', 'thi công', NOW(), NOW()),
('Khu đô thị Hòa Bình Green', 4, 'Đà Nẵng', 'Công ty XD JKL', 'Khu đô thị xanh với nhiều tiện ích', '2023-05-20', '2025-02-28', 'thi công', NOW(), NOW()),
('Bitexco Financial Tower 2', 5, 'Hồ Chí Minh', 'Công ty XD MNO', 'Tòa tháp tài chính cao nhất khu vực', '2022-08-12', '2024-08-30', 'thi công', NOW(), NOW()),
('Khu biệt thự Vinpearl', 1, 'Nha Trang', 'Công ty XD PQR', 'Khu biệt thự nghỉ dưỡng cao cấp', '2023-01-15', '2024-02-28', 'hoàn thành', NOW(), NOW()),
('Sân bay Sungroup', 2, 'Vân Đồn', 'Công ty XD STU', 'Dự án nâng cấp sân bay khu vực', '2022-06-10', '2023-12-30', 'hoàn thành', NOW(), NOW()),
('Khu công nghiệp BRG Eco', 3, 'Bắc Ninh', 'Công ty XD VWX', 'Khu công nghiệp thân thiện môi trường', '2023-07-22', '2025-07-22', 'thi công', NOW(), NOW()),
('Bệnh viện Hòa Bình International', 4, 'Hà Nội', 'Công ty XD YZ', 'Bệnh viện quốc tế đạt chuẩn 5 sao', '2023-02-15', '2024-08-30', 'thi công', NOW(), NOW()),
('Bitexco Mall', 5, 'Cần Thơ', 'Công ty XD AAA', 'Trung tâm thương mại lớn nhất ĐBSCL', '2023-04-10', '2024-10-15', 'thi công', NOW(), NOW());

-- Connect employees to construction projects (nhan_vien_cong_trinh)
INSERT INTO nhan_vien_cong_trinh (ma_nhan_vien, ma_cong_trinh) VALUES
(1, 1), (1, 3), (1, 5),
(2, 1), (2, 2),
(3, 2), (3, 4), (3, 6),
(4, 3), (4, 7), (4, 9),
(5, 4), (5, 8),
(6, 5), (6, 10),
(7, 6), (7, 8), (7, 10),
(8, 7), (8, 9);
-- Sample data for doi_thau_khoan (Contractor Teams)
INSERT INTO doi_thau_khoan (ten, ma_cong_trinh, doi_truong, so_luong_thanh_vien, so_dien_thoai, loai, nguoi_phu_trach, created_at, updated_at) VALUES
('Đội Xây dựng Phố Đông', 1, 'Trần Văn Minh', 12, '0912345678', 'Xây dựng', 1, NOW(), NOW()),
('Đội Điện Alpha', 1, 'Nguyễn Thành Long', 8, '0923456789', 'Điện', 3, NOW(), NOW()),
('Đội Móng Beta', 2, 'Phạm Minh Tuấn', 15, '0934567890', 'Móng', 2, NOW(), NOW()),
('Đội Hoàn thiện Omega', 3, 'Lê Văn Hùng', 20, '0945678901', 'Hoàn thiện', 4, NOW(), NOW()),
('Đội Sơn Delta', 4, 'Hoàng Văn Tuấn', 6, '0956789012', 'Sơn', 5, NOW(), NOW()),
('Đội Lát gạch Gamma', 5, 'Vũ Thị Hương', 10, '0967890123', 'Lát gạch', 1, NOW(), NOW());

-- Sample data for may_moc (Machinery)
INSERT INTO may_moc (ten, loai, ma_cong_trinh, trang_thai, gia, dia_diem_hien_tai, created_at, updated_at) VALUES
('Máy xúc Komatsu PC200', 'Máy xúc', 1, 'hoạt động', 1200000000, 'Công trường Hà Nội', NOW(), NOW()),
('Cần cẩu XCMG QY25K', 'Cần cẩu', 1, 'hoạt động', 2500000000, 'Công trường Hà Nội', NOW(), NOW()),
('Máy ủi Caterpillar D6', 'Máy ủi', 2, 'hoạt động', 1800000000, 'Công trường Phú Quốc', NOW(), NOW()),
('Máy trộn bê tông Liebherr', 'Máy trộn', 3, 'hư hỏng', 800000000, 'Kho thiết bị', NOW(), NOW()),
('Máy đào Hitachi ZX210', 'Máy đào', 4, 'hoạt động', 1500000000, 'Công trường Đà Nẵng', NOW(), NOW()),
('Máy lu BOMAG BW213', 'Máy lu', 5, 'hoạt động', 950000000, 'Công trường HCM', NOW(), NOW()),
('Máy phát điện Cummins 500KVA', 'Máy phát điện', 6, 'hư hỏng', 750000000, 'Kho thiết bị', NOW(), NOW()),
('Máy bơm bê tông Putzmeister', 'Máy bơm', 7, 'hư hỏng', 1250000000, 'Công trường Vân Đồn', NOW(), NOW());

-- Sample data for task (Tasks)
INSERT INTO task (ten, ma_cong_trinh, nguoi_phan_cong, nguoi_thuc_hien, ngay_bat_dau, ngay_hoan_thanh, thoi_han, trang_thai, mo_ta, created_at, updated_at) VALUES
('Đào móng khu A', 1, 3, 1, '2023-01-20', '2023-02-10', '2023-02-15', 'hoàn thành', 'Đào móng cho khu vực A của dự án', NOW(), NOW()),
('Lắp đặt hệ thống điện tầng 1', 1, 3, 2, '2023-02-15', NULL, '2023-03-15', 'đang tiến hành', 'Lắp đặt hệ thống điện cho tầng 1', NOW(), NOW()),
('Thiết kế mặt bằng khu nghỉ dưỡng', 2, 4, 2, '2023-03-15', '2023-04-10', '2023-04-15', 'hoàn thành', 'Thiết kế chi tiết mặt bằng khu nghỉ dưỡng', NOW(), NOW()),
('Xây tường ngăn tầng 3-10', 3, 3, 5, '2023-01-10', NULL, '2023-05-30', 'kiểm tra', 'Xây tường ngăn các phòng từ tầng 3-10', NOW(), NOW()),
('Lắp đặt hệ thống PCCC', 4, 4, 3, '2023-06-01', NULL, '2023-07-15', 'chưa bắt đầu', 'Lắp đặt hệ thống PCCC toàn bộ tòa nhà', NOW(), NOW()),
('Hoàn thiện mặt ngoài tòa nhà', 5, 3, 1, '2023-03-01', '2023-06-15', '2023-06-30', 'hoàn thành', 'Hoàn thiện mặt ngoài theo thiết kế', NOW(), NOW());

-- Sample data for vat_tu (Materials)
INSERT INTO vat_tu (ten, don_vi, ma_chuan, nguon_mua, phi_van_chuyen, so_luong, so_luong_muc_thap, ma_cong_trinh, created_at, updated_at) VALUES
('Xi măng Holcim', 'Bao', 'XM001', 'Công ty TNHH Vật liệu XD Tín Phát', 5000000, 2000, 200, 1, NOW(), NOW()),
('Cát xây dựng', 'Khối', 'CT002', 'Công ty CP Khai thác Đá Tân Long', 8000000, 500, 50, 1, NOW(), NOW()),
('Thép Hòa Phát Φ10', 'Tấn', 'TP003', 'Đại lý Thép Hòa Phát Miền Bắc', 2000000, 100, 20, 2, NOW(), NOW()),
('Gạch ốp lát Viglacera', 'Thùng', 'GO004', 'Đại lý Viglacera Thăng Long', 1500000, 300, 30, 3, NOW(), NOW()),
('Sơn ngoại thất Dulux', 'Thùng', 'SN005', 'Công ty CP Sơn Dulux Việt Nam', 500000, 150, 15, 4, NOW(), NOW()),
('Ống nước Tiền Phong', 'Cây', 'ON006', 'Công ty Nhựa Tiền Phong', 800000, 500, 50, 5, NOW(), NOW()),
('Dây điện Cadivi', 'Cuộn', 'DD007', 'Đại lý Cadivi Miền Nam', 600000, 200, 20, 6, NOW(), NOW()),
('Kính cường lực 10mm', 'Tấm', 'KC008', 'Công ty TNHH Kính Việt Nhật', 3000000, 100, 10, 7, NOW(), NOW());

-- Sample data for thanh_vien_doi_thi_cong (Team Members)
INSERT INTO thanh_vien_doi_thi_cong (ma_doi_thi_cong, ho_ten, so_dien_thoai, so_ngay_cong, created_at, updated_at) VALUES
(1, 'Nguyễn Văn Hùng', '0912345111', 22.5, NOW(), NOW()),
(1, 'Trần Văn Tú', '0912345222', 21, NOW(), NOW()),
(1, 'Lê Minh Hoàng', '0912345333', 23, NOW(), NOW()),
(2, 'Phạm Thị Mai', '0912345444', 20.5, NOW(), NOW()),
(2, 'Hoàng Văn Thắng', '0912345555', 22, NOW(), NOW()),
(3, 'Ngô Văn Dũng', '0912345666', 21.5, NOW(), NOW()),
(3, 'Vũ Thị Hà', '0912345777', 19, NOW(), NOW()),
(4, 'Đặng Văn Tùng', '0912345888', 23.5, NOW(), NOW()),
(4, 'Bùi Thị Lan', '0912345999', 20, NOW(), NOW()),
(5, 'Trịnh Văn Hòa', '0912345000', 21, NOW(), NOW());

