package com.constructhub.backend.repository;

import com.constructhub.backend.model.DoiThauKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiThauKhoanRepository extends JpaRepository<DoiThauKhoan, Long> {
    int countDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach);

    Page<DoiThauKhoan> findByNguoiPhuTrach(Long nguoiPhuTrach, Pageable pageable);

    Page<DoiThauKhoan> findDoiThauKhoanByNguoiPhuTrach(Long nguoiPhuTrach, Pageable pageable);




}