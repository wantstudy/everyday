package parallel.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class TestFuture {
	
	@Test
	public void testJdkFuture() throws InterruptedException, ExecutionException{
		//构造futureTask
		FutureTask<String> futureTask = new FutureTask<String>(new RealDataJDK("a"));
		// 建立一个容量为1的固定尺寸的线程池	
		ExecutorService executor = Executors.newFixedThreadPool(1);
		/*当将一个Callable的对象传递给ExecutorService的submit方法，则该call方法自动在一个线程上执行，
		并且会返回执行结果Future对象。
		同样，将Runnable的对象传递给ExecutorService的submit方法，则该run方法自动在一个线程上执行，
		并且会返回执行结果Future对象，但是在该Future对象上调用get方法，将返回null。*/
		executor.submit(futureTask);
		System.out.println("请求完毕");
		
		try {
			//模拟其它的业务逻辑处理
			System.out.println("主程序在处理其他业务逻辑start");
			Thread.sleep(1000);
			System.out.println("主程序在处理其他业务逻辑end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//取得call方法的返回值，如果call方法没有执行完毕，则依然会等待
		System.out.println("result :" + futureTask.get());
	}

	
	@Test
	public void testPersonFuture(){
		Client client = new Client();
		//会立即返回构造的future数据
		Data request = client.request("b");
		System.out.println("请求完毕");
		try {
			//模拟处理其他业务逻辑
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//获取处理好的真实数据
		System.out.println(request.getResult());
	}
}
