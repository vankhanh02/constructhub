package com.constructhub.backend.service.Impl;

import com.constructhub.backend.dto.request.DoiThauKhoanRequestDTO;
import com.constructhub.backend.model.DoiThauKhoan;
import com.constructhub.backend.repository.DoiThauKhoanRepository;
import com.constructhub.backend.service.DoiThauKhoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/doithaukhoan")
@Tag(name = "Đội Thầu Khoán")
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

    @Override
    @Transactional
    public Long saveDoiThauKhoan(DoiThauKhoanRequestDTO request) {
        // Validate request
        if (request == null || request.getTen() == null) {
            throw new IllegalArgumentException("Missing required information");
        }

        // Using builder pattern to match the actual DoiThauKhoan entity fields
        DoiThauKhoan doiThauKhoan = DoiThauKhoan.builder()
                .ten(request.getTen())
                .soDienThoai(request.getSoDienThoai())
                .nguoiPhuTrach(request.getNguoiPhuTrach())
                .loai(request.getLoai()) // Use getLoai() instead of getLinhVuc()
                .soLuongThanhVien(request.getSoLuongThanhVien() != null ? request.getSoLuongThanhVien() : 0)
                .build();

        doiThauKhoan = doiThauKhoanRepository.save(doiThauKhoan);
        return doiThauKhoan.getId();
    }


}
