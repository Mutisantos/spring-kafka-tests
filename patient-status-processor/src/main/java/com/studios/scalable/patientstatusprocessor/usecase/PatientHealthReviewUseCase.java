package com.studios.scalable.patientstatusprocessor.usecase;

import com.studios.scalable.patientstatusprocessor.model.AlertedHealthState;
import com.studios.scalable.patientstatusprocessor.model.UpdatedGeoLocation;
import com.studios.scalable.patientstatusprocessor.model.UpdatedHealthDetails;

public interface PatientHealthReviewUseCase {
	
	AlertedHealthState evaluateHealthState(UpdatedHealthDetails health, UpdatedGeoLocation location);

}
