package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsageCostDetail {
  private String userId;
  private BigDecimal callCost;
  private BigDecimal dataCost;
  private ZonedDateTime time;
}
