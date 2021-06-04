package com.studios.scalable.patientstatusprocessor.repository;

public interface PatientHealthReviewRepository {

	HealthState obtainLatestHealthReport(String userId);

}
