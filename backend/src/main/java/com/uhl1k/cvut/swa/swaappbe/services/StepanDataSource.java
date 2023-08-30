package com.uhl1k.cvut.swa.swaappbe.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "StepanService")
public interface StepanDataSource {
  @RequestMapping(path = "/openapi/health", method = RequestMethod.GET)
  @ResponseBody
  String aliveEndPoint();

  @RequestMapping(path = "/openapi/shops", method = RequestMethod.GET)
  @ResponseBody
  String getShops(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

  @RequestMapping(path = "/openapi/shops", method = RequestMethod.PUT)
  @ResponseBody
  int addShop(@RequestBody Object shop);

  @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.GET)
  @ResponseBody
  Object getShop(@PathVariable(name = "id") int id);

  @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.POST)
  @ResponseBody
  Object modifyShop(@PathVariable(name = "id") int id, @RequestBody Object shop);

  @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  void deleteShop(@PathVariable(name = "id") int id);

  @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
  @ResponseBody
  Object getAvailability(@PathVariable(name = "isbn") String isbn, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

  @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.PUT)
  @ResponseBody
  void addAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId);

  @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.POST)
  @ResponseBody
  void modifyAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId);

  @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.DELETE)
  @ResponseBody
  void removeAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId);
}
