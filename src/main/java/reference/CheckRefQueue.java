package reference;

import java.lang.ref.Reference;

/**
 * 检查引用队列，监控对象回收情况
 * @author wangweiwei
 *
 */
public class CheckRefQueue extends Thread{

	static Reference<MyObject> obj = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		try {
			//如果对象被回收则进入引用队列
			obj = (Reference<MyObject>) MyObjectReference.queue.remove();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(obj == null){
			System.out.println("Object for softReference is " + obj.get());
		} 
	}
}
