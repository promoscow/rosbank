package ru.xpendence.rosbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.xpendence.rosbank.model.Employee;

import java.util.List;

@Data
@AllArgsConstructor
public class BranchDto {
    private Long id;
    private String name;
    private Double geoLat;
    private Double geoLon;
    private String street;
    private List<Employee> employees;
    private Double path;
    private int countEmployee;
}