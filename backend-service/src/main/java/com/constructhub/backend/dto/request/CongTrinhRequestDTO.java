package com.constructhub.backend.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Builder
public class CongTrinhRequestDTO {
    private String ten;

    private Long maChuDauTu;

    private String diaDiem;

    private LocalDate ngayBatDau;

    private LocalDate ngayKetThuc;

    private String tinhTrang;


}
