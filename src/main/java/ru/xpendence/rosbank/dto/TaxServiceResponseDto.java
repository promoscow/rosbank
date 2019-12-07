package ru.xpendence.rosbank.dto;

import lombok.Data;

@Data
public class TaxServiceResponseDto {
    private String name;
    private String latitude;
    private String longitude;
    private String inn;
    private String region;
}
