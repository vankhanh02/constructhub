package com.constructhub.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CongTrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_cong_trinh")
    private Long id;

    @Column(name="ten_cong_trinh")
    private String tenCongTrinh;

    @Column(name="ma_chu_dau_tu")
    private Long maChuDauTu;

    @Column(name="dia_diem")
    private String diaDiem;

    @Column(name="don_vi_thi_cong")
    private String donViThiCong;
    @Column(name="mo_ta")
    private String moTa;

    @Column(name="ngay_bat_dau")
    private LocalDate ngayBatDau;

    @Column(name="ngay_ket_thuc")
    private LocalDate ngayKetThuc;

    @Column(name="tinh_trang")
    private String tìnhTrang;

    @Column(name="do_uu_tien")
    private String doUuTien;

    @Column(name="loai_du_quyet_dinh")
    private String loạiDuQuyetDinh;

    @Column(name="loai_cong_trinh_ket_cau")
    private String loạiCongTrinhKetCau;

    @Column(name="loai_cong_trinh_cong_nang")
    private String loạiCongTrinhCongNang;

    @Column(name="loai_thiet_ke")
    private String loạiThietKe;

    @Column(name="cap_cong_trinh")
    private int capCongTrinh;





}
