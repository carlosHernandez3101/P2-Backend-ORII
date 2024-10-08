package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unicauca.orii.core.mobility.application.service.FormCommandService;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.request.FormCreateRequest;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.response.FormCreateResponse;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper.IFormRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agreement")
@CrossOrigin(origins = "*")
public class AgreementCommandController {
    
    private final FormCommandService formCommandService;
    private final IFormRestMapper formRestMapper;

    @PostMapping("/create")
        public ResponseEntity<FormCreateResponse> createForm(@RequestBody FormCreateRequest formCreateRequest) {
        Form form = formRestMapper.toForm(formCreateRequest);
        form = formCommandService.createForm(form);
        return ResponseEntity.ok(formRestMapper.toFormCreateResponse(form));
    }

}
