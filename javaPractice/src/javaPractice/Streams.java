package javaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 3 };

		//Arrays.stream(arr)
		Stream<Integer> stream = Arrays.stream(arr);

		long count = stream.count();

		System.out.println("Total number of elements in stream: " + count);

		// Filter items > 1

		Stream<Integer> stream2 = Arrays.stream(arr);

		count = stream2.filter(i -> i > 1).count();

		System.out.println("Number of elements > 1: " + count);

		// Filter items > 2

		count = Arrays.stream(arr).filter(i -> i > 2).count();

		System.out.println("Number of items > 2: " + count);
		
		// Streaming HashMaps
		HashMap<String, Integer> dogs = new HashMap<>();
		
		dogs.put("Blaze", 11);
		dogs.put("Tyson", 14);
		dogs.put("Wanda", 3);
		
		count = dogs.entrySet().stream().filter(t -> t.getValue() > 10).count(); // Count the dogs older than 10 years.
		
		System.out.println("Number of dogs older than 10 years: " + count);
		
		// Stream.of(any object type)
		Stream<String> strStream =  Stream.of("Arthur", "Tanisha", "Tyrell", "Lina");
		count = strStream.count();
		System.out.println("Number of names in stream: " + count);
		
	}

}
