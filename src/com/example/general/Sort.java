package com.example.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	public static void main(String args[]) {
		List<String> list1 = Arrays.asList("Alpbha","Beta","Mahesh","Jayesh","Suresh","Naresh");
		List<String> list2 = Arrays.asList("Alpbha","Beta","Mahesh","Jayesh","Suresh","Naresh");

		System.out.println(list1);
		Sort sortTest = new Sort();
		
		sortTest.sortUsingJava7(list1);
		System.out.println(list1);
		
		System.out.println("-------------------");
		System.out.println(list2);
		sortTest.sortUsingJava8(list2);
		System.out.println(list2);
	
		System.out.println("-------------------");

		List<String> listStr = Arrays.asList("ABC","Rajni","Saluja","Kamal","Akshaj","Akshu");
	
		System.out.println(listStr);

		listStr.sort((s1,s2) -> s1.compareTo(s2));
		System.out.println(listStr);
		List<String> listStr1 = Arrays.asList("ABC","Rajni","Saluja","Kamal","Akshaj","Akshu");

		listStr1.sort(null);
		System.out.println(listStr1);

	}

	 //[Alpbha, Beta, Jayesh, Mahesh, Naresh, Suresh]
	private void sortUsingJava7(List<String> names) {
		//Collections.sort(names);
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		
	});
	}
	
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1,s2) -> s1.compareTo(s2));
		
	}
}