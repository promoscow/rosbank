package ru.xpendence.rosbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEnd {
    private Double latitude;
    private Double longitude;
    private String cityName;
    private List<BranchDto> branches;
}