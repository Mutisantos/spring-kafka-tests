package com.studios.scalable.patientstatusprocessor.usecase;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "patient")
public class HealthParamConfig {
  private Integer maxTemperature;
  private Integer maxSymptoms;

}
