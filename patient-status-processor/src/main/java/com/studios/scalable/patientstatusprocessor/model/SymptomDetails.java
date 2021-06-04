package com.studios.scalable.patientstatusprocessor.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SymptomDetails {

	private final SymptomsEnum sypmtom;
	private final Integer severity;
	private final Integer daysOfSymptom;

}
