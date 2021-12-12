package com.digitalnewagency.jobofferapp.web.controller;

import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/dna/offers",produces = "application/json")
public interface JobOfferController {

    @GetMapping
    ResponseEntity<List<JobOfferDTO>> getValidJobOffers();

    @PostMapping
    ResponseEntity<?> createJobOffer(@RequestBody JobOfferDTO request);

}
