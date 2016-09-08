package supervene.basis;

import org.junit.Test;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Mythread is running");
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
	}
	
	@Test
	public void testInClassRun(){
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println("thread is run");
			}
		};
		thread.start();
	}

}
