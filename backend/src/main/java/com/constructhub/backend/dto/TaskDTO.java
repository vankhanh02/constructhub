package com.constructhub.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String ten;
    private Long maCongTrinh;
    private Long nguoiThucHien;
    private String trangThai;
    private LocalDate thoiHan;

//    private void setTen(String ten)
//    {
//        this.ten = ten;
//    }
//    private String getTen()
//    {
//        return this.ten;
//    }

}