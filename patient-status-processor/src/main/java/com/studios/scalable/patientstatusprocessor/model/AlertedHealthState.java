package com.studios.scalable.patientstatusprocessor.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AlertedHealthState {

	private String userId;
	private HealthStateEnum healthStatus;
	private BigDecimal latitude;
	private BigDecimal longitude;

}
