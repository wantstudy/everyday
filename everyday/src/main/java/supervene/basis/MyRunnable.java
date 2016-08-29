package supervene.basis;

import org.junit.Test;
import org.omg.CORBA.LocalObject;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("my runnable run");
	}

	@Test
	public void testMyrunnable(){
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}

	@Test
	public void testInClassRunnable(){
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("inclass thread run");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Test
	public void testGetThreadName(){
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "my runnable");
		thread.start();
		System.out.println("current:" + Thread.currentThread().getName());
		System.out.println(thread.getName());
	}

	@Test
	public void testMoreThread(){
		System.out.println(Thread.currentThread().getName());
		for(int i=0; i<10; i++){
			new Thread("" + i){
				public void run(){
					System.out.println("Thread: " + getName() + "running");
				}
			}.start();
		}
	}


}
