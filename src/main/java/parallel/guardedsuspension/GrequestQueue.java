package parallel.guardedsuspension;

import java.util.LinkedList;

/**
 * 请求队列
 * @author wangweiwei
 *
 */
public class GrequestQueue {

	private LinkedList<Grequest> queue = new LinkedList<Grequest>();
	
	//客户端把请求放入队列
	public  synchronized void addGrequest(Grequest grequest){
		queue.add(grequest);
		//放入请求后通知服务端获取请求
		notifyAll();
	}
	
	//服务端获取队列中的请求
	public synchronized Grequest getGrequest(){
		if (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return queue.remove();
	}
}
