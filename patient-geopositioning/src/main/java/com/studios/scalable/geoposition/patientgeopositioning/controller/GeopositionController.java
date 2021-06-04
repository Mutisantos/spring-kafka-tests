package com.studios.scalable.geoposition.patientgeopositioning.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studios.scalable.geoposition.patientgeopositioning.model.UpdatedGeoLocation;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GeopositionController {

	private final StreamBridge streamBridge;

	// get the message as a complex type via HTTP, publish it to broker using spring
	// cloud stream
	@PostMapping(value = "/position")
	public ResponseEntity<String> publishMessageComplextType(@RequestBody final UpdatedGeoLocation payload) {
		if(streamBridge.send("output", payload)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
