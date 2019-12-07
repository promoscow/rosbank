package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.xpendence.rosbank.dto.AgentRequest;
import ru.xpendence.rosbank.dto.TaxServiceResponseDto;
import ru.xpendence.rosbank.service.FindBranchService;

@CrossOrigin
@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AgentRequestController {
    private final RestTemplate restTemplate;
    private final FindBranchService findBranchService;

    @PostMapping("/request")
    public ResponseEntity<TaxServiceResponseDto> getInfoFromAgent(@RequestBody AgentRequest agentRequest) {
        String url = "http://algo:8082/inn";

        ResponseEntity<TaxServiceResponseDto> taxServiceResponse = restTemplate.getForEntity(
                UriComponentsBuilder.fromHttpUrl(url).queryParam("inn", agentRequest.getInnNumber()).toUriString(),
                TaxServiceResponseDto.class);
        String cityNameFromComment = findBranchService.getCity(agentRequest.getComment());
        if (cityNameFromComment != null && cityNameFromComment.equalsIgnoreCase(taxServiceResponse.getBody().getRegion())) {
            //вернуть результат
        } else if (cityNameFromComment == null) {
            //вернуть результат
        } else {
            //отправить телефон Славе и вернуть результат
        }
        return taxServiceResponse;
    }
}
