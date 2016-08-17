package connPool;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.PoolableObjectFactory;

public class ObjectPoolFactoryDemo implements PoolableObjectFactory {


	//线程安全的数字处理类（count++不安全）
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	//取出时激活线程池对象

	public void activateObject(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		sys("取出时激活线程池对象");
	}

	//对象从线程池中销毁时调用
	public void destroyObject(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		sys("销毁时调用" + arg0);
	}

	//创建对象
	public Object makeObject() throws Exception {
		//自增 getAndIncrement
		Object obj = String.valueOf(atomicInteger.getAndIncrement());
		//获取当前值
		System.out.println("创建对象：" + atomicInteger.get());
		return obj;
	}

	//返回时调用
	public void passivateObject(Object arg0) throws Exception {
		sys("返回时调用");
	}

	//检验对象是否可用
	public boolean validateObject(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void sys(String str){
		System.out.println(str);
	}


}
