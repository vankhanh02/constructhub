package com.constructhub.backend.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponseDTO {
    private Long id;
    private String ten;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private String chucVu;
    private String trangThai;
    private String vaiTro;
}