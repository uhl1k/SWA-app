package com.uhl1k.cvut.swa.swaappbe.controller;

import com.uhl1k.cvut.swa.swaappbe.services.AliveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  private AliveService aliveService;

  @Autowired
  public RootController(AliveService aliveService) {
    this.aliveService = aliveService;
  }

  @GetMapping("/")
  public String rootController() {
    return "Well hello there ;).";
  }

  @GetMapping("/stepan")
  public String stepanController() {
    return aliveService.getStepanAlive();
  }

  @GetMapping("/petr")
  public String petrController() {
    return aliveService.getPetrAlive();
  }
}
