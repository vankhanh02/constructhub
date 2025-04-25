package com.constructhub.backend.controller;

import com.constructhub.backend.entity.CongTrinh;
import com.constructhub.backend.service.CongTrinhService;
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
@RequestMapping("/congtrinh")
public class CongTrinhController {
    @Autowired
    private CongTrinhService congTrinhService;

    @GetMapping("/active-count")
    public int getActiveConstructionCount() {
        return congTrinhService.getActiveConstructionCount();
    }

    @GetMapping("/getAll")
    public Page<CongTrinh> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return congTrinhService.getAllConstructions(pageable);
    }
}
