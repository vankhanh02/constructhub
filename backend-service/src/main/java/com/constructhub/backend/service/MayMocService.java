package com.constructhub.backend.service;

import com.constructhub.backend.dto.request.MayMocRequestDTO;
import com.constructhub.backend.dto.response.MayMocResponseSTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface MayMocService {
    Page<MayMocResponseSTO> getAllMayMoc(Pageable pageable);
    Long saveMayMoc(MayMocRequestDTO request);
    int getActiveMayMoc();
    int getDamagedMayMoc();
}
