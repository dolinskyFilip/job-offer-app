package com.digitalnewagency.jobofferapp.testdata;

import com.digitalnewagency.jobofferapp.model.entity.Category;
import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;

import java.time.LocalDateTime;
import java.util.List;

public class JobOfferFactory {
    public static List<JobOffer> jobOfferDTOList() {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setUserName("Test");
        jobOffer.setCategory(Category.FOOD_DRINKS);
        jobOffer.setStartDate(LocalDateTime.of(2021, 12, 1, 12, 00));
        return List.of(jobOffer);
    }

    public static JobOfferDTO createNonValidjobOffer() {
        JobOfferDTO jobOffer = new JobOfferDTO();
        jobOffer.setUserName("Test");
        jobOffer.setCategory(Category.FOOD_DRINKS);
        jobOffer.setStartDate(LocalDateTime.of(2022, 12, 1, 12, 00));
        jobOffer.setEndDate(LocalDateTime.of(2021, 12, 1, 12, 00));
        return jobOffer;
    }
}
