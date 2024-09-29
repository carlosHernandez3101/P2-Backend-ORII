package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import com.edu.unicauca.orii.core.mobility.domain.enums.ScopeEnum;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.AgreementEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IAgreementRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AgreementCommandControllerUpdateIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IAgreementRepository agreementRepository;

    private AgreementEntity initialAgreementEntity;

    @BeforeEach
    public void setup() {
        // Create and save the initial AgreementEntity in the database before each test
        initialAgreementEntity = AgreementEntity.builder()
                .institution("Universidad Nacional")
                .agreementNumber("AC213")
                .country("Colombia")
                .description("Intercambio")
                .scope(ScopeEnum.INTERNATIONAL)
                .startDate(new Date())  // Current date
                .build();

        initialAgreementEntity = agreementRepository.save(initialAgreementEntity);  // Save and get ID
    }


    @Test
    public void testUpdateAgreementWithValidData() throws Exception {
        // Valid update request
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isOk())// Expecting HTTP 200 OK
                .andExpect(jsonPath("$.institution").value("Universidad Nacional"))
                .andExpect(jsonPath("$.agreementNumber").value("AC213"))
                .andExpect(jsonPath("$.country").value("Colombia"))
                .andExpect(jsonPath("$.description").value("Intercambio"))
                .andExpect(jsonPath("$.scope").value("VALOR"))
                .andExpect(jsonPath("$.startDate").value("23-08-2024"));
    }

    @Test
    public void testUpdateAgreementWithEmptyInstitution() throws Exception {
        // Institution field is empty
        String updatedAgreement = """
        {
            "institution": "",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateAgreementWithEmptyAgreementNumber() throws Exception {
        // Agreement number is empty
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateAgreementWithEmptyCountry() throws Exception {
        // Country field is empty
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateAgreementWithEmptyDescription() throws Exception {
        // Description field is empty
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateAgreementWithEmptyScope() throws Exception {
        // Scope field is empty
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateAgreementWithEmptyStartDate() throws Exception {
        // Start date is empty
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": ""
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 Bad Request
    }

    @Test
    public void testUpdateNonExistentAgreement() throws Exception {
        // Invalid update request
        String updatedAgreement = """
        {
            "institution": "Universidad Nacional",
            "agreementNumber": "AC213",
            "country": "Colombia",
            "description": "Intercambio",
            "scope": "VALOR",
            "startDate": "23-08-2024"
        }
        """;

        mockMvc.perform(put("/agreement/update/{id}", 9999L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isNotFound());  // Expecting HTTP 404 Not FOund
    }


    @Test
    public void testUpdateAgreementWithNullInstitution() throws Exception {
        String updatedAgreement = """
    {
        "institution": null,
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateAgreementWithNullAgreementNumber() throws Exception {
        String updatedAgreement = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": null,
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateAgreementWithNullCountry() throws Exception {
        String updatedAgreement = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": null,
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateAgreementWithNullDescription() throws Exception {
        String updatedAgreement = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": null,
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateAgreementWithNullScope() throws Exception {
        String updatedAgreement = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": null,
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateAgreementWithNullStartDate() throws Exception {
        String updatedAgreement = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": null
    }
    """;

        mockMvc.perform(put("/agreement/update/{id}", initialAgreementEntity.getAgreementId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedAgreement))
                .andExpect(status().isBadRequest());
    }

}