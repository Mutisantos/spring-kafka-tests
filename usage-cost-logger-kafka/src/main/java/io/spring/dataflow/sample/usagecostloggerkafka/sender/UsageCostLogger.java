package io.spring.dataflow.sample.usagecostloggerkafka.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

import io.spring.dataflow.sample.usagecostloggerkafka.UsageCostLoggerKafkaApplication;
import io.spring.dataflow.sample.usagecostloggerkafka.model.UsageCostDetail;

@Configuration
public class UsageCostLogger {

  private static final Logger logger =
      LoggerFactory.getLogger(UsageCostLoggerKafkaApplication.class);

  @Bean
  public Consumer<UsageCostDetail> processCostDetails() {
    return usageCostDetail -> {
      logger.info(usageCostDetail.toString());
    };
  }
}
