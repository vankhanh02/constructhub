package com.constructhub.backend.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class VatTuRequestDTO {
    String ten;

    String donVi;

    String maChuan;

    String nguonMua;

    BigDecimal phiVanChuyen;

    Integer soLuong;

    Integer soLuongMucThap;

    Long maCongTrinh;
}
