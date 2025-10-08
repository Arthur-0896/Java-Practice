package javaPractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DirectoriesAndNIO {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		File dir = new File("myDir");

		System.out.println(dir.mkdir()); // Create the Directory.

		File myFile = new File(dir, "newFile.txt");
		System.out.println(myFile.createNewFile()); // Create the file.

		PrintWriter pw = new PrintWriter(myFile);
		pw.println("1st Line");
		pw.print("2nd Line");

		pw.flush();
		pw.close();

		System.out.println("dir exists? " + dir.exists());

		FileReader fw = new FileReader(myFile);
		BufferedReader buf = new BufferedReader(fw);

		String s = null;
		while ((s = buf.readLine()) != null) {
			System.out.println(s);
		}
		buf.close();

		File delDir = new File("delDir");
		delDir.mkdir();

		File delFile1 = new File(delDir, "delFile1.txt");
		delFile1.createNewFile();

		File delFile2 = new File(delDir, "delFile2.txt");
		delFile2.createNewFile();

		System.out.println("delFile1 deleted? " + delFile1.delete()); // Delete the first file.
		System.out.println("delDir deleted? " + delDir.delete()); // Attempt to delete the directory.

		File newFile = new File(delDir, "newFile.txt");
		File newDir = new File("newDir");

		delFile2.renameTo(newFile);
		delDir.renameTo(newDir);

		String[] files = new String[50];
		
		File dirToSearch = new File("myDir");
		
		files = dirToSearch.list();
		
		for(String fileName : files) {
			System.out.println("Found '" + fileName + "'");
		}
	}
}