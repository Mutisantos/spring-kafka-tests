package com.studios.scalable.healthstatereporter.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportedHealthDetails {
  private String userId;
  private BigDecimal celciusTemperature;
  private Boolean hadCovid;
  private Boolean exposedToCovid;
  private Boolean hadPositivePCR;
  private Boolean wasVaccinated;
  private List<SymptomDetails> symptoms; 
}
