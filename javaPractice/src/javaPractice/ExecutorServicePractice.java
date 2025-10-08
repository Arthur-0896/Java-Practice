package javaPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicePractice {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i = 1; i <= 5; i++) {
			executorService.submit(new Task(i));
		}
		
		// executorService.shutdown();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println();
		}
		
		executorService.submit(new Task(6));
		executorService.submit(new Task(7));

	}
}

class Task implements Runnable{

	int taskId;
	
	Task(int id) {
		taskId = id;
	}
	
	@Override
	public void run() {
		System.out.println("Task " + taskId + " running on thread " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println();
		}
		
		System.out.println("Task " + taskId + " completed by thread " + Thread.currentThread().getName());
	}
	
}
