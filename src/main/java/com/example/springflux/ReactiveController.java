package com.example.springflux;

import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/reactive")
public class ReactiveController {

    private final ReactiveStringRedisTemplate redisTemplate;

    public ReactiveController(ReactiveStringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @GetMapping("/")
    public Mono<String> get() {
        return Mono.just("hello world!");
    }

    @GetMapping("/redis")
    public Mono<String> redis() {
        return this.redisTemplate.opsForValue().set("foo", "bar")
                .then(
                        this.redisTemplate.opsForValue().get("foo")
                );
    }
}
