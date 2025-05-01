package com.constructhub.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "Hello Controller")
public class HelloController {

    @Operation(summary = "Test API", description = "Mo tar chi tiet")
    @GetMapping("/hello")
    public String greeting(@RequestParam String name) {
        return "Hello, " + name;
    }
}
