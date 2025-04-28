package com.constructhub.backend.service.Impl;

import com.constructhub.backend.entity.DoiThauKhoan;
import com.constructhub.backend.entity.NhanVien;
import com.constructhub.backend.repository.DoiThauKhoanRepository;
import com.constructhub.backend.service.DoiThauKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoiThauKhoanServiceImpl implements DoiThauKhoanService {

    @Autowired
    private DoiThauKhoanRepository doiThauKhoanRepository;


    @Override
    public int countDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach) {
        return doiThauKhoanRepository.countDoiThauKhoanByNguoiPhuTrach(nguoiPhuTrach);
    }

    @Override
    public Page<DoiThauKhoan> findDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach, Pageable pageable) {
        return doiThauKhoanRepository.findDoiThauKhoanByNguoiPhuTrach(nguoiPhuTrach, pageable);
    }

    @Override
    public Page<DoiThauKhoan> findAllDoiThauKhoan(Pageable pageable) {
        return doiThauKhoanRepository.findAll(pageable);
    }


}
