package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.MayMocRequestDTO;
import com.constructhub.backend.dto.response.MayMocResponseSTO;
import com.constructhub.backend.model.MayMoc;
import com.constructhub.backend.repository.MayMocRepository;
import com.constructhub.backend.service.MayMocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MayMocServiceImpl implements MayMocService {
    @Autowired
    private MayMocRepository mayMocRepository;
    @Override
    public Page<MayMocResponseSTO> getAllMayMoc(Pageable pageable) {
        return mayMocRepository.findAll(pageable)
                .map(mayMoc -> MayMocResponseSTO.builder()
                        .id(mayMoc.getId())
                        .ten(mayMoc.getTen())
                        .loai(mayMoc.getLoai())
                        .maCongTrinh(mayMoc.getMaCongTrinh())
                        .trangThai(mayMoc.getTrangThai())
                        .gia(mayMoc.getGia())
                        .diaDiemHienTai(mayMoc.getDiaDiemHienTai())
                        .build());
    }

    @Override
    public Long saveMayMoc(MayMocRequestDTO request) {
        MayMoc maymoc = MayMoc.builder()
                .ten(request.getTen())
                .loai(request.getLoai())
                .maCongTrinh(request.getMaCongTrinh())
                .trangThai(request.getTrangThai())
                .gia(request.getGia())
                .diaDiemHienTai(request.getDiaDiemHienTai())
                .build();

        return mayMocRepository.save(maymoc).getId();
    }
    @Override
    public int getActiveMayMoc() {
        return mayMocRepository.getActiveMayMoc();
    }

    @Override
    public int getDamagedMayMoc() {
        return mayMocRepository.getDamagedMayMoc();
    }



}
