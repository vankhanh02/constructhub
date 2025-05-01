package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.DoiThauKhoanRequestDTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.model.DoiThauKhoan;
import com.constructhub.backend.service.DoiThauKhoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doithaukhoan")
@Tag(name = "Đội Thầu Khoán")
public class DoiThauKhoanController {

    @Autowired
    private DoiThauKhoanService doiThauKhoanService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Long> addDoiThauKhoan(@RequestBody DoiThauKhoanRequestDTO doiThauKhoan) {
        return new ResponseData<>(
                HttpStatus.CREATED.value(),
                "Thêm đội thầu khoán thành công",
                doiThauKhoanService.saveDoiThauKhoan(doiThauKhoan)
        );
    }

    @GetMapping("/getAll")
    public ResponseData<Page<DoiThauKhoan>> getAllDoiThauKhoan(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<DoiThauKhoan> doiThauKhoanPage = doiThauKhoanService.findAllDoiThauKhoan(pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách đội thầu khoán thành công",
                doiThauKhoanPage
        );
    }

    @GetMapping("/getByNguoiPhuTrach")
    public ResponseData<Page<DoiThauKhoan>> getDoiThauKhoanByNguoiPhuTrach(
            @RequestParam Long nguoiPhuTrach,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<DoiThauKhoan> doiThauKhoanPage = doiThauKhoanService.findDoiThauKhoanByNguoiPhuTrach(nguoiPhuTrach, pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách đội thầu khoán theo người phụ trách thành công",
                doiThauKhoanPage
        );
    }
}