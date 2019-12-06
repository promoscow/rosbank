package ru.xpendence.rosbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
