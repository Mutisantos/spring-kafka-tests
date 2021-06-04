package io.spring.dataflow.sample.usagecostprocessorkafka.sender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.Function;

import io.spring.dataflow.sample.usagecostprocessorkafka.model.UsageCostDetail;
import io.spring.dataflow.sample.usagecostprocessorkafka.model.UsageDetail;

@Configuration
public class UsageCostProcessor {

  private final BigDecimal ratePerSecond = BigDecimal.valueOf(0.10);
  private final BigDecimal ratePerMB = BigDecimal.valueOf(0.05);
  private static final MathContext context = new MathContext(2, RoundingMode.HALF_UP);

  @Bean
  /*
   * The bean will act as both a producer and a consumer. Will consume an Usage Detail from one
   * topic and then generate an UsageCostDetail that will be sent to another topic
   */
  public Function<UsageDetail, UsageCostDetail> processUsageCost() {
    return usageDetail -> {
      final UsageCostDetail usageCostDetail = new UsageCostDetail();
      usageCostDetail.setUserId(usageDetail.getUserId());
      usageCostDetail.setCallCost(usageDetail.getDuration().multiply(ratePerSecond, context));
      usageCostDetail.setDataCost(usageDetail.getData().multiply(ratePerMB, context));
      return usageCostDetail;
    };
  }
}
