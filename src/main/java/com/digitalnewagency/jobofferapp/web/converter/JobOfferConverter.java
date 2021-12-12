package com.digitalnewagency.jobofferapp.web.converter;

import com.digitalnewagency.jobofferapp.commons.exception.WrongParameterException;
import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobOfferConverter {

    public JobOffer convertJobOfferDTOToJobOffer(JobOfferDTO jobOfferDTO) {
        if (jobOfferDTO == null) throw new WrongParameterException("User cannot be null");
        if (jobOfferDTO.getEndDate().isBefore(jobOfferDTO.getStartDate()))
            throw new WrongParameterException(("Start date have to be before end date"));

        JobOffer jobOffer = new JobOffer();
        jobOffer.setUserName(jobOfferDTO.getUserName());
        jobOffer.setCategory(jobOfferDTO.getCategory());
        jobOffer.setStartDate(jobOfferDTO.getStartDate());
        jobOffer.setEndDate(jobOfferDTO.getEndDate());
        return jobOffer;
    }

    public JobOfferDTO convertJobOffertoJobOfferDTO(JobOffer jobOffer) {
        JobOfferDTO jobOfferDTO = new JobOfferDTO();
        jobOfferDTO.setId(jobOffer.getId());
        jobOfferDTO.setCategory(jobOffer.getCategory());
        jobOfferDTO.setStartDate(jobOffer.getStartDate());
        jobOfferDTO.setEndDate(jobOffer.getEndDate());
        jobOfferDTO.setUserName(jobOffer.getUserName());
        return jobOfferDTO;
    }
    public List<JobOfferDTO> convertListtoListDTO(List<JobOffer> list) {
        return list.stream()
                .map(this::convertJobOffertoJobOfferDTO)
                .collect(Collectors.toList());
    }
}
