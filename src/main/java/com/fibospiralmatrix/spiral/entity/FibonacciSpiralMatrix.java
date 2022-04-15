package com.fibospiralmatrix.spiral.entity;

public class FibonacciSpiralMatrix {
	private int[][] spiralArray;
	private int top;
    private int bottom;
	private int left;
    private int right;
    private int number;
    
    public void setInitialValues(int rows, int columns) {
    	spiralArray = new int[rows][columns]; 
    	top = 0;
        bottom = rows-1;
        left = 0;
        right = columns-1;
        number = 0;
    }
    
    public void increseTop() {
    	top++;
    }
    
    public void decreseBottom() {
    	bottom--;
    }
    
    public void increseLeft() {
    	left++;
    }
    
    public void decreseRight() {
    	right--;
    }
    
    public int increseAndReturnNumber() {
    	return number++;
    }

	public int[][] getSpiralArray() {
		return spiralArray;
	}

	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}
    
    
}
