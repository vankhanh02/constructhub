package com.constructhub.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
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

    @Column(name="thoi_han")
    private LocalDate thoiHan;

    @Column(name="trang_thai")
    private String trangThai;

    @Column(name="thoi_gian_tao", updatable=false)
    private LocalDateTime thoiGianTao;

    @Column(name="mo_ta")
    private String moTa;

}
