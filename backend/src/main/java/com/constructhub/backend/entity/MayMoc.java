package com.constructhub.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="may_moc")
public class MayMoc {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name="ma_may_moc")
    private Long id;
    @Column(name="ten")
    private String ten;

    @Column(name="loai")
    private String loai;

    @Column(name="ma_cong_trinh")
    private Long maCongTrinh;

    @Column(name="trangThai")
    private String trangThai;

    @Column(name="gia")
    private BigDecimal gia;

    @Column(name="dia_diem_hien_tai")
    private String diaDiemHienTai;

}
