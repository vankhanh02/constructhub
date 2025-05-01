package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.VatTuRequestDTO;
import com.constructhub.backend.dto.response.VatTuResponseDTO;
import com.constructhub.backend.model.VatTu;
import com.constructhub.backend.repository.VatTuRepository;
import com.constructhub.backend.service.VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VatTuServiceImpl implements VatTuService {
    @Autowired
    private VatTuRepository vatTuRepository;

    @Override
    public Long addVatTu(VatTuRequestDTO request) {
        VatTu vatTu = VatTu.builder()
                .ten(request.getTen())
                .donVi(request.getDonVi())
                .maChuan(request.getMaChuan())
                .nguonMua(request.getNguonMua())
                .phiVanChuyen(request.getPhiVanChuyen())
                .soLuong(request.getSoLuong())
                .soLuongMucThap(request.getSoLuongMucThap())
                .maCongTrinh(request.getMaCongTrinh())
                .build();

        return vatTuRepository.save(vatTu).getId();
    }



    @Override
    public Page<VatTuResponseDTO> getVatTuWithLowStock(Pageable pageable) {
        Page<VatTu> vatTuPage = vatTuRepository.findVatTuWithLowStock(pageable);
        return vatTuPage.map(this::mapToDto);
    }
    @Override
    public Page<VatTuResponseDTO> getAllVatTu(Pageable pageable) {
        Page<VatTu> vatTuPage = vatTuRepository.findAll(pageable);
        return vatTuPage.map(this::mapToDto);
    }
    private VatTuResponseDTO mapToDto(VatTu vatTu) {
        return VatTuResponseDTO.builder()
                .id(vatTu.getId())
                .ten(vatTu.getTen())
                .donVi(vatTu.getDonVi())
                .maChuan(vatTu.getMaChuan())
                .nguonMua(vatTu.getNguonMua())
                .phiVanChuyen(vatTu.getPhiVanChuyen())
                .soLuong(vatTu.getSoLuong())
                .soLuongMucThap(vatTu.getSoLuongMucThap())
                .maCongTrinh(vatTu.getMaCongTrinh())
                .build();
    }


}
