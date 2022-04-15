package com.fibospiralmatrix.spiral.service;

import com.fibospiralmatrix.spiral.dto.FibonacciSpiralMatrixDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.fibospiralmatrix.spiral.entity.FibonacciNumbers;
import com.fibospiralmatrix.spiral.entity.FibonacciSpiralMatrix;

import java.util.Arrays;

@Slf4j
@Service
public class FiboSpiralMatrixServiceImpl implements FibosSpiralMatrixService {
	private FibonacciNumbers fibonacciNumbers;
	private FibonacciSpiralMatrix fiboSpiralMatrix;

	@Override
	public FibonacciSpiralMatrixDTO getSpiralMatrix(Integer rows, Integer columns) {
		initFibonacciNumbers(rows, columns);
		spiralMatrix(rows, columns);
		return getSpiralArrayDTO();
	}
	
	private void initFibonacciNumbers(int rows, int columns) {
		log.info("initFibonacciNumbers:  rows: {}, columns: {}", rows, columns);
		fibonacciNumbers = new FibonacciNumbers();
		fibonacciNumbers.mapFibonacciSequence(rows, columns);
	}

	private void spiralMatrix(int rows, int columns) {
		initFibonacciSpiralMatrix(rows, columns);
        while(outerCondition()){
        	getValuesFromTopRow();
        	getValuesFromRightColumn();
        	getValuesFromBottomRow();
        	getValuesFromLeftColumn();
        }
	}
	
	private void initFibonacciSpiralMatrix(int rows, int columns) {
		fiboSpiralMatrix = new FibonacciSpiralMatrix();
		fiboSpiralMatrix.setInitialValues(rows, columns);
	}
	
	private boolean outerCondition() {
		return fiboSpiralMatrix.getLeft()<=fiboSpiralMatrix.getRight() 
        		&& fiboSpiralMatrix.getTop()<=fiboSpiralMatrix.getBottom();
	}
	
	private void getValuesFromTopRow() {
		for(int i=fiboSpiralMatrix.getLeft();i<=fiboSpiralMatrix.getRight();i++) {
            fiboSpiralMatrix.getSpiralArray()[fiboSpiralMatrix.getTop()][i] = fibonacciNumbers.getElementAtPosition(fiboSpiralMatrix.increseAndReturnNumber());
        }
		fiboSpiralMatrix.increseTop();
	}
	
	private void getValuesFromRightColumn() {
		for(int i=fiboSpiralMatrix.getTop();i<=fiboSpiralMatrix.getBottom();i++) {
            fiboSpiralMatrix.getSpiralArray()[i][fiboSpiralMatrix.getRight()] = fibonacciNumbers.getElementAtPosition(fiboSpiralMatrix.increseAndReturnNumber());
        }
		fiboSpiralMatrix.decreseRight();;
	}
	
	private void getValuesFromBottomRow() {
		if (fiboSpiralMatrix.getBottom() >= fiboSpiralMatrix.getTop()){ //created due to border case: rows 3, columns 4
			for(int i=fiboSpiralMatrix.getRight();i>=fiboSpiralMatrix.getLeft();i--) {
				fiboSpiralMatrix.getSpiralArray()[fiboSpiralMatrix.getBottom()][i] = fibonacciNumbers.getElementAtPosition(fiboSpiralMatrix.increseAndReturnNumber());
			}
			fiboSpiralMatrix.decreseBottom();
		}
	}
	
	private void getValuesFromLeftColumn() {
		for(int i=fiboSpiralMatrix.getBottom();i>=fiboSpiralMatrix.getTop();i--) {
            fiboSpiralMatrix.getSpiralArray()[i][fiboSpiralMatrix.getLeft()] = fibonacciNumbers.getElementAtPosition(fiboSpiralMatrix.increseAndReturnNumber());
        }
		fiboSpiralMatrix.increseLeft();
	}

	private FibonacciSpiralMatrixDTO getSpiralArrayDTO(){
		FibonacciSpiralMatrixDTO fibonacciSpiralMatrixDTO = new FibonacciSpiralMatrixDTO();
		fibonacciSpiralMatrixDTO.setRows(fiboSpiralMatrix.getSpiralArray());
		log.info("FibonacciSpiralMatrixDTO:  rows: {}", (Object) fibonacciSpiralMatrixDTO.getRows());
		return fibonacciSpiralMatrixDTO;
	}

}
