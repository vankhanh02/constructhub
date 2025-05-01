package com.constructhub.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="nhan_vien")
public class NhanVien extends BaseEntity{
    @Column(name="ten")
    private String ten;

    @Column(name="so_dien_thoai")
    private String soDienThoai;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="email")
    private String email;

    @Column(name="chuc_vu")
    private String chucVu;

    @Column(name="trang_thai")
    private String trangThai;

    @Column(name="vai_tro")
    private String vaiTro;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "nhan_vien_cong_trinh",
            joinColumns = @JoinColumn(name = "ma_nhan_vien"),
            inverseJoinColumns = @JoinColumn(name = "ma_cong_trinh"))
    @ToString.Exclude()
    private List<CongTrinh> congTrinhList;

}
