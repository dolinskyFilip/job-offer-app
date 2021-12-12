package com.digitalnewagency.jobofferapp.web.dto.joboffer;

import com.digitalnewagency.jobofferapp.model.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class JobOfferDTO {

    private Long id;

    @NotNull
    private Category category;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @NotNull
    private String userName;
}
