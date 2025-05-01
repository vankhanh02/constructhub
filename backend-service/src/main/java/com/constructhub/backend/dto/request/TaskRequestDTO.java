package com.constructhub.backend.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class TaskRequestDTO {
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
