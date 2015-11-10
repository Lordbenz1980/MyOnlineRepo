package com.baines.calculator;

public class Model {
	
	public double calculate(Double number1,Double number2,String operator){
		
		switch (operator){
		case "+":
			return number1+number2;
		case "-":
			return number1-number2;
		case "*":
			return number1*number2;
		case "/":
			if(number2==0)
			 return 0;
			
			return number1/number2;
		
		}
		System.out.println("Unknown Operator - "+ operator);
		return 0;
		
	}
	
	public double calculateProzent(Double number1){
		return number1/100;
	}

}
