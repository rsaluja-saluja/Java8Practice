package com.example.general;

public class LambdaExpr {

	/* 
	 * Lambda expressions are used primarily to define inline implementation 
	 * of a functional interface, i.e., an interface with a single method only.
	 * Lambda expression eliminates the need of anonymous class and gives a very 
	 * simple yet powerful functional programming capability to Java.
	 * 
	 * Using lambda expression, you can refer to any final variable or effectively 
	 * final variable (which is assigned only once)
	 */
	
	final static String str1 = " World!!!!";
	final static String str2;
	static {
		str2 = "World ####";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MathOperation addition = (a,b) -> a+b;
		MathOperation subtraction = (a,b) -> a-b;
		MathOperation multiplication = (a,b) -> a*b;
		
		System.out.println(addition.operation(23, 12));
		System.out.println(subtraction.operation(23, 12));

		System.out.println(multiplication.operation(23, 12));
		
		GreetingsService ser = str -> System.out.println("Hello "+str);
		ser.sayMessage("World");

		GreetingsService ser1 = str -> System.out.println(str + str1);
		ser1.sayMessage("Hello");
		
		GreetingsService ser2 = str -> System.out.println(str + str2);
		ser2.sayMessage("Hello");

	}
	
	interface MathOperation {
		int operation(int num1,int num2);
	}
	
	interface GreetingsService {
		void sayMessage(String str);
	}

}
