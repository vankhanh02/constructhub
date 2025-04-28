package com.constructhub.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="ma_task")
    private Long id;


    @Column (name="ma_cong_trinh")
    private Long maCongTrinh;

    @Column(name="ten")
    private String ten;

    @Column(name="nguoi_phan_cong")
    private Long nguoiPhanCong;

    @Column(name="nguoi_thuc_hien")
    private Long nguoiThucHien;

    @Column(name="ngay_bat_dau")
    private LocalDate ngayBatDau;

    @Column(name="ngay_hoan_thanh")
    private LocalDate ngayHoanThanh;

    @Column(name="thoi_han")
    private LocalDate thoiHan;

    @Column(name="trang_thai")
    private String trangThai;

    @Column(name="thoi_gian_tao", updatable=false)
    private LocalDateTime thoiGianTao;

    @Column(name="mo_ta")
    private String moTa;

    public Long getId() {
        return id;
    }

    public Long getMaCongTrinh() {
        return maCongTrinh;
    }

    public String getTen() {
        return ten;
    }

    public Long getNguoiPhanCong() {
        return nguoiPhanCong;
    }

    public Long getNguoiThucHien() {
        return nguoiThucHien;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDate getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public LocalDate getThoiHan() {
        return thoiHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public LocalDateTime getThoiGianTao() {
        return thoiGianTao;
    }

    public String getMoTa() {
        return moTa;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMaCongTrinh(Long maCongTrinh) {
        this.maCongTrinh = maCongTrinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNguoiPhanCong(Long nguoiPhanCong) {
        this.nguoiPhanCong = nguoiPhanCong;
    }

    public void setNguoiThucHien(Long nguoiThucHien) {
        this.nguoiThucHien = nguoiThucHien;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayHoanThanh(LocalDate ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public void setThoiHan(LocalDate thoiHan) {
        this.thoiHan = thoiHan;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setThoiGianTao(LocalDateTime thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    // Constructors
    public Task() {
    }

    public Task(Long id, Long maCongTrinh, String ten, Long nguoiPhanCong,
                Long nguoiThucHien, LocalDate ngayBatDau, LocalDate ngayHoanThanh,
                LocalDate thoiHan, String trangThai, LocalDateTime thoiGianTao, String moTa) {
        this.id = id;
        this.maCongTrinh = maCongTrinh;
        this.ten = ten;
        this.nguoiPhanCong = nguoiPhanCong;
        this.nguoiThucHien = nguoiThucHien;
        this.ngayBatDau = ngayBatDau;
        this.ngayHoanThanh = ngayHoanThanh;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
        this.thoiGianTao = thoiGianTao;
        this.moTa = moTa;
    }

}
