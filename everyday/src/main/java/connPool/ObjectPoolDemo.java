package connPool;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.SoftReferenceObjectPool;
import org.apache.commons.pool.impl.StackObjectPool;

public class ObjectPoolDemo {
	
	static ObjectPoolFactoryDemo objectPoolFactoryDemo = new ObjectPoolFactoryDemo();
	//通用性对象池，可以设置对象池的容量，对象池行为-创建。等待，配置项教多
	static ObjectPool objectPool = new GenericObjectPool(objectPoolFactoryDemo);
	//利用stack保存对象，可以指定初始容量，无对象可用自动增加
	static ObjectPool objectPool1 = new StackObjectPool(objectPoolFactoryDemo);
	//利用ArrayList保存对象，保存的是软引用，对象数量无限制
	static ObjectPool objectPool2 = new SoftReferenceObjectPool(objectPoolFactoryDemo);

	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	
	public static class PoolThead extends Thread{
		public void run(){
			Object obj = null;
			try {
				for (int i = 0; i < 100 ; i++) {
					System.out.println("当前循环 ：" + i);
					//从池中获取对象
					obj = objectPool.borrowObject();
					System.out.println("使用的对象: " + obj);
					//把对象返回给对象池
					objectPool.returnObject(obj);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				atomicInteger.getAndIncrement();
			}
		}
	}
	
	public static void main(String[] args) {
		new PoolThead().start();
		new PoolThead().start();
		new PoolThead().start();
		
		try {
			while(true){
				//对象池数量3个
				if(atomicInteger.get() == 3){
					objectPool.close();
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
