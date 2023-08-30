package com.uhl1k.cvut.swa.swaappbe.services;

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

@Service
@EnableFeignClients
@EnableDiscoveryClient
public class PetrService {

  @Autowired
  private PetrDataSource petrDataSource;

  public String getPetrAlive() {
    return petrDataSource.aliveEndPoint();
  }

  @FeignClient(name = "PetrService")
  interface PetrDataSource {
    @RequestMapping(path = "/petr", method = RequestMethod.GET)
    @ResponseBody
    String aliveEndPoint();

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    Object getBooks(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("title") String title);

    @RequestMapping(path = "/books", method = RequestMethod.PUT)
    @ResponseBody
    int addBook(@RequestBody Object book);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    Object getBook(@PathVariable("isbn") String isbn);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.POST)
    @ResponseBody
    Object modifyBook(@PathVariable("isbn") String isbn, @RequestBody Object book);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteBook(@PathVariable("isbn") String isbn);

    @RequestMapping(path = "/authors", method = RequestMethod.GET)
    @ResponseBody
    Object getAuthors(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(path = "/authors", method = RequestMethod.PUT)
    @ResponseBody
    int addAuthor(@RequestBody Object author);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    Object getAuthor(@PathVariable("author-id") int id);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    void modifyAuthor(@PathVariable("author-id") int id, @RequestBody Object author);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    void deleteAuthor(@PathVariable("author-id") int id);

    @RequestMapping(path = "/authors/{author-id}/books", method = RequestMethod.GET)
    @ResponseBody
    Object getBooksFromAuthor(@PathVariable("author-id") int id);
  }
}
