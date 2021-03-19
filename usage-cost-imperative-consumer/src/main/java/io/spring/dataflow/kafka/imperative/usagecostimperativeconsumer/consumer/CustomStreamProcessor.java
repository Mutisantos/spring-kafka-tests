package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CustomStreamProcessor {

  @Output("usage-cost")
  MessageChannel usageOutput();

  @Output("test")
  MessageChannel output();

  @Input("usage-detail")
  SubscribableChannel usageInput();

}
