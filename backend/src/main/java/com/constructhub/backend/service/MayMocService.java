package com.constructhub.backend.service;

import com.constructhub.backend.entity.MayMoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MayMocService {
    Page<MayMoc> getAllMayMoc(Pageable pageable);

    int getActiveMayMoc();
    int getDamagedMayMoc();
}
