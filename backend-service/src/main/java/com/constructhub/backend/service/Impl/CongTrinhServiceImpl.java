package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.CongTrinhRequestDTO;
import com.constructhub.backend.dto.response.CongTrinhResponseDTO;
import com.constructhub.backend.model.CongTrinh;
import com.constructhub.backend.repository.CongTrinhRepository;
import com.constructhub.backend.service.CongTrinhService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CongTrinhServiceImpl implements CongTrinhService {
    @Autowired
    private CongTrinhRepository congTrinhRepository;

    @Override
    public Long createCongTrinh() {
        CongTrinh congtrinh = new CongTrinh();
        congtrinh.setTen("Trung tâm thương mại Vincom");
        congtrinh.setDiaDiem("Hà Nội");
        congtrinh.setMaChuDauTu(1L);
        congtrinh.setNgayBatDau(LocalDate.parse("2023-01-01"));
        congtrinh.setNgayKetThuc(LocalDate.parse("2023-12-31"));
        congTrinhRepository.save(congtrinh);
        return congtrinh.getId();
    }

    @Override
    public Page<CongTrinhResponseDTO> getAllCongTrinh(Pageable pageable) {
        Page<CongTrinh> congTrinhPage = congTrinhRepository.findAll(pageable);

        return congTrinhPage.map(congTrinh -> CongTrinhResponseDTO.builder()
                .id(congTrinh.getId())
                .ten(congTrinh.getTen())
                .diaDiem(congTrinh.getDiaDiem())
                .tinhTrang(congTrinh.getTinhTrang())
                .ngayBatDau(congTrinh.getNgayBatDau())
                .ngayKetThuc(congTrinh.getNgayKetThuc())
                .maChuDauTu(congTrinh.getMaChuDauTu())
                .build());
    }

    @Override
    public int getActiveConstructionCount() {
        return congTrinhRepository.getActiveConstructionCount();
    }

    @Override
    @Transactional
    public Long saveCongTrinh(CongTrinhRequestDTO request) {
        CongTrinh congtrinh = CongTrinh.builder()
                .ten(request.getTen())
                .maChuDauTu(request.getMaChuDauTu())
                .diaDiem(request.getDiaDiem())
                .ngayBatDau(request.getNgayBatDau())
                .ngayKetThuc(request.getNgayKetThuc())
        .build();
        congTrinhRepository.save(congtrinh);
        return congtrinh.getId();
    }


}
