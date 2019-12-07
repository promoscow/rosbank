package ru.xpendence.rosbank.dto;

import lombok.Data;

@Data
public class AgentRequest {
    private String agentCode;
    private String phoneNumber;
    private String innNumber;
    private String comment;
}
