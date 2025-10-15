package javaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Streams2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Arthur", "Tanisha", "Lina", "Tyrell");

		list.stream().filter(s -> s.startsWith("A") || s.startsWith("T")).filter(s -> s.length() > 6)
				.forEach(System.out::println);

		// Counting squares greater than 20.

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

		long count = nums.stream().peek(n -> System.out.println("Number is: " + n)).map(n -> Math.pow(n, 2))
				.filter(n -> n > 20).peek(n -> System.out.println("Square is: " + n)).count();

		System.out.println("Result(Stream): " + count);

		List<Reading> readings = Arrays.asList(new Reading(2022, 8, 8, 409.6), new Reading(2022, 9, 8, 407.6),
				new Reading(2022, 1, 9, 408.6), new Reading(2023, 1, 1, 405.5), new Reading(2023, 8, 8, 409.3),
				new Reading(2022, 8, 8, 407.9), new Reading(2022, 8, 8, 402.7));

		OptionalDouble avgReading = readings.stream().mapToDouble(reading -> reading.value)
				.filter(value -> value >= 406 && value < 407).average();

		// Average of readings:
		if (avgReading.isPresent()) {
			System.out.println("Average of 406 readings: " + avgReading.getAsDouble());
		} else {
			System.out.println("No 406 readings found- Cannot compute average.");
		}

		// Max of readings:
		OptionalDouble max = readings.stream().mapToDouble(reading -> reading.value).max();

		if (max.isPresent()) {
			System.out.println("Maximum value: " + max.getAsDouble());
		} else {
			System.out.println("No maximum value present");
		}

	}
}

class Reading {
	int year;
	int day;
	int month;
	double value;

	public Reading(int year, int day, int month, double value) {
		super();
		this.year = year;
		this.day = day;
		this.month = month;
		this.value = value;
	}

}