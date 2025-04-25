package com.constructhub.backend.controller;

import com.constructhub.backend.service.CongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
