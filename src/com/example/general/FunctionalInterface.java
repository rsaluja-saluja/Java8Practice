package com.example.general;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Functional interfaces have a single functionality to exhibit. 
 * For example, a Comparable interface with a single method ‘compareTo’ 
 * is used for comparison purpose. Java 8 has defined a lot of functional 
 * interfaces to be used extensively in lambda expressions.
 * Example - Predicate, Consumer
 * 
 * This can have only one abstract method. It can have default methods.
 * Where an instance of such an interface is required, a Lambda Expression can be used instead.
 */
public class FunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		eval(list, n->true);
		System.out.println("--------------------");
		
		eval(list, n->n%2==0);
		System.out.println("--------------------");

		eval(list, n->n%2!=0);
		System.out.println("--------------------");

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Java 7 way");
			}
			
		});
		t.start();
		//Runnable is Functional Interface
		Thread th = new Thread(
				()->System.out.println("Jaba 8 way with Functional Interface")
				);
		th.start();

	}

	private static void eval(List<Integer> numList, Predicate<Integer> fun) {
		for (Integer num : numList) {
			if(fun.test(num))
				System.out.println(num);
		}
	}
}
