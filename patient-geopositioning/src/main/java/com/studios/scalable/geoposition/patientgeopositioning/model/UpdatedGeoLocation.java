package com.studios.scalable.geoposition.patientgeopositioning.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedGeoLocation {

	private BigDecimal latitude;
	private BigDecimal longitude;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime timestamp;

}
