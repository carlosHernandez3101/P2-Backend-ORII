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


@RestController
@RequiredArgsConstructor
@RequestMapping("/form")
@CrossOrigin(origins = "*")
public class FormQueryController {
    private final FormQueryService formQueryService;

    @GetMapping("/allForm")
    public Page<Form> findAllForms(Pageable pageable) {
     return formQueryService.findAllForms(pageable);
    }
}
