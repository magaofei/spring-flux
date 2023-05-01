package com.example.springflux;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/block")
@RestController()
public class BlockController {

    private final StringRedisTemplate redisTemplate;

    public BlockController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/")
    public String get() {
        return "Hello world!";
    }

    @GetMapping(value = "/redis")
    public String redis() {
        this.redisTemplate.opsForValue().set("foo", "bar");
        return this.redisTemplate.opsForValue().get("foo");
    }

}
