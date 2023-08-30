package com.uhl1k.cvut.swa.swaappbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailabilityDto {
  private String shopName;
  private int shopId;
  private int amount;
  private double price;
}
