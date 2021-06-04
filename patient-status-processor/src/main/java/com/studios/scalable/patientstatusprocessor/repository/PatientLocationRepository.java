package com.studios.scalable.patientstatusprocessor.repository;

public interface PatientLocationRepository {
	
	Location obtainLatestLocation (final String userId);
	
}
