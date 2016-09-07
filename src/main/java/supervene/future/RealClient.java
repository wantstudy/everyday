package supervene.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author wangweiwei
 * Future模式核心在于去除了等待时间，并使得原来的等待时间可以用于处理其他的业务逻辑
 * ，从而充分利用计算机资源
 *
 */
public class RealClient {

	public static void main(String[] args) {
		//构造FutureTask
		FutureTask<String> futureTask = new FutureTask<String>(new RealData("a"));

		ExecutorService exService = Executors.newFixedThreadPool(1);

		//发送请求
		exService.submit(futureTask);

		System.out.println("请求完毕");

		//模拟其他的业务逻辑
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取call()返回的结果，如果没有返回，则继续等待返回
		try {
			String string = futureTask.get();
			System.out.println(string);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
