package com.constructhub.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="task")
public class Task extends BaseEntity{

    @Column(name="ten")
    private String ten;

    @Column (name="ma_cong_trinh")
    private Long maCongTrinh;


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


    @Column(name="mo_ta")
    private String moTa;

}
