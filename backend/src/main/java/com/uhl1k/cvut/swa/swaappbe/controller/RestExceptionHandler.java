package com.uhl1k.cvut.swa.swaappbe.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<String> genericErrorHandler(Exception ex, WebRequest req) {
    System.out.println(ex.getMessage());
    ex.printStackTrace(System.out);
    return new ResponseEntity<>(HttpStatusCode.valueOf(500));
  }
}
