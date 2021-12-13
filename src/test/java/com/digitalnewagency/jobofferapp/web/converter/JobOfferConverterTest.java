package com.digitalnewagency.jobofferapp.web.converter;

import com.digitalnewagency.jobofferapp.commons.exception.NoDataFoundException;
import com.digitalnewagency.jobofferapp.commons.exception.WrongParameterException;
import com.digitalnewagency.jobofferapp.model.entity.Category;
import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.testdata.JobOfferFactory;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class JobOfferConverterTest {

    private JobOfferConverter jobOfferConverter = new JobOfferConverter();

    @Test
    @DisplayName("test if  converter return job offer list do dto list correct")
    void shouldReturnDTOListCorrect() {

        var result = jobOfferConverter.convertListtoListDTO(JobOfferFactory.jobOfferDTOList());

        Assertions.assertThat(result)
                .isNotNull()
                .hasSize(1);
        Assertions.assertThat(result.get(0).getUserName()).isEqualTo("Test");

    }

    @Test
    @DisplayName("test if converter return exception when start date is after end date")
    void shouldReturnExceptionWhenStartDateIsAfterEndDate() {
        Assertions.assertThatThrownBy(() -> {
            jobOfferConverter.convertJobOfferDTOToJobOffer(JobOfferFactory.createNonValidjobOffer());
        }).isInstanceOf(WrongParameterException.class).hasMessage("Start date have to be before end date");

    }

    @Test
    @DisplayName("test if converter return exception when null given")
    void shouldReturnExceptionWhenNullGiven() {
        Assertions.assertThatThrownBy(() -> {
            jobOfferConverter.convertJobOfferDTOToJobOffer(null);
        }).isInstanceOf(WrongParameterException.class).hasMessage("JobOffer cannot be null");

    }

}