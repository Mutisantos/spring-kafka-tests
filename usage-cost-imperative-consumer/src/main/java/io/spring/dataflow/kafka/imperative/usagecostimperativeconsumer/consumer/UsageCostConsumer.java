package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.ZonedDateTime;

import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model.UsageCostDetail;
import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model.UsageDetail;

@SuppressWarnings("deprecation")
@EnableBinding(Processor.class)
public class UsageCostConsumer {

  private final BigDecimal ratePerSecond = BigDecimal.valueOf(0.10);
  private final BigDecimal ratePerMB = BigDecimal.valueOf(0.05);
  private static final MathContext context = new MathContext(2, RoundingMode.HALF_UP);
  private static final Logger logger = LoggerFactory.getLogger(UsageCostConsumer.class);

  @StreamListener(target = Processor.INPUT)
  @SendTo(Processor.OUTPUT)
  public UsageCostDetail processDetails(@Payload final UsageDetail message) {
    logger.info("received a string message : {}", message);
    return UsageCostDetail.builder().userId(message.getUserId())
        .callCost(message.getDuration().multiply(ratePerSecond, context))
        .time(ZonedDateTime.now())
        .dataCost(message.getData().multiply(ratePerMB, context)).build();
    // processor.output().send(MessageBuilder.withPayload(build).setHeader("type", "chat").build());
    // processor.usageOutput().send(MessageBuilder.withPayload(build).build());

  }

}
