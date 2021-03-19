package io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.controller;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model.UsageCostDetail;
import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.model.UsageDetail;
import io.spring.dataflow.kafka.imperative.usagecostimperativeconsumer.source.UsageMessageProducer;

@RestController
public class UsageCostController {
  private final UsageMessageProducer producer;

  public UsageCostController(final UsageMessageProducer producer) {
    super();
    this.producer = producer;
  }

  // get the message as a complex type via HTTP, publish it to broker using spring cloud stream
  @PostMapping(value = "/sendMessage/complexType")
  public String publishMessageComplextType(@RequestBody final UsageDetail payload) {
    producer.getMySource().output()
        .send(MessageBuilder.withPayload(payload).setHeader("type", "chat").build());

    return "success";
  }

  // get the String message via HTTP, publish it to broker using spring cloud stream
  @PostMapping(value = "/sendMessage/string")
  public String publishMessageString(@RequestBody final String payload) {
    // send message to channel
    producer.getMySource().output()
        .send(MessageBuilder.withPayload(payload).setHeader("type", "string").build());

    return "success";
  }
}
