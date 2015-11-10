package com.baines.calculator;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField output;
	private double number1 = 0.0;
	private String operator = "";
	private boolean start = true;
	
	private Model model=new Model();
	

	@FXML
	private void processProcent(ActionEvent event){
		if(start){
			output.setText("");
			start=false;	
		}
		//Holt sich den text vom Button
		String value = ((Button)event.getSource()).getText();	
		//Schreibt value mit zu Output
		output.setText(output.getText()+value);
	}
	
	@FXML
	private void processNumpad(ActionEvent event){
		if(start){
			output.setText("");
			start=false;
			
		}
		//Holt sich den text vom Button
		String value = ((Button)event.getSource()).getText();	
		//Schreibt value mit zu Output
		output.setText(output.getText()+value);
	}
	
	@FXML
	private void processOperator(ActionEvent event){
		//Holt sich den text vom Button
		String value = ((Button)event.getSource()).getText();
		
		if(!"=".equals(value)){
			if(!operator.isEmpty())
				return;
				
			operator=value;
			number1= Double.parseDouble(output.getText());
			output.setText("");
		}
		else{
			if(operator.isEmpty())
					return;
			
			if(!operator.equals("%")){
				output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()), operator)));
				operator="";
				start=true;
			}else{
				output.setText(String.valueOf(model.calculateProzent(number1)));
				operator="";
				start=true;
			}
		}
	}
	@FXML
	private void processClear(ActionEvent event){
		
	number1=0;
	output.setText("");
	operator="";
	}
	


}
