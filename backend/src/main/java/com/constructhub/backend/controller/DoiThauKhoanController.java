package com.constructhub.backend.controller;

import com.constructhub.backend.entity.DoiThauKhoan;
import com.constructhub.backend.entity.NhanVien;
import com.constructhub.backend.service.DoiThauKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doithau")
public class DoiThauKhoanController {
    @Autowired
    private DoiThauKhoanService doiThauKhoanService;

    @GetMapping("/count")
    public int countDoiThauKhoanByNguoiPhuTrach(@RequestParam Long nguoiPhuTrach) {
        return doiThauKhoanService.countDoiThauKhoanByNguoiPhuTrach(nguoiPhuTrach);
    }

    @GetMapping("list-by-nguoi-phu-trach")
    public Page<DoiThauKhoan> findDoiThauKhoanByNguoiPhuTrach(
            @RequestParam Long nguoiPhuTrach,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
            ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy= Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return doiThauKhoanService.findDoiThauKhoanByNguoiPhuTrach(nguoiPhuTrach, pageable);
    }
    @GetMapping("/list")
    public Page<DoiThauKhoan> findAllDoiThauKhoan(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return doiThauKhoanService.findAllDoiThauKhoan(pageable);
    }


}
