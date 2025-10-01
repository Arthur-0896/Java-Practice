package javaPractice;

public class PrintNumbersUsingThreads implements Runnable {

	int i = 1;
	@Override
	public synchronized void run() {
		for(; i <= 10; i++) {
			System.out.println("THREAD-" + Thread.currentThread().getName() + " : " + i);
		}
	}

	public static void main(String[] args) {
		PrintNumbersUsingThreads printNumbersUsingThreads = new PrintNumbersUsingThreads();
		Thread t1 = new Thread(printNumbersUsingThreads);
		Thread t2 = new Thread(printNumbersUsingThreads);
		Thread t3 = new Thread(printNumbersUsingThreads);

		t1.start();
		t2.start();
		t3.start();
	}
}
