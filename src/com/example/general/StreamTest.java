package com.example.general;

/*
 * The stream represents a sequence of objects from a source such as a collection,
 * which supports aggregate operations. They were designed to make collection processing 
 * simple and concise.
 * Some of the intermediate operations are filter, map and flatMap.
 * Terminal operations include forEach, reduce, Collect and sum.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * Makes Data processing easier
 * Stream represents a sequence of objects from a source, which supports aggregate operations
 * A stream provides a set of elements of specific type in a sequential manner. 
 *  Stream takes Collections, Arrays, or I/O resources as input source
 *  Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on
 */
public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Print 10 Random numbers using forEach
//		Random rand = new Random();
//		System.out.println(rand.nextInt(10));
//		// rand.ints().limit(10).forEach(System.out::println);
//		rand.ints(10).forEach(System.out::println);
//		rand.ints(10, 1, 10).forEach(System.out::println);

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		// Count empty strings
		System.out.println("---Count Empty Strings---");
		System.out.println("List: " + strings);
		long count = 0;
		for (String str : strings) {
			if (!str.isEmpty()) {
				count++;
			}
		}
		System.out.println("Using Java7 count: " + count);

		count = 0;
		count = strings.stream().filter(s -> !s.isEmpty()).count();
		System.out.println("Using Java8 count: " + count);

		// Count Strings of length 3
		System.out.println("---Count Strings of length 3---");

		count = 0;
		for (String str : strings) {
			if (str.length() == 3)
				count++;
		}
		System.out.println("Using Java7 count: " + count);
		count = strings.stream().filter(s -> (s.length() == 3)).count();
		System.out.println("Using Java8 count: " + count);

		// Eliminate empty string
		System.out.println("--- Find non-empty strings from list ---");

		List<String> list1 = new ArrayList<String>();
		for (String str : strings) {
			if (!str.isEmpty())
				list1.add(str);
		}
		System.out.println("Using Java7 non-empty list : " + list1);

		List<String> list2 = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
		System.out.println("Using Java8 non-empty list : " + list2);

		// Eliminate empty string and join using comma.
		System.out.println("---Eliminate empty string and join using comma---");
		System.out.println("Using Java 7 :" + joinNonEmptyString(strings, ","));
		String jointStr = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(","));
		System.out.println("Using Java 8 :" + jointStr);

		// get list of square of distinct numbers
		System.out.println("---get list of square of distinct numbers---");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		List<Integer> sqrNumbers = getSquareList(numbers);
		System.out.println("Using Java 7: " + sqrNumbers);

		List<Integer> sqrNumbers1 = numbers.stream().distinct().map(x -> x * x).collect(Collectors.toList());
		System.out.println("Using Java 8: " + sqrNumbers1);

		// get numbers statistics
		System.out.println("---get number statistics---");

		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("List: " + integers);
		IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		System.out.println("Count of all numbers : " + stats.getCount());

	}

	private static List<Integer> getSquareList(List<Integer> numbers) {
		List<Integer> numList = new ArrayList<Integer>();
		for (Integer num : numbers) {
			Integer square = num.intValue() * num.intValue();
			if (!numList.contains(square))
				numList.add(square);
		}
		return numList;
	}

	private static String joinNonEmptyString(List<String> list, String separator) {
		StringBuilder builder = new StringBuilder();
		for (String str : list) {
			if (!str.isEmpty()) {
				builder.append(str);
				builder.append(separator);
			}
		}
		return builder.substring(0, builder.length() - 1).toString();
	}

}
