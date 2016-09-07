package parallel.guardedsuspension;

import java.util.ArrayList;
import java.util.List;

import parallel.future.FutureData;

public class ClientThread extends Thread {

	private GrequestQueue queue;
	
	private List<Grequest> myQueue = new ArrayList<Grequest>();

	public ClientThread( GrequestQueue queue,String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		//构造请求
		for (int i = 0; i < 10; i++) {
			Grequest grequest = new Grequest("Request ID: " + i +" ThreadName: " + Thread.currentThread().getName());
			
			grequest.setResponse(new FutureData());
			//提交请求
			queue.addGrequest(grequest);
			
			myQueue.add(grequest);
			
			try {
				//客户端提交请求的速度快于服务器处理速度
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前客户端："+ Thread.currentThread().getName() + "当前处理请求："+grequest);
			
			//取得服务器的返回值
			for (Grequest r : myQueue) {
				System.out.println("response is " + r.getResponse().getResult());
				
			}
		}
	}
}
