package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/cities")
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }
}
