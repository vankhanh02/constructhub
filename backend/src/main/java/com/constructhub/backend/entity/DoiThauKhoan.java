package com.constructhub.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

    @Column(name="nguoi_phu_trach")
    private Long nguoiPhuTrach;

    @Column(name="dọi_truong")
    private String doiTruong;

    @Column(name="so_luong_thanh_vien")
    private int soLuongThanhVien;

    @Column(name="loai")
    private String loai;

}
