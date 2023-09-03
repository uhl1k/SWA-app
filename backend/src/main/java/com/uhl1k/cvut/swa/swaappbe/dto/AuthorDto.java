package com.uhl1k.cvut.swa.swaappbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
  private int id;
  private String name;
  private String surname;
  private String birth;
}
