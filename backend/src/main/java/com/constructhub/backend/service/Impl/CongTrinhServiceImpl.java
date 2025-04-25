package com.constructhub.backend.service.Impl;

import com.constructhub.backend.entity.CongTrinh;
import com.constructhub.backend.repository.CongTrinhRepository;
import com.constructhub.backend.service.CongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CongTrinhServiceImpl implements CongTrinhService {

    @Autowired
    private CongTrinhRepository congTrinhRepository;
    @Override
    public int getActiveConstructionCount() {
        return congTrinhRepository.getActiveConstructionCount();
    }

    @Override
    public Page<CongTrinh> getAllConstructions(Pageable pageable) {
        return congTrinhRepository.findAll(pageable);
    }


}
