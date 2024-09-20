package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unicauca.orii.core.mobility.application.service.AgreementCommandService;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.AgreementData;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper.IAgreementRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agreement")
@CrossOrigin(origins = "*")
public class AgreementCommandController {

    private final AgreementCommandService agreementCommandService;
    private final IAgreementRestMapper agreementRestMapper;

    @PostMapping("/create")
    public ResponseEntity<AgreementData> createAgreement(
            @RequestBody AgreementData agreementCreateRequest) {

        Agreement agreement = agreementRestMapper.toAgreement(agreementCreateRequest);
        agreement = agreementCommandService.createAgreement(agreement);
        return ResponseEntity.ok(agreementRestMapper.toAgreementData(agreement));
    }

}
