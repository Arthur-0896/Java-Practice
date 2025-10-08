package javaPractice;

class NumberPrinter implements Runnable {
	private static final Object lock = new Object();
	private static int number = 1;
	private final int threadId;
	private static final int totalThreads = 3;
	private static final int N = 10;

	public NumberPrinter(int threadId) {
		this.threadId = threadId;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				if (number > N) {
					lock.notifyAll();
					break;
				}

				if ((number - 1) % totalThreads == threadId) {
					System.out.println("THREAD-" + (threadId + 1) + " : " + number);
					number++;
					lock.notifyAll();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		}
	}
}

public class SequencePrinter {
	public static void main(String[] args) {

		Thread t1 = new Thread(new NumberPrinter(0));
		Thread t2 = new Thread(new NumberPrinter(1));
		Thread t3 = new Thread(new NumberPrinter(2));

		t1.start();
		t2.start();
		t3.start();
	}
}