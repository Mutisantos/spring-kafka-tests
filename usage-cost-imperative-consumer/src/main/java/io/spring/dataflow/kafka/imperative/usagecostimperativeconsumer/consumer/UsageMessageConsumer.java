package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.consumer;

import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model.UsageCostDetail;

@SuppressWarnings("deprecation")
@EnableBinding(Sink.class)
@Getter
@Setter
public class UsageMessageConsumer {

  private static final Logger logger = LoggerFactory.getLogger(UsageMessageConsumer.class);

  @StreamListener(target = Sink.INPUT)
  public void consume(final String message) {
    logger.info("recieved a string message : {}", message);
  }

  @StreamListener(target = Sink.INPUT, condition = "headers['type']=='chat'")
  public void handle(@Payload final UsageCostDetail message) {
    final DateTimeFormatter df =
        DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withZone(ZoneId.systemDefault());
    if (Objects.nonNull(message.getTime())) {
      final String time = df.format(message.getTime());
      logger.info("Recibí un mensaje desde el Procesador Personalizado: [{}]: {}", time, message);
    } else {
      logger.info("Recibí un mensaje desde el Procesador Personalizado: [{}]: {}",
          ZonedDateTime.now(), message);
    }

  }

}
