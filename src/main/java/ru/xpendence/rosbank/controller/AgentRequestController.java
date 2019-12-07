package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.rosbank.dto.AgentRequest;
import ru.xpendence.rosbank.dto.ResponseEnd;
import ru.xpendence.rosbank.service.FindBranchService;

@CrossOrigin
@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AgentRequestController {
    private final FindBranchService findBranchService;

    @PostMapping("/request")
    public ResponseEnd getInfoFromAgent(@RequestBody AgentRequest agentRequest) {
        return findBranchService.sendRequest(agentRequest);
    }
}