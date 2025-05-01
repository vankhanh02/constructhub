package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.CongTrinhRequestDTO;
import com.constructhub.backend.dto.response.CongTrinhResponseDTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.service.CongTrinhService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/congtrinh")
@Tag( name = "Công Trình")
public class CongTrinhController {
    @Autowired
    private CongTrinhService congTrinhService;

    @PostMapping("/add")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseData<Long> addCongTrinh() {

        return new ResponseData<>(HttpStatus.CREATED.value(), "Thêm công trình thành công", congTrinhService.createCongTrinh());
    }

    @PostMapping("/add-congtrinh")
    public ResponseData<Long> addCongTrinhDetail(@RequestBody CongTrinhRequestDTO congTrinh) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "Thêm công trình thành công", congTrinhService.saveCongTrinh(congTrinh));
    }


    @GetMapping("/getAll")
    public ResponseData<Page<CongTrinhResponseDTO>> getAllCongTrinh(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<CongTrinhResponseDTO> congTrinhPage = congTrinhService.getAllCongTrinh(pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách công trình thành công",
                congTrinhPage
        );
    }
    @GetMapping("/active-count")
    public ResponseData<Integer> getActiveConstructionCount() {
        return new ResponseData<>(HttpStatus.OK.value(), "Lấy số lượng công trình đang hoạt động thành công", congTrinhService.getActiveConstructionCount());
    }

}
