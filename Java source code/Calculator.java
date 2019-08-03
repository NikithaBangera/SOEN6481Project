package com.eternity.numbers;

import java.io.BufferedReader;

/**
 * Calculator class which gives the basic functionality of the calculator along with the 
 * options to generate the Champernowne constant.
 * @author Nikitha
 *
 */
public class Calculator {
	private String savedNumber;
	private String previousResult;
	private String secondNumber;
	Generator generator;
	
	/**
	 * Constructor of the Calculator class
	 */
	public Calculator() {
		this.savedNumber = "0";
		this.previousResult = "0";
		this.secondNumber = "0";
		this.generator = new Generator();
	}
	
	/**
	 * Calculate method contains some of the operations that can be performed in a calculator.
	 * @param br - BufferedReader parameter
	 * @param userInput - input from the user
	 * @param isFirstIteration - boolean variable to check for the first iteration of the application
	 * @return isFirstIteration - return the status of the boolean variable
	 * @throws Exception - Exception
	 */
	public boolean calculate(BufferedReader br, String userInput, boolean isFirstIteration) throws Exception {
		System.out.println("Please choose one of the calculator options:");
		System.out.println("1. Addition\t2. Subtraction\t3. Multiplication");
		System.out.println("4. Division\t5. Modulo\t6. Square of a number");
		System.out.println("7. Square Root of a number\t8. Find the position in Champernowne Constant(C10)"
				+ "\t9. Generate a binary Champernowne constant(C2)");
		System.out.println("10. Generate base 10 Champernowne Constant(C10)\t11. Save the number\t12. Display the result");
		System.out.println("13. Exit the calculator application");
		String userSelection = br.readLine();
		while(!userSelection.matches("[0-9]+")) {
			System.out.println("Please choose between options 1 to 13.");
			if(!isFirstIteration && !(userSelection.equalsIgnoreCase("12") || userSelection.equalsIgnoreCase("13"))) {
				userInput = userInputChoice(br);
			}
		}
		String firstNumber = userInput;
		if(isFirstIteration) {
			previousResult = userInput;
		}
		if(!isFirstIteration && !(userSelection.equalsIgnoreCase("11") || userSelection.equalsIgnoreCase("12") || userSelection.equalsIgnoreCase("13"))) {
			firstNumber = userInputChoice(br);
		}
		isFirstIteration = false;
		switch (userSelection) {
		case "1": System.out.println("Please enter the second number for addition:");
				  secondNumber = userInputChoice(br);
				  if(firstNumber.matches("[0-9.]+") || secondNumber.matches("[0-9.]+")) {
					  previousResult = String.valueOf(new Double(firstNumber) + new Double(secondNumber));
				  }
				  else {
					  previousResult = String.valueOf(new Integer(firstNumber) + new Integer(secondNumber));
				  }
				  System.out.println("The sum of "+firstNumber+" and "+secondNumber+" is "+previousResult);
			break;
		
		case "2": System.out.println("Please enter the second number for subtraction:");
		  		  secondNumber = userInputChoice(br);
		  		  if(firstNumber.matches("[0-9.]+") || secondNumber.matches("[0-9.]+")) {
		  			  previousResult = String.valueOf(new Double(firstNumber) - new Double(secondNumber));
		  		  }
		  		  else {
		  			  previousResult = String.valueOf(new Integer(firstNumber) - new Integer(secondNumber));
		  		  }
		  		  System.out.println("The difference of "+firstNumber+" and "+secondNumber+" is "+previousResult);
		  	break;
		  	
		case "3": System.out.println("Please enter the second number for multiplication:");
				  secondNumber = userInputChoice(br);
				  if(firstNumber.matches("[0-9.]+") || secondNumber.matches("[0-9.]+")) {
					  previousResult = String.valueOf(new Double(firstNumber) * new Double(secondNumber));
				  }
				  else {
					  previousResult = String.valueOf(new Integer(firstNumber) * new Integer(secondNumber));
				  }
				  System.out.println("The product of "+firstNumber+" and "+secondNumber+" is "+previousResult);
			break;  
		
		case "4": System.out.println("Please enter the second number for division:");
				  secondNumber = userInputChoice(br);
				  if(secondNumber.equalsIgnoreCase("0")) {
					  System.out.println("#ERR: Division by zero.");
				  }
				  else {
					  if(firstNumber.matches("[0-9.]+") || secondNumber.matches("[0-9.]+")) {
						  previousResult = String.valueOf(new Double(firstNumber) / new Double(secondNumber));
					  }
					  else {
						  previousResult = String.valueOf(new Integer(firstNumber) / new Integer(secondNumber));
					  }
					  System.out.println("The quotient of "+firstNumber+" and "+secondNumber+" is "+previousResult);
				  }
		  break;
		
		case "5": System.out.println("Please enter the second number for modulus:");
				  secondNumber = userInputChoice(br);
				  if(firstNumber.matches("[0-9.]+") || secondNumber.matches("[0-9.]+")) {
					  previousResult = String.valueOf(new Double(firstNumber) * new Double(secondNumber));
				  }
				  else {
					  previousResult = String.valueOf(new Integer(firstNumber) * new Integer(secondNumber));
				  }
				  System.out.println("The remainder of "+firstNumber+" and "+secondNumber+" is "+previousResult);
		 break; 
		
		case "6": if(firstNumber.matches("[0-9.]+")) {
					  previousResult = String.valueOf((int)(new Double(firstNumber) * new Double(firstNumber)));
				  }
				  else {
					  previousResult = String.valueOf(new Integer(firstNumber) * new Integer(firstNumber));
				  } 
				  System.out.println("The square of "+firstNumber+" is "+previousResult);
		 break;
		
		case "7": previousResult = String.valueOf(squareRoot(firstNumber));
				  System.out.println("The square root of "+firstNumber+" is "+previousResult);
		 break;
		
		case "8": while(!firstNumber.matches("[0-9]+")) {
					System.out.println("Please enter a valid positive integer number.");
					firstNumber = br.readLine();
				  }
				  while(!(new Integer(firstNumber) > 0)) {
					  System.out.println("Please enter a valid positive integer number.");
					  firstNumber = br.readLine();
				  }
				  int position = generator.findPosition(firstNumber);
				  previousResult = String.valueOf(position);
				  System.out.println("The position of "+firstNumber+" in Champernowne constant(C10) is "+position);
			break;
			
		case "9": while(!firstNumber.matches("[0-9]+")) {
					System.out.println("Please enter a valid positive integer number.");
					firstNumber = br.readLine();
				  }
				  while(!(new Integer(firstNumber) > 0)) {
					  System.out.println("Please enter a valid positive integer number.");
					  firstNumber = br.readLine();
				  }
				  previousResult = "0."+generator.generateBinaryConstant(firstNumber);
				  System.out.println("The base 2 Champernowne constant of length "+firstNumber+" digits is "+previousResult);
			break;
			
		case "10": while(!firstNumber.matches("[0-9]+")) {
					System.out.println("Please enter a valid positive integer number.");
					firstNumber = br.readLine();
				  }
				  while(!(new Integer(firstNumber) > 0)) {
					  System.out.println("Please enter a valid positive integer number.");
					  firstNumber = br.readLine();
				  }
				  previousResult = "0."+generator.generateBaseTenConstant(firstNumber);
				  System.out.println("The base 10 Champernowne constant of length "+firstNumber+" digits is "+previousResult);
					break;
				  
			
		case "11": savedNumber = previousResult;
				   System.out.println("Number "+savedNumber+" saved successfully.");
			break;
		
		case "12": System.out.println(previousResult);
			break;
		
		case "13": System.exit(0);
			
		default:
			break;
		}
		return isFirstIteration;
	}
	
