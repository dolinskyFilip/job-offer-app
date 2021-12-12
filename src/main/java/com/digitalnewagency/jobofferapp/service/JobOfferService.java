package com.digitalnewagency.jobofferapp.service;

import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;

import java.util.List;

public interface JobOfferService {

    List<JobOffer> getValidJobOffers();

    JobOffer createJobOffer(JobOffer request);
}
