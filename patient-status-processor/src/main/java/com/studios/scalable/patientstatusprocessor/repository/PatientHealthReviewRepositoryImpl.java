package com.studios.scalable.patientstatusprocessor.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class PatientHealthReviewRepositoryImpl implements PatientHealthReviewRepository {

	@Override
	public HealthState obtainLatestHealthReport(String userId) {
		return HealthState.builder()
				.celciusTemperature(BigDecimal.valueOf(36.1))
				.exposedToCovid(false)
				.hadCovid(false)
				.hadPositivePCR(false)
				.wasVaccinated(false)
				.build();
	}

}
