package com.constructhub.backend.service;

import com.constructhub.backend.entity.CongTrinh;
import org.springframework.stereotype.Service;

@Service
public interface CongTrinhService {
    int getActiveConstructionCount();
}
