package com.studios.scalable.patientstatusprocessor.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HealthStateEnum {

	// ROBO / GBI
	HEALTHY("Headache"), 
	POTENTIALLY_EXPOSED("Dry Cough"),
	CONFIRMED_EXPOSURE(""),
	INFECTED(""),
	VACCINATED(""),
	RECOVERED("");

	private final String name;

}
