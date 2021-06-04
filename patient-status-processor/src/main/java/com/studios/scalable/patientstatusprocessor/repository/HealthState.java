package com.studios.scalable.patientstatusprocessor.repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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
public class HealthState {
	private String userId;
	private BigDecimal celciusTemperature;
	private Boolean hadCovid;
	private Boolean exposedToCovid;
	private Boolean hadPositivePCR;
	private Boolean wasVaccinated;
}
