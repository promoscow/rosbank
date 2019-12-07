package ru.xpendence.rosbank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.xpendence.rosbank.dao.BranchRepository;
import ru.xpendence.rosbank.dao.CityRepository;
import ru.xpendence.rosbank.dto.AgentRequest;
import ru.xpendence.rosbank.dto.ResponseEnd;
import ru.xpendence.rosbank.dto.TaxServiceResponseDto;
import ru.xpendence.rosbank.model.Branch;
import ru.xpendence.rosbank.model.City;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FindBranchService {
    private final RestTemplate restTemplate;
    private final CityRepository cityRepository;
    private final BranchRepository branchRepository;

    public ResponseEnd getBranches(Double latitude, Double longitude, String cityName) {
        City city = cityRepository.getByName(cityName);
        List<Branch> listAllBranches = branchRepository.findAllByCityId(city.getId());
        for (Branch branch : listAllBranches) {
            Double path = Math.sqrt(Math.pow(branch.getGeoLat() - latitude, 2) + Math.pow(branch.getGeoLon() - longitude, 2));
            branch.setPath(path);
        }
        List<Branch> resultBranch = listAllBranches
                .stream()
                .sorted(Comparator.comparing(Branch::getPath))
                .limit(1)
                .collect(Collectors.toList());
        return new ResponseEnd(latitude, longitude, cityName, resultBranch);
    }

    public ResponseEnd sendRequest(AgentRequest agentRequest) {
        String url = "http://algo:8082/inn";

        ResponseEntity<TaxServiceResponseDto> taxServiceResponse = restTemplate.getForEntity(
                UriComponentsBuilder.fromHttpUrl(url).queryParam("inn", agentRequest.getInnNumber()).toUriString(),
                TaxServiceResponseDto.class);
        TaxServiceResponseDto resDto = taxServiceResponse.getBody();

        return getBranches(Double.parseDouble(resDto.getLatitude()),
                Double.parseDouble(resDto.getLongitude()),
                resDto.getRegion());
    }

    public String getCity(String comment) {
        List<City> cities = cityRepository.findAll();
        String[] array = comment.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (cities.contains(array[i])) {
                return array[i];
            }
        }
        return null;
    }
}
