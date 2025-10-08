package javaPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterAndBufferedReader {
	public static void main(String[] args) {
		try {
			PrintWriter printWriter = new PrintWriter("PrintWriter.txt");
			printWriter.println("Hello");
			printWriter.println("Folks");
			printWriter.println("Finally");
			printWriter.print("null");

			printWriter.flush();
			printWriter.close();

			// Wrapping around FileWriter:
			try {
				FileWriter fw = new FileWriter("PrintWriter2.txt");
				PrintWriter pw = new PrintWriter(fw);

				pw.println("Created using Writer wrapper");

				pw.flush();
				pw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			FileReader fileReader = new FileReader("PrintWriter.txt");
			BufferedReader buf = new BufferedReader(fileReader);

			try {
				String currentLine = buf.readLine();

				while (currentLine != null) {
					System.out.println(currentLine);
					currentLine = buf.readLine();
				}
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
