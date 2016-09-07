package parallel.guardedsuspension;

import parallel.future.FutureData;
import parallel.future.RealData;

/**
 * 服务端，用于处理客户端请求
 * @author wangweiwei
 *
 */
public class ServerThread extends Thread {
	
	private GrequestQueue queue;
	
	public ServerThread(GrequestQueue queue, String name ) {
		super(name);
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true){
			//获取请求
			final Grequest grequest = queue.getGrequest();
			FutureData futureData = (FutureData) grequest.getResponse();
			RealData realData = new RealData(grequest.getName());
			futureData.setRealData(realData);
/**			try {
				//模拟处理请求
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
*/			
			System.out.println("服务端，当前线程"+Thread.currentThread().getName() + "  请求： " + grequest);
		}
	}
}
