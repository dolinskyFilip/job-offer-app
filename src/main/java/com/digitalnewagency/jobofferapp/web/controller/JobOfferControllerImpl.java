package com.digitalnewagency.jobofferapp.web.controller;

import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.service.JobOfferService;
import com.digitalnewagency.jobofferapp.web.converter.JobOfferConverter;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class JobOfferControllerImpl implements JobOfferController {

    private JobOfferService service;

    private JobOfferConverter converter;

    @Override
    public ResponseEntity<List<JobOfferDTO>> getValidJobOffers() {

        var list = service.getValidJobOffers();
        var result= converter.convertListtoListDTO(list);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createJobOffer(JobOfferDTO request) {
        var jobOffer = converter.convertJobOfferDTOToJobOffer(request);
        var createdJobOffer = service.createJobOffer(jobOffer);
        var result=converter.convertJobOffertoJobOfferDTO(createdJobOffer);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
