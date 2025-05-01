package com.constructhub.backend.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class MayMocRequestDTO {
    private String ten;

    private String loai;

    private Long maCongTrinh;

    private String trangThai;

    private BigDecimal gia;

    private String diaDiemHienTai;
}
