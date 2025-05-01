package com.constructhub.backend.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Builder
public class TaskResponseDTO {
    private Long id;
    private String ten;

    private Long maCongTrinh;

    private Long nguoiPhanCong;

    private Long nguoiThucHien;


    private LocalDate ngayBatDau;

    private LocalDate ngayHoanThanh;

    private LocalDate thoiHan;

    private String trangThai;

    private String moTa;
}
