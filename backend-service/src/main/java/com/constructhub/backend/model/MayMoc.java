package com.constructhub.backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="may_moc")
public class MayMoc extends BaseEntity {


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
