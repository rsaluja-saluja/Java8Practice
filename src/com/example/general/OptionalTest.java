package com.example.general;

import java.util.Optional;

/*
 * Optional object is used to represent null with absent value. 
 * This class has various utility methods to facilitate code to handle 
 * values as ‘available’ or ‘not available’ instead of checking null values. 
 */
public class OptionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer val1 = null;
		Integer val2 = 20;
		
		Optional<Integer> num1 = Optional.ofNullable(val1);
		Optional<Integer> num2 = Optional.ofNullable(val2);
		
		OptionalTest test = new OptionalTest();
		Integer sum = test.add(num1,num2);
		System.out.println(sum);
	}

	private Integer add(Optional<Integer> num1, Optional<Integer> num2) {
		// TODO Auto-generated method stub
		Integer a = num1.orElse(0);
		Integer b = num2.orElse(0);
	//	Integer b= num2.get(); // throws NoSUchElementException if value is not present
		return a+b;
	}

	

}
