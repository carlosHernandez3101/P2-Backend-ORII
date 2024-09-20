package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.unicauca.orii.core.mobility.application.service.FormCommandService;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.request.FormCreateRequest;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.response.FormCreateResponse;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper.IFormRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/form")
@CrossOrigin(origins = "*")
public class FormCommandController {
    
    private final FormCommandService formCommandService;
    private final IFormRestMapper formRestMapper;

    @PostMapping("/create")
        public ResponseEntity<FormCreateResponse> createForm(@RequestBody FormCreateRequest formCreateRequest) {
        Form form = formRestMapper.toForm(formCreateRequest);
        form = formCommandService.createForm(form);
        return ResponseEntity.ok(formRestMapper.toFormCreateResponse(form));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        formCommandService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }

}
