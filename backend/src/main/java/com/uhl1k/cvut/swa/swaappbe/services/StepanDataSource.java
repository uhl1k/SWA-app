package com.uhl1k.cvut.swa.swaappbe.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "StepanService")
public interface StepanDataSource {
  @RequestMapping(path = "/stepan", method = RequestMethod.GET)
  @ResponseBody
  String aliveEndPoint();
}
