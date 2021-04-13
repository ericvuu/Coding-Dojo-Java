package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {

		Calculator calculatorTest = new Calculator();
		
		calculatorTest.setOperandOne(10.5);
		calculatorTest.setOperation("+");
		calculatorTest.setOperandTwo(5.2);
		calculatorTest.performOperation();
		calculatorTest.getResult();

	}

}
