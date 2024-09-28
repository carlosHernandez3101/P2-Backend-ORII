package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AgreementCommandControllerCreateIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCreateAgreementWithValidData() throws Exception {
        String validRequest = """
        {
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
                        .content(validRequest))
                .andExpect(status().isCreated());  // Expecting HTTP 201 for success
    }

    @Test
    public void testCreateAgreementWithEmptyInstitution() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());  // Expecting HTTP 400 for bad request
    }

    @Test
    public void testCreateAgreementWithEmptyAgreementNumber() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithEmptyCountry() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithEmptyDescription() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithEmptyScope() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithEmptyStartDate() throws Exception {
        String invalidRequest = """
        {
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
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void testCreateAgreementWithNullInstitution() throws Exception {
        String invalidRequest = """
    {
        "institution": null,
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithNullAgreementNumber() throws Exception {
        String invalidRequest = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": null,
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithNullCountry() throws Exception {
        String invalidRequest = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": null,
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithNullDescription() throws Exception {
        String invalidRequest = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": null,
        "scope": "VALOR",
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithNullScope() throws Exception {
        String invalidRequest = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": null,
        "startDate": "23-08-2024"
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateAgreementWithNullStartDate() throws Exception {
        String invalidRequest = """
    {
        "institution": "Universidad Nacional",
        "agreementNumber": "AC213",
        "country": "Colombia",
        "description": "Intercambio",
        "scope": "VALOR",
        "startDate": null
    }
    """;

        mockMvc.perform(post("/agreement/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequest))
                .andExpect(status().isBadRequest());
    }


}