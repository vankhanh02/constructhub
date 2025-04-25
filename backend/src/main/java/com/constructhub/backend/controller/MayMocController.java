package com.constructhub.backend.controller;

import com.constructhub.backend.entity.MayMoc;
import com.constructhub.backend.service.MayMocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maymoc")
@CrossOrigin(origins = "*")
public class MayMocController {

    private final MayMocService mayMocService;

    @Autowired
    public MayMocController(MayMocService mayMocService) {
        this.mayMocService = mayMocService;
    }

    @GetMapping("/list")
    public Page<MayMoc> getAllMayMoc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return mayMocService.getAllMayMoc(pageable);
    }

    @GetMapping("/active")
    public int getActiveMayMocCount() {
        return mayMocService.getActiveMayMoc();
    }

    @GetMapping("/damaged")
    public int getDamagedMayMocCount() {
        return mayMocService.getDamagedMayMoc();
    }
}