	/**
	 * This method gives the user some more options to proceed with the calculation 
	 * @param br - BufferedReader input
	 * @return firstNumber - return the number to be user for further calculations
	 * @throws Exception - Exception
	 */
	private String userInputChoice(BufferedReader br) throws Exception {
		String firstNumber = "";
		System.out.println("Choose from the following options to proceed:");
		System.out.println("1.Saved Number\t2.Previous Result\t3.Enter a new Number");
		int choice = Integer.parseInt(br.readLine());
		if(choice == 1) {
			firstNumber = savedNumber; 
		}
		else if(choice == 2) {
			firstNumber = previousResult;
		}
		else {
			System.out.println("Enter a number");
			String newUserInput = br.readLine();
			while(!newUserInput.matches("[0-9.]*")) {
				System.out.println("Please enter a valid number.");
				newUserInput = br.readLine();
			}
			firstNumber = newUserInput;
		}
		return firstNumber;
	}

	/**
	 * This method is used to calculate the square-root of a number 
	 * @param firstNumber - the number whose square-root is to be calculated
	 * @return half - the square-root of the given number
	 */
	public double squareRoot(String firstNumber) {
		double temp;
		double doubleFirstNum;
		int intFirstNum;
		double half;
		if(firstNumber.matches("[0-9.]+")) {
			doubleFirstNum = (new Double(firstNumber)).doubleValue();
			half = doubleFirstNum / 2;
			do {
				temp = half;
				half = (temp + (doubleFirstNum / temp)) / 2;
			}while((temp - half) != 0);
		}
		else {
			intFirstNum = (new Integer(firstNumber)).intValue();
			half = intFirstNum / 2;
			do {
				temp = half;
				half = (temp + (intFirstNum / temp)) / 2;
			}while((temp - half) != 0);
		}
		return half;
	}

	/**
	 * This method calculates the power of a number
	 * @param userInput - the input value
	 * @return result - returns the result
	 */
	public int powerOf(String userInput) {
		int size = userInput.length() - 1;
		int result = 1;
		while(size > 0) {
			result = result * 10;
			size--;
		}
		return result;
	}
}
