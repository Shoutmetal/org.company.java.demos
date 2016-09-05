package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		CustomThread ct = new CustomThread();
//		ct.start();
		
//		for(int i = 0;i<=100;i++)
//			System.out.println("Main Thread " + i);
		
		CustomThreadRunnable ctr = new CustomThreadRunnable();
		
		//Thread thread = new Thread(ctr);
		//thread.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		executor.submit(ctr);
		executor.submit(ctr);
		executor.submit(ctr);
		executor.submit(ctr);
		executor.submit(ctr);
		executor.submit(ctr);
		
		executor.shutdown();
		
		boolean finished = executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		
		System.out.println("Finished: " + finished);
		
		
	}

}
