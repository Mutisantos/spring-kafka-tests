package io.spring.dataflow.sample.usagecostprocessorkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class UsageCostDetail {
  private String userId;
  private BigDecimal callCost;
  private BigDecimal dataCost;
}
