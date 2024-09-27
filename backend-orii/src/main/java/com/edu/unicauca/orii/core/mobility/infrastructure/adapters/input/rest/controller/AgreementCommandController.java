package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.unicauca.orii.core.mobility.application.service.AgreementCommandService;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.AgreementData;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper.IAgreementRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agreement")
@CrossOrigin(origins = "*")
public class AgreementCommandController {

    private final AgreementCommandService agreementCommandService;
    private final IAgreementRestMapper agreementRestMapper;

    @PostMapping("/create")
    public ResponseEntity<AgreementData> createAgreement(@Valid 
            @RequestBody AgreementData agreementCreateRequest) {

        Agreement agreement = agreementRestMapper.toAgreement(agreementCreateRequest);
        agreement = agreementCommandService.createAgreement(agreement);
        return ResponseEntity.ok(agreementRestMapper.toAgreementData(agreement));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AgreementData> updateAgreement(
            @PathVariable Long id, 
            @RequestBody AgreementData agreementUpdateRequest) {

        Agreement agreement = agreementRestMapper.toAgreement(agreementUpdateRequest);
        agreement = agreementCommandService.updateAgreement(id, agreement);
        return ResponseEntity.ok(agreementRestMapper.toAgreementData(agreement));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAgreement(@PathVariable Long id) {
        agreementCommandService.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }

}
