package javaPractice;


/* WAP to print 1-10 in such a way three threads take turns to print each number*/

public class ThreadsOneToTenProblem extends Thread {

	int count = 1;
	@Override
	public void run() {
		
		
		for(int i = 1; i <= 10; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new ThreadsOneToTenProblem();
		Thread t2 = new ThreadsOneToTenProblem();
		Thread t3 = new ThreadsOneToTenProblem();

		
		
	}
	
}
