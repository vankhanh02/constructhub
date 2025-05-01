package com.constructhub.backend.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhanVienRequestDTO {
    private String ten;

    private String soDienThoai;

    private String diaChi;

    private String email;

    private String chucVu;

    private String trangThai;


    private String vaiTro;

}
