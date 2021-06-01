package com.example.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student1 = new Student("Jayesh", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Khyati", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		System.out.println(students);
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Get student with exact match name "Jayesh"
		 *****************************************************/
		Optional<Student> s = students.stream().filter((student) -> student.getName().equals("Jayesh")).findFirst();
		System.out.println(s.isPresent() ? s.get().toString() : "No such student present");
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Get student with matching address "1235"
		 *****************************************************/

		Optional<Student> s1 = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235"))
				.findFirst();
		System.out.println(s1.isPresent() ? s1.get().toString() : "No such student present");
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Get all student having mobile numbers 3333.
		 *****************************************************/
		List<Student> ss;
		ss = students.stream()
				.filter(student -> student.getMobileNumbers().stream().anyMatch(x -> x.getNumber().equals("3333")))
				.collect(Collectors.toList());
		for (Student s2 : ss) {
			System.out.println(s2);
		}

		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Get all student having mobile number 1233 and 1234
		 *****************************************************/
		List<Student> ss1 = students.stream()
				.filter(student -> student.getMobileNumbers().stream()
						.allMatch(x -> x.getNumber().equals("4444") || x.getNumber().equals("3333")))
				.collect(Collectors.toList());
		for (Student s3 : ss1) {
			System.out.println(s3);
		}
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Create a List<Student> from the List<TempStudent>
		 *****************************************************/
		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmp = Arrays.asList(tmpStud1, tmpStud2);
		List<Student> s4 = tmp.stream()
				.map(tempStud -> new Student(tempStud.name, tempStud.age, tempStud.address, tempStud.mobileNumbers))
				.collect(Collectors.toList());
		for (Student s5 : s4) {
			System.out.println(s5);
		}
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Convert List<Student> to List<String> of student name
		 *****************************************************/
		List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
		System.out.println(names.stream().collect(Collectors.joining(",")));
		System.out.println(names.stream().collect(Collectors.joining()));
		System.out.println(names.stream().collect(Collectors.joining(",", "[", "]")));

		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Convert List<students> to String
		 *****************************************************/
		String names1 = students.stream().map(Student::getName).collect(Collectors.joining(",", "{", "}"));
		System.out.println(names1);
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Change the case of List<String>
		 *****************************************************/
		List<String> nameList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
		nameList.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------");

		nameList.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Sort List<String>
		 *****************************************************/
		List<String> namesList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
		namesList.stream().sorted().forEach(System.out::println);

		System.out.println("--------------------------------------------------------------");

		/*****************************************************
		 * Conditionally apply Filter condition, say if flag is enabled then
		 *****************************************************/

		List<Student> sList = students.stream().filter(stud -> stud.getName().startsWith("J"))
				.sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
		System.out.println("Before Filtering");
		students.forEach(st -> System.out.println(st.getName()));
		System.out.println("\nAfter Filtering and sorting");
		sList.forEach(st1 -> System.out.println(st1.getName()));
	}

}
