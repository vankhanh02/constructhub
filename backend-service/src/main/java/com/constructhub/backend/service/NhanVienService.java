package com.constructhub.backend.service;

import com.constructhub.backend.dto.request.NhanVienRequestDTO;
import com.constructhub.backend.dto.response.NhanVienResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienService {
    Long saveNhanVien(NhanVienRequestDTO nhanVienRequestDTO);
    Page<NhanVienResponseDTO> getAllNhanVien(Pageable pageable);
}
