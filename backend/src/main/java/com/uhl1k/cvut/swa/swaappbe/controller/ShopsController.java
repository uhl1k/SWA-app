package com.uhl1k.cvut.swa.swaappbe.controller;

import com.uhl1k.cvut.swa.swaappbe.dto.NewShopDto;
import com.uhl1k.cvut.swa.swaappbe.dto.PageDto;
import com.uhl1k.cvut.swa.swaappbe.dto.ShopDto;
import com.uhl1k.cvut.swa.swaappbe.services.StepanService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopsController {

  private StepanService stepanService;

  @Autowired
  public ShopsController(StepanService stepanService) {
    this.stepanService = stepanService;
  }

  @GetMapping("/api/shops")
  public ResponseEntity<PageDto<ShopDto>> getShops(@Param int page, @Param int pageSize) {
    return new ResponseEntity<>(stepanService.getShops(page, pageSize), HttpStatus.OK);
  }

  @PutMapping("/api/shops")
  public ResponseEntity<Integer> addNewShop(@RequestBody NewShopDto shop) {
    return new ResponseEntity<>(stepanService.createShop(shop), HttpStatus.CREATED);
  }

  @GetMapping("/api/shops/{id}")
  public ResponseEntity<ShopDto> getShop(@RequestParam int id) {
    return new ResponseEntity<>(stepanService.getShop(id), HttpStatus.OK);
  }

  @PostMapping("/api/shops/{id}")
  public ResponseEntity<Object> modifyShop(@RequestParam int id, @RequestBody NewShopDto shop) {
    stepanService.updateShop(id, shop);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/api/shops/{id}")
  public ResponseEntity<Object> deleteShop(@RequestParam int id) {
    stepanService.deleteShop(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
