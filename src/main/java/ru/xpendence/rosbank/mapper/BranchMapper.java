package ru.xpendence.rosbank.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.rosbank.dto.BranchDto;
import ru.xpendence.rosbank.model.Branch;

@Component
public class BranchMapper {

    public BranchDto toDto(Branch branch) {

        return new BranchDto(branch.getId(), branch.getName(), branch.getGeoLat(), branch.getGeoLon(),
                branch.getStreet(), branch.getEmployees(), branch.getPath());
    }
}