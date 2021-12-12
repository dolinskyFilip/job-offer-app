package com.digitalnewagency.jobofferapp.web.converter;

import com.digitalnewagency.jobofferapp.model.entity.Category;
import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JobOfferConverterTest {

    private JobOfferConverter jobOfferConverter=new JobOfferConverter();

    @Test
    @DisplayName("should convert job offer list do dto list correct")
    void shouldReturnDTOListCorrect() {

        JobOffer jobOffer = new JobOffer();
        jobOffer.setUserName("Test");
        jobOffer.setCategory(Category.FOOD_DRINKS);
        jobOffer.setStartDate(LocalDateTime.of(2021,12,1,12,00));
        List<JobOffer> jobOffers= List.of(jobOffer);

        var result= jobOfferConverter.convertListtoListDTO(jobOffers);

        Assertions.assertThat(result)
                .isNotNull()
                .hasSize(1);
        Assertions.assertThat(result.get(0).getUserName()).isEqualTo("Test");

    }

}