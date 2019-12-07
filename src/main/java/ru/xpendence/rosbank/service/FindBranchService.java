package ru.xpendence.rosbank.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FindBranchService {
    private final RestTemplate restTemplate;
    private final CityRepository cityRepository;
    private final BranchRepository branchRepository;
    private static final String URL = "http://algo:8082/inn";

    public ResponseEnd getBranches(Double latitude, Double longitude, String cityName) {
        City city = cityRepository.getByName(cityName);
        log.info("Получен город {} ", city.getName());
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
        log.info("Получение резальтат по отделниям {} ", Arrays.toString(new List[]{resultBranch}));
        return new ResponseEnd(latitude, longitude, cityName, resultBranch);
    }

    public ResponseEnd sendRequest(AgentRequest agentRequest) {
        ResponseEntity<TaxServiceResponseDto> taxServiceResponse = restTemplate.getForEntity(
                UriComponentsBuilder.fromHttpUrl(URL).queryParam("inn", agentRequest.getInnNumber()).toUriString(),
                TaxServiceResponseDto.class);
        TaxServiceResponseDto resDto = taxServiceResponse.getBody();
        log.info("Получен ответ от микросервиса {} ", resDto.toString());

        return getBranches(Double.parseDouble(resDto.getLatitude()),
                Double.parseDouble(resDto.getLongitude()),
                resDto.getRegion());
    }
}