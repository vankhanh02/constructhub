package com.constructhub.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vat_tu")
public class VatTu {
    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="ma_vat_tu")
    private Long id;

    @Column(name="ten")
    private String ten;

    @Column(name="ma_chuan")
    private String maChuan;

    @Column(name="don_vi")
    private String donVi;

    @Column(name="so_luong")
    private int soLuong;

    @Column(name="so_luong_muc_thap")
    private String soLuongMucThap;


    @Column(name="nguon_mua")
    private String nguonMua;



}
