package com.example.springflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

    @GetMapping("/reactive")
    public Mono<String> get() {
        return Mono.just("Hello world!");
    }
}
