package javaPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathsAndFiles {
	public static void main(String[] args) throws IOException {

		Path dirPath = Paths.get("newDir"); // Get the Path of the directory

		System.out.println(Files.exists(dirPath)); // Check if the directory exists

		if (Files.notExists(dirPath))
			Files.createDirectory(dirPath); // Create the directory

		System.out.println(Files.exists(dirPath)); // Check again

		// Path filePath = Paths.get("newDir\\newFile.txt"); // First way to specify
		Path filePath = Paths.get("newDir", "newFile.txt"); // Second way to specify Path

		if (Files.notExists(filePath))
			Files.createFile(filePath);

		Path multipleDirectories = Paths.get("C:", "parent", "child1", "child2");
		Files.createDirectories(multipleDirectories);

		Path destination = Paths.get("newDir", "newFileCopy.txt");

		Files.copy(filePath, destination, StandardCopyOption.REPLACE_EXISTING); // Copy the file.
																				// StandardCopyOption.REPLACE_EXISTING
																				// allows overwriting

		Files.delete(destination); // Delete the file

		Files.move(filePath, destination); // Move the file

		// Path instance functions:
		System.out.println("Root: " + multipleDirectories.getRoot());
		System.out.println("Parent of child2: " + multipleDirectories.getParent());
		System.out.println("Number of directories: " + multipleDirectories.getNameCount());
		System.out.println("First directory name: " + multipleDirectories.getName(0));
		System.out.println("File system name: " + multipleDirectories.getFileSystem());
		System.out.println("Child directories: " + multipleDirectories.subpath(1, 3));
		System.out.println("toString(): " + multipleDirectories.toString());
		System.out.println("Get file name: " + multipleDirectories.getFileName());

		System.out.println();

		// Print tree directory structure
		int spaces = 1;
		System.out.println(multipleDirectories.getRoot());
		spaces += 2;
		for (Path subpath : multipleDirectories) {
			System.out.format("%" + spaces + "s%s%n", "", subpath);
			spaces += 2;
		}
	}
}
