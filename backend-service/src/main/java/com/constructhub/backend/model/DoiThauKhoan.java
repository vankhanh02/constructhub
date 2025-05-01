package com.constructhub.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="doi_thau_khoan")
public class DoiThauKhoan extends BaseEntity {


    @Column(name="ten")
    private String ten;

    @Column(name="ma_cong_trinh")
    private Long maCongTrinh;


    @Column(name="doi_truong")
    private String doiTruong;

    @Column(name="so_luong_thanh_vien")
    private Integer soLuongThanhVien;


    @Column(name="so_dien_thoai")
    private String soDienThoai;

    @Column(name="loai")
    private String loai;


    @Column(name = "nguoi_phu_trach")
    private Long nguoiPhuTrach;


}
