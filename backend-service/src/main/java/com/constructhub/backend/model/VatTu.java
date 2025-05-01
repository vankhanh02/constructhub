package com.constructhub.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "vat_tu")
public class VatTu extends BaseEntity{
    @Column(name="ten")
    String ten;
    @Column(name="don_vi")
    String donVi;
    @Column(name="ma_chuan")
    String maChuan;
    @Column(name="nguon_mua")
    String nguonMua;
    @Column(name="phi_van_chuyen")
    BigDecimal phiVanChuyen;
    @Column(name="so_luong")
    Integer soLuong;
    @Column(name="so_luong_muc_thap")
    Integer soLuongMucThap;
    @Column(name="ma_cong_trinh")
    Long maCongTrinh;
}
