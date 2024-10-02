package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.unicauca.orii.core.mobility.application.service.FormQueryService;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;

import lombok.RequiredArgsConstructor;

/**
 * REST controller for querying forms.
 * This controller provides endpoints for retrieving forms from the database.
 *
 * @author JhossefCons
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/form")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
public class FormQueryController {
    
    private final FormQueryService formQueryService;

    /**
     * Retrieves a paginated list of all forms.
     * 
     * @param pageable the pagination information
     * @return a page of forms
     */
    @GetMapping("/allForms")
    public Page<Form> findAllForms(Pageable pageable) {
     return formQueryService.findAllForms(pageable);
    }
}