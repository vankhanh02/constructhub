package com.constructhub.backend.service;

import com.constructhub.backend.entity.DoiThauKhoan;
import com.constructhub.backend.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DoiThauKhoanService {
    int countDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach);

    Page<DoiThauKhoan> findDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach, Pageable pageable);

    Page<DoiThauKhoan> findAllDoiThauKhoan(Pageable pageable);
}