package com.example.springflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    @GetMapping("/block")
    public String get() {
        return "Hello world!";
    }
}
