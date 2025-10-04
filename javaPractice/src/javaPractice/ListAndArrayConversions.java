package javaPractice;

import java.util.ArrayList;
import java.util.List;

public class ListAndArrayConversions {
	
	public static void main(String[] args) {
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
		
		/*
		 * OUTPUT: 
		 * [Tanisha, Lina] 
		 * Arthur Tanisha Lina
		 */
	}
}
