package com.constructhub.backend.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class VatTuResponseDTO {
    Long id;
    String ten;

    String donVi;

    String maChuan;

    String nguonMua;

    BigDecimal phiVanChuyen;

    Integer soLuong;

    Integer soLuongMucThap;

    Long maCongTrinh;
}
