package com.example.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {

	static List<Employee> empList = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		empList.add(new Employee(111, "Jiya", 32,"Female", "HR", 2011, 25000.0));

		empList.add(new Employee(122, "Paul", 25,"Male", "Sales", 2015, 13500.0));

		empList.add(new Employee(133, "Martin", 29,"Male", "IT", 2012, 18000.0));

		empList.add(new Employee(144, "Murali", 28,"Male", "IT", 2014, 32500.0));

		empList.add(new Employee(155, "Nima", 27,"Female", "Sales", 2013, 22700.0));

		empList.add(new Employee(166, "Iqbal", 43,"Male", "HR", 2016, 115000.0));

		empList.add(new Employee(177, "Manu", 35,"Male", "IT", 2010, 34500.0));

		empList.add(new Employee(188, "Wang", 31,"Male", "Security", 2016, 15700.0));

		empList.add(new Employee(199, "Amelia", 24,"Female", "HR", 2015, 21300.0));

		empList.add(new Employee(200, "Jaden", 38,"Male", "Sales", 2014, 10700.0));

		empList.add(new Employee(211, "Nitin", 27,"Male", "HR", 2017, 28900.0));

		empList.add(new Employee(222, "ALi", 25,"Male", "Security", 2012, 11500.0));

		empList.add(new Employee(233, "Sanvi", 24,"Female", "Sales", 2011, 12000.0));
		
		System.out.println(empList.size());
		

//		Query1 - How many male and female employees are in organization
//		System.out.println("Male Count: "+empList.stream().filter(e -> e.gender.equals("Male")).count());		
//		System.out.println("Male Count: "+empList.stream().filter(e -> e.gender.equals("Female")).count());
		System.out.println("How many male and female employees are in organization");
		Map<String, Long> noOfMaleFemale = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleFemale);
		
//		Query2 - Print name of all department in organization
		System.out.println("Print name of all department in organization");
		empList.stream().map(e -> e.getDepartment()).distinct().forEach(System.out::println);
		
//		Query3 - What is average age of male and female employee
		System.out.println("What is average age of male and female employee");
		Map<String, Double> averageAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println(averageAge);
		
//		Query4 - Get details of highest paid employee in organization
		System.out.println("Get details of highest paid employee in organization");
		Optional<Employee> emp = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(emp.get());
		
//		Query5 - Get names of all employees who joined after 2015
		System.out.println("Query5 - Get names of all employees who joined after 2015");
		empList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		
//		Query6 - Count no of employees in each department
		System.out.println("Query6 - Count no of employees in each deparment");
		Map<String,Long> empCount = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		empCount.entrySet().forEach(e -> System.out.println(e.getKey()+":"+e.getValue()));
		
//		Query7 - What is average salary of each department
		System.out.println("Query7 - What is average salary of each department");
		Map<String, Double> averageSalary = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalary);
		
//		Query8 - Get details of youngest male employee in HR department
//		Optional<Employee> emp1 = empList.stream().filter(e->e.getDepartment().equals("HR") && e.getGender().equals("Male")).sorted(Comparator.comparing(Employee::getAge)).findFirst();
		Optional<Employee> emp1 = empList.stream().filter(e->e.getDepartment().equals("HR") && e.getGender().equals("Male")).min(Comparator.comparing(Employee::getAge));
		System.out.println(emp1.get());
		
//		Query9 - Who is most working experience in organization
		System.out.println("Query9 - Who is most working experience in organization");
		Optional<Employee> emp2 = empList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
		System.out.println(emp2.get());
		
//		Query10 - No of male and female employees in Sales department
		System.out.println("No of male and female employees in Sales department");
		Map<String,Long> depGenCount = empList.stream().filter(e->e.getDepartment().equals("Sales")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(depGenCount);
		
//		Query11 -Average salary and total salary of whole organization
		DoubleSummaryStatistics stat = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary: " + stat.getAverage());
		System.out.println("Total Salary: "+stat.getSum());
		
//		Query12 - Separate the employees who are younger(=25years) from employees who are >25
		Map<Boolean, List<Employee>> empL = empList.stream().collect(Collectors.partitioningBy(e->e.getAge() >25));
		empL.entrySet().forEach(System.out::println);
		
//		Query13 - Oldest employee name, age and departmen
		Optional<Employee> e3 = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println(e3.get());
		
	}

}
