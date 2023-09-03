package com.uhl1k.cvut.swa.swaappbe.services;

import com.uhl1k.cvut.swa.swaappbe.dto.AuthorDto;
import com.uhl1k.cvut.swa.swaappbe.dto.BookDto;
import com.uhl1k.cvut.swa.swaappbe.dto.NewAuthorDto;
import com.uhl1k.cvut.swa.swaappbe.dto.NewBookDto;
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

  public BookDto[] getBooks(int page, int pageSize, String title) {
    return petrDataSource.getBooks(page, pageSize, title);
  }

  public int addBook(NewBookDto book) {
    return petrDataSource.addBook(book);
  }

  public BookDto getBook(String isbn) {
    return petrDataSource.getBook(isbn);
  }

  public BookDto modifyBook(String isbn, NewBookDto book) {
    return petrDataSource.modifyBook(isbn, book);
  }

  public void deleteBook(String isbn) {
    petrDataSource.deleteBook(isbn);
  }

  public AuthorDto[] getAuthors(int page, int pageSize) {
    return petrDataSource.getAuthors(page, pageSize);
  }

  public int addAuthor(NewAuthorDto author) {
    return petrDataSource.addAuthor(author);
  }

  public AuthorDto getAuthor(int id) {
    return petrDataSource.getAuthor(id);
  }

  public void modifyAuthor(int id, NewAuthorDto author) {
    petrDataSource.modifyAuthor(id, author);
  }

  public void deleteAuthor(int id) {
    petrDataSource.deleteAuthor(id);
  }

  public BookDto[] getBooksFromAuthor(int id) {
    return petrDataSource.getBooksFromAuthor(id);
  }

  @FeignClient(name = "PetrService")
  interface PetrDataSource {
    @RequestMapping(path = "/petr", method = RequestMethod.GET)
    @ResponseBody
    String aliveEndPoint();

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    @ResponseBody
    BookDto[] getBooks(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("title") String title);

    @RequestMapping(path = "/books", method = RequestMethod.PUT)
    @ResponseBody
    int addBook(@RequestBody NewBookDto book);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    BookDto getBook(@PathVariable("isbn") String isbn);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.POST)
    @ResponseBody
    BookDto modifyBook(@PathVariable("isbn") String isbn, @RequestBody NewBookDto book);

    @RequestMapping(path = "/books/{isbn}", method = RequestMethod.DELETE)
    @ResponseBody
    void deleteBook(@PathVariable("isbn") String isbn);

    @RequestMapping(path = "/authors", method = RequestMethod.GET)
    @ResponseBody
    AuthorDto[] getAuthors(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(path = "/authors", method = RequestMethod.PUT)
    @ResponseBody
    int addAuthor(@RequestBody NewAuthorDto author);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    AuthorDto getAuthor(@PathVariable("author-id") int id);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    void modifyAuthor(@PathVariable("author-id") int id, @RequestBody NewAuthorDto author);

    @RequestMapping(path = "/authors/{author-id}", method = RequestMethod.GET)
    @ResponseBody
    void deleteAuthor(@PathVariable("author-id") int id);

    @RequestMapping(path = "/authors/{author-id}/books", method = RequestMethod.GET)
    @ResponseBody
    BookDto[] getBooksFromAuthor(@PathVariable("author-id") int id);
  }
}
