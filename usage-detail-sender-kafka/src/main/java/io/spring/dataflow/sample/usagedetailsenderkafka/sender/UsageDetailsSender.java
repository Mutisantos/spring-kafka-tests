package io.spring.dataflow.sample.usagedetailsenderkafka.sender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Supplier;

import io.spring.dataflow.sample.usagedetailsenderkafka.model.UsageDetail;

@Configuration
public class UsageDetailsSender {

  private final String[] users = {"user1", "user2", "user3", "user4", "user5"};

  @Bean
  public Supplier<UsageDetail> sendEvents() {
    return () -> {
      final UsageDetail usageDetail = new UsageDetail();
      usageDetail.setUserId(this.users[new Random().nextInt(5)]);
      usageDetail.setDuration(BigDecimal.valueOf(new Random().nextInt(300)));
      usageDetail.setData(BigDecimal.valueOf(new Random().nextInt(700)));
      return usageDetail;
    };
  }
}
