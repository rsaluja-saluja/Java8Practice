package com.example.general;

import java.util.Arrays;
import java.util.List;

/*
 * Method references help to point to methods by their names.
 * A method reference can be used to point the following types of methods 
 * - Static methods
 * - Instance methods
 * - Constructors using new operator 
 */
public class MethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("Alpha","Beta","Gaman","Jayesh","Naresh");
		
		list.forEach(System.out::println);
	}

}
