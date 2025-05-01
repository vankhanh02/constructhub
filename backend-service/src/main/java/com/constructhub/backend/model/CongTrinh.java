package com.constructhub.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cong_trinh")
public class CongTrinh extends BaseEntity{
    @Column(name="ten")
    private String ten;

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
    private String tinhTrang;

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

    @ManyToMany(mappedBy = "congTrinhList")
    @ToString.Exclude
    private List<NhanVien> nhanVienList;



}
