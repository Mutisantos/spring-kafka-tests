package com.studios.scalable.healthstatereporter.source;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SymptomsEnum {

	// ROBO / GBI
	HEADACHE("Headache"), 
	DRY_COUGH("Dry Cough"), 
	SORE_THROAT("Sore Throat"),
	SMELL_LOSS("Loss of Smell"),
	TASTE_LOSS("Loss of Taste"),
	CHEST_PAIN("Chest pain");

	private final String name;

}
