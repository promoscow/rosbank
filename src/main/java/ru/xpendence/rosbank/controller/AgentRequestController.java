package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.rosbank.dto.AgentRequest;
import ru.xpendence.rosbank.dto.ResponseEnd;
import ru.xpendence.rosbank.service.FindBranchService;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AgentRequestController {
    private final FindBranchService findBranchService;

    @PostMapping("/request")
    public ResponseEnd getInfoFromAgent(@RequestBody AgentRequest agentRequest) {
        log.info("Получен запрос от фронта {}", agentRequest.toString());
        return findBranchService.sendRequest(agentRequest);
    }
}