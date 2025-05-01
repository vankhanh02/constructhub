package com.constructhub.backend.service;

import com.constructhub.backend.dto.request.VatTuRequestDTO;
import com.constructhub.backend.dto.response.VatTuResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface VatTuService {
    Long addVatTu(VatTuRequestDTO request);
    Page<VatTuResponseDTO> getAllVatTu(Pageable pageable);
    Page<VatTuResponseDTO> getVatTuWithLowStock(Pageable pageable);

}
