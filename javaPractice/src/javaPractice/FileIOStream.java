package javaPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {
	public static void main(String[] args) {
		
		File f = new File("FileWriter4.txt");
		byte[] byteArr = new byte[50];
		try {
			
			FileOutputStream fos = new FileOutputStream(f);
			FileInputStream fis = new FileInputStream(f);

			try {
				fos.write("Hello\nfolks\n".getBytes());
				fos.flush();
				fos.close();

				fis.read(byteArr);
				
				for(byte b: byteArr) {
					System.out.print((char)b);
				}
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
