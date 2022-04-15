package com.fibospiralmatrix.spiral.entity;

import java.util.List;

import com.fibospiralmatrix.spiral.util.Calculation;

public class FibonacciNumbers {
	
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public void mapFibonacciSequence(int column, int row) {
		numbers = Calculation.getFibonacciSequence(column, row);
	}
	
	public Integer getElementAtPosition(int position) {
		return numbers.get(position);
	}	
	
}
