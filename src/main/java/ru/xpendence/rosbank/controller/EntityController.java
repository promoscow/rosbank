package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.rosbank.dao.CityRepository;
import ru.xpendence.rosbank.dto.BranchDto;
import ru.xpendence.rosbank.dto.ResponseEnd;
import ru.xpendence.rosbank.model.City;
import ru.xpendence.rosbank.service.FindBranchService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/entity")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EntityController {
    private final FindBranchService findBranchService;
    private final CityRepository cityRepository;

    @GetMapping("cities")
    public List<City> allCity() {
        return cityRepository.findAll();
    }

    @PostMapping("branch")
    public ResponseEnd getAllBranches(@RequestBody BranchDto dto) {
        return findBranchService.getBranches(dto.getLat(), dto.getLon(), dto.getCityName());
    }
}
