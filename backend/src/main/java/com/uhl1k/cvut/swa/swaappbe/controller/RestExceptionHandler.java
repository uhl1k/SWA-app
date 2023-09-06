package com.uhl1k.cvut.swa.swaappbe.controller;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(value = {FeignException.class})
  public ResponseEntity<String> feignExceptionHandler(Exception ex, WebRequest req) {
    switch (ex.getMessage().substring(1, 4)) {
      case "400":
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<String> genericErrorHandler(Exception ex, WebRequest req) {
    System.out.println(ex.getMessage());
    ex.printStackTrace(System.out);
    return new ResponseEntity<>(HttpStatusCode.valueOf(500));
  }
}
