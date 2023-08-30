package com.uhl1k.cvut.swa.swaappbe.controller;

import com.uhl1k.cvut.swa.swaappbe.services.PetrService;
import com.uhl1k.cvut.swa.swaappbe.services.StepanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  private PetrService petrService;
  private StepanService stepanService;

  @Autowired
  public RootController(PetrService petrService, StepanService stepanService) {
    this.petrService = petrService;
    this.stepanService = stepanService;
  }

  @GetMapping("/")
  public String rootController() {
    return "Well hello there ;).";
  }

  @GetMapping("/stepan")
  public String stepanController() {
    return stepanService.getStepanAlive();
  }

  @GetMapping("/petr")
  public String petrController() {
    return petrService.getPetrAlive();
  }
}
