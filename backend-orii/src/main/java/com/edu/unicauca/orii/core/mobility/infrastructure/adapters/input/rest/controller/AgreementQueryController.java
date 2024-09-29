package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unicauca.orii.core.mobility.application.service.AgreementQueryService;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.AgreementData;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper.IAgreementRestMapper;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/agreement")
@CrossOrigin(origins = "*")
public class AgreementQueryController {
    
    private final AgreementQueryService agreementQueryService;
    private final IAgreementRestMapper agreementRestMapper;

    @GetMapping("/all")
    public ResponseEntity<Page<AgreementData>> getAgreements(Pageable pageable) {
       Page<Agreement> objAgreement=agreementQueryService.getAgreement(pageable);
           Page<AgreementData> objResponse = objAgreement.map(agreementRestMapper::toAgreementData);
    
         return ResponseEntity.ok(objResponse);

    }
    @GetMapping("filterbynumerorname/{search}")
    public ResponseEntity<List<AgreementData>> getAgreenmentByNumberOrName(@PathVariable String search) {
        List<Agreement> objAgreements=agreementQueryService.getAgreementByNumberOrName(search);
        List<AgreementData> objResponse=agreementRestMapper.toListAgreementData(objAgreements);
        return ResponseEntity.ok(objResponse);
    }
    
}
    
