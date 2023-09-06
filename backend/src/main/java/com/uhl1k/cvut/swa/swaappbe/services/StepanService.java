package com.uhl1k.cvut.swa.swaappbe.services;

import com.uhl1k.cvut.swa.swaappbe.dto.AvailabilityDto;
import com.uhl1k.cvut.swa.swaappbe.dto.NewAvailabilityDto;
import com.uhl1k.cvut.swa.swaappbe.dto.NewShopDto;
import com.uhl1k.cvut.swa.swaappbe.dto.PageDto;
import com.uhl1k.cvut.swa.swaappbe.dto.ShopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableFeignClients
@EnableDiscoveryClient
@Service
public class StepanService {

  @Autowired
  private StepanDataSource stepanDataSource;

  public String getStepanAlive() {
    return stepanDataSource.stepanAlive();
  }

  public PageDto<ShopDto> getShops(int page, int pageSize) {
    return stepanDataSource.getShops(page, pageSize);
  }

  public ShopDto getShop(int id) {
    return stepanDataSource.getShop(id);
  }

  public int createShop(NewShopDto shop) {
    return stepanDataSource.addShop(shop);
  }

  public void updateShop(int id, NewShopDto shop) {
    stepanDataSource.modifyShop(id, shop);
  }

  public void deleteShop(int id) {
    stepanDataSource.deleteShop(id);
  }

  public AvailabilityDto[] getBookAvailability(int page, int pageSize, String isbn) {
    return stepanDataSource.getAvailability(isbn, page, pageSize);
  }

  public void addBookAvailability(String isbn, int shopId, NewAvailabilityDto availability) {
    stepanDataSource.addAvailability(isbn, shopId, availability);
  }

  public void changeBookAvailability(String isbn, int shopId, NewAvailabilityDto availability) {
    stepanDataSource.modifyAvailability(isbn, shopId, availability);
  }

  public void removeAvailabilityForBook(String isbn, int shopId) {
    stepanDataSource.removeAvailability(isbn, shopId);
  }

  @FeignClient(name = "StepanService")
  interface StepanDataSource {
    @RequestMapping(path = "/openapi/health", method = RequestMethod.GET)
    @ResponseBody
    String stepanAlive();

    @RequestMapping(path = "/openapi/shops", method = RequestMethod.GET)
    @ResponseBody
    PageDto<ShopDto> getShops(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(path = "/openapi/shops", method = RequestMethod.PUT)
    @ResponseBody
    int addShop(@RequestBody NewShopDto shop);

    @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.GET)
    @ResponseBody
    ShopDto getShop(@PathVariable(name = "id") int id);

    @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.POST)
    @ResponseBody
    void modifyShop(@PathVariable(name = "id") int id, @RequestBody NewShopDto shop);

    @RequestMapping(path = "/openapi/shops/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteShop(@PathVariable(name = "id") int id);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    AvailabilityDto[] getAvailability(@PathVariable(name = "isbn") String isbn, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.PUT)
    @ResponseBody
    void addAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId, @RequestBody NewAvailabilityDto availability);

    @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.POST)
    @ResponseBody
    void modifyAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId, @RequestBody NewAvailabilityDto availability);

    @RequestMapping(path = "/books/{isbn}/availability/{shopId}", method = RequestMethod.DELETE)
    @ResponseBody
    void removeAvailability(@PathVariable(name = "isbn") String isbn, @PathVariable(name = "shopId") int shopId);
  }
}
