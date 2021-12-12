package com.digitalnewagency.jobofferapp.service;

import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.model.repository.JobOfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JobOfferServiceImpl implements JobOfferService {

    private JobOfferRepository repository;

    @Override
    public List<JobOffer> getValidJobOffers() {
        return repository.findValidJobOffers(LocalDateTime.now());
    }

    @Override
    public JobOffer createJobOffer(JobOffer jobOffer) {
        return repository.save(jobOffer);
    }
}
