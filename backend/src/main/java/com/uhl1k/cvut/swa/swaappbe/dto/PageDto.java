package com.uhl1k.cvut.swa.swaappbe.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDto<K> {
  int page;
  int pageSize;
  int totalPages;

  K[] data;
}
