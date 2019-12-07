package ru.xpendence.rosbank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.xpendence.rosbank.dto.Test;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 03.12.19
 * Time: 17:24
 * e-mail: v.chernyshov@pflb.ru
 */
@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {

    private final RestTemplate restTemplate;

    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<Test> test() {
        return restTemplate.getForEntity("http://algo:8082/test", Test.class);
    }

    @PostMapping("hello")
    public String hello(@RequestBody String s) {
        return s;
    }
}
