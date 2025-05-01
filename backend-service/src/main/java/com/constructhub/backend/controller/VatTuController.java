package com.constructhub.backend.controller;

import com.constructhub.backend.dto.request.VatTuRequestDTO;
import com.constructhub.backend.dto.response.ResponseData;
import com.constructhub.backend.dto.response.VatTuResponseDTO;
import com.constructhub.backend.service.VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vattu")
public class VatTuController {
    @Autowired
    private VatTuService vatTuService;

    @PostMapping("/add")
    public ResponseData<Long> addVatTu(@RequestBody VatTuRequestDTO vatTuRequest) {
        Long vatTuId = vatTuService.addVatTu(vatTuRequest);
        return new ResponseData<>(
                HttpStatus.CREATED.value(),
                "Thêm vật tư thành công",
                vatTuId
        );
    }
    @GetMapping
    public ResponseData<Page<VatTuResponseDTO>> getAllVatTu(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<VatTuResponseDTO> vatTuPage = vatTuService.getAllVatTu(pageable);
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách vật tư thành công",
                vatTuPage
        );
    }
    @GetMapping("/low-stock")
    public ResponseData<Page<VatTuResponseDTO>> getVatTuWithLowStock(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<VatTuResponseDTO> vatTuPage = vatTuService.getVatTuWithLowStock(pageable);
        return new ResponseData<>(
                HttpStatus.OK.value(),
                "Lấy danh sách vật tư có số lượng thấp thành công",
                vatTuPage
        );
    }



}
