package javaPractice;

public class ThreadingSynchronizePractice extends Thread {

	StringBuffer sb;

	public ThreadingSynchronizePractice(StringBuffer sb) {
		super();
		this.sb = sb;
	}

	@Override
	public void run() {
		synchronized (sb) {
			System.out.println(Thread.currentThread().getName());
			for (int i = 1; i <= 100; i++) {
				System.out.print(sb);
			}
			System.out.println();
			Character newChar = (char) (sb.charAt(0) + 1);
			sb.replace(0, 1, newChar.toString());
		}
	}

	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer("A");

		Thread t1 = new ThreadingSynchronizePractice(stringBuffer);
		Thread t2 = new ThreadingSynchronizePractice(stringBuffer);
		Thread t3 = new ThreadingSynchronizePractice(stringBuffer);

		t1.start();
		t2.start();
		t3.start();
	}
}
