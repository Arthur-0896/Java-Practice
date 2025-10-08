package javaPractice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
	public static void main(String[] args) {
		File file = new File("fileWriter.txt");
		char[] charArray = new char[50];

		try {
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.write("Hello\nfolks\n");

			fileWriter.flush();
			fileWriter.close();

			FileReader fileReader = new FileReader(file);

			int size = fileReader.read(charArray);

			System.out.println("Size= " + size);

			for(char c: charArray) {
				System.out.print(c);
			}
			
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
