package com.constructhub.backend.service;

import com.constructhub.backend.entity.CongTrinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CongTrinhService {
    int getActiveConstructionCount();

    Page<CongTrinh> getAllConstructions(Pageable pageable);
}
