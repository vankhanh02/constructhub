package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.NhanVienRequestDTO;
import com.constructhub.backend.dto.response.NhanVienResponseDTO;
import com.constructhub.backend.model.NhanVien;
import com.constructhub.backend.repository.NhanVienRepository;
import com.constructhub.backend.service.NhanVienService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired
    private NhanVienRepository nhanVienRepository;


    @Override
    @Transactional
    public Long saveNhanVien(NhanVienRequestDTO request) {
        // Validate request
        if (request == null || request.getTen() == null) {
            throw new IllegalArgumentException("Missing required employee information");
        }

        // Using builder pattern as per the model class
        NhanVien nhanVien = NhanVien.builder()
                .ten(request.getTen())
                .soDienThoai(request.getSoDienThoai())
                .diaChi(request.getDiaChi())
                .email(request.getEmail())
                .chucVu(request.getChucVu())
                .trangThai(request.getTrangThai())
                .vaiTro(request.getVaiTro())
                .build();

        nhanVien = nhanVienRepository.save(nhanVien);
        return nhanVien.getId();
    }

    @Override
    public Page<NhanVienResponseDTO> getAllNhanVien(Pageable pageable) {
        Page<NhanVien> nhanVienPage = nhanVienRepository.findAll(pageable);

        return nhanVienPage.map(nhanVien -> NhanVienResponseDTO.builder()
                .id(nhanVien.getId())
                .ten(nhanVien.getTen())
                .soDienThoai(nhanVien.getSoDienThoai())
                .diaChi(nhanVien.getDiaChi())
                .email(nhanVien.getEmail())
                .chucVu(nhanVien.getChucVu())
                .trangThai(nhanVien.getTrangThai())
                .vaiTro(nhanVien.getVaiTro())
                .build());
    }
}
