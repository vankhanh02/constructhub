package com.constructhub.backend.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@Builder
public class CongTrinhResponseDTO {
    private Long id;
    private String ten;
    private String diaDiem;
    private String tinhTrang;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private Long maChuDauTu;
}
