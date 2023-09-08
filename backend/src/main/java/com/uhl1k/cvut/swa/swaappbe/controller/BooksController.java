package com.uhl1k.cvut.swa.swaappbe.controller;

import com.uhl1k.cvut.swa.swaappbe.dto.BookDto;
import com.uhl1k.cvut.swa.swaappbe.dto.PageDto;
import com.uhl1k.cvut.swa.swaappbe.services.PetrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@Controller
public class BooksController {

  private PetrService petrService;

  @Autowired
  public BooksController(PetrService petrService) {
    this.petrService = petrService;
  }

  @GetMapping("/api/books")
  public ResponseEntity<PageDto<BookDto>> getBooks(@RequestParam int page, @RequestParam int pageSize, @RequestParam String title) {
    return new ResponseEntity<>(petrService.getBooks(page, pageSize, title), HttpStatus.OK);
  }
}
