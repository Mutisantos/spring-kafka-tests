package com.studios.scalable.healthstatereporter.source;

import lombok.Getter;
import lombok.Setter;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@Getter
@Setter
public class HealthReportSource {

  private Source mySource;

  public HealthReportSource(final Source mySource) {
    super();
    this.mySource = mySource;
  }

}
