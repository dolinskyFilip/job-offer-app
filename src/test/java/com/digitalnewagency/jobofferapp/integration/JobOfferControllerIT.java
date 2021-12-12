package com.digitalnewagency.jobofferapp.integration;

import com.digitalnewagency.jobofferapp.JobOfferAppApplication;
import com.digitalnewagency.jobofferapp.model.entity.Category;
import com.digitalnewagency.jobofferapp.model.entity.JobOffer;
import com.digitalnewagency.jobofferapp.web.advice.ErrorResponse;
import com.digitalnewagency.jobofferapp.web.dto.joboffer.JobOfferDTO;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {JobOfferAppApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JobOfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ClientAndServer mockServer;
    private ObjectMapper mapper;


    @BeforeAll
    void init() {
        mapper = new ObjectMapper().findAndRegisterModules();
        ;
        mockServer = ClientAndServer.startClientAndServer(8080);
    }

    @AfterAll
    void cleanUp() {
        mockServer.stop();
        while (!mockServer.hasStopped(3, 100l, TimeUnit.MILLISECONDS)) ;
    }

    @BeforeEach
    void resetMockServer() {
        mockServer.reset();
    }

    @Test
    @DisplayName("test if controller returns  valid job offers with 200 status")
    void shouldReturnValidJobOffersCorrect() throws Exception {

        var link = "/dna/offers";

        var result = mockMvc.perform(MockMvcRequestBuilders.get(link)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
       var jobOfferDTO = mapper.readValue(result.getContentAsString(),new TypeReference<List<JobOfferDTO>>(){});

        Assertions.assertThat(jobOfferDTO).isNotEmpty();
        Assertions.assertThat(jobOfferDTO).hasSize(5);
    }

    @Test
    @DisplayName("test if controller returns 201 and create a job offer")
    void shouldCreateJobOfferCorrect() throws Exception {
        JobOfferDTO jobOfferDTO= new JobOfferDTO();
       jobOfferDTO.setCategory(Category.FOOD_DRINKS);
      jobOfferDTO.setStartDate(LocalDateTime.of(2021,12,1,12,00));
      jobOfferDTO.setEndDate(LocalDateTime.of(2022,11,1,12,00));
      jobOfferDTO.setUserName("Filip");

        var link = "/dna/offers";

        var result = mockMvc.perform(MockMvcRequestBuilders.post(link)
                .content(mapper.writeValueAsString(jobOfferDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn().getResponse();
        var jobOfferDTOresult = mapper.readValue(result.getContentAsString(),JobOfferDTO.class);

        Assertions.assertThat(jobOfferDTOresult).isNotNull();
        Assertions.assertThat(jobOfferDTOresult.getUserName()).isEqualTo("Filip");
    }

}
