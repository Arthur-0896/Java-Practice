package javaPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetAndTreeMaps {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		treeSet.add(1600);
		treeSet.add(1630);
		treeSet.add(1700);
		treeSet.add(1730);
		treeSet.add(1800);
		treeSet.add(1900);
		treeSet.add(1930);

		System.out.println(treeSet);

		System.out.println("First after 4 PM is: " + treeSet.higher(1545));
		
		System.out.println("Last before 7 PM is: " + treeSet.lower(1900));
	
		Iterator<Integer> it = treeSet.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("After Polling First: " + treeSet.pollFirst());
		
		it = treeSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		treeSet = (TreeSet<Integer>) treeSet.descendingSet();
		
		System.out.println("After reversing:");
		
		it = treeSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		List<Integer> al = new ArrayList<>(10);
	}
}
