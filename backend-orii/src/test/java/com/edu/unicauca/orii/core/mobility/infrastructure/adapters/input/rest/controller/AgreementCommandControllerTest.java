package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AgreementCommandControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateOrUpdateValidAgreement() throws Exception {
        // Valid agreement request
        String validAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validAgreementJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.agreementStatus").value("ACTIVE"));
    }

    @Test
    void shouldReturnBadRequestForMissingAgreementStatus() throws Exception {
        // Invalid request: missing agreementStatus
        String invalidAgreementJson = """
            {
                "agreementStatus": "",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingInstitution() throws Exception {
        // Invalid request: missing institution
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingAgreementNumber() throws Exception {
        // Invalid request: missing agreementNumber
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingCountry() throws Exception {
        // Invalid request: missing country
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingDescription() throws Exception {
        // Invalid request: missing description
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingScope() throws Exception {
        // Invalid request: missing scope
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForMissingStartDate() throws Exception {
        // Invalid request: missing startDate
        String invalidAgreementJson = """
            {
                "agreementStatus": "ACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": ""
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForInvalidAgreementStatus() throws Exception {
        // Invalid request: Invalid agreementStatus 'DONE'
        String invalidAgreementJson = """
            {
                "agreementStatus": "DONE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "28-03-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidAgreementJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldCreateOrUpdateWithInactiveAgreement() throws Exception {
        // Valid agreement with inactive status
        String validAgreementJson = """
            {
                "agreementStatus": "INACTIVE",
                "institution": "Universidad Nacional",
                "agreementNumber": "AC213",
                "country": "Colombia",
                "description": "Intercambio",
                "scope": "VALOR",
                "startDate": "23-08-2024"
            }
        """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validAgreementJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.agreementStatus").value("INACTIVE"));
    }

}