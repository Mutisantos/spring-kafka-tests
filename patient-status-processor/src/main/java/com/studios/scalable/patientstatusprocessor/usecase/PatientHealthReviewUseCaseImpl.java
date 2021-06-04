package com.studios.scalable.patientstatusprocessor.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.studios.scalable.patientstatusprocessor.model.AlertedHealthState;
import com.studios.scalable.patientstatusprocessor.model.AlertedHealthState.AlertedHealthStateBuilder;
import com.studios.scalable.patientstatusprocessor.model.HealthStateEnum;
import com.studios.scalable.patientstatusprocessor.model.UpdatedGeoLocation;
import com.studios.scalable.patientstatusprocessor.model.UpdatedHealthDetails;
import com.studios.scalable.patientstatusprocessor.repository.HealthState;
import com.studios.scalable.patientstatusprocessor.repository.Location;
import com.studios.scalable.patientstatusprocessor.repository.PatientHealthReviewRepository;
import com.studios.scalable.patientstatusprocessor.repository.PatientLocationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientHealthReviewUseCaseImpl implements PatientHealthReviewUseCase {

	// Add some repository logic and such
	private final PatientLocationRepository locationRepository;

	private final PatientHealthReviewRepository healthRepository;

	private final HealthParamConfig healthConfigs;

	@Override
	public AlertedHealthState evaluateHealthState(UpdatedHealthDetails health, UpdatedGeoLocation location) {

		AlertedHealthStateBuilder builder = AlertedHealthState.builder();
		Location previousLocation = locationRepository.obtainLatestLocation(health.getUserId());
		HealthState previousHealthReport = healthRepository.obtainLatestHealthReport(health.getUserId());

		double distance = Math.sqrt(
				Math.pow(location.getLatitude().doubleValue() - previousLocation.getLatitude().doubleValue(), 2) + Math
						.pow(location.getLongitude().doubleValue() - previousLocation.getLongitude().doubleValue(), 2));

		return builder.build();
	}

	private HealthStateEnum examinePatientState(UpdatedHealthDetails healthReport) {
		if(healthReport.getHadCovid()) {
			return HealthStateEnum.RECOVERED;
		}
		if(healthReport.getHadPositivePCR()) {
			return HealthStateEnum.INFECTED;
		}
		if (healthReport.getCelciusTemperature()
				.compareTo(BigDecimal.valueOf(healthConfigs.getMaxTemperature())) >= 0) {
			return HealthStateEnum.POTENTIALLY_EXPOSED;
		}
		return HealthStateEnum.HEALTHY;
	}

}
