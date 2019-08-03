package com.eternity.numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main class of the Eternity Numbers Calculator
 * @author Nikitha
 *
 */
public class EternityNumbers {
	private static String userInput = "0";
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Eternity Numbers Calculator");
		System.out.println("Enter a number:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		userInput = br.readLine();
		boolean isFirstIteration = true;
		while(!userInput.matches("[0-9.]*")) {
			System.out.println("Please enter a valid number.");
			userInput = br.readLine();
		}
		Calculator eternityNumbersCalculator = new Calculator();
		while(true) {	
			
			isFirstIteration = eternityNumbersCalculator.calculate(br, userInput, isFirstIteration);
		}
	}
}
