package io.spring.dataflow.sample.usagecostloggerkafka.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

import io.spring.dataflow.sample.usagecostloggerkafka.UsageCostLoggerKafkaApplication;
import io.spring.dataflow.sample.usagecostloggerkafka.model.NewUsageCostEvent;

@Configuration
public class UsageCostLogger {

  private static final Logger logger =
      LoggerFactory.getLogger(UsageCostLoggerKafkaApplication.class);

  @Bean
  public Consumer<NewUsageCostEvent> processCostDetails() {
    return newUsageCostEvent -> {
      logger.info(newUsageCostEvent.toString());
    };
  }
}
