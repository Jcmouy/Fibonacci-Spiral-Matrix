package com.fibospiralmatrix.spiral.controller;

import com.fibospiralmatrix.spiral.dto.FibonacciSpiralMatrixDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fibospiralmatrix.spiral.service.FibosSpiralMatrixService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/spiral", produces = "application/json")
@CrossOrigin(origins = "*")
public class FiboSpiralMatrixController {
	
	@Autowired
	FibosSpiralMatrixService fibosSpiralMatrixService;
	
	@GetMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FibonacciSpiralMatrixDTO> getSpiralMatrix(@RequestParam(required = true) Integer rows,
                                                                    @RequestParam(required = true) Integer cols) {
        log.info("FibonSpiralMatrixController:  get spiral matrix rows: {}, columns: {}", rows, cols);
        return new ResponseEntity<>(fibosSpiralMatrixService.getSpiralMatrix(rows, cols), HttpStatus.OK);
    }
}
