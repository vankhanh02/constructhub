package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.MayMocRequestDTO;
import com.constructhub.backend.dto.response.MayMocResponseSTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.service.MayMocService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maymoc")
@Tag(name="Máy Móc")
public class MayMocController {
    @Autowired
    private MayMocService mayMocService;

    @GetMapping("/getAll")
    public ResponseData<Page<MayMocResponseSTO>> getAllMayMoc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<MayMocResponseSTO> mayMocPage = mayMocService.getAllMayMoc(pageable);

        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách máy móc thành công",
                mayMocPage
        );
    }
    @PostMapping("/add")
    public ResponseData<Long> addMayMoc(@RequestBody MayMocRequestDTO mayMoc) {
        Long id = mayMocService.saveMayMoc(mayMoc);
        return new ResponseData<>(
                HttpStatus.CREATED.value(),
                "Thêm máy móc thành công",
                id
        );
    }
    @GetMapping("/getActive")
    public ResponseData<Integer> getActiveMayMoc() {
        int activeCount = mayMocService.getActiveMayMoc();
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Số lượng máy móc đang hoạt động",
                activeCount
        );
    }

    @GetMapping("/getDamaged")
    public ResponseData<Integer> getDamagedMayMoc() {
        int damagedCount = mayMocService.getDamagedMayMoc();
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Số lượng máy móc bị hư hỏng",
                damagedCount
        );
    }
}
