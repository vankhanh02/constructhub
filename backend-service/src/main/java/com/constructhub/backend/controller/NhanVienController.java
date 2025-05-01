package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.NhanVienRequestDTO;
import com.constructhub.backend.dto.response.NhanVienResponseDTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.service.NhanVienService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nhanvien")
@Tag(name = "Nhân Viên")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Long> addNhanVien(@RequestBody NhanVienRequestDTO nhanVien) {
        Long id = nhanVienService.saveNhanVien(nhanVien);
        return new ResponseData<>(
                HttpStatus.CREATED.value(),
                "Thêm nhân viên thành công",
                id
        );
    }

    @GetMapping("/getAll")
    public ResponseData<Page<NhanVienResponseDTO>> getAllNhanVien(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<NhanVienResponseDTO> nhanVienPage = nhanVienService.getAllNhanVien(pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách nhân viên thành công",
                nhanVienPage
        );
    }
}