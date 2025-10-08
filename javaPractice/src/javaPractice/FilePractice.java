package javaPractice;

import java.io.File;
import java.io.IOException;

public class FilePractice {

	public static void main(String[] args) {
		File file = new File("DummyFile.txt");
		
		boolean newFile = false;
		System.out.println(file.exists());
		
		try {
			newFile = file.createNewFile();
		} catch(IOException ie) {
			System.out.println("IOException caught in main");
		}
		
		System.out.println(newFile);
		System.out.println(file.exists());
	}

}
