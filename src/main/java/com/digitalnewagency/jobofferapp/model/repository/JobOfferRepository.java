package com.digitalnewagency.jobofferapp.model.repository;

import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {


    @Query("select j from JobOffer j where j.startDate <= :date and j.endDate >=:date")
    List<JobOffer> findValidJobOffers(LocalDateTime date);
}
