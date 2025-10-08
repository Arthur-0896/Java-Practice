package javaPractice;

import java.io.Console;

public class ConsolePractice {
	public static void main(String[] args) {
		Console console = System.console();

		String name = "";
		char[] pw;

		pw = console.readPassword("%s", "pw: ");

		for (char character : pw)
			console.format("%c ", character);
		console.format("\n");

		MyUtility mu = new MyUtility();
		name = console.readLine("%s", "input: ");
		console.format("Output: %s", mu.doStuff(name));

	}
}

class MyUtility {
	String doStuff(String arg1) {
		return "result is " + arg1;
	}
}
