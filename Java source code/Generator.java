package com.eternity.numbers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Generator class is used to find the position, generate the base 10 of Champernowne constant 
 * and also the binary representation(base 2) of the Champernowne constant.
 * @author Nikitha
 *
 */
public class Generator {
	
	/**
	 * This method finds the position of the number in the Champernowne constant
	 * @param userInput - the input number
	 * @return position - returns the position of the number
	 */
	public int findPosition(String userInput) {
		Calculator calculate = new Calculator();
		int userInputNum = (new Integer(userInput)).intValue();
		int nearestPower = calculate.powerOf(userInput);
		int position = 0;
		if(nearestPower >= 100) {
			int finalNumber = userInputNum - nearestPower;
			int j = 90;
			for(int i=2; i<userInput.length();i++) {
				position += j * i;
				j = j * 10;
			}
			position = 10 + position + (finalNumber * userInput.length());
		}
		else if(nearestPower >= 10) {
			position = 10 + ((userInputNum - 10) * 2);
		}
		else {
			position = userInputNum;
		}
		return position;
	}
	
	/**
	 * This method generates the binary representation of the Champernowne constant
	 * @param userInput - the input number
	 * @return binaryNumber - return the binarydigits
	 */
	public String generateBinaryConstant(String userInput) {
		String binaryNumber = "";
		int n = Integer.parseInt(userInput);
		
		 // Create an empty queue of strings 
        Queue<String> q = new LinkedList<String>(); 
          
        // Enqueue the first binary number 
        q.add("1"); 
        
        // This loops 1 as root and 0 as left child and 1 as right child and so on 
        while(n-- > 0) 
        { 
            // print the front of queue 
            String s1 = q.peek(); 
            q.remove(); 
            binaryNumber = binaryNumber+s1; 
              
            // Store s1 before changing it 
            String s2 = s1; 
            // Append "0" to s1 and enqueue it 
            q.add(s1 + "0"); 
              
            // Append "1" to s2 and enqueue it. Note that s2 contains 
            // the previous front 
            q.add(s2 + "1"); 
        }
		return binaryNumber.substring(0, Integer.parseInt(userInput));
	}
	
	/**
	 * This method generates the base 10 champernowne constant
	 * @param userInput - the input number
	 * @return constant - the base 10 constant
	 */
	public String generateBaseTenConstant(String userInput) {
		String constant = "";
		int i = 1;
		int numberOfIterations = Integer.parseInt(userInput);
		while(numberOfIterations > 0) {
			constant += String.valueOf(i);
			numberOfIterations--;
			i++;
		}
		return constant.substring(0, Integer.parseInt(userInput));
		
	}
}
