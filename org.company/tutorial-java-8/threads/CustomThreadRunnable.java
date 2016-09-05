package threads;

public class CustomThreadRunnable implements Runnable {

	@Override
	public void run() {
		message();
	}
	
	//one thread can access at a time using "synchronized"
	public synchronized void message()
	{
		for(int i = 0;i<=100;i++)
		System.out.println("thread: " + Thread.currentThread().getId() + " value: " + i);
	}

}
