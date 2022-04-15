package com.fibospiralmatrix.spiral.service;

import com.fibospiralmatrix.spiral.dto.FibonacciSpiralMatrixDTO;

public interface FibosSpiralMatrixService {

	FibonacciSpiralMatrixDTO getSpiralMatrix(Integer rows, Integer columns);
}
