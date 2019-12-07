package ru.xpendence.rosbank.dto;

import lombok.Data;

@Data
public class BranchDto {
    private Double lat;
    private Double lon;
    private String cityName;
}