package com.constructhub.backend.service;

import com.constructhub.backend.dto.request.CongTrinhRequestDTO;
import com.constructhub.backend.dto.response.CongTrinhResponseDTO;
import com.constructhub.backend.model.CongTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CongTrinhService {
    Long createCongTrinh();
    Page<CongTrinhResponseDTO> getAllCongTrinh(Pageable pageable);
    int getActiveConstructionCount();
    Long saveCongTrinh(CongTrinhRequestDTO congTrinh);
}
