package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.rosbank.dto.AgentRequest;

@CrossOrigin
@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AgentRequestController {
    
    @PostMapping("/request")
    public AgentRequest getInfoFromAgent(@RequestBody AgentRequest agentRequest) {
        return agentRequest;
    }
}
