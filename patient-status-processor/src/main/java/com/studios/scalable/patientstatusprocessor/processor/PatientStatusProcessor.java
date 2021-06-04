package com.studios.scalable.patientstatusprocessor.processor;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studios.scalable.patientstatusprocessor.model.AlertedHealthState;
import com.studios.scalable.patientstatusprocessor.model.UpdatedGeoLocation;
import com.studios.scalable.patientstatusprocessor.model.UpdatedHealthDetails;
import com.studios.scalable.patientstatusprocessor.usecase.PatientHealthReviewUseCase;

import lombok.AllArgsConstructor;

@Configuration @AllArgsConstructor public class PatientStatusProcessor {


    private final PatientHealthReviewUseCase useCase;
    private final Logger logger = Logger.getLogger(PatientStatusProcessor.class);

    /*
     * The bean will act as both a producer and a consumer. Will consume an Usage
     * Detail from one topic and then generate an UsageCostDetail that will be sent
     * to another topic
     */
    //	@Bean
    //		public BiFunction<UpdatedHealthDetails, UpdatedGeoLocation, AlertedHealthState> processHealthAndLocation() {
    //			return (updatedHealth, updatedGeolocation) -> {
    //				logger.info(String.format("New Health Details: [%s] in new Location: [%s]", updatedHealth.toString(), updatedGeolocation.toString()));
    //				return useCase.evaluateHealthState(updatedHealth, updatedGeolocation);
    //			};
    //		}

    //    @Bean
    //    public Function<UpdatedHealthDetails, AlertedHealthState> processHealth() {
    //        return updatedHealth -> {
    //            logger.info(String
    //                .format("New Health Details: [%s] in new Location: [%s]", updatedHealth.toString()));
    //            return useCase.evaluateHealthState(updatedHealth, null);
    //        };
    //    }

    @Bean
    public Function<UpdatedGeoLocation, AlertedHealthState> processPosition() {
        return updatedGeoLocation -> {
            logger.info(String
                .format("New Health Details: {}", updatedGeoLocation.toString()));
            return AlertedHealthState.builder().build();
        };
    }

}
