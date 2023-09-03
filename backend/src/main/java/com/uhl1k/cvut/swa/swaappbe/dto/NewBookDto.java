package com.uhl1k.cvut.swa.swaappbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDto {
  private String title;
  private String isbn;
  private String published;
  private String language;
  private String genre;
  private int author;
}
