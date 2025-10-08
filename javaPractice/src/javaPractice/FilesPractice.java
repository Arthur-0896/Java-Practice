package javaPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesPractice {
	
	public static void main(String[] args) {
		
		Path csvPath = Paths.get("src/javaPractice/students.csv");
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			List<String> lines = Files.readAllLines(csvPath);
			
			
			
			for(String line : lines) {
				String[] values = line.split(",");	
				
				Student student = new Student(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
				
				students.add(student);
			}		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Student student : students) {
			System.out.println(student);
		}
	}
}