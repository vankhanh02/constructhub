package com.constructhub.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="nhan_vien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_nhan_vien")
    private Long id;

    @Column(name="ho_ten")
    private String hoTen;

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
    private List<CongTrinh> congTrinhList;




}
