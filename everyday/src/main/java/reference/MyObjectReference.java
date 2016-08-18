package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Before;
import org.junit.Test;

/**
 * 引用类型： 强引用，软引用，弱引用，虚引用
 * @author wangweiwei
 *
 */
public class MyObjectReference {
	
	MyObject myObject ;
	
	public static ReferenceQueue<MyObject> queue;

	@Before
	public void before(){
		//初始化对象     强引用
		myObject = new MyObject();
		
		//构造引用队列
		queue = new ReferenceQueue<MyObject>();
	}
	
	
	/**
	 * 内存充足的情况下，不会回收软引用
	 * 执行时，设置该方法的jvm参数： -Mmx5M:限定最大可用堆
	 */
	@Test
	public void testSoftReference(){
		long maxMemory = Runtime.getRuntime().maxMemory(); 
		System.out.println("maxMemory : " + maxMemory );
		System.out.println("freeMemory : " + Runtime.getRuntime().freeMemory());
		//创建软引用
		SoftReference<MyObject> reference = new SoftReference<MyObject>(myObject,queue);
		
		//检查引用队列，监控对象回收情况
		new CheckRefQueue().start();
		
		//删除强引用
		myObject = null;
		
		//显示回收系统资源
		System.gc();
		
		System.out.println("after GC:Soft Get = " + reference.get());
		
		System.out.println("分配大内存块");
		
		@SuppressWarnings("unused")
		byte[] b = new byte[4*1024*1245];  //分配一块较大内存，强迫GC
		
		System.out.println("after byte freeMemory : " + Runtime.getRuntime().freeMemory());
		System.out.println("after new byte[] soft Get = " + reference.get());
		
	}
	
	/**
	 * 系统GC时，只要发现弱引用，就会对对象进行回收
	 * 执行时，设置该方法的jvm参数： -Mmx5M
	 */
	@Test
	public void testWeakReference(){
		long maxMemory = Runtime.getRuntime().maxMemory(); 
		System.out.println("maxMemory : " + maxMemory );
		System.out.println("freeMemory : " + Runtime.getRuntime().freeMemory());
		//创建软引用
		WeakReference<MyObject> reference = new WeakReference<MyObject>(myObject,queue);
		
		//检查引用队列，监控对象回收情况
		new CheckRefQueue().start();
		
		//删除强引用
		myObject = null;
		
		//显示回收系统资源
		System.gc();
		
		System.out.println("after GC:Soft Get = " + reference.get());
		
		System.out.println("after byte freeMemory : " + Runtime.getRuntime().freeMemory());
		
		System.out.println("after new byte[] soft Get = " + reference.get());
		
	}
	
	/**
	 * 虚引用最弱的一个，相当于无引用，随时都可能被回收
	 * 用于跟踪垃圾回收过程
	 * 执行时，设置该方法的jvm参数： -Mmx5M
	 * @throws Exception 
	 */
	@Test
	public void testPhantomReference() throws Exception{
		long maxMemory = Runtime.getRuntime().maxMemory(); 
		System.out.println("maxMemory : " + maxMemory );
		System.out.println("freeMemory : " + Runtime.getRuntime().freeMemory());
		//创建软引用
		@SuppressWarnings("unused")
		PhantomReference<MyObject> reference = new PhantomReference<MyObject>(myObject,queue);
		
		//检查引用队列，监控对象回收情况
		new CheckRefQueue().start();
		
		//删除强引用
		myObject = null;
		
		Thread.sleep(1000);
		
		int i =1;
		while(true){
			System.out.println("第"+i+"次gc");
			System.gc();
			Thread.sleep(1000);
		}
		
	}
	
}
