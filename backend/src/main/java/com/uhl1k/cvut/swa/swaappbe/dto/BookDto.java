package com.uhl1k.cvut.swa.swaappbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
  //private int id;
  private String isbn;
  private String title;
  private String published;
  private String language;
  private String genre;
  private int author;
}
