package com.example.general;

/*
 * it adds backward compatibility so that old interfaces can be used to leverage the 
 * lambda expression capability of Java 8.
 * 
 * An interface can also have static helper methods
 */
public class DefaultMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle vehicle = new Car();
	      vehicle.print();
	}
}

	interface Vehicle {

		default void print() {
			System.out.println("I am a vehicle!");
		}

		static void blowHorn() {
			System.out.println("Blowing horn!!!");
		}
	}

	interface FourWheeler {

		default void print() {
			System.out.println("I am a four wheeler!");
		}
	}

	class Car implements Vehicle, FourWheeler {

		public void print() {
			Vehicle.super.print();
			FourWheeler.super.print();
			Vehicle.blowHorn();
			System.out.println("I am a car!");
		}
	}

