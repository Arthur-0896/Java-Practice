package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndArrayConversions {
	
	public static void main(String[] args) {
		// toArray() method demonstration
		List<String> arrayList= new ArrayList<>();
		String[] arr = new String[3];
		
		arrayList.add("Arthur");
		arrayList.add("Tanisha");
		arrayList.add("Lina");

		arrayList.toArray(arr);
		
		arrayList.remove(0); // toArray() does not join the List and the Array.
		
		System.out.println(arrayList);
		
		for(String str : arr) {
			System.out.print(str + ' ');
		}
		System.out.println("\n");
		/*
		 * OUTPUT: 
		 * [Tanisha, Lina] 
		 * Arthur Tanisha Lina
		 */
		
		// Arrays.asList() demonstration
		String arr2[] = new String[5];
		arr2[0] = "John";
		arr2[1] = "Marsh";
		arr2[2] = "Becky";	
		
		List<String> arrayList2 = Arrays.asList(arr2);
		
		
		System.out.println("Before modification:");
		System.out.println("ArrayList2: " + arrayList2);
		System.out.println("\nArray: ");
		
		for(String str: arr2) {
			System.out.print(str+ " ");
		}
		System.out.println("\n");

		arr2[0] = "Micah"; // The asList() operation joins the array and the arraylist. 
						   // A change in the array will also change the arrayList as the ArrayList
						   // is backed by the array.
		
		System.out.println("After modification:");
		System.out.println("ArrayList2: " + arrayList2);   
		System.out.println("\nArray: ");
		// Unsupported operation: arrayList2.add("asd");
		for(String str: arr2) {
			System.out.print(str+ " ");
		}
		/*
		 * Before modification: ArrayList2: [John, Marsh, Becky]
		 * 
		 * Array: John Marsh Becky
		 * 
		 * After modification: ArrayList2: [Micah, Marsh, Becky]
		 * 
		 * Array: Micah Marsh Becky
		 */	}
}
