package io.spring.dataflow.sample.usagecostloggerkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class UsageCostDetail {
  private String userId;
  private BigDecimal callCost;
  private BigDecimal dataCost;
  private ZonedDateTime time;
}
