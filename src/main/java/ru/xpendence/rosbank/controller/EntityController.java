package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.rosbank.dao.CityRepository;
import ru.xpendence.rosbank.model.City;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/entity")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EntityController {

    private final CityRepository cityRepository;

    @GetMapping("cities")
    public List<City> allCity() {
        return cityRepository.findAll();
    }
}
