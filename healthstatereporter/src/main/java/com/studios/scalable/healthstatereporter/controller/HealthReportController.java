package com.studios.scalable.healthstatereporter.controller;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studios.scalable.healthstatereporter.model.ReportedHealthDetails;
import com.studios.scalable.healthstatereporter.source.HealthReportSource;

@RestController
public class HealthReportController {
  private final HealthReportSource producer;

  public HealthReportController(final HealthReportSource producer) {
    super();
    this.producer = producer;
  }

  // get the message as a complex type via HTTP, publish it to broker using spring cloud stream
  @PostMapping(value = "/healthState")
  public String publishMessageComplextType(@RequestBody final ReportedHealthDetails payload) {
    producer.getMySource().output()
        .send(MessageBuilder.withPayload(payload).build());
    return "success";
  }
  

}
