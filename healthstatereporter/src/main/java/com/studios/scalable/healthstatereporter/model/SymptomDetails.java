package com.studios.scalable.healthstatereporter.model;

import com.studios.scalable.healthstatereporter.source.SymptomsEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SymptomDetails {

	private final SymptomsEnum sypmtom;
	private final Integer severity;
	private final Integer daysOfSymptom;

}
