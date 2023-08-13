package com.uhl1k.cvut.swa.swaappbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@EnableFeignClients
@EnableDiscoveryClient
@Service
public class AliveService {

  private PetrDataSource petrDataSource;
  private StepanDataSource stepanDataSource;

  @Autowired
  public AliveService(PetrDataSource petrDataSource, StepanDataSource stepanDataSource) {
    this.petrDataSource = petrDataSource;
    this.stepanDataSource = stepanDataSource;
  }

  public String getPetrAlive() {
    return petrDataSource.aliveEndPoint();
  }

  public String getStepanAlive() {
    return stepanDataSource.aliveEndPoint();
  }
}
