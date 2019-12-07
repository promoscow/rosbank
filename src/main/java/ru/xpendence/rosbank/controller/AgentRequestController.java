package ru.xpendence.rosbank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/entity")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AgentRequestController {


}
