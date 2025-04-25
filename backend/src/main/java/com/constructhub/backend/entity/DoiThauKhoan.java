package com.constructhub.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doi_thi_cong")
public class DoiThauKhoan {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="ma_doi_thi_cong")
    private Long id;

    @Column(name="ten_doi_thi_cong")
    private String tenDoiThau;

    @Column(name="ma_cong_trinh")
    private Long maCongTrinh;


    @Column(name="doi_truong")
    private String doiTruong;

    @Column(name="so_luong_thanh_vien")
    private int soLuongThanhVien;


    @Column(name="so_dien_thoai")
    private String soDienThoai;

    @Column(name="loai")
    private String loai;


    @Column(name = "nguoi_phu_trach")
    private Long nguoiPhuTrach;





}
