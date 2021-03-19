package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.source;

import lombok.Getter;
import lombok.Setter;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@Getter
@Setter
public class UsageMessageProducer {

  private Source mySource;

  public UsageMessageProducer(final Source mySource) {
    super();
    this.mySource = mySource;
  }

}
