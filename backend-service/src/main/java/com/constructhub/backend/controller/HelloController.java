package com.constructhub.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@Controller  // Changed from RestController to Controller for redirect
@RequestMapping("/")
@Tag(name = "Hello Controller")
public class HelloController {

    @GetMapping("/")
    public RedirectView redirectToSwagger() {
        return new RedirectView("/swagger-ui/index.html");
    }

    @Operation(summary = "Test API", description = "Mo tar chi tiet")
    @GetMapping("/hello")
    public String greeting(@RequestParam String name) {
        return "Hello, " + name;
    }
}
