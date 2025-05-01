package com.constructhub.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoiThauKhoanRequestDTO {
    private String ten;

    private Long maCongTrinh;

    private String doiTruong;

    private Integer soLuongThanhVien;

    private String soDienThoai;

    private String loai;

    private Long nguoiPhuTrach;
}