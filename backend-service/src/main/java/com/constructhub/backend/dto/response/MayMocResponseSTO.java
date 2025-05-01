package com.constructhub.backend.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class MayMocResponseSTO {
    private Long id;
    private String ten;

    private String loai;

    private Long maCongTrinh;

    private String trangThai;

    private BigDecimal gia;

    private String diaDiemHienTai;
}
