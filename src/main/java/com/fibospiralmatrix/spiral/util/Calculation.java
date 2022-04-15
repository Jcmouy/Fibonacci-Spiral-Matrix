package com.fibospiralmatrix.spiral.util;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
	static List<Integer> listNumbers = new ArrayList<>();
	static int a = 0, b = 1, c;
	
	public static List<Integer> getFibonacciSequence(int column, int row) {
		resetValuesIfNeeded();
		listNumbers.add(0, 0);
		listNumbers.add(1, 1);
		calculateFibonacciNumber(column * row - 2);
		return listNumbers;
	} 
	
	private static void calculateFibonacciNumber(int n) {
        if (n > 0) {
    	 c = a + b;
         a = b;
         b = c;
         listNumbers.add(c);
         calculateFibonacciNumber(n - 1);        
        }
	}

	private static void resetValuesIfNeeded(){
		if (a > 0) {
			a = 0;
			b = 1;
			listNumbers.clear();
		}
	}

}
