package com.codingdojo.calculator;

public class Calculator implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private double operandOne;
	private double operandTwo;
	private String operator;
	private double result;
	
	public Calculator() {
		
	}
	
	public void performOperation() {
		if(operator.equals("+")){
			result = this.getOperandOne(operandOne) + this.getOperandTwo(operandTwo);
		} else if (operator.equals("-")) {
			result = this.getOperandOne(operandOne) - this.getOperandTwo(operandTwo);
		} else {
			throw new java.lang.Error("Cannot perform operation");
		}
	}
	
	public double getResult() {
		System.out.println(result);
		return result;
	}
	
//	Getter and Setters
	
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	 
	public void setOperation(String operator) {
		if(!operator.equals("+") && !operator.equals("-")) {
			throw new java.lang.Error("Wrong type of operator. Please input a - or a + operator");
		} else {
			this.operator = operator;
		}
	}
	
	public double getOperandOne(double operandOne) {
		return operandOne;
	}
	
	
	public double getOperandTwo(double operandTwo) {
		return operandTwo;
	}

	public String getOperation() {
		return operator;
	}
	
}
