package com.uhl1k.cvut.swa.swaappbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewShopDto {
  private int id;
  private String name;
  private String address;
  private String phone;
  private String email;
  private String opens;
  private String closes;
}
