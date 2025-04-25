package com.constructhub.backend.service.Impl;

import com.constructhub.backend.entity.MayMoc;
import com.constructhub.backend.repository.MayMocRepository;
import com.constructhub.backend.service.MayMocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MayMocServiceImpl implements MayMocService {

    private final MayMocRepository mayMocRepository;

    @Autowired
    public MayMocServiceImpl(MayMocRepository mayMocRepository) {
        this.mayMocRepository = mayMocRepository;
    }

    @Override
    public Page<MayMoc> getAllMayMoc(Pageable pageable) {
        return mayMocRepository.findAll(pageable);
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