package io.spring.dataflow.sample.usagedetailsenderkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class UsageDetail {
  private String userId;
  private BigDecimal data;
  private BigDecimal duration;
}
