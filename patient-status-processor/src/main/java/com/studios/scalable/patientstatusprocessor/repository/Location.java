package com.studios.scalable.patientstatusprocessor.repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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
public class Location {
  private BigDecimal latitude;
  private BigDecimal longitude;
  private ZonedDateTime timestamp;
}
