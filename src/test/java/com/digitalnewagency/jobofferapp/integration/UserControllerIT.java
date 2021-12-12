package com.digitalnewagency.jobofferapp.integration;

import com.digitalnewagency.jobofferapp.JobOfferAppApplication;
import com.digitalnewagency.jobofferapp.web.advice.ErrorResponse;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;
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

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {JobOfferAppApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerIT {

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
    @DisplayName("test if controller returns 200 for getUser endpoint")
    void shouldReturnUserCorrect() throws Exception {

        var link = "/dna/users/Filip";

        var result = mockMvc.perform(MockMvcRequestBuilders.get(link)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        var userDTO = mapper.readValue(result.getContentAsString(), UserDTO.class);

        org.assertj.core.api.Assertions.assertThat(userDTO.getName()).isEqualTo("Filip");
    }

    @Test
    @DisplayName("test if controller returns 404 when giving  parameter for entity that doesn't exist")
    void shouldReturnExceptionWhen() throws Exception {

        var link = "/dna/users/notFound";

        var result = mockMvc.perform(MockMvcRequestBuilders.get(link)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn().getResponse();
        var errorResponse = mapper.readValue(result.getContentAsString(), ErrorResponse.class);

        Assertions.assertThat(errorResponse.getMessage()).isEqualTo("User not found");

    }
}
