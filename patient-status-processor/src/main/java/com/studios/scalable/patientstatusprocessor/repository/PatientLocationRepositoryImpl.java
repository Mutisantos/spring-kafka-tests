package com.studios.scalable.patientstatusprocessor.repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PatientLocationRepositoryImpl implements PatientLocationRepository {

	@Override
	public Location obtainLatestLocation(String userId) {
		return Location.builder().latitude(BigDecimal.valueOf(44.104894)).longitude(BigDecimal.valueOf(12.608894))
				.timestamp(ZonedDateTime.now().minusDays(7)).build();
	}

}